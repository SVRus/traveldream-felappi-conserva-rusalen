package entities;

import entities.Product;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Outing
 *
 */
@Entity
@DiscriminatorValue("OUTING")
public class Outing extends Product implements Serializable {

	
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	private static final long serialVersionUID = 1L;
private String description;
private String area;

	
	
	public Outing() {
		super();
	}
   
}