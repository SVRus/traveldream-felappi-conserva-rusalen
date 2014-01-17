package entitymanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.RegisteredUser;
import entities.TravelPackage;

/**
 * Session Bean implementation class TravelPackageEntityManagement
 */
@Stateless
public class TravelPackageEntityManagement extends AbstractEntityManagement implements TravelPackageEntityManagementLocal {
	 @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
	    private EntityManager em;
    /**
     * Default constructor. 
     */
    public TravelPackageEntityManagement() {
    	 super (TravelPackage.class);
    }
       
    @Override
	protected EntityManager getEntityManager() {
		 return em;
	}
    
    public Long findIdCustomerBuyer(Long idTravelPackage)
    {
    	Query query = em.createNativeQuery("SELECT  idcustomerbuyer FROM travelpackage where idtravelpackage=? ");
   	  query.setParameter(1, idTravelPackage);
   	   Long id;
   	    	Object result=  query.getSingleResult();
   	    	if (result==null)
   	    	id=new Long(0);
   	    	else
   	    		id=(Long)result;
   	    	
    	System.out.println(" questo � l'id"+id);
		return id;
    }
    
    public Long findIdCustomerFriendOwner(Long idTravelPackage)
    {
    	Query query = em.createNativeQuery("SELECT  idcustomerfriendowner FROM travelpackage where idtravelpackage=? ");
     	  query.setParameter(1, idTravelPackage);
     	   Long id;
     	    	Object result=  query.getSingleResult();
     	    	if (result==null)
     	    	id=new Long(0);
     	    	else
     	    	id=(Long)result;
     	    	System.out.println(" questo � l'id"+id);
  		return id;
    }
    
    
    
    

}
