package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@NamedQuery(name = "findeveryproduct", query = "SELECT b FROM Product b ")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="PRODUCT_TYPE")
public class Product implements Serializable {

	
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idProduct;
private float cost;
@Temporal(TemporalType.TIMESTAMP)
private Date timeStart;
@Temporal(TemporalType.TIMESTAMP)
private Date timeEnd;
private String name;
public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public long getEmployeeCreator() {
	return employeeCreator;
}


public void setEmployeeCreator(long employeeCreator) {
	this.employeeCreator = employeeCreator;
}


@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="idtravelpackage")
private TravelPackage travel;

private long employeeCreator;
public long getIdProduct() {
	return idProduct;
}


public void setIdProduct(long idProduct) {
	this.idProduct = idProduct;
}


public float getCost() {
	return cost;
}


public void setCost(float cost) {
	this.cost = cost;
}


public Date getTimeStart() {
	return timeStart;
}


public void setTimeStart(Date timeStart) {
	this.timeStart = timeStart;
}


public Date getTimeEnd() {
	return timeEnd;
}


public void setTimeEnd(Date timeEnd) {
	this.timeEnd = timeEnd;
}

public TravelPackage getTravel() {
	return travel;
}


public void setTravel(TravelPackage travel) {
	this.travel = travel;
}


public long getIdproduct() {
	return idProduct;
}

}
