package dto;

import java.util.Calendar;
import java.util.Date;

import stateenum.State;

public class FlightDTO extends ProductDTO {
	private String flight_company;
	private String area_start;
	private String place_start;
	private String place_end;
	private String more_info;
	
/**
 * 
 * @param idstage
 * @param employeeCreator
 * @param name
 * @param idProduct
 * @param cost
 * @param timeStart
 * @param timeEnd
 * @param state
 * @param area
 * @param flight_company
 * @param area_start
 * @param place_start
 * @param place_end
 * @param more_info
 */
	
	public FlightDTO(long idstage, String employeeCreator, String name,
			long idProduct, float cost, Calendar timeStart, Calendar timeEnd,
			State state, String area, String flight_company, String area_start,
			String place_start, String place_end, String more_info) {
		super(idstage, employeeCreator, name, idProduct, cost, timeStart,
				timeEnd, state, area);
		this.flight_company = flight_company;
		this.area_start = area_start;
		this.place_start = place_start;
		this.place_end = place_end;
		this.more_info = more_info;
	}
	public FlightDTO(long idstage, String employeeCreator, String name,
			float cost, Calendar timeStart, Calendar timeEnd, State state,
			String area, String flight_company, String area_start,
			String place_start, String place_end, String more_info) {
		super(idstage, employeeCreator, name, cost, timeStart, timeEnd, state,
				area);
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
	
	
	
	
}
