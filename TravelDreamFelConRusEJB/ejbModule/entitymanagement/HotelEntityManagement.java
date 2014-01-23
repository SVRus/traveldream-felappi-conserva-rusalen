package entitymanagement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import stateenum.State;
import entities.Hotel;
import entities.Outing;

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
    @Override
	public List<Hotel> findAllByParameter(Object par) {
		
		Query q= em.createQuery("SELECT c from Hotel c   where c.state =:par ",Hotel.class);
		q.setParameter("par", par);
		List <Hotel> list=q.getResultList();
		if(list!=null)
		return new ArrayList <Hotel> (list);
		else
		return new ArrayList <Hotel> ();
	}

public <Hotel>List<Hotel> findAllByStateAndArea(State state,Calendar timeStart,Calendar timeEnd,String area)
{
		
		Query q= em.createQuery("SELECT c from Hotel c   where c.state =:state and c.timestart>=:timestart and c.area=:area and c.timeend<=:timeend ");
		q.setParameter("state", state);
		q.setParameter("timestart",timeStart);
		q.setParameter("timeend", timeEnd);
		q.setParameter("area", area);
		List <Hotel> list=q.getResultList();
		if(list!=null)
		return new ArrayList <Hotel> (list);
		else
		return new ArrayList <Hotel> ();
}






}
