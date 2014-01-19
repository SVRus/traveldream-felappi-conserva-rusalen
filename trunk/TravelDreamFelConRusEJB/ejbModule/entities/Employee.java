package entities;

import entities.RegisteredUser;
import groupenum.Group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@DiscriminatorValue("EMPLOYEE")

public class Employee extends RegisteredUser implements Serializable {
	
	
	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	
	
	public Employee(String email, String name, String surname,
			String telephone, String password, String username,
			List<Group> groups, List<Product> managedProduct,
			List<PrepackedTravelPackage> managedTravelPackage, Code code) {
		super(email, name, surname, telephone, password, username, groups);
		this.managedProduct = managedProduct;
		this.managedTravelPackage = managedTravelPackage;
		this.code = code;
	}

	public List<Product> getManagedProduct() {
		return new ArrayList <Product> (managedProduct);
	}
	public void setManagedProduct(List<Product> managedProduct) {
		this.managedProduct = managedProduct;
	}
	public List<PrepackedTravelPackage> getManagedTravelPackage() {
		return new ArrayList <PrepackedTravelPackage>(managedTravelPackage);
	}
	public void setManagedTravelPackage(
			List<PrepackedTravelPackage> managedTravelPackage) {
		this.managedTravelPackage = managedTravelPackage;
	}
	
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}
   @OneToMany(cascade={CascadeType.PERSIST ,CascadeType.MERGE})
   @JoinColumn(name="idemployee")
   private List <Product> managedProduct;
   @OneToMany(cascade=CascadeType.ALL)
   @JoinColumn(name="idEmployeeCreator")
   private List <PrepackedTravelPackage> managedTravelPackage;//inserire la relazione
  
   @OneToOne()
   @JoinColumn(name="code")
   private Code code; 
}
