package entitymanagement;

import java.util.ArrayList;
import java.util.Iterator;
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
	     ArrayList <Group> groupList=new ArrayList <Group> ();
	    	List <String> result=   query.getResultList();
	    	if (result==null)
	    	return new ArrayList <Group>();
	    	else
	    	{
	    	Iterator <String >	iter=result.iterator();
	    	while(iter.hasNext())
	    	{
	    		groupList.add(Group.valueOf(iter.next()));
	    		
	    	}
	    	return groupList;
	    	}
	    	
	
    	 
    	 
     }

	@Override
	public List findAllByParameter(Object par) {
		// TODO Auto-generated method stub
		return null;
	}
   
}
