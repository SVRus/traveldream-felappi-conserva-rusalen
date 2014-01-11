package entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: GiftList
 *
 */
@Entity

public class GiftList implements Serializable {

	
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
