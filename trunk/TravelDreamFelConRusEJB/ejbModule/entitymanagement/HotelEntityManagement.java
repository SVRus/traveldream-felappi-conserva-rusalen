package entitymanagement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dto.HotelDTO;
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

public <Hotel>List<Hotel> findAllByStateAndArea(State state,Long timeStart,Long timeEnd,String area)
{
		
		Query q= em.createQuery("SELECT c from Hotel c   where c.state =:state  and c.area=:area  and c.timeStart>=:timestart and c.timeEnd<=:timeend");
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
private <Hotel >List<Hotel> findHotelEquivalent(HotelDTO hotelDTO ,int number)
{   State state=State.AVAILABLE;
	Query q= em.createQuery("SELECT c from Hotel c   where c.name=:name and c.cost=:cost and c.state =:state  and c.area=:area  and c.timeStart=:timestart and c.timeEnd=:timeend and c.room_type=:room_type and c.place=:place");
	q.setParameter("state", state);
	q.setParameter("name", hotelDTO.getName());

	q.setParameter("timestart",hotelDTO.getTimeStart().getTime());
	q.setParameter("timeend", hotelDTO.getTimeEnd().getTime());
	q.setParameter("area", hotelDTO.getArea());
	q.setParameter("cost", hotelDTO.getCost());
	q.setParameter("place", hotelDTO.getPlace());
	q.setParameter("room_type", hotelDTO.getRoom_type());

	List <Hotel> list=q.getResultList();
	if(list!=null && list.size()>=number)
		return new ArrayList <Hotel> (list);
		else
		return new ArrayList <Hotel> ();
}
public boolean findBooleanHotelEquivalent(HotelDTO hotelDTO ,int number)
{
	return (findHotelEquivalent(hotelDTO , number).size())>=number;
	
	
}
public int findIntegerHotelEquivalent(HotelDTO hotelDTO )
{
	 State state=State.AVAILABLE;
		Query q= em.createQuery("SELECT c from Hotel c   where  c.cost=:cost and c.state =:state  and c.area=:area    and c.place=:place and c.timeStart=:timestart and c.timeEnd=:timeend and c.room_type=:room_type");
		q.setParameter("state", state);
		q.setParameter("area", hotelDTO.getArea());
		q.setParameter("cost", hotelDTO.getCost());
		q.setParameter("place", hotelDTO.getPlace());
		q.setParameter("timestart", hotelDTO.getTimeStart().getTime());
        q.setParameter("timeend",hotelDTO.getTimeEnd().getTime());
        q.setParameter("room_type",hotelDTO.getRoom_type());

		List <Hotel> list=q.getResultList();
		System.out.print("la lista è "+list.toString()+list.size());
		
			return (new ArrayList <Hotel>(list)).size();
		
		
	
	}
public <Hotel> Hotel findFirstHotelAvailable(HotelDTO hotelDTO)
{ State state=State.AVAILABLE;
Query q= em.createQuery("SELECT c from Hotel c   where c.name=:name and c.cost=:cost and c.state =:state  and c.area=:area  and c.timeStart=:timestart and c.timeEnd=:timeend and c.room_type=:room_type and c.place=:place");
q.setParameter("state", state);
q.setParameter("name", hotelDTO.getName());

q.setParameter("timestart",hotelDTO.getTimeStart().getTime());
q.setParameter("timeend", hotelDTO.getTimeEnd().getTime());
q.setParameter("area", hotelDTO.getArea());
q.setParameter("cost", hotelDTO.getCost());
q.setParameter("place", hotelDTO.getPlace());
q.setParameter("room_type", hotelDTO.getRoom_type());

List <Hotel> list=q.getResultList();
	if(list==null||list.size()==0)
		return null;
		else
			return list.get(0);
	
}
}
