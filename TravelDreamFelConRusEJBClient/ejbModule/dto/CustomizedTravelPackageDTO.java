package dto;

import java.util.Date;
import java.util.List;

import travelstateenum.TravelState;

public class CustomizedTravelPackageDTO extends TravelPackageDTO {



private Long idCustomizer;	

public CustomizedTravelPackageDTO(long idtravelpackage, Date time_end,
		Date time_start, String description, String name,
			List<StageDTO> stages, String idCustomerBuyer,
			String idCustomerFriendOwner, String friendCode, Date purchaseTime,Long idCustomizer,TravelState travelState) {
		super(idtravelpackage, time_end, time_start, description, name,
				stages, idCustomerBuyer, idCustomerFriendOwner, friendCode,
				purchaseTime,travelState);
		this.idCustomizer=idCustomizer;
	}

public CustomizedTravelPackageDTO(Date time_end, Date time_start,
		String description, String name, List<StageDTO> stages,
		String idCustomerBuyer, String idCustomerFriendOwner,
		String friendCode, Date purchaseTime, Long idCustomizer,TravelState travelState) {
	super(time_end, time_start, description, name, stages, idCustomerBuyer,
			idCustomerFriendOwner, friendCode, purchaseTime,travelState);
	this.idCustomizer = idCustomizer;
}

public Long getIdCustomizer() {
	return idCustomizer;
}

public void setIdCustomizer(Long idCustomizer) {
	this.idCustomizer = idCustomizer;
}

}
