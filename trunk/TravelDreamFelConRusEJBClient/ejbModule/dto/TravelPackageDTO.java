package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import travelstateenum.TravelState;


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




	public String getIdCustomerBuyer() {
		return idCustomerBuyer;
	}


	public void setIdCustomerBuyer(String idCustomerBuyer) {
		this.idCustomerBuyer = idCustomerBuyer;
	}




	public TravelPackageDTO(Date time_end, Date time_start, String description,
			String name, List<StageDTO> stages, String idCustomerBuyer, String friendCode, Date purchaseTime,TravelState travelState) {
		super();
		this.time_end = time_end;
		this.time_start = time_start;
		this.description = description;
		this.name = name;
		this.stages = stages;
		this.idCustomerBuyer = idCustomerBuyer;
		this.friendCode = friendCode;
		this.purchaseTime = purchaseTime;
		this.travelState=travelState;
	}


	public TravelState getTravelState() {
		return travelState;
	}


	public void setTravelState(TravelState travelState) {
		this.travelState = travelState;
	}



	public String getFriendCode() {
		return friendCode;
	}


	public void setFriendCode(String friendCode) {
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
private Date time_start=new Date();
private String description="";
private String name="";
private List<StageDTO> stages=new ArrayList <StageDTO>();	
private String idCustomerBuyer;	
private String friendCode;
private Date purchaseTime;
public TravelPackageDTO() {
	super();
}


private TravelState travelState;

public TravelPackageDTO(long idtravelpackage, Date time_end,Date time_start,
		String description, String name, List<StageDTO> stages,
		String idCustomerBuyer, String friendCode,
		Date purchaseTime,TravelState travelState) {
	super();
	this.idtravelpackage = idtravelpackage;
	this.time_end = time_end;
	this.time_start = time_start;
	this.description = description;
	this.name = name;
	this.stages = stages;
	this.idCustomerBuyer = idCustomerBuyer;
	this.friendCode = friendCode;
	this.purchaseTime = purchaseTime;
	this.travelState=travelState;
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
