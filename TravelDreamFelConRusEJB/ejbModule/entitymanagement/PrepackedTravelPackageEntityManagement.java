package entitymanagement;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.PrepackedTravelPackage;

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

    public PrepackedTravelPackage findPrepackedTravelPackageByName(String name)
    {
    	String query="select travel from PrepackedTravelPackage travel where name:=name";
    	Query q = em.createQuery(query, PrepackedTravelPackage.class);
    	q.setParameter("name", name);
    	PrepackedTravelPackage travel=(PrepackedTravelPackage) q.getSingleResult();
    	return travel;
    }
    
    
}
