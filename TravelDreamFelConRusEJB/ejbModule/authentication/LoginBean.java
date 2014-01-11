package authentication;


import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.GenericUserDTO;
import dto_entitiesconversion.DTOFactory;
import entities.Customer;
import entities.Employee;
import entitymanagement.CustomerEntityManagementLocal;
import entitymanagement.EmployeeEntityManagementLocal;
import groupenum.Group;

/**
 * Session Bean implementation class LoginBean
 * It exploits the beans {@link entitymanagement.EmployeeEntityManagemen} and {@link entitymanagement.CustomerEntityManagement}
 * @overview this bean is used to handle the login phase
 */
@Stateless
@LocalBean
public class LoginBean implements LoginBeanLocal {

@EJB
CustomerEntityManagementLocal customer;
 
@EJB
EmployeeEntityManagementLocal employee;

@Resource
EJBContext context;


	/**
     * Default constructor. 
     */
    
public LoginBean() 
{
        // TODO Auto-generated constructor stub
}

/**
 * @author Marcello
 * This method is used to obtain the Object representation of the user (Customer or Employee)
 * @return the GenericUserDTO representing the logged in user
 */
@Override
@RolesAllowed({Group._CUSTOMER,Group._EMPLOYEE})
public GenericUserDTO findLogIn()
{
	String username=getPrincipalUsername();
	GenericUserDTO generic=null;
	if (context.isCallerInRole("EMPLOYEE"))
	{
		generic=DTOFactory.toTDO((Employee)employee.find(username));
		
	}
	else if(context.isCallerInRole("CUSTOMER"))
	{
		generic=DTOFactory.toTDO((Customer)customer.find(username));
		
	}
	return generic;
	

}
/**
 * @author Marcello
 * Thid method is used to get the primary key (username) of the user holding the session
 * @return the username of the user holding the session
 */
private String getPrincipalUsername() 
{
	
	return context.getCallerPrincipal().getName();
}


/**
 * @author Marcello
 * This method verify whether the user is logged (as a Customer or as an Employee)
 * @return the boolean value stating the authentication of the user
 */
@Override
public boolean isLogged() {
	
	return context.isCallerInRole("CUSTOMER") ||context.isCallerInRole("EMPLOYEE");
}












    
}
