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

	
	private static final long serialVersionUID = 1L;
private String description;
private String area;

	
	
	public Outing() {
		super();
	}
   
}