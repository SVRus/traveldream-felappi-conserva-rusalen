package dto;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
	public PrepackedTravelPackageDTO(long idtravelpackage, Calendar time_end,
			Calendar time_start, String description, String name,
			List<StageDTO> stages, String idCustomerBuyer,
			String idCustomerFriendOwner, String friendCode, Calendar purchaseTime,
			long idEmployeeCreator) {
		super(idtravelpackage, time_end, time_start, description, name, stages,
				idCustomerBuyer, idCustomerFriendOwner, friendCode,
				purchaseTime);
		this.idEmployeeCreator = idEmployeeCreator;
	}

	public PrepackedTravelPackageDTO(Calendar time_end, Calendar time_start,
		String description, String name, List<StageDTO> stages,
		String idCustomerBuyer, String idCustomerFriendOwner,
		String friendCode, Calendar purchaseTime, long idEmployeeCreator) {
	super(time_end, time_start, description, name, stages, idCustomerBuyer,
			idCustomerFriendOwner, friendCode, purchaseTime);
	this.idEmployeeCreator = idEmployeeCreator;
}

	long idEmployeeCreator;
	
	
}
