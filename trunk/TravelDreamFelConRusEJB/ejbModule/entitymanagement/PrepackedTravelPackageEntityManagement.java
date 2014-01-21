package entitymanagement;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    public Long findIdEmployeeCreator(Long idPrepackedTravelPackage)
	{
		Query query = em.createNativeQuery("SELECT  idemployeecreator FROM prepackedtravelpackage where idtravelpackage=? ");
   	     query.setParameter(1, idPrepackedTravelPackage);
   	   Long id;
   	    	Object result=  query.getSingleResult();
   	    	if (result==null)
   	    	id=new Long(0);
   	    	else
   	    	id=(Long)result;
    	
		return id;
		
		
		
		
		
	}

	

	@Override
	public List findAllByParameter(Object par) {
		// TODO Auto-generated method stub
		return null;
	}
	
    
    
}
