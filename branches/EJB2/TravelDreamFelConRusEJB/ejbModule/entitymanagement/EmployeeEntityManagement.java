package entitymanagement;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Employee;

/**
 * Session Bean implementation class EmployeeEntityManagement
 */
@Stateless
@LocalBean
public class EmployeeEntityManagement extends AbstractEntityManagement implements EmployeeEntityManagementLocal {

    /**
     * Default constructor. 
     */
    public EmployeeEntityManagement() {
    	 super(Employee.class);
    }
       
   
    @PersistenceContext(unitName = "TravelDreamFelConRusEJB")
    private EntityManager em;

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
