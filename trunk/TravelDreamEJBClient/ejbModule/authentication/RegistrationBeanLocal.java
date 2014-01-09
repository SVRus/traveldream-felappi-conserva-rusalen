package authentication;

import javax.ejb.Local;

import dto.CustomerDTO;
import dto.EmployeeDTO;

@Local
public interface RegistrationBeanLocal {
public boolean customerRegister(CustomerDTO customer);





}
