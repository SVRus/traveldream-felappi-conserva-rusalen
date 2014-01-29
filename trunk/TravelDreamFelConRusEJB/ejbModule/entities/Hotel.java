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
 * constructor used during th creation phase
 * @param cost
 * @param timeStart
 * @param timeEnd
 * @param name
 * @param state
 * @param area
 * @param place
 * @param room_type
 * @param more_info
 */
public Hotel(float cost, Long timeStart, Long timeEnd, String name,
			State state, String area, String place, String room_type,
			String more_info) {
		super(cost, timeStart, timeEnd, name, state, area);
		this.place = place;
		this.room_type = room_type;
		this.more_info = more_info;
		
	}
/**
 * constructor
 * @param idProduct
 * @param cost
 * @param timeStart
 * @param timeEnd
 * @param name
 * @param state
 * @param area
 * @param room_type
 * @param more_info
 * @param place
 */
public Hotel(long idProduct, float cost, Long timeStart,
		Long timeEnd, String name, State state, String area ,String room_type, String more_info,
			
			String place) {
		super(idProduct, cost, timeStart, timeEnd, name, state, area);
		this.place = place;
		this.room_type = room_type;
		this.more_info = more_info;
	}

private String place;
private String room_type;
private String more_info;



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
	   /*public boolean equals(Object object)
	   {
		   
		   
		   if(! (object instanceof Outing))
		return false;
		   return equals((Hotel)object);
	   }
	   
	   public boolean equals(Hotel hotel)
	   {
		   
	   return super.equals(hotel)&&place.equalsIgnoreCase(hotel.getPlace())&&room_type.equalsIgnoreCase(hotel.getRoom_type());
		   
		}*/
}
