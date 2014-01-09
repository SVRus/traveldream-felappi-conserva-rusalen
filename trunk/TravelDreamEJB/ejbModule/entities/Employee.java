package entities;

import entities.RegisteredUser;
import groupenum.Group;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@DiscriminatorValue("EMPLOYEE")

public class Employee extends RegisteredUser implements Serializable {
	
	
	public Employee(String email, String name, String surname,
			String telephone, String password, String username,
			List<Group> groups, List<Product> managedProduct,
			List<PrepackedTravelPackage> managedTravelPackage) {
		super(email, name, surname, telephone, password, username, groups);
		this.managedProduct = managedProduct;
		this.managedTravelPackage = managedTravelPackage;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public List<Product> getManagedProduct() {
		return managedProduct;
	}
	public void setManagedProduct(List<Product> managedProduct) {
		this.managedProduct = managedProduct;
	}
	public List<PrepackedTravelPackage> getManagedTravelPackage() {
		return managedTravelPackage;
	}
	public void setManagedTravelPackage(
			List<PrepackedTravelPackage> managedTravelPackage) {
		this.managedTravelPackage = managedTravelPackage;
	}
	
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long code; //deve essere unica.. come faccio a specificarlo?
   @OneToMany(cascade=CascadeType.ALL)
   @JoinColumn(name="employeeCreator")
   private List <Product> managedProduct;//inserire la relazione
   @OneToMany(cascade=CascadeType.ALL)
   @JoinColumn(name="idPrepackedTravelPackage")
   private List <PrepackedTravelPackage> managedTravelPackage;//inserire la relazione
   
}
