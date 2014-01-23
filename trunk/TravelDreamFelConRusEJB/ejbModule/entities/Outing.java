package entities;

import entities.Product;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

import stateenum.State;

/**
 * Entity implementation class for Entity: Outing
 *
 */
@Entity
 
@DiscriminatorValue("OUTING")
public class Outing extends Product implements Serializable {

	
	public Outing(float cost, Calendar timeStart, Calendar timeEnd, String name,
			 String description, String area,State state,String place) {
		super(cost, timeStart, timeEnd, name, state,area);
		this.description = description;
		this.place=place;
	}



	public Outing(long idProduct, float cost, Calendar timeStart,Calendar timeEnd,
			String name,  String description, String area,State state,String place) {
		super(idProduct, cost, timeStart, timeEnd, name,state,area);
		this.description = description;
		this.place=place;
	}



	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}





	private static final long serialVersionUID = 1L;
private String description;
private String place;

	
	
	public Outing() {
		super();
	}
   public boolean equals(Object object)
   {
	   
	   
	   if(! (object instanceof Outing))
	return false;
	   return equals((Outing)object);
   }
   
   public boolean equals(Outing outing)
   {
	   
   return super.equals(outing)	;   
	   
	}
   
}