package entitymanagement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.RegisteredUser;
import groupenum.Group;

/**
 * Session Bean implementation class RegisteredUserEntityManagement
 */
@Stateless
@LocalBean
public class RegisteredUserEntityManagement extends AbstractEntityManagement implements RegisteredUserEntityManagementLocal {
	 @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
	    private EntityManager em;
    /**
     * Default constructor. 
     */
    public RegisteredUserEntityManagement() {
        super (RegisteredUser.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		 return em;
	}
     public ArrayList <Group> findGroups(String username)
     {	Query query = em.createNativeQuery("SELECT  groupname FROM user_group where username=? ");
	     query.setParameter(1, username);
	   ArrayList <Group> groups;
	    	List result=  query.getResultList();
	    	if (result==null)
	    	groups=new ArrayList <Group> ();
	    	else
	    	groups=new ArrayList <Group> (result);
	
	return groups;
	
    	 
    	 
     }
   
}
