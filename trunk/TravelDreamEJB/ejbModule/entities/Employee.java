package entities;

import entities.RegisteredUser;

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
   @JoinColumn(name="idTravelPackage")
   private List <PrepackedTravelPackage> managedTravelPackage;//inserire la relazione
   
}
