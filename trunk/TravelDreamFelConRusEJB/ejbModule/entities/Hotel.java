package entities;

import entities.Product;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import stateenum.State;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity

@DiscriminatorValue("HOTEL")
public class Hotel extends Product implements Serializable {
	

/**
 * constructor used during the update phase
 * @param cost
 * @param timeStart
 * @param timeEnd
 * @param name
 * @param travel
 * @param area
 * @param place
 * @param room_type
 * @param more_info
 */
public Hotel(float cost, Date timeStart, Date timeEnd, String name,
			 String area, String place, String room_type,
			String more_info,State state) {
		super(cost, timeStart, timeEnd, name, state);
		this.area = area;
		this.place = place;
		this.room_type = room_type;
		this.more_info = more_info;
	}
/**
 * constructor used during the creation phase
 * @param idProduct
 * @param cost
 * @param timeStart
 * @param timeEnd
 * @param name
 * @param travel
 * @param area
 * @param place
 * @param room_type
 * @param more_info
 */
public Hotel(long idProduct, float cost, Date timeStart, Date timeEnd,
			String name, String area, String place,
			String room_type, String more_info,State state) {
		super(idProduct, cost, timeStart, timeEnd, name,state);
		this.area = area;
		this.place = place;
		this.room_type = room_type;
		this.more_info = more_info;
	}

private String area;
private String place;
private String room_type;
private String more_info;
	

public String getArea() {
	return area;
}

public void setArea(String area) {
	this.area = area;
}

public String getPlace() {
	return place;
}

public void setPlace(String place) {
	this.place = place;
}

public String getRoom_type() {
	return room_type;
}

public void setRoom_type(String room_type) {
	this.room_type = room_type;
}

public String getMore_info() {
	return more_info;
}

public void setMore_info(String more_info) {
	this.more_info = more_info;
}

	private static final long serialVersionUID = 1L;

	public Hotel() {
		super();
	}
   
}
