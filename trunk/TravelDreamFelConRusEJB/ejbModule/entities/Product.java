package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import stateenum.State;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
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
	 * @param state
	 */
	public Product(long idProduct, float cost, Date timeStart, Date timeEnd,
			String name,State state,String area) {
		super();
		this.idproduct = idProduct;
		this.cost = cost;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.name = name;
		this.state=state;
		this.area=area;
		
	}




public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
/**
 * constructor used during the creation phase
 * @param cost
 * @param timeStart
 * @param timeEnd
 * @param name
 * @param travel
 */
	public Product(float cost, Date timeStart, Date timeEnd, String name,State state,String area
			) {
		super();
		this.cost = cost;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.name = name;
		this.state=state;
		this.area=area;
			}





	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idproduct;
private float cost;
@Temporal(TemporalType.TIMESTAMP)
private Date timeStart;
@Temporal(TemporalType.TIMESTAMP)
private Date timeEnd;
private String name;

@Enumerated(EnumType.STRING)
private State state;

private String area;

public long getIdproduct() {
	return idproduct;
}
public void setIdproduct(long idproduct) {
	this.idproduct = idproduct;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}






public long getIdProduct() {
	return idproduct;
}


public void setIdProduct(long idProduct) {
	this.idproduct = idproduct;
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