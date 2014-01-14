package productManagement;

import java.util.Date;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import concistencyCheck.ConsistencyCheckBeanLocal;
import dto.FlightDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.ProductDTO;
import entities.Flight;
import entities.Hotel;
import entities.Outing;
import entities.Product;
import entities.TravelPackage;
import entitymanagement.FlightEntityManagementLocal;
import entitymanagement.HotelEntityManagementLocal;
import entitymanagement.OutingEntityManagementLocal;
import groupenum.Group;

/**
 * Session Bean implementation class ProductCreateBean
 */
@Stateless
@LocalBean
public class ProductCreateBean implements ProductCreateBeanLocal {
@EJB
OutingEntityManagementLocal outing;
@EJB
HotelEntityManagementLocal hotel;
@EJB
FlightEntityManagementLocal flight;
@EJB
ConsistencyCheckBeanLocal check;
    /**
     * Default constructor. 
     */
    public ProductCreateBean() {
       
    }
   
    public boolean createProduct(ProductDTO productdto)
    {   Product product=productDTOToEntity(productdto);
		boolean ok=false;
		if( product instanceof Hotel)
		{
			try
			{   
				hotel.create(product);
				
				ok=true;
			}
			catch(Exception e)
			{
				ok=false;
				
			}
		}
		else if(product instanceof Outing)
		{
			try
			{   
				outing.create(product);
				
				ok=true;
			}
			catch(Exception e)
			{
				ok=false;
				
			}
			
			
		}
		else if(product instanceof Flight)
		{
			try
			{   
				flight.create(product);
				
				ok=true;
			}
			catch(Exception e)
			{
				ok=false;
				
			}
			
		}
    	    	
    	
    	return ok;
    	
   }
    
    private Product productDTOToEntity(ProductDTO product)
    {
    	Product entity=null;
    	if(product instanceof HotelDTO )
    	{
    		entity=new Hotel(product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),null,((HotelDTO)product).getArea(),((HotelDTO)product).getPlace(),((HotelDTO)product).getRoom_type(),((HotelDTO)product).getMore_info());
    	}
    	else if (product instanceof FlightDTO)
    	{
    		 entity=new Flight(product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),null,((FlightDTO)product).getFlight_company(),((FlightDTO)product).getArea_start(),((FlightDTO)product).getArea_end(),((FlightDTO)product).getPlace_start(),((FlightDTO)product).getPlace_end(),((FlightDTO)product).getMore_info());   		
    		
    	
    	}
    	else if (product instanceof OutingDTO)
    	{
    		entity=new Outing(product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),null,((OutingDTO)product).getDescription(),((OutingDTO)product).getArea());
    		
    	}
    	return entity;
    }
    
}
