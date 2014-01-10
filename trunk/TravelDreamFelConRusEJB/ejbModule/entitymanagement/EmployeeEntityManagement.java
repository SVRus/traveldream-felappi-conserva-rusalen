package entitymanagement;

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
    /**
     * This method permit to find an employee by name
     * @param name
     * @return the object employee with the name specified
     */
    public Employee findPrepackedTravelPackageByName(String name)
    {
    	String query="select employee from Employee employee where name:=name";
    	Query q = em.createQuery(query, Employee.class);
    	q.setParameter("name", name);
    	Employee employee=(Employee) q.getSingleResult();
    	return employee;
    }
    /**
     * This method permit to find an employee by code
     * @param code
     * @return the object employee with the code specified
     */
    public Employee findPrepackedTravelPackageByCode(String code)
    {
    	String query="select employee from Employee employee where code:=code";
    	Query q = em.createQuery(query, Employee.class);
    	q.setParameter("code", code);
    	Employee employee=(Employee) q.getSingleResult();
    	return employee;
    }
    
    
}
