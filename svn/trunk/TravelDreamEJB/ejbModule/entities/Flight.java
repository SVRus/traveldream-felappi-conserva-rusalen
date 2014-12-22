package entities;

import entities.Product;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
@DiscriminatorValue("FLIGHT")
public class Flight extends Product implements Serializable {

	
	private static final long serialVersionUID = 1L;
private String flight_company;
private String area_start;
private String area_end;
private String place_start;
private String place_end;
private String more_info;
	public Flight() {
		super();
	}
   
}
