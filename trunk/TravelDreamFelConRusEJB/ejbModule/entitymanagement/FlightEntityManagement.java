package entitymanagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Flight;
import entities.Outing;

/**
 * Session Bean implementation class FlightEntityManagement
 */
@Stateless
public class FlightEntityManagement extends AbstractEntityManagement implements FlightEntityManagementLocal {
	 @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
	    private EntityManager em;
    /**
     * Default constructor. 
     */
    public FlightEntityManagement() {
    	super (Flight.class);
    }
       
    
    @Override
	protected EntityManager getEntityManager() {
		 return em;
	}
    
    public boolean findEnoughFlight()
    {
    	
    	
    }
   
}
