package dto;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import travelstateenum.TravelState;

public class PrepackedTravelPackageDTO extends TravelPackageDTO {

public PrepackedTravelPackageDTO() {
		super();
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
 * @param idCustomerBuyer
 * @param idCustomerFriendOwner
 * @param friendCode
 * @param purchaseTime
 * @param idEmployeeCreator
 */
	public PrepackedTravelPackageDTO(long idtravelpackage, Date time_end,
			Date time_start, String description, String name,
			List<StageDTO> stages, String idCustomerBuyer,
			 String friendCode, Date purchaseTime,
			String idEmployeeCreator,TravelState travelState) {
		super(idtravelpackage, time_end, time_start, description, name, stages,
				idCustomerBuyer, friendCode,
				purchaseTime,travelState);
		this.idEmployeeCreator = idEmployeeCreator;
	}

	public PrepackedTravelPackageDTO(Date time_end, Date time_start,
		String description, String name, List<StageDTO> stages,
		String idCustomerBuyer,
		String friendCode, Date purchaseTime, String idEmployeeCreator,TravelState travelState) {
	super(time_end, time_start, description, name, stages, idCustomerBuyer,
			 friendCode, purchaseTime,travelState);
	this.idEmployeeCreator = idEmployeeCreator;
}

	String idEmployeeCreator;
	
	
}
