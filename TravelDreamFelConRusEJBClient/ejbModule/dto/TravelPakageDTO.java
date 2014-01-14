package dto;

import java.util.Date;
import java.util.List;


public class TravelPakageDTO 
{


private long idtravelpackage;
private Date time_end;
private Date time_start;
private String description;
private String name;
private List<ProductDTO> products;	
private long idCustomerBuyer;	
private long idCustomerFriendOwner;
private long friendCode;
private Date purchaseTime;


public TravelPakageDTO(long idtravelpackage, Date time_end, Date time_start,
		String description, String name, List<ProductDTO> products,
		long idCustomerBuyer, long idCustomerFriendOwner, long friendCode,
		Date purchaseTime) {
	super();
	this.idtravelpackage = idtravelpackage;
	this.time_end = time_end;
	this.time_start = time_start;
	this.description = description;
	this.name = name;
	this.products = products;
	this.idCustomerBuyer = idCustomerBuyer;
	this.idCustomerFriendOwner = idCustomerFriendOwner;
	this.friendCode = friendCode;
	this.purchaseTime = purchaseTime;
}






}
