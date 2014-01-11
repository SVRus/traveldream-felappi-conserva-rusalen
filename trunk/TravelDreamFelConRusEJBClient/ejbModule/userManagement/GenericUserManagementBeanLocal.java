package userManagement;

import javax.ejb.Local;

import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.GenericUserDTO;
/**
 * classe stupida
 * @author Marcello
 *
 */
@Local
public interface GenericUserManagementBeanLocal {

	 public boolean employeeRegister(EmployeeDTO employee);
	 public boolean customerRegister(CustomerDTO customer);
	 public boolean isLogged();
	 public GenericUserDTO findLogIn();
}
