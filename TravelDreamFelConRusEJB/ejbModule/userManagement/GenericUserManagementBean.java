package userManagement;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.GenericUserDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

/**
 * Session Bean implementation class GenericUserManagement
 */
@Stateless
@LocalBean
public class GenericUserManagementBean implements GenericUserManagementBeanLocal {
@EJB
LoginBeanLocal login;
@EJB
RegistrationBeanLocal register;


    /**
     * Default constructor. 
     */
    public GenericUserManagementBean() {
        // TODO Auto-generated constructor stub
    }

   
    
    public boolean customerRegister(CustomerDTO customer)
    {
    	return register.customerRegister(customer);
    }

	@Override
	public boolean isLogged() {
		
		return login.isLogged();
	}

	@Override
	public GenericUserDTO findLogIn() {
		
		return login.findLogIn();
	}



	@Override
	public boolean employeeRegister(EmployeeDTO employee) {
		
		return   employeeRegister ( employee);
	}
    
   
    
}
