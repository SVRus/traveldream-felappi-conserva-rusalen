package entities;

import entities.TravelPackage;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CustomizedTravelPackage
 *
 */
@Entity
@DiscriminatorValue("CUSTOMIZEDTRAVELPACKAGE")

public class CustomizedTravelPackage extends TravelPackage implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public CustomizedTravelPackage() {
		super();
	}

@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="idregistereduser")
 private Customer customizer;
}
