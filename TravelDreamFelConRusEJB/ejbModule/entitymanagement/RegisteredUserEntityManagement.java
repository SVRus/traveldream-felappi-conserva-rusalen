package entitymanagement;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.RegisteredUser;

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
       
   
}
