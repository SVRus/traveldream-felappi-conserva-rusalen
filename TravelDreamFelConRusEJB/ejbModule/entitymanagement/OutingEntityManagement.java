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
import dto.OutingDTO;
import stateenum.State;
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

	
	@Override
	public List<Outing> findAllByParameter(Object par) {
		
		Query q= em.createQuery("SELECT c from Outing c where c.state =:par",Outing.class);
		q.setParameter("par", par);
		List <Outing> list=q.getResultList();
		if(list!=null)
		return new ArrayList <Outing> (list);
		else
		return new ArrayList <Outing> ();
	}
	  public <Outing>List<Outing> findALLByStateAndArea(State state, Long timeStart,Long timeEnd,String area)
	   {

			Query q= em.createQuery("SELECT c from Outing c   where c.state =:state  and c.area=:area  and c.timeStart>=:timestart and c.timeEnd<=:timeend");
			q.setParameter("state", state);
			q.setParameter("timestart",timeStart);
			q.setParameter("timeend", timeEnd);
			q.setParameter("area", area);
			List <Outing> list=q.getResultList();
			if(list!=null)
			return new ArrayList <Outing> (list);
			else
			return new ArrayList <Outing> ();
		   
	   }
	  private <Outing>List<Outing> findOutingEquivalent(OutingDTO outingDTO ,int number)
	  {   State state=State.AVAILABLE;
	  	Query q= em.createQuery("SELECT c from Outing c   where c.name=:name and c.cost=:cost and c.state =:state  and c.area=:area  and c.timeStart=:timestart and c.timeEnd=:timeend and c.description=:description and c.place=:place");
	  	q.setParameter("state", state);
	  	q.setParameter("timestart",outingDTO.getTimeStart().getTime());
	  	q.setParameter("timeend", outingDTO.getTimeEnd().getTime());
	  	q.setParameter("area", outingDTO.getArea());
	  	q.setParameter("cost", outingDTO.getCost());
	  	q.setParameter("place", outingDTO.getPlace());
	  	q.setParameter("description", outingDTO.getDescription());
		q.setParameter("name", outingDTO.getName());

	  	List <Outing> list=q.getResultList();
	  	if(list!=null && list.size()>=number)
	  		return new ArrayList <Outing> (list);
	  		else
	  		return new ArrayList <Outing> ();
	  }
	  public boolean findBooleanOutingEquivalent(OutingDTO outingDTO ,int number)
	  {
	  	return (findOutingEquivalent(outingDTO , number).size())>=number;
	  	
	  	
	  }
	  public int findIntegerOutingEquivalent(OutingDTO outingDTO )
	  {
		  
		  
		  State state=State.AVAILABLE;
		  	Query q= em.createQuery("SELECT c from Outing c where c.name=:name and c.cost=:cost and c.state =:state  and c.area=:area  and c.timeStart=:timestart and c.timeEnd=:timeend and c.description=:description and c.place=:place");
		  	q.setParameter("state", state);
		  	q.setParameter("timestart",outingDTO.getTimeStart().getTime());
		  	q.setParameter("timeend", outingDTO.getTimeEnd().getTime());
		  	q.setParameter("area", outingDTO.getArea());
		  	q.setParameter("cost", outingDTO.getCost());
		  	q.setParameter("place", outingDTO.getPlace());
		  	q.setParameter("description", outingDTO.getDescription());
			q.setParameter("name", outingDTO.getName());

		  	List <Outing> list=q.getResultList();
		  	if(list!=null )
		  		return list.size();
		  		else
		  		return 0;
	  	
	  	}
	  public <Outing> Outing findFirstOutingAvailable(OutingDTO outingDTO)
	  {
		  State state=State.AVAILABLE;
		  	Query q= em.createQuery("SELECT c from Outing c   where c.name=:name and c.cost=:cost and c.state =:state  and c.area=:area  and c.timeStart=:timestart and c.timeEnd=:timeend and c.description=:description and c.place=:place");
		  	q.setParameter("state", state);
		  	q.setParameter("timestart",outingDTO.getTimeStart().getTime());
		  	q.setParameter("timeend", outingDTO.getTimeEnd().getTime());
		  	q.setParameter("area", outingDTO.getArea());
		  	q.setParameter("cost", outingDTO.getCost());
		  	q.setParameter("place", outingDTO.getPlace());
		  	q.setParameter("description", outingDTO.getDescription());
			q.setParameter("name", outingDTO.getName());

		  	List <Outing> list=q.getResultList();
		  	if(list==null||list.size()==0)
		  		return null;
		  		else
		  			return list.get(0);
		  
		  
		  
		  
	  }

}
