package entities;

import entities.Product;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity
@DiscriminatorValue("HOTEL")
public class Hotel extends Product implements Serializable {
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
