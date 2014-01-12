package entitymanagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Outing;

/**
 * Session Bean implementation class OutingEntityManagement
 */
@Stateless
public class OutingEntityManagement extends AbstractEntityManagement implements OutingEntityManagementLocal {
	 @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
	    private EntityManager em;
    /**
     * Default constructor. 
     */
    public OutingEntityManagement() {
    	super (Outing.class);
    }
       
    @Override
	protected EntityManager getEntityManager() {
		 return em;
	}
  

}
