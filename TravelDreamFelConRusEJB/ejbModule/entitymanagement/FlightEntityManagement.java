package entitymanagement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import stateenum.State;
import entities.Flight;
import entities.Hotel;
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
    
   
	@Override
	public  List<Flight> findAllByParameter(Object par) {
		Query q= em.createQuery("SELECT c from Flight c   where c.state =:par",Flight.class);
		q.setParameter("par", par);
		List <Flight> list=q.getResultList();
		if(list!=null)
		return new ArrayList <Flight> (list);
		else
		return new ArrayList <Flight> ();
	}
   public <Flight>List<Flight> findALLByStateAndAreaStart(State state, Calendar time,String area)
   {
	   Query q= em.createQuery("SELECT c from Flight c where c.state =:par and c.area_start=:area and c.timestart=:time");
		q.setParameter("par",state);
		q.setParameter("area",state);
		q.setParameter("time",time);

		List <Flight> list=q.getResultList();
		if(list!=null)
		return new ArrayList <Flight> (list);
		else
		return new ArrayList <Flight> ();
	   
   }
   public <Flight>List<Flight> findALLByStateAndAreaEnd(State state, Calendar time,String area)
   {
	   Query q= em.createQuery("SELECT c from Flight c where c.state =:par and c.area=:area and c.timestart=:time");
		q.setParameter("par",state);
		q.setParameter("area",state);
		q.setParameter("time",time);

		List <Flight> list=q.getResultList();
		if(list!=null)
		return new ArrayList <Flight> (list);
		else
		return new ArrayList <Flight> ();
	   
   }
   
}
