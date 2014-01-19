package entities;

import entities.TravelPackage;

import java.io.Serializable;
import java.util.Calendar;
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

	
	

	private static final long serialVersionUID = 1L;

	public PrepackedTravelPackage() {
		super();
	}
/**
 * 
 * @param time_end
 * @param time_start
 * @param description
 * @param name
 * @param stages
 * @param friendCode
 * @param purchaseTime
 */
	public PrepackedTravelPackage(Calendar time_end, Calendar time_start,
			String description, String name, List<Stage> stages,
			String friendCode, Calendar purchaseTime) {
		super(time_end, time_start, description, name, stages, friendCode, purchaseTime);
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * @param idtravelpackage
 * @param time_end
 * @param time_start
 * @param description
 * @param name
 * @param stages
 * @param friendCode
 * @param purchaseTime
 */
	public PrepackedTravelPackage(long idtravelpackage, Calendar time_end,
			Calendar time_start, String description, String name,
			List<Stage> stages, String friendCode, Calendar purchaseTime) {
		super(idtravelpackage, time_end, time_start, description, name, stages,
				friendCode, purchaseTime);
		// TODO Auto-generated constructor stub
	}

	

	
	
}
