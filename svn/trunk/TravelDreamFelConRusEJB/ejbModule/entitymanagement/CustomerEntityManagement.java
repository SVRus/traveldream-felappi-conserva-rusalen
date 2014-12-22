package entitymanagement;

import java.util.List;

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
	 @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
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




	

	@Override
	public List findAllByParameter(Object par) {
		// TODO Auto-generated method stub
		return null;
	}
       
   

}
