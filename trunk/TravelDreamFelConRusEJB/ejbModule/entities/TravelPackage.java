package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import travelstateenum.TravelState;

/**
 * Entity implementation class for Entity: TravelPackage
 *
 */

@Entity
@NamedQuery(name = "findeverytravelpackage", query = "SELECT b FROM TravelPackage b ")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TRAVELPACKAGE_TYPE")
public class TravelPackage implements Serializable {

	






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



	



	public TravelPackage(long idtravelpackage, Date time_end, Date time_start,
			String description, String name, List<Stage> stages,
			String friendCode, Date purchaseTime,TravelState travelState) {
		super();
		this.idtravelpackage = idtravelpackage;
		this.time_end = time_end;
		this.time_start = time_start;
		this.description = description;
		this.name = name;
		this.stages = stages;
		this.friendCode = friendCode;
		this.purchaseTime = purchaseTime;
		this.travelState=travelState;
	}



	public List<Stage> getStages() {
		return new ArrayList< Stage> (stages) ;
	}



	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}



	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idtravelpackage;
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







@Temporal (TemporalType.TIMESTAMP)
private Date time_end;
@Temporal (TemporalType.TIMESTAMP)

private Date time_start;
private String description;
@Column(unique=true)
private String name;
@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="IDTRAVELPACKAGE")
private List<Stage> stages;

private String friendCode;
private TravelState travelState;
public TravelState getTravelState() {
	return travelState;
}



public void setTravelState(TravelState travelState) {
	this.travelState = travelState;
}



@Temporal (TemporalType.TIMESTAMP)
private Date purchaseTime;


	public TravelPackage() {
		super();
	}



	public TravelPackage(Date time_end,Date time_start, String description,
			String name, List<Stage> stages,  String friendCode, Date purchaseTime,TravelState travelState) {
		super();
		this.time_end = time_end;
		this.time_start = time_start;
		this.description = description;
		this.name = name;
		this.stages = stages;
	    this.travelState=travelState;
		this.friendCode = friendCode;
		this.purchaseTime = purchaseTime;
	}
   
}
