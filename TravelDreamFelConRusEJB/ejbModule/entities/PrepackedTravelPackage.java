package entities;

import entities.TravelPackage;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import travelstateenum.TravelState;

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
	public PrepackedTravelPackage(Date time_end, Date time_start,
			String description, String name, List<Stage> stages,
			String friendCode, Date purchaseTime,TravelState travelState) {
		super(time_end, time_start, description, name, stages, friendCode, purchaseTime, travelState);
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
	public PrepackedTravelPackage(long idtravelpackage, Date time_end,
			Date time_start, String description, String name,
			List<Stage> stages, String friendCode, Date purchaseTime,TravelState travelState) {
		super(idtravelpackage, time_end, time_start, description, name, stages,
				friendCode, purchaseTime,travelState);
		// TODO Auto-generated constructor stub
	}

	

	
	
}
