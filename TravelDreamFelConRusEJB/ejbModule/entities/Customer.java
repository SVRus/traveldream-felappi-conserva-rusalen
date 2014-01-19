package entities;

import entities.RegisteredUser;
import groupenum.Group;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@NamedQuery(name = "findeverycustomer", query = "SELECT b FROM Customer b ")
@DiscriminatorValue("CUSTOMER")
public class Customer extends RegisteredUser implements Serializable {

	
	public List<CustomizedTravelPackage> getCustomizedTravelPackages() {
		return customizedTravelPackages;
	}



	public void setCustomizedTravelPackages(
			List<CustomizedTravelPackage> customizedTravelPackages) {
		this.customizedTravelPackages = customizedTravelPackages;
	}



	public List<Customer> getFriends() {
		return new ArrayList<Customer> (friends);
	}



	public void setFriends(List<Customer> friends) {
		this.friends = friends;
	}



	public List<TravelPackage> getPurchasedTravelPackages() {
		return new ArrayList <TravelPackage>(purchasedTravelPackages);
	}



	public void setPurchasedTravelPackages(
			List<TravelPackage> purchasedTravelPackages) {
		this.purchasedTravelPackages = purchasedTravelPackages;
	}



	public List<TravelPackage> getPreparedForAFriendTravelPackages() {
		return new ArrayList <TravelPackage>(preparedForAFriendTravelPackages);
	}



	public void setPreparedForAFriendTravelPackages(
			List<TravelPackage> preparedForAFriendTravelPackages) {
		this.preparedForAFriendTravelPackages = preparedForAFriendTravelPackages;
	}



	public List<GiftList> getGiftLists() {
		return  new ArrayList <GiftList> (giftLists);
	}



	public void setGiftLists(List<GiftList> giftLists) {
		this.giftLists = giftLists;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Customer(String email, String name, String surname,
			String telephone, String password, String username,
			List<Group> groups,
			List<CustomizedTravelPackage> customizedTravelPackages,
			List<Customer> friends,
			List<TravelPackage> purchasedTravelPackages,
			List<TravelPackage> preparedForAFriendTravelPackages,
			List<GiftList> giftLists) {
		super(email, name, surname, telephone, password, username, groups);
		this.customizedTravelPackages = customizedTravelPackages;
		this.friends = friends;
		this.purchasedTravelPackages = purchasedTravelPackages;
		this.preparedForAFriendTravelPackages = preparedForAFriendTravelPackages;
		this.giftLists = giftLists;
	}



	private static final long serialVersionUID = 1L;

@OneToMany(cascade=CascadeType.ALL)	
@JoinColumn(name="idcustomer")
private List <CustomizedTravelPackage> customizedTravelPackages;



@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(name = "friendship", joinColumns = @JoinColumn(name = "friendA"),inverseJoinColumns = @JoinColumn(name = "friendB"))
private List <Customer> friends;
@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="idCustomerBuyer")
private List <TravelPackage> purchasedTravelPackages;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="idCustomerFriendOwner")
private List <TravelPackage> preparedForAFriendTravelPackages;
@OneToMany (cascade=CascadeType.ALL)
@JoinColumn(name="idCustomer")
private List <GiftList> giftLists;



	public Customer() {
		super();
	}
   
}

