package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import travelstateenum.TravelState;

/**
 * Entity implementation class for Entity: TravelPackage
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TRAVELPACKAGE_TYPE")
public class TravelPackage implements Serializable {

	






	public String getFriendCode() {
		return friendCode;
	}



	public void setFriendCode(String friendCode) {
		this.friendCode = friendCode;
	}



	public Long getPurchaseTime() {
		return purchaseTime;
	}



	public void setPurchaseTime(Long purchaseTime) {
		this.purchaseTime = purchaseTime;
	}



	



	public TravelPackage(long idtravelpackage, Long time_end, Long time_start,
			String description, String name, List<Stage> stages,
			String friendCode, Long purchaseTime,TravelState travelState) {
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



public Long getTime_end() {
	return time_end;
}



public void setTime_end(Long time_end) {
	this.time_end = time_end;
}



public Long getTime_start() {
	return time_start;
}



public void setTime_start(Long time_start) {
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








private Long time_end;
private Long time_start;
private String description;
private String name;
@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="IDTRAVELPACKAGE")
private List<Stage> stages;

private String friendCode;
@Enumerated(EnumType.STRING)

private TravelState travelState;
public TravelState getTravelState() {
	return travelState;
}



public void setTravelState(TravelState travelState) {
	this.travelState = travelState;
}



private Long purchaseTime;


	public TravelPackage() {
		super();
	}



	public TravelPackage(Long time_end,Long time_start, String description,
			String name, List<Stage> stages,  String friendCode, Long purchaseTime,TravelState travelState) {
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
   public boolean isAllSold()
   {
	   Iterator <Stage> iter=stages.iterator();
	   boolean sold=true;
	   while(iter.hasNext()&& !sold)
	   {
		   
		   sold=sold&&iter.next().isAllSold();
		   
	   }
	   
	   return sold;
   }
}
