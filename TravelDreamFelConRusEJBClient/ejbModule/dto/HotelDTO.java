package dto;

import java.util.Calendar;
import java.util.Date;

import stateenum.State;

public class HotelDTO extends ProductDTO {
	private String place;
	private String room_type;
	private String more_info;
	
	
	/**
	 * constructor without the idproduct: used during the creation phase
	 * @param idtravelpackage
	 * @param employeeCreator
	 * @param name
	 * @param cost
	 * @param timeStart
	 * @param timeEnd
	 * @param area
	 * @param place
	 * @param room_type
	 * @param more_info
	 */
	public HotelDTO(long idtravelpackage, String employeeCreator, String name,
			float cost, Calendar timeStart, Calendar timeEnd, String area,
			String place, String room_type, String more_info,State state) {
		super(idtravelpackage, employeeCreator, name, cost, timeStart, timeEnd,state,area);
		this.place = place;
		this.room_type = room_type;
		this.more_info = more_info;
	}
	/**
	 * constructor with the idproduct: it can't be used during the creation phase
	 * @param idtravelpackage
	 * @param employeeCreator
	 * @param name
	 * @param idProduct
	 * @param cost
	 * @param timeStart
	 * @param timeEnd
	 * @param area
	 * @param place
	 * @param room_type
	 * @param more_info
	 */
	public HotelDTO(long idtravelpackage, String employeeCreator, String name,
			long idProduct, float cost, Calendar timeStart, Calendar timeEnd,
			String area, String place, String room_type, String more_info,State state) {
		super(idtravelpackage, employeeCreator, name, idProduct, cost,
				timeStart, timeEnd,state,area);
		this.place = place;
		this.room_type = room_type;
		this.more_info = more_info;
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
	
	
	
	
}
