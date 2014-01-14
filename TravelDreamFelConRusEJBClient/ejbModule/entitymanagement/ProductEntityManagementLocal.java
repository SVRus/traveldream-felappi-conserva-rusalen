package entitymanagement;

import javax.ejb.Local;

@Local
public interface ProductEntityManagementLocal {

	
	 public String findEmployeeCreator(long idproduct);
	 public long findTravelPackageContainer(long idproduct);
	 public <Product>  Product find(Object id);
	 public <Product> void remove (Product product);   
}
