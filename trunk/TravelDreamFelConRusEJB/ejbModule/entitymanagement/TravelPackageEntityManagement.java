package entitymanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dto.CustomizedTravelPackageDTO;
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
    
    public String findIdCustomerBuyer(Long idTravelPackage)
    {
    	Query query = em.createNativeQuery("SELECT  idcustomerbuyer FROM travelpackage where idtravelpackage=? ");
   	  query.setParameter(1, idTravelPackage);
   	  
   	    	Object result=  query.getSingleResult();
   	    	if (result==null)
   	    	return null;
   	    	else
   	    	return (String)result;
   	    	
    	
    }
    
    public String findIdCustomerFriendOwner(Long idTravelPackage)
    {
    	Query query = em.createNativeQuery("SELECT  idcustomerfriendowner FROM travelpackage where idtravelpackage=? ");
     	  query.setParameter(1, idTravelPackage);
     	   
     	    	Object result=  query.getSingleResult();
     	    	if (result==null)
     	    	return null;
     	    	else
     	    	
  		return (String)(result);
    }
    
   
    

}
