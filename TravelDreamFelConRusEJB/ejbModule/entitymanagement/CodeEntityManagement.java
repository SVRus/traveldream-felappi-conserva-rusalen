package entitymanagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Code;

/**
 * Session Bean implementation class CodeEntityManagement
 */
@Stateless
public class CodeEntityManagement extends AbstractEntityManagement implements CodeEntityManagementLocal {
	 @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
	    private EntityManager em;
    /**
     * Default constructor. 
     */
    public CodeEntityManagement() {
        super(Code.class);
    }
       
   
    @Override
	protected EntityManager getEntityManager() {
		 return em;
	}



	@Override
	public List findAllByParameter(Object par) {
		// TODO Auto-generated method stub
		return null;
	}
}
