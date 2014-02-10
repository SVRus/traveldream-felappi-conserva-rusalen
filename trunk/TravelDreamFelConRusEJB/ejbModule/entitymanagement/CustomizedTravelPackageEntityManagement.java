package entitymanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Customer;
import entities.CustomizedTravelPackage;

/**
 * Session Bean implementation class CustomizedTravelPackageEntityManagement
 */
@Stateless
public class CustomizedTravelPackageEntityManagement extends AbstractEntityManagement implements CustomizedTravelPackageEntityManagementLocal {
	 @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
	    private EntityManager em;

	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
    /**
     * Default constructor. 
     */
    public CustomizedTravelPackageEntityManagement() {
    	super (CustomizedTravelPackage.class);
    }
    /**
     * method that find the customizer of the given travelPackage
     */
    public String findIdCustomizer(Long idPrepackedTravelPackage)
   	{
   		Query query = em.createNativeQuery("SELECT  idcustomer FROM customizedtravelpackage where idtravelpackage=? ");
      	     query.setParameter(1, idPrepackedTravelPackage);
      	   Long id;
      	    	List <String> result= query.getResultList();
      	    	
      	    	if (result==null|| result.size()==0)
      	      	return null;
      	      	
      	      	return result.get(0);
   		
   		
   		
   		
   		
   		
   	}
	
    
    
    public CustomizedTravelPackage findCustomizedTravelPackageForFriend(String code)
    {
    	Query query = em.createQuery("SELECT  c FROM CustomizedTravelPackage c where c.friendCode=:code ",CustomizedTravelPackage.class);
 	     query.setParameter("code",code);
 	    	List   <CustomizedTravelPackage> result=query.getResultList();
 	    	if (result==null|| result.size()==0)
 	       	return null;
 	       	
 	       	return result.get(0);
    }
	
	@Override
	public List findAllByParameter(Object par) {
		// TODO Auto-generated method stub
		return null;
	}
    

}
