package entitymanagement;


import javax.ejb.Local;

@Local
public interface ProductEntityManagementLocal {

	
	
	 public <Product>  Product find(Object id);
	 public <Product> void remove (Product product);
	   public String findEmployeeCreator(long idproduct);
	   public Long findStageContainer(long idproduct);

}
