package entities;

import entities.TravelPackage;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PrepackedTravelPackage
 *
 */
@Entity
@NamedQuery(name = "findeveryprepackedtravelpackage",query = "SELECT a FROM PrepackedTravelPackage  a")
@DiscriminatorValue("PREPACKEDTRAVELPACKAGE")
public class PrepackedTravelPackage extends TravelPackage implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public PrepackedTravelPackage() {
		super();
	}
  private long employeeCreator; 
}
