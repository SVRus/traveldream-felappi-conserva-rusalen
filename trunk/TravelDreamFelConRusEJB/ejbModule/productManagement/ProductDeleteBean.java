package productManagement;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.ProductDTO;
import entities.Product;
import entitymanagement.FlightEntityManagementLocal;
import entitymanagement.HotelEntityManagementLocal;
import entitymanagement.OutingEntityManagementLocal;
import entitymanagement.ProductEntityManagementLocal;

/**
 * Session Bean implementation class ProductDeleteBean
 */
@Stateless
@LocalBean
public class ProductDeleteBean implements ProductDeleteBeanLocal {
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
    public ProductDeleteBean() {
        // TODO Auto-generated constructor stub
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
    
    
}
