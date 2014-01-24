package entitymanagement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
   public <Flight>List<Flight> findALLByStateAndAreaStart(State state, Date timeStart,Date timeEnd,String area)
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
   public <Flight>List<Flight> findALLByStateAndAreaEnd(State state, Date timeStart,Date timeEnd,String area)
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
   private <Flight >List<Flight> findFlightEquivalent(FlightDTO flightDTO ,int number)
   {   State state=State.AVAILABLE;
   	Query q= em.createQuery("SELECT c from Flight c where c.area_start=:areastart and c.area=:area and c.place_start=:place_start and c.place_end=:place_end and c.name=:name and c.cost=:cost and c.state =:state and c.timeStart=:timestart and c.timeEnd=:timeend and c.flight_company=:flight_company  ");
   	q.setParameter("state", state);
   	q.setParameter("timestart",flightDTO.getTimeStart());
   	q.setParameter("timeend", flightDTO.getTimeEnd());
   	q.setParameter("areastart", flightDTO.getArea_start());
   	q.setParameter("area", flightDTO.getArea());
   	q.setParameter("cost", flightDTO.getCost());
   	q.setParameter("place_start", flightDTO.getPlace_start());
   	q.setParameter("place_end", flightDTO.getPlace_end());
   	q.setParameter("flight_company", flightDTO.getFlight_company());
	q.setParameter("name", flightDTO.getName());

   	List <Flight> list=q.getResultList();
   	if(list!=null && list.size()>=number)
   		return new ArrayList <Flight> (list);
   		else
   		return new ArrayList <Flight> ();
   }
   public boolean findBooleanFlightEquivalent(FlightDTO flightDTO ,int number)
   {
   	return (findFlightEquivalent(flightDTO , number).size())>=number;
   	
   	
   }
   public int findIntegerFlightEquivalent(FlightDTO  flightDTO)
   {
	   State state=State.AVAILABLE;
	   	Query q= em.createQuery("SELECT c from Flight c where c.area_start=:areastart and c.area=:area and c.place_start=:place_start and c.place_end=:place_end and c.name=:name and c.cost=:cost and c.state =:state and c.timeStart=:timestart and c.timeEnd=:timeend and c.flight_company=:flight_company  ");
	   	q.setParameter("state", state);
	   	q.setParameter("timestart",flightDTO.getTimeStart());
	   	q.setParameter("timeend", flightDTO.getTimeEnd());
	   	q.setParameter("areastart", flightDTO.getArea_start());
	   	q.setParameter("area", flightDTO.getArea());
	   	q.setParameter("cost", flightDTO.getCost());
	   	q.setParameter("place_start", flightDTO.getPlace_start());
	   	q.setParameter("place_end", flightDTO.getPlace_end());
	   	q.setParameter("flight_company", flightDTO.getFlight_company());
		q.setParameter("name", flightDTO.getName());

	   	List <Flight> list=q.getResultList();
	   	if(list!=null )
	   		return list.size();
	   		else
	   		return 0;
   	
   	}
   
}
