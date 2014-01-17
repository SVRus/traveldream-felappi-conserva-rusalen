package entities;

import entities.Product;

import java.io.Serializable;
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

	
	public Outing(float cost, Date timeStart, Date timeEnd, String name,
			 String description, String area,State state) {
		super(cost, timeStart, timeEnd, name, state,area);
		this.description = description;
	}



	public Outing(long idProduct, float cost, Date timeStart, Date timeEnd,
			String name,  String description, String area,State state) {
		super(idProduct, cost, timeStart, timeEnd, name,state,area);
		this.description = description;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}





	private static final long serialVersionUID = 1L;
private String description;

	
	
	public Outing() {
		super();
	}
   
}