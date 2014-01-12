package entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: GiftList
 *
 */
@Entity

public class GiftList implements Serializable {

	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getIdBuyer() {
		return idBuyer;
	}
	public void setIdBuyer(String idBuyer) {
		this.idBuyer = idBuyer;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	public boolean isBought() {
		return bought;
	}
	public void setBought(boolean bought) {
		this.bought = bought;
	}
	public TravelPackage getTravelPackage() {
		return travelPackage;
	}
	public void setTravelPackage(TravelPackage travelPackage) {
		this.travelPackage = travelPackage;
	}
	private static final long serialVersionUID = 1L;

	public GiftList() {
		super();
	}
@Id
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="idProduct")
private Product product;
private String idBuyer;
private String moreInfo;
private boolean bought;
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="travelPackageFK")
private TravelPackage travelPackage;



}
