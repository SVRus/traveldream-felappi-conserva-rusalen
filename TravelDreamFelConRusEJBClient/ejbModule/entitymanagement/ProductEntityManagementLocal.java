package entitymanagement;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ProductEntityManagementLocal {

	
	
	 public <Product>  Product find(Object id);
	 public <Product> void remove (Product product);
	   public String findEmployeeCreator(long idproduct);
	   public Long findTravelPackageContainer(long idproduct);
	    public List <String> findEveryArea(long id);

}
