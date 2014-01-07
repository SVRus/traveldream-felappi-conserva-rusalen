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
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idGiftList;
private long idCustomer;
private long idBuyer;
private String moreInfo;
private boolean bought;
private long giftListCode;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="travelPackageFK")
private TravelPackage travelPackage;



}
