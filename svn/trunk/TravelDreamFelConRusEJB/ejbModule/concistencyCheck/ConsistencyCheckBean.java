package concistencyCheck;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.ProductDTO;
import entities.TravelPackage;

/**
 * Session Bean implementation class ConsistencyCheckBean
 */
@Stateless
@LocalBean
public class ConsistencyCheckBean implements ConsistencyCheckBeanLocal {

    /**
     * Default constructor. 
     */
    public ConsistencyCheckBean() {
        // TODO Auto-generated constructor stub
    }
//TODO
   /* public boolean checkConsistency(ProductDTO product)
    {
    	TravelPackage travel
    	
    	
    }
    */
    
    
}
