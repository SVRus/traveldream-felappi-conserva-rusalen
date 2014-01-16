package entities;

import entities.TravelPackage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PrepackedTravelPackage
 *
 */
@Entity
@NamedQuery(name = "findeveryprepackedtravelpackage",query = "SELECT a FROM PrepackedTravelPackage  a")
@DiscriminatorValue("PREPACKEDTRAVELPACKAGE")
public class PrepackedTravelPackage extends TravelPackage implements Serializable {

	
	public PrepackedTravelPackage(Date time_end,
			Date time_start, String description, String name,
			List<Product> products, long friendCode, Date purchaseTime) {
		super(time_end, time_start, description, name, products,
				 friendCode, purchaseTime);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	public PrepackedTravelPackage() {
		super();
	}

}
