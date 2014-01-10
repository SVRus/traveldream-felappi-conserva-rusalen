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
private String getPrincipalUsername() 
{
	
	return context.getCallerPrincipal().getName();
}












    
}
