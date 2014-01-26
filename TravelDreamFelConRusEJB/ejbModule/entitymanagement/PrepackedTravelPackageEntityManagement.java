package entitymanagement;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Outing;
import entities.PrepackedTravelPackage;
import entities.Product;

/**
 * Session Bean implementation class PrepackedTravelPackageEntityManagement
 */
@Stateless
@LocalBean
public class PrepackedTravelPackageEntityManagement extends AbstractEntityManagement implements PrepackedTravelPackageEntityManagementLocal {

    /**
     * Default constructor. 
     */
    public PrepackedTravelPackageEntityManagement() {
    	 super(PrepackedTravelPackage.class);
    }
    @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public String findIdEmployeeCreator(Long idPrepackedTravelPackage)
	{
		Query query = em.createNativeQuery("SELECT  idemployeecreator FROM prepackedtravelpackage where idtravelpackage=? ");
   	     query.setParameter(1, idPrepackedTravelPackage);
   	   
   	    	Object result=  query.getSingleResult();
   	    	if (result==null)
   	    	return null;
   	    	else
   	    	return (String)result;
    	
		
		
		
		
		
	}

	

	@Override
	public List findAllByParameter(Object par) {

		Query q= em.createQuery("SELECT c from PrepackedTravelPackage c where c.travelState =:par",PrepackedTravelPackage.class);
		q.setParameter("par", par);
		List <PrepackedTravelPackage> list=q.getResultList();
		if(list!=null)
		return new ArrayList <PrepackedTravelPackage> (list);
		else
		return new ArrayList <PrepackedTravelPackage> ();
	}
	
    
    
}
