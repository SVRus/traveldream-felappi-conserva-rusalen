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
@OneToMany(mappedBy="travel",cascade=CascadeType.ALL)
private List<Product> products;
private long idCustomerBuyer;
private long idCustomerFriendOwner;
private long friendCode;

@Temporal (TemporalType.TIMESTAMP)
private Date purchaseTime;


	public TravelPackage() {
		super();
	}
   
}
