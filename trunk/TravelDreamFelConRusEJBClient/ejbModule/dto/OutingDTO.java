package dto;

import java.util.Calendar;
import java.util.Date;

import stateenum.State;

public class OutingDTO extends ProductDTO {
	private String description;
	private String place;
	/**
	 * constructor without the idproduct: used during the creation phase
	 * @param idstage
	 * @param employeeCreator
	 * @param name
	 * @param cost
	 * @param timeStart
	 * @param timeEnd
	 * @param description
	 * @param area
	 */
	public OutingDTO(long idstage, String employeeCreator, String name,
			float cost, Calendar timeStart, Calendar timeEnd, String description,
			String area,State state,String place) {
		super(idstage, employeeCreator, name, cost, timeStart, timeEnd, state,area);
		this.description = description;
		this.place=place;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	/**
	 * constructor with the idproduct: it can't be used during the creation phase
	 * @param idstage
	 * @param employeeCreator
	 * @param name
	 * @param idProduct
	 * @param cost
	 * @param timeStart
	 * @param timeEnd
	 * @param description
	 * @param area
	 */
	public OutingDTO(long idstage, String employeeCreator, String name,
			long idProduct, float cost, Calendar timeStart, Calendar timeEnd,
			String description, String area,State state,String place) {
		super(idstage, employeeCreator, name, idProduct, cost,
				timeStart, timeEnd,state,area);
		this.description = description;
		this.place=place;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}


  




}
