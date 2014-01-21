package entitymanagement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
 

}
