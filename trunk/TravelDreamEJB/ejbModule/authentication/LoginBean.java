package authentication;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.GenericUserDTO;
import entitymanagement.CustomerEntityManagementLocal;
import entitymanagement.EmployeeEntityManagementLocal;

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
public CustomerDTO findLogInCustomer(String username) {
	
	return null;
}

@Override
public EmployeeDTO findLogInEmployee(String username) {
	// TODO Auto-generated method stub
	return null;
}
public GenericUserDTO findLogIn()
{
	return null;
	

}

public String getPrincipalUsername() 
{
	
	return context.getCallerPrincipal().getName();
}
    
}
