package dto;

import java.util.Date;
import java.util.List;


public class TravelPackageDTO 
{


public long getIdtravelpackage() {
		return idtravelpackage;
	}


	public void setIdtravelpackage(long idtravelpackage) {
		this.idtravelpackage = idtravelpackage;
	}


	public Date getTime_end() {
		return time_end;
	}


	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}


	public Date getTime_start() {
		return time_start;
	}


	public void setTime_start(Date time_start) {
		this.time_start = time_start;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<StageDTO> getProducts() {
		return stages;
	}


	public void setProducts(List<StageDTO> stages) {
		this.stages = stages;
	}


	public long getIdCustomerBuyer() {
		return idCustomerBuyer;
	}


	public void setIdCustomerBuyer(long idCustomerBuyer) {
		this.idCustomerBuyer = idCustomerBuyer;
	}


	public long getIdCustomerFriendOwner() {
		return idCustomerFriendOwner;
	}


	public void setIdCustomerFriendOwner(long idCustomerFriendOwner) {
		this.idCustomerFriendOwner = idCustomerFriendOwner;
	}


	public long getFriendCode() {
		return friendCode;
	}


	public void setFriendCode(long friendCode) {
		this.friendCode = friendCode;
	}


	public Date getPurchaseTime() {
		return purchaseTime;
	}


	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}


private long idtravelpackage;
private Date time_end;
private Date time_start;
private String description;
private String name;
private List<StageDTO> stages;	
private long idCustomerBuyer;	
private long idCustomerFriendOwner;
private long friendCode;
private Date purchaseTime;


public TravelPackageDTO(long idtravelpackage, Date time_end, Date time_start,
		String description, String name, List<StageDTO> stages,
		long idCustomerBuyer, long idCustomerFriendOwner, long friendCode,
		Date purchaseTime) {
	super();
	this.idtravelpackage = idtravelpackage;
	this.time_end = time_end;
	this.time_start = time_start;
	this.description = description;
	this.name = name;
	this.stages = stages;
	this.idCustomerBuyer = idCustomerBuyer;
	this.idCustomerFriendOwner = idCustomerFriendOwner;
	this.friendCode = friendCode;
	this.purchaseTime = purchaseTime;
}


public List<StageDTO> getStages() {
	return stages;
}


public void setStages(List<StageDTO> stages) {
	this.stages = stages;
}






}
