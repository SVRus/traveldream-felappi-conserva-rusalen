package entitymanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Hotel;

/**
 * Session Bean implementation class HotelEntityManagement
 */
@Stateless
public class HotelEntityManagement extends AbstractEntityManagement implements HotelEntityManagementLocal {
	 @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
	    private EntityManager em;
    /**
     * Default constructor. 
     */
    public HotelEntityManagement() {
    	super (Hotel.class);
    }
       
   
    @Override
	protected EntityManager getEntityManager() {
		 return em;
	}

public  List<Hotel> findAll()
{
	Query query = em.createNamedQuery("findeveryhotel");
	
	List<Hotel> hotel = query.getResultList();
	return hotel;
	

}

}
