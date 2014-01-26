package entitymanagement;

import javax.ejb.Local;

@Local
public interface CustomerEntityManagementLocal {

	public <Customer> void create(Customer customer);
	public <Customer>  Customer find(Object id);
	public <Customer> void edit(Customer customer);
	
}
