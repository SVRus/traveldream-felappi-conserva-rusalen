package travelPackageManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mailSender.MailSenderLocal;

import org.apache.commons.codec.digest.DigestUtils;

import stateenum.State;
import travelstateenum.TravelState;
import authentication.LoginBeanLocal;
import dto.CustomerDTO;
import dto.CustomizedTravelPackageDTO;
import dto.EmployeeDTO;
import dto.FlightDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
import dto.StageDTO;
import dto.TravelPackageDTO;
import dto_entitiesconversion.DTOFactory;
import entities.Customer;
import entities.CustomizedTravelPackage;
import entities.Employee;
import entities.PrepackedTravelPackage;
import entities.Product;
import entities.Stage;
import entities.TravelPackage;
import entitymanagement.CustomerEntityManagementLocal;
import entitymanagement.CustomizedTravelPackageEntityManagementLocal;
import entitymanagement.EmployeeEntityManagementLocal;
import entitymanagement.FlightEntityManagementLocal;
import entitymanagement.HotelEntityManagementLocal;
import entitymanagement.OutingEntityManagementLocal;
import entitymanagement.PrepackedTravelPackageEntityManagementLocal;
import entitymanagement.TravelPackageEntityManagementLocal;

/**
 * Session Bean implementation class TravelPackageCreateBean
 */
@Stateless
@LocalBean
public class TravelPackageCRUDBean implements TravelPackageCRUDBeanLocal {
@EJB
PrepackedTravelPackageEntityManagementLocal preman;
@EJB
CustomizedTravelPackageEntityManagementLocal cusman;
@EJB
EmployeeEntityManagementLocal emplo;
@EJB
TravelPackageEntityManagementLocal trav; 
@EJB
DTOFactory dto;
@EJB
LoginBeanLocal log;
@EJB
OutingEntityManagementLocal outing;
@EJB
HotelEntityManagementLocal hotel;
@EJB
FlightEntityManagementLocal flight;
@EJB
CustomerEntityManagementLocal custoEntityMan;
@EJB
MailSenderLocal mail;


    /**
     * Default constructor. 
     */
    public TravelPackageCRUDBean() {
        
    }

	/**
	 * method that let an employee persist a travel package
	 */
	@Override
	public boolean createTravelFromEmployee(TravelPackageDTO prepacked) {
		String username=log.getPrincipalUsername();
		Employee employee=emplo.find(username);
		prepacked.setRecoursiveTravelProductState( TravelState.AVAILABLE, State.INCLUDED);
		TravelPackage travel=dto.travelPackageDTOToEntity(prepacked, true);
		List <PrepackedTravelPackage> travelList=Arrays.asList((PrepackedTravelPackage)travel);
    	employee.addPackages(travelList);
    	try
    	{
    		emplo.edit(employee);
    		
    		return true;
    	}
    	catch(Exception e)
    	{
    	return false;
    	}
    	
		
	}
/**
 * method that let update a travelPackage
 */
	public boolean updateTravelPackage(TravelPackageDTO traveldto)
	{
		TravelPackage travel=dto.travelPackageDTOToEntity(traveldto, false);
		boolean ok=false;
		if(travel instanceof PrepackedTravelPackage)
		{
			try {
				preman.edit((PrepackedTravelPackage)travel);
				ok=true;
				System.out.print("ho aggiornato");
			} catch (Exception e) {
				e.printStackTrace();
				ok=false;
			}
			
		}
		else if(travel instanceof CustomizedTravelPackage)
		{
			try {
				cusman.edit((CustomizedTravelPackage)travel);
				ok=true;
			} catch (Exception e) {
				e.printStackTrace();
				ok=false;
			}
			
		}
		
		return ok;
		
				
	}
	/**
	 * method that delete a travelPackage
	 */
	 public boolean delete(TravelPackageDTO traveldto)
	    {
	    	boolean ok=false;
			try 
			{ traveldto.setRecoursiveTravelProductState(TravelState.AVAILABLE, State.AVAILABLE);
					TravelPackage product=trav.find(traveldto.getIdtravelpackage());
					trav.remove(product);
					ok=true;
			}
	    	catch (Exception e)
			{ e.printStackTrace();
	    		ok=false;
	    		
			}
	    	return ok;  	
	    	
	    }
	/**
	 * method that finds all prepackedTravelPackages
	 */
	public List <PrepackedTravelPackageDTO> findAllPrepacked()
	{
		List <PrepackedTravelPackage> prelist=preman.findAll();
		System.out.println("lista "+prelist);
		List <PrepackedTravelPackageDTO>prelistdto=dto.prepackedTravelPackageToDTO(prelist);
		return prelistdto;
	}
	public List <CustomizedTravelPackageDTO> findAllCustomized()
	{
		List <CustomizedTravelPackage> prelist=cusman.findAll();
		List <CustomizedTravelPackageDTO>prelistdto=dto.customizedTravelPackageToDTO(prelist);
		return prelistdto;
		
		
		
	}
	
public CustomizedTravelPackageDTO cloneTravelPackage(PrepackedTravelPackageDTO preDTO)
{
	List <StageDTO> stagesPreDTO=preDTO.getStages();
	List <StageDTO> stagesCusDTO= new ArrayList <StageDTO>();
	Iterator <StageDTO> iterStages=stagesPreDTO.iterator();
	while (iterStages.hasNext())
	{
		StageDTO partial=iterStages.next();
		System.out.println(partial.toString());
		ArrayList <ProductDTO> productsPreDTO=partial.getProducts();
		System.out.println(productsPreDTO.toString()+"prodotti parziali");
		Iterator  <ProductDTO> iterProducts=productsPreDTO.iterator();
		List <ProductDTO> productsCusDTO=new ArrayList <ProductDTO>();
		while(iterProducts.hasNext())
		{
			ProductDTO prodPartial=dto.findClonedProduct(iterProducts.next());
			System.out.print("prodotto parziale"+prodPartial);
			if(prodPartial!=null)
			productsCusDTO.add(prodPartial);
					
			
		}
		
		StageDTO stagePartialCus=new StageDTO(new ArrayList<ProductDTO>(productsCusDTO),partial.getArea(),partial.getTimeStart(),partial.getTimeEnd());
		stagesCusDTO.add(stagePartialCus);
		
	}

		CustomizedTravelPackageDTO cus=new CustomizedTravelPackageDTO(preDTO.getTime_end(),preDTO.getTime_start(),preDTO.getDescription(),preDTO.getName(),new ArrayList<StageDTO>(stagesCusDTO),null,null,null,null,TravelState.AVAILABLE);
	
	
	return cus;
	

}

public PrepackedTravelPackageDTO cloneTravelPackageToPrepacked(PrepackedTravelPackageDTO preDTO)
{
	List <StageDTO> stagesPreDTO=preDTO.getStages();
	List <StageDTO> stagesPreOutDTO= new ArrayList <StageDTO>();
	Iterator <StageDTO> iterStages=stagesPreDTO.iterator();
	while (iterStages.hasNext())
	{
		StageDTO partial=iterStages.next();
		System.out.println(partial.toString());
		ArrayList <ProductDTO> productsPreDTO=partial.getProducts();
		System.out.println(productsPreDTO.toString()+"prodotti parziali");
		Iterator  <ProductDTO> iterProducts=productsPreDTO.iterator();
		List <ProductDTO> productsPreOutDTO=new ArrayList <ProductDTO>();
		while(iterProducts.hasNext())
		{
			ProductDTO prodPartial=dto.findClonedProduct(iterProducts.next());
			System.out.print("prodotto parziale"+prodPartial);
			if(prodPartial!=null)
			productsPreOutDTO.add(prodPartial);
					
			
		}
		
		StageDTO stagePartialPreOut=new StageDTO(new ArrayList<ProductDTO>(productsPreOutDTO),partial.getArea(),partial.getTimeStart(),partial.getTimeEnd());
		stagesPreOutDTO.add(stagePartialPreOut);
		
	}
	

		PrepackedTravelPackageDTO pre=new PrepackedTravelPackageDTO(preDTO.getTime_end(),preDTO.getTime_start(),preDTO.getDescription(),preDTO.getName(),new ArrayList<StageDTO>(stagesPreOutDTO),null,null,null,null,TravelState.AVAILABLE);
	
	
	return pre;





}

public boolean createCustomizedTravelPackageFromCustomer(CustomizedTravelPackageDTO custo)
{   custo.setRecoursiveTravelProductState(TravelState.SOLD, State.SOLD);
	String username=log.getPrincipalUsername();
	Customer customer=custoEntityMan.find(username);
	CustomizedTravelPackage travel=(CustomizedTravelPackage)dto.travelPackageDTOToEntity(custo, true);
	
	List <CustomizedTravelPackage> cusTravList=customer.getCustomizedTravelPackages();
	cusTravList.add(travel);
	customer.setCustomizedTravelPackages(cusTravList);
	try
	{
		custoEntityMan.edit(customer);
		
		return true;
	}
	catch(Exception e)
	{
	return false;
	}


}

/**
 * da testare
 * @param travel
 * @return
 */
	public int getNumberEquivalentPackage(TravelPackageDTO travel)
	{
		List <StageDTO> stages=travel.getStages();
		Iterator <StageDTO> iterStages=stages.iterator();
		int result=Integer.MAX_VALUE;
		while(iterStages.hasNext())
		{
			StageDTO partial=iterStages.next();
			List <ProductDTO> products=partial.getProducts();
			Iterator <ProductDTO> iterProducts=products.iterator();
			while(iterProducts.hasNext())
			{
				int partialNumber=0;
				ProductDTO partialProduct=iterProducts.next();
				if(partialProduct instanceof OutingDTO)
				{
					partialNumber=outing.findIntegerOutingEquivalent((OutingDTO)partialProduct);
					
				}
				else if(partialProduct instanceof HotelDTO)
				{
					partialNumber=hotel.findIntegerHotelEquivalent((HotelDTO)partialProduct);
				}
				else if(partialProduct instanceof FlightDTO)
				{
					partialNumber=flight.findIntegerFlightEquivalent((FlightDTO)partialProduct);
					
				}
				if(partialNumber<=result&&partialNumber>0)
					result=partialNumber;
				
			}
			
			
			
		}
		
		if(result==Integer.MAX_VALUE)
		return 0;
		else
		return result;
			
	}
	/**
	 * da testare
	 * 
	 * @param travel
	 * @return
	 */
	public ProductDTO getMinimunAmountProductEquivalentPackage(TravelPackageDTO travel)
	{
		List <StageDTO> stages=travel.getStages();
		Iterator <StageDTO> iterStages=stages.iterator();
		int result=Integer.MAX_VALUE;
		ProductDTO product=null;
		while(iterStages.hasNext())
		{
			StageDTO partial=iterStages.next();
			List <ProductDTO> products=partial.getProducts();
			Iterator <ProductDTO> iterProducts=products.iterator();
			while(iterProducts.hasNext())
			{
				int partialNumber=0;
				ProductDTO partialProduct=iterProducts.next();
				if(partialProduct instanceof OutingDTO)
				{
					partialNumber=outing.findIntegerOutingEquivalent((OutingDTO)partialProduct);
					
				}
				else if(partialProduct instanceof HotelDTO)
				{
					partialNumber=hotel.findFirstHotelAvailable((HotelDTO)partialProduct);
				}
				else if(partialProduct instanceof FlightDTO)
				{
					partialNumber=flight.findIntegerFlightEquivalent((FlightDTO)partialProduct);
					
				}
				if(partialNumber<=result)
				{
					result=partialNumber;
				    product=partialProduct;
				}
			}
			
			
			
		}
		
		
		return product;
			
	}//prodotti parziali
	
	public List <PrepackedTravelPackageDTO> findAllPrepackedTravelPackageByParameter(TravelState state)
	{
		List <PrepackedTravelPackage> foundList=preman.findAllByParameter(state);
		List <PrepackedTravelPackageDTO> preList=dto.prepackedTravelPackageToDTO(foundList);
		return preList;
	}
	
	
	public boolean createCustomizedTravelPackageForFriend( CustomizedTravelPackageDTO customizedTravel)
		{  
		String code=DigestUtils.sha256Hex(new Long(customizedTravel.getIdtravelpackage()).toString());
		customizedTravel.setFriendCode(code);
	    boolean ok=updateTravelPackage(customizedTravel);
		String email=log.findLogIn().getEmail();
	    
	    return ok=ok&&mail.simpleSendMail(email, "", "");
	}



public ArrayList <PrepackedTravelPackageDTO> findAllPackageForEmployee()
{
	EmployeeDTO emplo=(EmployeeDTO)log.findLogIn();
	ArrayList <PrepackedTravelPackageDTO> travel=emplo.getManagedTravelPackage();
return travel;

}

public ArrayList<TravelPackageDTO>  findAllPackageForCustomer()
{
	CustomerDTO customer=(CustomerDTO)log.findLogIn();
	ArrayList<TravelPackageDTO> travels=customer.getPurchasedTravelPackage();
	return travels;
}


public ArrayList <CustomizedTravelPackageDTO> findAllCustomizedForCustomer()
{
	CustomerDTO customer=(CustomerDTO)log.findLogIn();
	ArrayList<CustomizedTravelPackageDTO> travels=customer.getCustomizedTravelPackage();
	return travels;

}

}
