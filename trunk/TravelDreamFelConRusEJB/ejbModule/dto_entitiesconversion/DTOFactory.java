package dto_entitiesconversion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.ProductDTO;
import dto.FlightDTO;
import entities.Customer;
import entities.CustomizedTravelPackage;
import entities.Employee;
import entities.Flight;
import entities.GiftList;
import entities.Hotel;
import entities.Outing;
import entities.Product;
import entities.TravelPackage;
import entitymanagement.ProductEntityManagementLocal;
@Stateless
@LocalBean
public class DTOFactory {
@EJB
ProductEntityManagementLocal proman;
	private  ProductDTO productToDTO(Product product)
	{ 
		ProductDTO result=null;
	
		if (product instanceof  Flight)
		{   product=(Flight)product;
			result=new FlightDTO(product.getTravel().getIdtravelpackage(),proman.findEmployeeCreator(product.getIdproduct()),product.getName(),product.getCost(),product.getTimeStart(),product.getTimeEnd(),((Flight)product).getFlight_company(),((Flight)product).getArea_start(),((Flight)product).getArea_end(),((Flight)product).getPlace_start(),((Flight)product).getPlace_end(),((Flight)product).getMore_info());
			
		}
		else if (product instanceof Outing)
		{
			product=(Outing)product;
			result=new OutingDTO(product.getTravel().getIdtravelpackage(),proman.findEmployeeCreator(product.getIdproduct()),product.getName(),product.getCost(),product.getTimeStart(),product.getTimeEnd(),((Outing) product).getDescription(),((Outing) product).getArea());
			
		}
		else if (product instanceof Hotel)
		{
			product=(Hotel)product;
			result=new HotelDTO(product.getTravel().getIdtravelpackage(),proman.findEmployeeCreator(product.getIdproduct()),product.getName(),product.getCost(),product.getTimeStart(),product.getTimeEnd(),((Hotel) product).getArea(),((Hotel) product).getPlace(),((Hotel) product).getRoom_type(),((Hotel) product).getMore_info());
			
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
	
	private ArrayList<ProductDTO> productListToDTO(List <Product> prodlist)
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
		EmployeeDTO emplo=new EmployeeDTO(employee.getEmail(),employee.getName(),employee.getSurname(),employee.getTelephone(),employee.getPassword(),employee.getUsername());
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

}
