package productManagement;


import javax.annotation.PostConstruct;
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
import entitymanagement.FlightEntityManagementLocal;
import entitymanagement.HotelEntityManagementLocal;
import entitymanagement.OutingEntityManagementLocal;
import entitymanagement.ProductEntityManagementLocal;

/**
 * Session Bean implementation class ProductCreateBean
 */
@Stateless
@LocalBean
public class ProductCRUDBean implements ProductCRUDBeanLocal {
@EJB
OutingEntityManagementLocal outing;
@EJB
HotelEntityManagementLocal hotel;
@EJB
FlightEntityManagementLocal flight;
@EJB
ProductEntityManagementLocal prod;


    /**
     * Default constructor. 
     */
    public ProductCRUDBean() {
       
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
    		entity=new Hotel(product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),((HotelDTO)product).getArea(),((HotelDTO)product).getPlace(),((HotelDTO)product).getRoom_type(),((HotelDTO)product).getMore_info(),product.getState());
    	}
    	else if (product instanceof FlightDTO)
    	{
    		 entity=new Flight(product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),((FlightDTO)product).getFlight_company(),((FlightDTO)product).getArea_start(),((FlightDTO)product).getArea_end(),((FlightDTO)product).getPlace_start(),((FlightDTO)product).getPlace_end(),((FlightDTO)product).getMore_info(),product.getState());   		
    		
    	
    	}
    	else if (product instanceof OutingDTO)
    	{
    		entity=new Outing(product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),((OutingDTO)product).getDescription(),((OutingDTO)product).getArea(),product.getState());
    		
    	}
    	return entity;
    }
    public boolean delete(ProductDTO productdto)
    {
    	boolean ok=false;
		try 
		{
				Product product=prod.find(productdto.getIdProduct());
				prod.remove(product);
				ok=true;
		}
    	catch (Exception e)
		{
    		ok=false;
    		
		}
    	return ok;  	
    	
    }
    public boolean updateProduct(ProductDTO productdto)
    {   Product product=productDTOToEntityUpdate(productdto);
    	boolean ok=false;
    	if( product instanceof Hotel)
    	{
    		try
    		{   
    			hotel.edit(product);
    			
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
    			outing.edit(product);
    			
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
    			flight.edit(product);
    			
    			ok=true;
    		}
    		catch(Exception e)
    		{
    			ok=false;
    			
    		}
    		
    	}
    	    	
    	
    	return ok;
    	
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
    		 entity=new Flight(product.getIdProduct(),product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),((FlightDTO)product).getFlight_company(),((FlightDTO)product).getArea_start(),((FlightDTO)product).getArea_end(),((FlightDTO)product).getPlace_start(),((FlightDTO)product).getPlace_end(),((FlightDTO)product).getMore_info(),product.getState());   		
    		
    	
    	}
    	else if (product instanceof OutingDTO)
    	{
    		entity=new Outing(product.getIdProduct(),product.getCost(),product.getTimeStart(),product.getTimeEnd(),product.getName(),((OutingDTO)product).getDescription(),((OutingDTO)product).getArea(),product.getState());
    		
    	}
    	return entity;
    }

}
