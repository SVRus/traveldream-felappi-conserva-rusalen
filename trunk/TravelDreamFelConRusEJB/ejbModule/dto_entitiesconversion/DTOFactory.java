package dto_entitiesconversion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.codec.digest.DigestUtils;

import dto.CustomerDTO;
import dto.CustomizedTravelPackageDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
import dto.FlightDTO;
import dto.StageDTO;
import dto.TravelPackageDTO;
import entities.Code;
import entities.Customer;
import entities.CustomizedTravelPackage;
import entities.Employee;
import entities.Flight;
import entities.GiftList;
import entities.Hotel;
import entities.Outing;
import entities.PrepackedTravelPackage;
import entities.Product;
import entities.Stage;
import entities.TravelPackage;
import entitymanagement.CustomizedTravelPackageEntityManagementLocal;
import entitymanagement.PrepackedTravelPackageEntityManagementLocal;
import entitymanagement.ProductEntityManagementLocal;
import entitymanagement.TravelPackageEntityManagementLocal;
import groupenum.Group;
@Stateless
@LocalBean
public class DTOFactory {
@EJB
private ProductEntityManagementLocal proman;
@EJB
private PrepackedTravelPackageEntityManagementLocal pretrav;
@EJB
private TravelPackageEntityManagementLocal travel;
@EJB
private CustomizedTravelPackageEntityManagementLocal custrav;



	 private ProductDTO productToDTO(Product product)

	{ 
	System.out.println("il prodotto � "+product.toString());
		ProductDTO result=null;
	    Long idtravelpackage= proman.findStageContainer(product.getIdProduct());
		
	    
	    
	    if (product instanceof  Flight)
		{   
			result=new FlightDTO(idtravelpackage,proman.findEmployeeCreator(product.getIdProduct()),product.getName(),product.getCost(),product.getTimeStart(),product.getTimeEnd(),((Flight)product).getFlight_company(),((Flight)product).getArea_start(),((Flight)product).getArea(),((Flight)product).getPlace_start(),((Flight)product).getPlace_end(),((Flight)product).getMore_info(),product.getState());
			
		}
		else if (product instanceof Outing)
		{
			
			result=new OutingDTO(idtravelpackage,proman.findEmployeeCreator(product.getIdProduct()),product.getName(),product.getCost(),product.getTimeStart(),product.getTimeEnd(),((Outing) product).getDescription(),((Outing) product).getArea(),product.getState());
			
		}
		else if (product instanceof Hotel)
		{
			
			result=new HotelDTO(idtravelpackage,proman.findEmployeeCreator(product.getIdProduct()),product.getName(),product.getCost(),product.getTimeStart(),product.getTimeEnd(),((Hotel) product).getArea(),((Hotel) product).getPlace(),((Hotel) product).getRoom_type(),((Hotel) product).getMore_info(),product.getState());
			
		}
		return result;
		
	}
	
	private  ArrayList <String> customerListToString(List<Customer> friends)
	{  
		ArrayList <String> cusString=new ArrayList<String> (); 
		Iterator<Customer> iter =friends.iterator();
		while(iter.hasNext())
		{
			cusString.add(iter.next().getUsername());
		}
		
		
		return cusString;
		
	}
	public  ArrayList <TravelPackageDTO> travelPackageToDTO(List <TravelPackage> travellist)
	{
		ArrayList <TravelPackageDTO> travelid=new ArrayList <TravelPackageDTO>();
		Iterator <TravelPackage> iter = travellist.iterator();
		while(iter.hasNext())
		{
			TravelPackage travelsimple=iter.next();
			
			travelid.add(this.simpleTravelPackageToDTO(travelsimple));
		
		
		
		
		}
		return travelid;
	}
	public  ArrayList <CustomizedTravelPackageDTO> customizedTravelPackageToDTO(List <CustomizedTravelPackage> travellist)
	{
		ArrayList <CustomizedTravelPackageDTO> travelid=new ArrayList <CustomizedTravelPackageDTO>();
		Iterator <CustomizedTravelPackage> iter = travellist.iterator();
		while(iter.hasNext())
		{
			travelid.add((CustomizedTravelPackageDTO)simpleTravelPackageToDTO(iter.next()));
		}
		return travelid;
	}
	public  ArrayList <PrepackedTravelPackageDTO> prepackedTravelPackageToDTO(List <PrepackedTravelPackage> travellist)
	{
		ArrayList <PrepackedTravelPackageDTO> travelid=new ArrayList <PrepackedTravelPackageDTO>();
		Iterator <PrepackedTravelPackage> iter = travellist.iterator();
		while(iter.hasNext())
		{   
			PrepackedTravelPackageDTO pretravel=(PrepackedTravelPackageDTO)simpleTravelPackageToDTO(iter.next());
		    
			travelid.add(pretravel);
		}
		return travelid;
	}
	
	
	public TravelPackageDTO simpleTravelPackageToDTO(TravelPackage pre)
	{ 
	  Long idtravelpackage=pre.getIdtravelpackage();
	  List <StageDTO> stageList=travelToStageDTO(pre);
	  String idCustomerBuyer=travel.findIdCustomerBuyer(idtravelpackage);
	  System.out.println(idCustomerBuyer);
	  String idCustomerFriendOwner=travel.findIdCustomerFriendOwner(idtravelpackage);
	  System.out.println(idCustomerFriendOwner);
	  
	  TravelPackageDTO dto=null;
	  if(pre instanceof PrepackedTravelPackage)
	  
	  {
	  Long idEmployeeCreator=pretrav.findIdEmployeeCreator(idtravelpackage);
	  System.out.println(idEmployeeCreator);
	   dto=new PrepackedTravelPackageDTO(idtravelpackage,pre.getTime_end(),pre.getTime_start(),pre.getDescription(),pre.getName(),stageList,idCustomerBuyer,idCustomerFriendOwner,pre.getFriendCode(),pre.getPurchaseTime(),idEmployeeCreator);
	  }
	  else if (pre instanceof CustomizedTravelPackage)
	  {
		  Long idCustomizer=custrav.findIdCustomizer(idtravelpackage);
		  dto=new CustomizedTravelPackageDTO(idtravelpackage,pre.getTime_end(),pre.getTime_start(),pre.getDescription(),pre.getName(),stageList,idCustomerBuyer,idCustomerFriendOwner,pre.getFriendCode(),pre.getPurchaseTime(),idCustomizer);
		  
	  }
		return dto;
		
	}
	
	/**
	 * @param travel
	 * @return
	 */
	
	private List <StageDTO> travelToStageDTO( TravelPackage travel)
	{
		List <Stage> stageList=travel.getStages();
		
		List <StageDTO> stageDTOList=new ArrayList <StageDTO> ();
		Iterator <Stage> iter=stageList.iterator();
		while(iter.hasNext())
		{
		  	Stage stage=iter.next();
		  	
		  	List <ProductDTO> forStage=productListToDTO(stage.getProducts());
		  	
		  			
		  	
		  	StageDTO stageDTO=new StageDTO(stage.getIdStage(),forStage,stage.getArea());
		  	stageDTOList.add(stageDTO);
			
		}
		
		return stageDTOList;
		
		
		
	}
	
		  	

	
	
	public ArrayList<ProductDTO> productListToDTO(List <Product> prodlist)
	{
		ArrayList <ProductDTO> result =new ArrayList <ProductDTO> ();
		Iterator <Product> iter =prodlist.iterator();
		while(iter.hasNext())
		{
			result.add(productToDTO(iter.next()));
		}
		
		return result;
		
	}
	public CustomerDTO toTDO(Customer customer)
	{   
		ArrayList <String> friends=customerListToString(customer.getFriends());
		ArrayList <TravelPackageDTO> purchasedTravelPackage = travelPackageToDTO(customer.getPurchasedTravelPackages());
		ArrayList <TravelPackageDTO> preparedForAFriendTravelPackage=travelPackageToDTO(customer.getPreparedForAFriendTravelPackages());
	    ArrayList <GiftListDTO> giftList =giftListCollectionTODTO(customer.getGiftLists());
	    ArrayList <CustomizedTravelPackageDTO> customizedTravelPackage=this.customizedTravelPackageToDTO(customer.getCustomizedTravelPackages());
	   	CustomerDTO cust=new CustomerDTO(customer.getEmail(),customer.getName(), customer.getSurname(),customer.getTelephone(), customer.getPassword(),customer.getUsername(),friends,purchasedTravelPackage,preparedForAFriendTravelPackage,giftList,customizedTravelPackage);

		return cust;
		
		
	}
	
	public  EmployeeDTO toTDO(Employee employee)
	{
		ArrayList<ProductDTO> managedproduct=productListToDTO(employee.getManagedProduct());
		ArrayList<PrepackedTravelPackageDTO> managedTravelPackage=prepackedTravelPackageToDTO(employee.getManagedTravelPackage());
		EmployeeDTO emplo=new EmployeeDTO(employee.getEmail(),employee.getName(),employee.getSurname(),employee.getTelephone(),employee.getPassword(),employee.getUsername(),employee.getCode().getCode(),managedproduct,managedTravelPackage);
		return emplo;
		
		
	}
	private GiftListDTO giftListToDTO(GiftList gift)
	{
		
		return new GiftListDTO (productToDTO(gift.getProduct()),gift.getIdBuyer(),gift.getMoreInfo(),gift.isBought(),gift.getTravelPackage().getIdtravelpackage());
				
	}
   private ArrayList <GiftListDTO> giftListCollectionTODTO(List <GiftList> gift)
   {
	   ArrayList <GiftListDTO> giftDTO=new  ArrayList <GiftListDTO>();
	   Iterator <GiftList> iter=gift.iterator();
	   while(iter.hasNext())
	   {
		   giftDTO.add(giftListToDTO(iter.next()));
		   
	   }
	   
	   
	   
	return giftDTO;
    }
   
   /**
    * @author Marcello
    * Private method that transform the EmployeeDTO in the entity employee, used during the registration phase
    * @param employee -->the employee DTO acquired from the web tier 
    * @return the entity Employee translated from the EmployeeDTO
    */
   public Employee dtoToEmployee(EmployeeDTO employee)
   {   
   	List<Group> groups=new ArrayList <Group>();
       groups.add(Group.EMPLOYEE);
       ArrayList <ProductDTO> listproddto=employee.getManagedproduct();
       List <Product> prod=new ArrayList <Product> ();

       Iterator <ProductDTO> iter=listproddto.iterator();
       while(iter.hasNext())
       {
    	   prod.add(productDTOToEntity(iter.next()));
    	   
       }
       
       
       List <PrepackedTravelPackage> prep=new ArrayList <PrepackedTravelPackage> ();
       Code code=new Code(employee.getCode());
       Employee real=new Employee(employee.getEmail(),employee.getName(),employee.getSurname(),employee.getTelephone(), DigestUtils.sha256Hex(employee.getPassword()),employee.getUsername(),groups,prod, prep,code);
		  	
   	return real;
   	
   	
   }
   
   
   
   
   
   
   /**
    * @author Marcello
    * Private method that transform the CustomerDTO in the entity customer
    * @param customer -->the customer DTO acquired from the web tier
    * @return the entity Customer translated from the CustomerDTO
    */
   public Customer dtoToCustomer(CustomerDTO customer)
   {
   	List<Group> groups=new ArrayList <Group>();
       groups.add(Group.CUSTOMER);
       List<CustomizedTravelPackage> customizedTravelPackages=new ArrayList <CustomizedTravelPackage>();
       List<Customer> friends=new ArrayList <Customer>();
       List<TravelPackage> purchasedTravelPackages=new ArrayList<TravelPackage>();
       List<TravelPackage> preparedForAFriendTravelPackages=new ArrayList <TravelPackage>();
       List<GiftList> giftLists=new ArrayList <GiftList>();
       Customer real=new Customer(customer.getEmail(),customer.getName(),customer.getSurname(),customer.getTelephone(),DigestUtils.sha256Hex(customer.getPassword()),customer.getUsername(),groups,customizedTravelPackages,friends,purchasedTravelPackages,preparedForAFriendTravelPackages,giftLists); 
       
  	   return real;
   	
   }
   public Product productDTOToEntity(ProductDTO product)
   {
   	Product entity=null;
   	if(product instanceof HotelDTO )
   	{
   		entity=new Hotel(product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),((HotelDTO)product).getArea(),((HotelDTO)product).getPlace(),((HotelDTO)product).getRoom_type(),((HotelDTO)product).getMore_info(),product.getState());
   	}
   	else if (product instanceof FlightDTO)
   	{
   		 entity=new Flight(product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),((FlightDTO)product).getFlight_company(),((FlightDTO)product).getArea_start(),((FlightDTO)product).getArea(),((FlightDTO)product).getPlace_start(),((FlightDTO)product).getPlace_end(),((FlightDTO)product).getMore_info(),product.getState());   		
   		
   	
   	}
   	else if (product instanceof OutingDTO)
   	{
   		entity=new Outing(product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),((OutingDTO)product).getDescription(),((OutingDTO)product).getArea(),product.getState());
   		
   	}
   	return entity;
   }
   public TravelPackage travelPackageDTOToEntity(TravelPackageDTO travel, boolean createUpdate)
   {
	  TravelPackage travelpackage=null;
	  List <Stage> stages=null;
	  if(createUpdate)
	  {
		  stages=stageListDTOToEntity(travel.getStages());
		  if(travel instanceof PrepackedTravelPackageDTO)
		  {
			  travelpackage=new PrepackedTravelPackage(travel.getTime_end(),travel.getTime_start(),travel.getDescription(),travel.getName(),stages,travel.getFriendCode(),travel.getPurchaseTime());
				
			  
		  }
		  else if(travel instanceof CustomizedTravelPackageDTO)
		  {
			  travelpackage=new CustomizedTravelPackage(travel.getTime_end(),travel.getTime_start(),travel.getDescription(),travel.getName(),stages,travel.getFriendCode(),travel.getPurchaseTime());
			  
		  }
		  
		  
		  
		  
		  
		  
		  
	  }
	  else
	  {
		  stages=stageListDTOToEntityUpdate(travel.getStages());
		  if(travel instanceof PrepackedTravelPackageDTO)
		  {
			  travelpackage=new PrepackedTravelPackage(travel.getIdtravelpackage(),travel.getTime_end(),travel.getTime_start(),travel.getDescription(),travel.getName(),stages,travel.getFriendCode(),travel.getPurchaseTime());
		  }
		  else if(travel instanceof CustomizedTravelPackageDTO)
		  {
			  
			  travelpackage=new CustomizedTravelPackage(travel.getIdtravelpackage(),travel.getTime_end(),travel.getTime_start(),travel.getDescription(),travel.getName(),stages,travel.getFriendCode(),travel.getPurchaseTime());
			  
		  }
	  }
	   
	  
	  
	  
	   return travelpackage;
	   
	   
	   
	   
	   
	   
   }
   private  List<Stage> stageListDTOToEntity(List <StageDTO> stagesDTOList)
   {
	   
	   List <Stage> stages=new ArrayList <Stage>();
	   Iterator <StageDTO> iter=stagesDTOList.iterator();
	   while (iter.hasNext())
	   {
		   Stage stage=stageDTOToEntity(iter.next());
		   stages.add(stage);
		   
	   }
	   return stages;
	   
   }
   private List <Stage>  stageListDTOToEntityUpdate(List <StageDTO> stagesDTOList)
   {
	   List <Stage> stages=new ArrayList <Stage>();
	   Iterator <StageDTO> iter=stagesDTOList.iterator();
	   while (iter.hasNext())
	   {
		   Stage stage=stageDTOToEntityUpdate(iter.next());
		   stages.add(stage);
		   
	   }
	   return stages;
	   
	   
	   
	   
	   
   }
	   
	   private List <Product> productDTOListToEntity(List <ProductDTO> productDTOList)
	   {   List <Product> productList= new ArrayList <Product> ();
		   Iterator <ProductDTO> iter=productDTOList.iterator();
		   while(iter.hasNext())
		   {
			   productList.add(productDTOToEntity(iter.next()));
			   
			   
		   }
		return productList;
		   
		   
	   }
   private Stage stageDTOToEntity(StageDTO stagedto)
   {
	   
	   
	   
	return new Stage(stagedto.getArea(),productDTOListToEntity(stagedto.getProducts()));
	   
	   
	   
   }
   private Stage stageDTOToEntityUpdate(StageDTO stagedto)
   {
	   
	   
	   return new Stage(stagedto.getIdStage(),stagedto.getArea(),productDTOListToEntityUpdate(stagedto.getProducts()));
   }
   
   
   private Product productDTOToEntityUpdate(ProductDTO product)
   {
   	Product entity=null;
   	if(product instanceof HotelDTO )
   	{
   		entity=new Hotel(product.getIdProduct(),product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),((HotelDTO)product).getArea(),((HotelDTO)product).getPlace(),((HotelDTO)product).getRoom_type(),((HotelDTO)product).getMore_info(),product.getState());
   	}
   	else if (product instanceof FlightDTO)
   	{
   		 entity=new Flight(product.getIdProduct(),product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),((FlightDTO)product).getFlight_company(),((FlightDTO)product).getArea_start(),((FlightDTO)product).getArea(),((FlightDTO)product).getPlace_start(),((FlightDTO)product).getPlace_end(),((FlightDTO)product).getMore_info(),product.getState());   		
   		
   	
   	}
   	else if (product instanceof OutingDTO)
   	{
   		entity=new Outing(product.getIdProduct(),product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),((OutingDTO)product).getDescription(),((OutingDTO)product).getArea(),product.getState());
   		
   	}
   	return entity;
   }

   
   private List <Product> productDTOListToEntityUpdate(List <ProductDTO> productDTOList)
   {   List <Product> productList=new ArrayList <Product> ();
	   Iterator <ProductDTO> iter=productDTOList.iterator();
	   while(iter.hasNext())
	   {
		   productList.add(productDTOToEntityUpdate(iter.next()));
		   
		   
	   }
	   
	   
	return productList;
	   
   }
   
}
