package dto;

import java.util.Date;

import stateenum.State;

public class OutingDTO extends ProductDTO {
	private String description;
	/**
	 * constructor without the idproduct: used during the creation phase
	 * @param idtravelpackage
	 * @param employeeCreator
	 * @param name
	 * @param cost
	 * @param timeStart
	 * @param timeEnd
	 * @param description
	 * @param area
	 */
	public OutingDTO(long idtravelpackage, String employeeCreator, String name,
			float cost, Date timeStart, Date timeEnd, String description,
			String area,State state) {
		super(idtravelpackage, employeeCreator, name, cost, timeStart, timeEnd, state,area);
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	 * @param description
	 * @param area
	 */
	public OutingDTO(long idtravelpackage, String employeeCreator, String name,
			long idProduct, float cost, Date timeStart, Date timeEnd,
			String description, String area,State state) {
		super(idtravelpackage, employeeCreator, name, idProduct, cost,
				timeStart, timeEnd,state,area);
		this.description = description;
	}







}
