package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TravelPackage
 *
 */

@Entity
@NamedQuery(name = "findeverytravelpackage", query = "SELECT b FROM TravelPackage b ")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TRAVELPACKAGE_TYPE")
public class TravelPackage implements Serializable {

	






	public long getFriendCode() {
		return friendCode;
	}



	public void setFriendCode(long friendCode) {
		this.friendCode = friendCode;
	}



	public Date getPurchaseTime() {
		return purchaseTime;
	}



	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}



	public TravelPackage(long idtravelpackage, Date time_end, Date time_start,
			String description, String name, List<Product> products,
			long idCustomerBuyer, long idCustomerFriendOwner, long friendCode,
			Date purchaseTime) {
		super();
		this.idtravelpackage = idtravelpackage;
		this.time_end = time_end;
		this.time_start = time_start;
		this.description = description;
		this.name = name;
		this.products = products;
		
		this.friendCode = friendCode;
		this.purchaseTime = purchaseTime;
	}



	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idtravelpackage;
public long getIdtravelpackage() {
	return idtravelpackage;
}



public void setIdtravelpackage(long idtravelpackage) {
	this.idtravelpackage = idtravelpackage;
}



public Date getTime_end() {
	return time_end;
}



public void setTime_end(Date time_end) {
	this.time_end = time_end;
}



public Date getTime_start() {
	return time_start;
}



public void setTime_start(Date time_start) {
	this.time_start = time_start;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public List<Product> getProducts() {
	return products;
}



public void setProducts(List<Product> products) {
	this.products = products;
}



@Temporal (TemporalType.TIMESTAMP)
private Date time_end;
@Temporal (TemporalType.TIMESTAMP)

private Date time_start;
private String description;
@Column(unique=true)
private String name;
@OneToMany()
@JoinColumn(name="IDTRAVELPACKAGE")
private List<Product> products;

private long friendCode;

@Temporal (TemporalType.TIMESTAMP)
private Date purchaseTime;


	public TravelPackage() {
		super();
	}



	public TravelPackage(Date time_end, Date time_start, String description,
			String name, List<Product> products,  long friendCode, Date purchaseTime) {
		super();
		this.time_end = time_end;
		this.time_start = time_start;
		this.description = description;
		this.name = name;
		this.products = products;
	
		this.friendCode = friendCode;
		this.purchaseTime = purchaseTime;
	}
   
}
