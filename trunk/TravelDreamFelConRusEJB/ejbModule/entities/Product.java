package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import dto.ProductDTO;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@NamedQuery(name = "findeveryproduct", query = "SELECT b FROM Product b ")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="PRODUCT_TYPE")
public class Product implements Serializable {
public Product()
{}
	/**
	 * constructor used during the update phase
	 * @param idProduct
	 * @param cost
	 * @param timeStart
	 * @param timeEnd
	 * @param name
	 * @param travel
	 */
	public Product(long idProduct, float cost, Date timeStart, Date timeEnd,
			String name) {
		super();
		this.idProduct = idProduct;
		this.cost = cost;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.name = name;
		;
	}




/**
 * constructor used during the creation phase
 * @param cost
 * @param timeStart
 * @param timeEnd
 * @param name
 * @param travel
 */
	public Product(float cost, Date timeStart, Date timeEnd, String name
			) {
		super();
		this.cost = cost;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.name = name;
			}





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



}
