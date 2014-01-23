package dto;

import java.util.Calendar;
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


	public Calendar getTime_end() {
		return time_end;
	}


	public void setTime_end(Calendar time_end) {
		this.time_end = time_end;
	}


	public Calendar getTime_start() {
		return time_start;
	}


	public void setTime_start(Calendar time_start) {
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




	public String getIdCustomerBuyer() {
		return idCustomerBuyer;
	}


	public void setIdCustomerBuyer(String idCustomerBuyer) {
		this.idCustomerBuyer = idCustomerBuyer;
	}


	public String getIdCustomerFriendOwner() {
		return idCustomerFriendOwner;
	}


	public TravelPackageDTO(Calendar time_end, Calendar time_start, String description,
			String name, List<StageDTO> stages, String idCustomerBuyer,
			String idCustomerFriendOwner, String friendCode, Calendar purchaseTime) {
		super();
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


	public void setIdCustomerFriendOwner(String idCustomerFriendOwner) {
		this.idCustomerFriendOwner = idCustomerFriendOwner;
	}


	public String getFriendCode() {
		return friendCode;
	}


	public void setFriendCode(String friendCode) {
		this.friendCode = friendCode;
	}


	public Calendar getPurchaseTime() {
		return purchaseTime;
	}


	public void setPurchaseTime(Calendar purchaseTime) {
		this.purchaseTime = purchaseTime;
	}


private long idtravelpackage;
private Calendar time_end;
private Calendar time_start;
private String description;
private String name;
private List<StageDTO> stages;	
private String idCustomerBuyer;	
private String idCustomerFriendOwner;
private String friendCode;
private Calendar purchaseTime;


public TravelPackageDTO(long idtravelpackage, Calendar time_end,Calendar time_start,
		String description, String name, List<StageDTO> stages,
		String idCustomerBuyer, String idCustomerFriendOwner, String friendCode,
		Calendar purchaseTime) {
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


public void addStage(StageDTO stage)
{
	stages.add(stage);	
}



}
