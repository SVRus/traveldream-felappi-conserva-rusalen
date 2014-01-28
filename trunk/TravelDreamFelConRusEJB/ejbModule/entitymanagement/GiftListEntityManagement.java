package entitymanagement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Flight;
import entities.GiftList;
import entities.TravelPackage;

/**
 * Session Bean implementation class GiftListEntityManagement
 */
@Stateless
public class GiftListEntityManagement extends AbstractEntityManagement implements GiftListEntityManagementLocal {
	@PersistenceContext(unitName = "TravelDreamFelConRusEJB")
    private EntityManager em;
/**
 * Default constructor. 
 */
    public GiftListEntityManagement() {
        super(GiftList.class);
    }
       
   

	@Override
	protected EntityManager getEntityManager() {
		 return em;
	}

	public List <Long> giftListAuthenticationCheck()
	{  
		Query query = em.createNativeQuery("SELECT distinct  travelPackageFK FROM GiftList ");
	   	  
	   	List <Long> lista=query.getResultList();
	   	    	
		return lista;
			
	}
	
	@Override
	public List findAllByParameter(Object par) {
		
		
		
		
		return null;
	}
	
public <GiftList> List <GiftList> findGiftListForPackage(TravelPackage id)
{
	Query query = em.createQuery("SELECT c FROM GiftList c  where  c.travelPackage =:id ");
    query.setParameter("id", id);
    List <GiftList> list=query.getResultList();
    if(list==null)
    	return new ArrayList <GiftList>();
    else
    	return list;
}
public String findCustomerCreator(long idProduct)
{
	Query query=em.createNativeQuery("SELECT idCustomer from GiftList where idProduct =?");
	query.setParameter(1, idProduct);
	String result=(String) query.getResultList().get(0);
	
	return result;
	

}


}
