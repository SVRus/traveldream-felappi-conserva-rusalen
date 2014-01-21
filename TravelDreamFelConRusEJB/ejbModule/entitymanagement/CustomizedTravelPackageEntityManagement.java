package entitymanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Customer;

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
    	super (Customer.class);
    }
    public Long findIdCustomizer(Long idPrepackedTravelPackage)
   	{
   		Query query = em.createNativeQuery("SELECT  idcustomer FROM customizedtravelpackage where idtravelpackage=? ");
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
