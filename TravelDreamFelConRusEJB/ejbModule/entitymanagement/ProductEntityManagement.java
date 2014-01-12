package entitymanagement;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Employee;
import entities.Product;
import entities.RegisteredUser;

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
    {
    	String query="select employeecreator from Product  where idproduct:=idproduct";
    	Query q = em.createQuery(query, Product.class);
    	q.setParameter("idproduct", idproduct);
    	String result=(String) q.getSingleResult();
    	return result;
    	
    }
    
    
}
