package entitymanagement;

import javax.ejb.Local;

@Local
public interface EmployeeEntityManagementLocal {

	public <Employee> void create(Employee employee);
	public <Employee>  Employee find(Object id);
	public <Employee> void edit(Employee employee);
}
