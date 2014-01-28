package dto;

import java.util.Date;
import java.util.List;

import travelstateenum.TravelState;

public class CustomizedTravelPackageDTO extends TravelPackageDTO {



private String idCustomizer;	
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
 * @param idCustomizer
 * @param travelState
 */
public CustomizedTravelPackageDTO(long idtravelpackage, Date time_end,
		Date time_start, String description, String name,
			List<StageDTO> stages, String idCustomerBuyer,
			 String friendCode, Date purchaseTime,String idCustomizer,TravelState travelState) {
		super(idtravelpackage, time_end, time_start, description, name,
				stages, idCustomerBuyer, friendCode,
				purchaseTime,travelState);
		this.idCustomizer=idCustomizer;
	}
/**
 * 
 * @param time_end
 * @param time_start
 * @param description
 * @param name
 * @param stages
 * @param idCustomerBuyer
 * @param idCustomerFriendOwner
 * @param friendCode
 * @param purchaseTime
 * @param idCustomizer
 * @param travelState
 */
public CustomizedTravelPackageDTO(Date time_end, Date time_start,
		String description, String name, List<StageDTO> stages,
		String idCustomerBuyer,
		String friendCode, Date purchaseTime, String idCustomizer,TravelState travelState) {
	super(time_end, time_start, description, name, stages, idCustomerBuyer,
			friendCode, purchaseTime,travelState);
	this.idCustomizer = idCustomizer;
}

public String getIdCustomizer() {
	return idCustomizer;
}

public void setIdCustomizer(String idCustomizer) {
	this.idCustomizer = idCustomizer;
}

}
