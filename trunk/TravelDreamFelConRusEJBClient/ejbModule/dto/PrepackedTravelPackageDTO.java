package dto;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import travelstateenum.TravelState;

public class PrepackedTravelPackageDTO extends TravelPackageDTO {

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
			String idCustomerFriendOwner, String friendCode, Date purchaseTime,
			long idEmployeeCreator,TravelState travelState) {
		super(idtravelpackage, time_end, time_start, description, name, stages,
				idCustomerBuyer, idCustomerFriendOwner, friendCode,
				purchaseTime,travelState);
		this.idEmployeeCreator = idEmployeeCreator;
	}

	public PrepackedTravelPackageDTO(Date time_end, Date time_start,
		String description, String name, List<StageDTO> stages,
		String idCustomerBuyer, String idCustomerFriendOwner,
		String friendCode, Date purchaseTime, long idEmployeeCreator,TravelState travelState) {
	super(time_end, time_start, description, name, stages, idCustomerBuyer,
			idCustomerFriendOwner, friendCode, purchaseTime,travelState);
	this.idEmployeeCreator = idEmployeeCreator;
}

	long idEmployeeCreator;
	
	
}
