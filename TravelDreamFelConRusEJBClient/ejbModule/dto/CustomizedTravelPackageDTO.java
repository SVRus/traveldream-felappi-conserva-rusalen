package dto;

import java.util.Date;
import java.util.List;

public class CustomizedTravelPackageDTO extends TravelPakageDTO {



	

public CustomizedTravelPackageDTO(long idtravelpackage, Date time_end,
			Date time_start, String description, String name,
			List<ProductDTO> products, long idCustomerBuyer,
			long idCustomerFriendOwner, long friendCode, Date purchaseTime) {
		super(idtravelpackage, time_end, time_start, description, name,
				products, idCustomerBuyer, idCustomerFriendOwner, friendCode,
				purchaseTime);
		
	}

}
