package entitymanagement;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Employee;
import entities.Product;
import entities.RegisteredUser;
import entities.TravelPackage;

/**
 * Session Bean implementation class ProductEntityManagement
 */
@Stateless
@LocalBean
public class ProductEntityManagement extends AbstractEntityManagement implements ProductEntityManagementLocal {

    /**
     * Default constructor. 
     */
    public ProductEntityManagement() {
    	super (Product.class);
    }
    @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
    private EntityManager em;   
    @Override
	protected EntityManager getEntityManager() {
		 return em;
	}
    
    public String findEmployeeCreator(long idproduct)
    {Query query = em.createNativeQuery("SELECT idemployee FROM product WHERE idProduct =?");
    query.setParameter(1, new Long(idproduct));
    
   
    	String result=(String) query.getSingleResult();
    	
    	return result;
    	
    }
    public Long findTravelPackageContainer(long idproduct)
    {
    	System.out.println("id product"+idproduct);
    	
    	
    	Query q = em.createNativeQuery("SELECT IDTRAVELPACKAGE FROM PRODUCT WHERE IDPRODUCT=?");
    	System.out.print("ciao");
    	q.setParameter(1, idproduct);
    	Object result= q.getSingleResult();
    	if (result==null)
    		result=new Long(0);
    	
    		
    	
    	return (Long)result;
    	
    	
    }
    public List <String> findEveryArea(long id)
    {
 	   List <String> listString ;
 	   Query query = em.createNativeQuery("SELECT distinct area FROM product where idtravelpackage=? ");
 	  query.setParameter(1, id);
 	   
 	    	listString = (List <String> ) query.getResultList();
 	    	
 	    	return listString;
 	   
 	   
 	   
 	}
    
    
    
    
}
