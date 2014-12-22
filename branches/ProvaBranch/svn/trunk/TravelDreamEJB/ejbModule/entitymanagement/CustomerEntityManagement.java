package entitymanagement;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Customer;

/**
 * Session Bean implementation class CustomerEntityManagement
 */
@Stateless
@LocalBean
public class CustomerEntityManagement extends AbstractEntityManagement implements CustomerEntityManagementLocal {
	 @PersistenceContext(unitName = "TravelDreamEJB")
	    private EntityManager em;

	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	
	
	
	
    /**
     * Default constructor. 
     */
    public CustomerEntityManagement() {
        super (Customer.class);
    }
       
   

}
