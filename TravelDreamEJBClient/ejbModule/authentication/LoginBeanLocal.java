package authentication;

import javax.ejb.Local;

import dto.CustomerDTO;
import dto.EmployeeDTO;

@Local
public interface LoginBeanLocal {
	public CustomerDTO findLogInCustomer(String username);
	public EmployeeDTO findLogInEmployee(String username);

}
