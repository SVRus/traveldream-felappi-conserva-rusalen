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

	
	public String getFlight_company() {
		return flight_company;
	}
	public void setFlight_company(String flight_company) {
		this.flight_company = flight_company;
	}
	public String getArea_start() {
		return area_start;
	}
	public void setArea_start(String area_start) {
		this.area_start = area_start;
	}
	public String getArea_end() {
		return area_end;
	}
	public void setArea_end(String area_end) {
		this.area_end = area_end;
	}
	public String getPlace_start() {
		return place_start;
	}
	public void setPlace_start(String place_start) {
		this.place_start = place_start;
	}
	public String getPlace_end() {
		return place_end;
	}
	public void setPlace_end(String place_end) {
		this.place_end = place_end;
	}
	public String getMore_info() {
		return more_info;
	}
	public void setMore_info(String more_info) {
		this.more_info = more_info;
	}
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
