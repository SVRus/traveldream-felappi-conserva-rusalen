package dto_entitiesconversion;

import dto.CustomerDTO;
import dto.EmployeeDTO;
import entities.Customer;
import entities.Employee;

public class DTOFactory {

	public static CustomerDTO toTDO(Customer customer)
	{
		CustomerDTO cust=new CustomerDTO(customer.getEmail(),customer.getName(), customer.getSurname(),customer.getTelephone(), customer.getPassword(),customer.getUsername());

		return cust;
		
		
	}
	
	public static EmployeeDTO toTDO(Employee employee)
	{
		EmployeeDTO emplo=new EmployeeDTO(employee.getEmail(),employee.getName(),employee.getSurname(),employee.getTelephone(),employee.getPassword(),employee.getUsername());
		return emplo;
		
		
	}
}
