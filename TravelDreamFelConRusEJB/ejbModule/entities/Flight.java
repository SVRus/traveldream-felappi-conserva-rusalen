package entities;

import entities.Product;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import stateenum.State;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity

@DiscriminatorValue("FLIGHT")
public class Flight extends Product implements Serializable {

	
	
	public Flight(long idProduct, float cost, Date timeStart, Date timeEnd,
			String name,  String flight_company,
			String area_start, String area_end, String place_start,
			String place_end, String more_info,State state) {
		super(idProduct, cost, timeStart, timeEnd, name, state,area_end);
		this.flight_company = flight_company;
		this.area_start = area_start;
		this.place_start = place_start;
		this.place_end = place_end;
		this.more_info = more_info;
	}
	
	public Flight(float cost, Date timeStart, Date timeEnd, String name,
			 String flight_company, String area_start,
			String area_end, String place_start, String place_end,
			String more_info,State state) {
		super(cost, timeStart, timeEnd, name, state,area_end);
		this.flight_company = flight_company;
		this.area_start = area_start;
		this.place_start = place_start;
		this.place_end = place_end;
		this.more_info = more_info;
	}

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
private String place_start;
private String place_end;
private String more_info;
	public Flight() {
		super();
	}
   
}
