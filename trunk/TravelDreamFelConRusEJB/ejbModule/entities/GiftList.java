package entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: GiftList
 *
 */
@Entity

public class GiftList implements Serializable {

	
	public GiftList(Product product, String idBuyer, String moreInfo,
			boolean bought, TravelPackage travelPackage) {
		super();
		this.product = product;
		this.idBuyer = idBuyer;
		this.moreInfo = moreInfo;
		this.bought = bought;
		this.travelPackage = travelPackage;
	}
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
@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
@JoinColumn(name="idProduct")
private Product product;
private String idBuyer;
private String moreInfo;
private boolean bought;
@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
@JoinColumn(name="travelPackageFK")
private TravelPackage travelPackage;



}
