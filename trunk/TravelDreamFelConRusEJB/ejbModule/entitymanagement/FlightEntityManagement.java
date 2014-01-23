package entitymanagement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dto.FlightDTO;
import dto.HotelDTO;
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
   public <Flight>List<Flight> findALLByStateAndAreaStart(State state, Calendar timeStart,Calendar timeEnd,String area)
   {

		Query q= em.createQuery("SELECT c from Flight c   where c.state =:state  and c.area_start=:area  and c.timeStart>=:timestart and c.timeEnd<=:timeend");
		q.setParameter("state", state);
		q.setParameter("timestart",timeStart);
		q.setParameter("timeend", timeEnd);
		q.setParameter("area", area);
		List <Flight> list=q.getResultList();
		if(list!=null)
		return new ArrayList <Flight> (list);
		else
		return new ArrayList <Flight> ();
   }
   public <Flight>List<Flight> findALLByStateAndAreaEnd(State state, Calendar timeStart,Calendar timeEnd,String area)
   {

		Query q= em.createQuery("SELECT c from Flight c   where c.state =:state  and c.area=:area  and c.timeStart>=:timestart and c.timeEnd<=:timeend");
		q.setParameter("state", state);
		q.setParameter("timestart",timeStart);
		q.setParameter("timeend", timeEnd);
		q.setParameter("area", area);
		List <Flight> list=q.getResultList();
		if(list!=null)
		return new ArrayList <Flight> (list);
		else
		return new ArrayList <Flight> ();
	   
   }
   private <Flight >List<Flight> findHotelEquivalent(FlightDTO flightDTO ,int number)
   {   State state=State.AVAILABLE;
   	Query q= em.createQuery("SELECT c from Flight c   where c.name=:name and c.cost=:cost and c.state =:state  and c.area=:area  and c.timeStart=:timestart and c.timeEnd=:timeend and c.room_type=:room_type and c.place=:place");
   	q.setParameter("state", state);
   	q.setParameter("timestart",flightDTO.getTimeStart());
   	q.setParameter("timeend", flightDTO.getTimeEnd());
   	q.setParameter("areastart", flightDTO.getArea_start());
   	q.setParameter("areaend", flightDTO.getArea());
   	q.setParameter("cost", flightDTO.getCost());
   	q.setParameter("place", flightDTO.getPlace_start());
   	q.setParameter("place", flightDTO.getPlace_end());
   	q.setParameter("room_type", flightDTO.getFlight_company());
   	q.setParameter("more_info", flightDTO.getMore_info());

   	List <Flight> list=q.getResultList();
   	if(list!=null && list.size()>=number)
   		return new ArrayList <Flight> (list);
   		else
   		return new ArrayList <Flight> ();
   }
   public boolean findBooleanHotelEquivalent(HotelDTO hotelDTO ,int number)
   {
   	return findHotelEquivalent(hotelDTO , number).size()>=number;
   	
   	
   }
   public int findIntegerHotelEquivalent(HotelDTO hotelDTO ,int number)
   {
   	return findHotelEquivalent(hotelDTO , number).size();
   	
   	}
   
}
