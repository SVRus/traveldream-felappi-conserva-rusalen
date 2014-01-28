package dto_entitiesconversion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.codec.digest.DigestUtils;

import stateenum.State;
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
import entitymanagement.CustomerEntityManagementLocal;
import entitymanagement.CustomizedTravelPackageEntityManagementLocal;
import entitymanagement.EmployeeEntityManagementLocal;
import entitymanagement.FlightEntityManagementLocal;
import entitymanagement.GiftListEntityManagementLocal;
import entitymanagement.HotelEntityManagementLocal;
import entitymanagement.OutingEntityManagementLocal;
import entitymanagement.PrepackedTravelPackageEntityManagementLocal;
import entitymanagement.ProductEntityManagementLocal;
import entitymanagement.RegisteredUserEntityManagementLocal;
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
private TravelPackageEntityManagementLocal travman;
@EJB
private CustomizedTravelPackageEntityManagementLocal custrav;
@EJB
private RegisteredUserEntityManagementLocal regman;
@EJB
private CustomerEntityManagementLocal cusman;
@EJB
private HotelEntityManagementLocal hotman;
@EJB
private OutingEntityManagementLocal outman;
@EJB
private FlightEntityManagementLocal fliman;
@EJB
private GiftListEntityManagementLocal giftMan;


public Employee employeeDTOToEntityUpdate(EmployeeDTO emplodto)
{
	
	List <Group> groups=regman.findGroups(emplodto.getUsername());
	List <Product> products=productDTOListToEntityUpdate(emplodto.getManagedproduct());
	List <PrepackedTravelPackage> prepacked=prepackedTravelPackageDTOListToEntity(emplodto.getManagedTravelPackage());
	Employee emplo=new Employee (emplodto.getEmail(),emplodto.getName(),emplodto.getSurname(),emplodto.getTelephone(),emplodto.getPassword(),emplodto.getUsername(),groups,products,prepacked,new Code(emplodto.getCode()));
	return emplo;
}


private Customer customerDTOToEntityUpdate(CustomerDTO cusdto)
{
	List <Group> groups =regman.findGroups(cusdto.getUsername());
	
	List <CustomizedTravelPackage> customized=customizedTravelPackageDTOListToEntity(cusdto.getCustomizedTravelPackage());
	List <TravelPackage> purchasedTravelPackages=travelPackageDTOListToEntity(cusdto.getPurchasedTravelPackage());
	List <GiftList> giftLists=giftListDTOToEntity(cusdto.getGiftlist());
	Customer customer=new Customer(cusdto.getEmail(),cusdto.getName(),cusdto.getSurname(),cusdto.getTelephone(),cusdto.getPassword(),cusdto.getUsername(),groups,customized,purchasedTravelPackages,giftLists);
	
	return customer;
}

public ArrayList <GiftList> giftListDTOToEntity (ArrayList <GiftListDTO> giftListsDTO)
{
	ArrayList<GiftList> giftLists=new ArrayList <GiftList> ();
	Iterator <GiftListDTO> iter=giftListsDTO.iterator();
	while(iter.hasNext())
	{
		GiftList giftList=this.simpleGiftListDTOToEntity(iter.next());
		giftLists.add(giftList);
	}
	
	return giftLists;
}
public GiftList simpleGiftListDTOToEntity(GiftListDTO giftListDTO)
{
	Product product= productDTOToEntityUpdate(giftListDTO.getProduct());
	TravelPackage travel=travman.find(giftListDTO.getTravelPackageid());
	
	GiftList giftList=new GiftList(product,giftListDTO.getIdBuyer(),giftListDTO.getMoreInfo(),giftListDTO.isBought(),travel);
	
	return giftList;
	
	
	
}



/*private ArrayList <Customer> stringListToCustomer(ArrayList <String> friendstring)
{
	ArrayList <Customer> friends=new ArrayList <Customer> ();
	Iterator <String> iter=friendstring.iterator();
	while(iter.hasNext())
	{
		Customer customer=cusman.find(iter.next());
		friends.add(customer);
	}
 return friends;
}*/

	 public ProductDTO productToDTO(Product product)

	{ 
		ProductDTO result=null;
	    Long idstage= proman.findStageContainer(product.getIdProduct());
		
	    
	    
	    if (product instanceof  Flight)
		{   
			result=new FlightDTO(idstage,proman.findEmployeeCreator(product.getIdProduct()),product.getName(),product.getIdProduct(),product.getCost(),new Date(product.getTimeStart()),new Date(product.getTimeEnd()),product.getState(),((Flight)product).getArea(),((Flight)product).getFlight_company(),((Flight)product).getArea_start(),((Flight)product).getPlace_start(),((Flight)product).getPlace_end(),((Flight)product).getMore_info());
			
		}
		else if (product instanceof Outing)
		{
			
			result=new OutingDTO(idstage,proman.findEmployeeCreator(product.getIdProduct()),product.getName(),product.getIdProduct(),product.getCost(),new Date(product.getTimeStart()),new Date(product.getTimeEnd()),((Outing) product).getDescription(),((Outing) product).getArea(),product.getState(),((Outing) product).getPlace());
			
		}
		else if (product instanceof Hotel)
		{
			
			result=new HotelDTO(idstage,proman.findEmployeeCreator(product.getIdProduct()),product.getName(),product.getIdProduct(),product.getCost(),new Date(product.getTimeStart()),new Date(product.getTimeEnd()),product.getState(),((Hotel) product).getArea(),((Hotel) product).getPlace(),((Hotel) product).getRoom_type(),((Hotel) product).getMore_info());
			
		}
		return result;
		
	}
	
	/*private  ArrayList <String> customerListToString(List<Customer> friends)
	{  
		ArrayList <String> cusString=new ArrayList<String> (); 
		Iterator<Customer> iter =friends.iterator();
		while(iter.hasNext())
		{
			cusString.add(iter.next().getUsername());
		}
		
		
		return cusString;
		
	}*/
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
	  String idCustomerBuyer=travman.findIdCustomerBuyer(idtravelpackage);
	  System.out.println(idCustomerBuyer+"customer");
	/*  String idCustomerFriendOwner=travman.findIdCustomerFriendOwner(idtravelpackage);
	  System.out.println(idCustomerFriendOwner);
	  */
	  TravelPackageDTO dto=null;
	  if(pre instanceof PrepackedTravelPackage)
	  
	  {
	  String idEmployeeCreator=pretrav.findIdEmployeeCreator(idtravelpackage);
	  System.out.println(idEmployeeCreator+"employee");
	   dto=new PrepackedTravelPackageDTO(idtravelpackage,new Date(pre.getTime_end()),new Date(pre.getTime_start()),pre.getDescription(),pre.getName(),stageList,idCustomerBuyer,pre.getFriendCode(),new Date(pre.getPurchaseTime()),idEmployeeCreator,pre.getTravelState());
	  }
	  else if (pre instanceof CustomizedTravelPackage)
	  {
		  String idCustomizer=custrav.findIdCustomizer(idtravelpackage);
		  dto=new CustomizedTravelPackageDTO(idtravelpackage,new Date(pre.getTime_end()),new Date(pre.getTime_start()),pre.getDescription(),pre.getName(),stageList,idCustomerBuyer,pre.getFriendCode(),new Date(pre.getPurchaseTime()),idCustomizer,pre.getTravelState());
		  
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
		  	
		  	ArrayList <ProductDTO> forStage=productListToDTO(stage.getProducts());
		  	
		  			
		  	
		  	StageDTO stageDTO=new StageDTO(stage.getIdStage(),forStage,stage.getArea(),new Date(stage.getTimeStart()),new Date(stage.getTimeEnd()));
		  	stageDTOList.add(stageDTO);
			
		}
		
		return stageDTOList;
		
		
		
	}
	
		  	

	
	
	public ArrayList <ProductDTO> productListToDTO(List <Product> prodlist)
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
		//ArrayList <String> friends=customerListToString(customer.getFriends());
		ArrayList <TravelPackageDTO> purchasedTravelPackage = travelPackageToDTO(customer.getPurchasedTravelPackages());
		//ArrayList <TravelPackageDTO> preparedForAFriendTravelPackage=travelPackageToDTO(customer.getPreparedForAFriendTravelPackages());
	    ArrayList <GiftListDTO> giftList =giftListCollectionTODTO(customer.getGiftLists());
	    ArrayList <CustomizedTravelPackageDTO> customizedTravelPackage=this.customizedTravelPackageToDTO(customer.getCustomizedTravelPackages());
	   	CustomerDTO cust=new CustomerDTO(customer.getEmail(),customer.getName(), customer.getSurname(),customer.getTelephone(), customer.getPassword(),customer.getUsername()/*,friends*/,purchasedTravelPackage/*,preparedForAFriendTravelPackage*/,giftList,customizedTravelPackage);

		return cust;
		
		
	}
	
	public  EmployeeDTO toTDO(Employee employee)
	{
		ArrayList<ProductDTO> managedproduct=productListToDTO(employee.getManagedProduct());
		ArrayList<PrepackedTravelPackageDTO> managedTravelPackage=prepackedTravelPackageToDTO(employee.getManagedTravelPackage());
		EmployeeDTO emplo=new EmployeeDTO(employee.getEmail(),employee.getName(),employee.getSurname(),employee.getTelephone(),employee.getPassword(),employee.getUsername(),employee.getCode().getCode(),managedproduct,managedTravelPackage);
		return emplo;
		
		
	}
	public GiftListDTO giftListToDTO(GiftList gift)//TODO to check
	{   String idCustomer=giftMan.findCustomerCreator(gift.getProduct().getIdProduct());
		
		return new GiftListDTO (productToDTO(gift.getProduct()),gift.getIdBuyer(),gift.getMoreInfo(),gift.isBought(),gift.getTravelPackage().getIdtravelpackage(),idCustomer);
				
	}
   public ArrayList <GiftListDTO> giftListCollectionTODTO(List <GiftList> gift)
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
    * Private method that transform the CustomerDTO in the entity customer , used during the registration phase
    * @param customer -->the customer DTO acquired from the web tier
    * @return the entity Customer translated from the CustomerDTO
    */
   public Customer dtoToCustomer(CustomerDTO customer)
   {
   	List<Group> groups=new ArrayList <Group>();
       groups.add(Group.CUSTOMER);
       List<CustomizedTravelPackage> customizedTravelPackages=new ArrayList <CustomizedTravelPackage>();
/*       List<Customer> friends=new ArrayList <Customer>();
*/       List<TravelPackage> purchasedTravelPackages=new ArrayList<TravelPackage>();
/*       List<TravelPackage> preparedForAFriendTravelPackages=new ArrayList <TravelPackage>();
*/       List<GiftList> giftLists=new ArrayList <GiftList>();
       Customer real=new Customer(customer.getEmail(),customer.getName(),customer.getSurname(),customer.getTelephone(),DigestUtils.sha256Hex(customer.getPassword()),customer.getUsername(),groups,customizedTravelPackages,/*friends,*/purchasedTravelPackages/*,preparedForAFriendTravelPackages*/,giftLists); 
       
  	   return real;
   	
   }
   public Product productDTOToEntity(ProductDTO product)
   {
   	Product entity=null;
   	if(product instanceof HotelDTO )
   	{
   		 
   		entity=new Hotel(product.getCost(),product.getTimeStart().getTime(),product.getTimeEnd().getTime(),product.getName(),product.getState(),((HotelDTO)product).getArea(),((HotelDTO)product).getPlace(),((HotelDTO)product).getRoom_type(),((HotelDTO)product).getMore_info());
   	}
   	else if (product instanceof FlightDTO)
   	{
   		
   		 entity=new Flight(product.getCost(),product.getTimeStart().getTime(),product.getTimeEnd().getTime(),product.getName(),((FlightDTO)product).getArea(),((FlightDTO)product).getFlight_company(),((FlightDTO)product).getArea_start(),((FlightDTO)product).getPlace_start(),((FlightDTO)product).getPlace_end(),((FlightDTO)product).getMore_info(),product.getState());   		
   		
   	
   	}
   	else if (product instanceof OutingDTO)
   		
   	{
   		entity=new Outing(product.getCost(),product.getTimeStart().getTime(),product.getTimeEnd().getTime(),product.getName(),((OutingDTO)product).getDescription(),((OutingDTO)product).getArea(),product.getState(),((OutingDTO) product).getPlace());
   		
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
			  travelpackage=new PrepackedTravelPackage(travel.getTime_end().getTime(),travel.getTime_start().getTime(),travel.getDescription(),travel.getName(),stages,travel.getFriendCode(),travel.getPurchaseTime().getTime(),travel.getTravelState());
				
			  
		  }
		  else if(travel instanceof CustomizedTravelPackageDTO)
		  {
			  travelpackage=new CustomizedTravelPackage(travel.getTime_end().getTime(),travel.getTime_start().getTime(),travel.getDescription(),travel.getName(),stages,travel.getFriendCode(),travel.getPurchaseTime().getTime(),travel.getTravelState());
			  
		  }
		  
		  
		  
		  
		  
		  
		  
	  }
	  else
	  {
		  stages=stageListDTOToEntityUpdate(travel.getStages());
		  if(travel instanceof PrepackedTravelPackageDTO)
		  {
			  travelpackage=new PrepackedTravelPackage(travel.getIdtravelpackage(),travel.getTime_end().getTime(),travel.getTime_start().getTime(),travel.getDescription(),travel.getName(),stages,travel.getFriendCode(),travel.getPurchaseTime().getTime(),travel.getTravelState());
		  }
		  else if(travel instanceof CustomizedTravelPackageDTO)
		  {
			  
			  travelpackage=new CustomizedTravelPackage(travel.getIdtravelpackage(),travel.getTime_end().getTime(),travel.getTime_start().getTime(),travel.getDescription(),travel.getName(),stages,travel.getFriendCode(),travel.getPurchaseTime().getTime(),travel.getTravelState());
			  
		  }
	  }
	   
	  
	  
	  
	   return travelpackage;
	   
	   
	   
	   
	   
	   
   }
   
   
   private List <CustomizedTravelPackage> customizedTravelPackageDTOListToEntity( ArrayList <CustomizedTravelPackageDTO> pretraveldtolist)
   {
	   ArrayList <CustomizedTravelPackage> travellist=new ArrayList<CustomizedTravelPackage>();
	   Iterator <CustomizedTravelPackageDTO> iter=pretraveldtolist.iterator();
	   while(iter.hasNext())
	   {
		   TravelPackage travel=travelPackageDTOToEntity(iter.next(), false);
		   travellist.add((CustomizedTravelPackage)travel);
	   }
	   
	   return travellist;
	      
   }
   
   
   
   private List <PrepackedTravelPackage> prepackedTravelPackageDTOListToEntity( ArrayList <PrepackedTravelPackageDTO> pretraveldtolist)
   {
	   ArrayList <PrepackedTravelPackage> travellist=new ArrayList<PrepackedTravelPackage>();
	   Iterator <PrepackedTravelPackageDTO> iter=pretraveldtolist.iterator();
	   while(iter.hasNext())
	   {
		   TravelPackage travel=travelPackageDTOToEntity(iter.next(), false);
		   travellist.add((PrepackedTravelPackage)travel);
	   }
	   
	   return travellist;
	      
   }
   private List <TravelPackage>  travelPackageDTOListToEntity( ArrayList <TravelPackageDTO> traveldtolist)
   {
	   ArrayList <TravelPackage> travellist=new ArrayList<TravelPackage>();
	   Iterator <TravelPackageDTO> iter=traveldtolist.iterator();
	   while(iter.hasNext())
	   {
		   TravelPackage travel=travelPackageDTOToEntity(iter.next(), false);
		   travellist.add(travel);
	   }
	   
	   return travellist;
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
	   
	   
	   
	return new Stage(stagedto.getArea(),productDTOListToEntity(stagedto.getProducts()),stagedto.getTimeStart().getTime(),stagedto.getTimeEnd().getTime());
	   
	   
	   
   }
   private Stage stageDTOToEntityUpdate(StageDTO stagedto)
   {
	   
	   
	   return new Stage(stagedto.getIdStage(),stagedto.getArea(),productDTOListToEntityUpdate(stagedto.getProducts()),stagedto.getTimeStart().getTime(),stagedto.getTimeEnd().getTime());
   }
   
   
   public Product productDTOToEntityUpdate(ProductDTO product)
   {
   	Product entity=null;
   	if(product instanceof HotelDTO )
   	{
   		entity=new Hotel(product.getIdProduct(),product.getCost(),product.getTimeStart().getTime(),product.getTimeEnd().getTime(),product.getName(),product.getState(),((HotelDTO)product).getArea(),((HotelDTO)product).getRoom_type(),((HotelDTO)product).getMore_info(),((HotelDTO)product).getPlace());
   	}
   	else if (product instanceof FlightDTO)
   	{
   		 entity=new Flight(product.getIdProduct(),product.getCost(),product.getTimeStart().getTime(),product.getTimeEnd().getTime(),product.getName(),((FlightDTO)product).getArea(),((FlightDTO)product).getFlight_company(),((FlightDTO)product).getArea_start(),((FlightDTO)product).getPlace_start(),((FlightDTO)product).getPlace_end(),((FlightDTO)product).getMore_info(),product.getState());   		
   		
   	
   	}
   	else if (product instanceof OutingDTO)
   	{
   		entity=new Outing(product.getIdProduct(),product.getCost(),product.getTimeStart().getTime(),product.getTimeEnd().getTime(),product.getName(),((OutingDTO)product).getDescription(),((OutingDTO)product).getArea(),product.getState(),((OutingDTO) product).getPlace());
   		
   	}
   	return entity;
   }

   
   private List <Product> productDTOListToEntityUpdate(ArrayList <ProductDTO> productDTOList)
   {   List <Product> productList=new ArrayList <Product> ();
	   Iterator <ProductDTO> iter=productDTOList.iterator();
	   while(iter.hasNext())
	   {
		   productList.add(productDTOToEntityUpdate(iter.next()));
		   
		   
	   }
	   
	   
	return productList;
	   
   }
   public ArrayList <OutingDTO> outingListToDTO(List <Outing> outing)
   {   
	   ArrayList <OutingDTO> outingDTO=new ArrayList <OutingDTO>();
	   Iterator <Outing> iter=outing.iterator();
	   while(iter.hasNext())
	   {
		   OutingDTO partial=(OutingDTO)productToDTO(iter.next());
		   outingDTO.add(partial);
		   
	   }
	   return outingDTO;
	   
	   
   }
   public ArrayList <FlightDTO> flightListToDTO(List <Flight> flight)
   {   
	   ArrayList <FlightDTO> flightDTO=new ArrayList <FlightDTO>();
	   Iterator <Flight> iter=flight.iterator();
	   while(iter.hasNext())
	   {
		   FlightDTO partial=(FlightDTO)productToDTO(iter.next());
		   flightDTO.add(partial);
		   
	   }
	   return flightDTO;
	   
	   
   } public ArrayList <HotelDTO> hotelListToDTO(List <Hotel> hotel)
   {   
	   ArrayList <HotelDTO> hotelDTO=new ArrayList <HotelDTO>();
	   Iterator <Hotel> iter=hotel.iterator();
	   while(iter.hasNext())
	   {
		   HotelDTO partial=(HotelDTO)productToDTO(iter.next());
		   hotelDTO.add(partial);
		   
	   }
	   return hotelDTO;
	   
	   
   }
   public ProductDTO findClonedProduct(ProductDTO toClone)
   {
   	
   	ProductDTO prodto=null;
   	if(toClone instanceof HotelDTO)
   	{
   		Hotel hotel=(Hotel)hotman.findFirstHotelAvailable((HotelDTO)toClone);
   		if(hotel!=null)
   		prodto=productToDTO(hotel);
   		
   	}
   	else if(toClone instanceof OutingDTO)
   	{Outing outing=(Outing)outman.findFirstOutingAvailable((OutingDTO)toClone);
   	if(outing!=null)
   		prodto=productToDTO(outing);
   		
   	}
   	else if(toClone instanceof FlightDTO)
   		
   	{     Flight flight=(Flight)fliman.findFirstFlightAvailable((FlightDTO)toClone);
   	
   	if(flight!=null)
   		prodto=productToDTO(flight);
   	}
   	
		return prodto;
   	
   	
   	
   }
   
}
