package entitymanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Stage;

/**
 * Session Bean implementation class StageEntityManagementBean
 */
@Stateless
public class StageEntityManagement extends AbstractEntityManagement implements StageEntityManagementLocal {
	 @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
	    private EntityManager em;
    /**
     * Default constructor. 
     */
    public StageEntityManagement() {
       super(Stage.class);
    }
       
   
    @Override
   	protected EntityManager getEntityManager() {
   		 return em;
   	}


	@Override
	public List findAllByParameter(Object par) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Long findIdTravelPackageContainer(Long idStage)
	{
		Query query = em.createNativeQuery("SELECT IDTRAVELPACKAGE FROM Stage WHERE idStage =?");
	    query.setParameter(1, idStage);
	    
	   
	    	Long result=(Long) query.getResultList().get(0);
	    	
	    	return result ;
	    	
		
		
		
	}
}
