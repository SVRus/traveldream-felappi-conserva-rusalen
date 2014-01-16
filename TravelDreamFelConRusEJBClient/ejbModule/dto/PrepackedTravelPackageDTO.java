package dto;

import java.util.Date;
import java.util.List;

public class PrepackedTravelPackageDTO extends TravelPakageDTO {
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
 */
	public PrepackedTravelPackageDTO(long idtravelpackage, Date time_end,
			Date time_start, String description, String name,
			List<StageDTO> stages, long idCustomerBuyer,
			long idCustomerFriendOwner, long friendCode, Date purchaseTime) {
		super(idtravelpackage, time_end, time_start, description, name, stages,
				idCustomerBuyer, idCustomerFriendOwner, friendCode, purchaseTime);
		
	}

	
	
	
}
