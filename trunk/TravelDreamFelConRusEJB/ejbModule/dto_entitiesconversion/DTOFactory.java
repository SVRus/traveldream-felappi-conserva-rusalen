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
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
import dto.FlightDTO;
import dto.StageDTO;
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
import entities.TravelPackage;
import entitymanagement.PrepackedTravelPackageEntityManagementLocal;
import entitymanagement.ProductEntityManagementLocal;
import entitymanagement.TravelPackageEntityManagement;
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
TravelPackageEntityManagementLocal travel;




	 private ProductDTO productToDTO(Product product)

	{ 
	System.out.println("il prodotto è "+product.toString());
		ProductDTO result=null;
	    Long idtravelpackage= proman.findTravelPackageContainer(product.getIdProduct());
		
	    
	    
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
	private  ArrayList <Long> travelPackageToLong(List <TravelPackage> travellist)
	{
		ArrayList <Long> travelid=new ArrayList <Long>();
		Iterator <TravelPackage> iter = travellist.iterator();
		while(iter.hasNext())
		{
			travelid.add(iter.next().getIdtravelpackage());
		}
		return travelid;
	}
	private  ArrayList <Long> customizedTravelPackageToLong(List <CustomizedTravelPackage> travellist)
	{
		ArrayList <Long> travelid=new ArrayList <Long>();
		Iterator <CustomizedTravelPackage> iter = travellist.iterator();
		while(iter.hasNext())
		{
			travelid.add(iter.next().getIdtravelpackage());
		}
		return travelid;
	}
	public  ArrayList <PrepackedTravelPackageDTO> prepackedTravelPackageToDTO(List <PrepackedTravelPackage> travellist)
	{
		ArrayList <PrepackedTravelPackageDTO> travelid=new ArrayList <PrepackedTravelPackageDTO>();
		Iterator <PrepackedTravelPackage> iter = travellist.iterator();
		while(iter.hasNext())
		{   
			PrepackedTravelPackageDTO pretravel=simplePrepackedTravelPackageToDTO(iter.next());
		    
			travelid.add(pretravel);
		}
		return travelid;
	}
	
	
	public PrepackedTravelPackageDTO simplePrepackedTravelPackageToDTO(PrepackedTravelPackage pre)
	{ 
	  List <StageDTO> stageList=findStage(pre);
	  Long idCustomerBuyer=travel.findIdCustomerBuyer(pre.getIdtravelpackage());
	  System.out.println(idCustomerBuyer);
	  Long idCustomerFriendOwner=travel.findIdCustomerFriendOwner(pre.getIdtravelpackage());
	  System.out.println(idCustomerFriendOwner);
	  Long idEmployeeCreator=pretrav.findIdEmployeeCreator(pre.getIdtravelpackage());
	  System.out.println(idEmployeeCreator);
	  PrepackedTravelPackageDTO predto=new PrepackedTravelPackageDTO(pre.getIdtravelpackage(),pre.getTime_end(),pre.getTime_start(),pre.getDescription(),pre.getName(),stageList,idCustomerBuyer,idCustomerFriendOwner,pre.getFriendCode(),pre.getPurchaseTime(),idEmployeeCreator);
		
		
		return predto;
		
		
		
	}
	
	private List <StageDTO> findStage( TravelPackage travel)
	{
		List <ProductDTO> productList=productListToDTO(travel.getProducts());
		List <String> areaList=proman.findEveryArea(travel.getIdtravelpackage());
		List <StageDTO> stageList=new ArrayList <StageDTO> ();
		Iterator <String> iter=areaList.iterator();
		while(iter.hasNext())
		{
		  	String area=iter.next();
		  	List <ProductDTO> forStage=new ArrayList <ProductDTO> ();
		  	Iterator <ProductDTO> iter1=productList.iterator();
		  	while(iter1.hasNext())
		  	{
		  		ProductDTO prod=iter1.next();
		  		if(prod.getArea().equals(area))
		  			forStage.add(prod);
		  		
		  	}
		  			
		  	
		  	StageDTO stage=new StageDTO(forStage,area);
		  	stageList.add(stage);
		  	
			
		}
		
		return stageList;
		
		
		
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
		ArrayList <Long> purchasedTravelPackage = travelPackageToLong(customer.getPurchasedTravelPackages());
		ArrayList <Long> preparedForAFriendTravelPackage=travelPackageToLong(customer.getPreparedForAFriendTravelPackages());
	    ArrayList <GiftListDTO> giftList =giftListCollectionTODTO(customer.getGiftLists());
	    ArrayList <Long> customizedTravelPackage=customizedTravelPackageToLong(customer.getCustomizedTravelPackages());
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
}
