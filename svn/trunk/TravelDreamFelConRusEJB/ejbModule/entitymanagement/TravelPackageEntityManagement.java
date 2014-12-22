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
   	  
   	    	List <String> result=  query.getResultList();
   	    	if (result==null|| result.size()==0)
   	     	return null;
   	     	
   	     	return result.get(0);
   	    	
    	
    }
    
/*    public String findIdCustomerFriendOwner(Long idTravelPackage)
    {
    	Query query = em.createNativeQuery("SELECT  idCustomerFriendOwner FROM travelpackage where idtravelpackage=? ");
     	  query.setParameter(1, idTravelPackage);
     	   
     	    	Object result=  query.getSingleResult();
     	    	if (result==null)
     	    	return null;
     	    	else
     	    	
  		return (String)(result);
    }
*/
	

	@Override
	public List findAllByParameter(Object par) {
		// TODO Auto-generated method stub
		return null;
	}
    //TODO
/*    public TravelPackage findTravelPackageByProduct(Long idProduct)
    {
//
    	
    	
    }
    */

	
	
}
