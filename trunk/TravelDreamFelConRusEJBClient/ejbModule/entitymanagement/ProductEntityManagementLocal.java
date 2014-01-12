package entitymanagement;

import javax.ejb.Local;

@Local
public interface ProductEntityManagementLocal {

	
	 public String findEmployeeCreator(long idproduct);
}
