package entities;

import entities.RegisteredUser;

import java.io.Serializable;


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

	
	private static final long serialVersionUID = 1L;

@OneToMany(mappedBy="customizer")	
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

