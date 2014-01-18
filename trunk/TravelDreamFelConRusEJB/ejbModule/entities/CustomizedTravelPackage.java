package entities;

import entities.TravelPackage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CustomizedTravelPackage
 *
 */
@Entity
@DiscriminatorValue("CUSTOMIZEDTRAVELPACKAGE")

public class CustomizedTravelPackage extends TravelPackage implements Serializable {

	


	public CustomizedTravelPackage(Date time_end, Date time_start,
			String description, String name, List<Stage> stages,
			String friendCode, Date purchaseTime) {
		super(time_end, time_start, description, name, stages, friendCode, purchaseTime);
		// TODO Auto-generated constructor stub
	}

	public CustomizedTravelPackage(long idtravelpackage, Date time_end,
			Date time_start, String description, String name,
			List<Stage> stages, String friendCode, Date purchaseTime) {
		super(idtravelpackage, time_end, time_start, description, name, stages,
				friendCode, purchaseTime);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	public CustomizedTravelPackage() {
		super();
	}

}
