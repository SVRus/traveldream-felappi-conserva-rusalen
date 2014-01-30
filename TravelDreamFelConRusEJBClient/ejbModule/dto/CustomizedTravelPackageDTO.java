package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import travelstateenum.TravelState;

public class CustomizedTravelPackageDTO extends TravelPackageDTO {



public CustomizedTravelPackageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

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
public CustomizedTravelPackageDTO(Long idtravelpackage, Date time_end,
		Date time_start, String description, String name,
		ArrayList<StageDTO> stages, String idCustomerBuyer,
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
		String description, String name, ArrayList<StageDTO> stages,
		String idCustomerBuyer,
		String friendCode, Date purchaseTime, String idCustomizer,TravelState travelState) {
	super(time_end, time_start, description, name, stages, idCustomerBuyer,
			friendCode, purchaseTime,travelState);
	this.idCustomizer = idCustomizer;
}
/**
 * constructor that convert a prepackedTravelPackage in a customizedTravelPackage
 * @param prepacked
 */
public CustomizedTravelPackageDTO(PrepackedTravelPackageDTO prepacked)
{
	
super(prepacked.getTime_end(),prepacked.getTime_start(),prepacked.getDescription(),prepacked.getName(),prepacked.getStages(),prepacked.getIdCustomerBuyer(),prepacked.getFriendCode(),prepacked.getPurchaseTime(),prepacked.getTravelState());
this.idCustomizer=null;

}

public String getIdCustomizer() {
	return idCustomizer;
}

public void setIdCustomizer(String idCustomizer) {
	this.idCustomizer = idCustomizer;
}

}
