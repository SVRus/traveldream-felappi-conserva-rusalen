package dto;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomizedTravelPackageDTO extends TravelPackageDTO {



private Long idCustomizer;	

public CustomizedTravelPackageDTO(long idtravelpackage, Calendar time_end,
		Calendar time_start, String description, String name,
			List<StageDTO> stages, String idCustomerBuyer,
			String idCustomerFriendOwner, String friendCode, Calendar purchaseTime,Long idCustomizer) {
		super(idtravelpackage, time_end, time_start, description, name,
				stages, idCustomerBuyer, idCustomerFriendOwner, friendCode,
				purchaseTime);
		this.idCustomizer=idCustomizer;
	}

public CustomizedTravelPackageDTO(Calendar time_end, Calendar time_start,
		String description, String name, List<StageDTO> stages,
		String idCustomerBuyer, String idCustomerFriendOwner,
		String friendCode, Calendar purchaseTime, Long idCustomizer) {
	super(time_end, time_start, description, name, stages, idCustomerBuyer,
			idCustomerFriendOwner, friendCode, purchaseTime);
	this.idCustomizer = idCustomizer;
}

public Long getIdCustomizer() {
	return idCustomizer;
}

public void setIdCustomizer(Long idCustomizer) {
	this.idCustomizer = idCustomizer;
}

}
