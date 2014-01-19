package dto;

import java.util.Calendar;
import java.util.Date;

import stateenum.State;


public class ProductDTO {
	
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	private long idstage;
	private String employeeCreator;
    private String name;
	private long idProduct;
	private float cost;
	private Calendar timeStart;
	private Calendar timeEnd;
	private State state;
	private String area;
	
	/**
	 * constructor without the idproduct: used during the creation phase
	 * @param idstage
	 * @param employeeCreator
	 * @param name
	 * @param cost
	 * @param timeStart
	 * @param timeEnd
	 */
	public ProductDTO(long idstage, String employeeCreator, String name,
			float cost, Calendar timeStart, Calendar timeEnd,State state,String area) {
		super();
		this.idstage = idstage;
		this.employeeCreator = employeeCreator;
		this.name = name;
		this.cost = cost;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.state=state;
		this.area=area;
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
	 */
	public ProductDTO(long idstage, String employeeCreator, String name,
			long idProduct, float cost, Calendar timeStart, Calendar timeEnd,State state,String area) {
		super();
		this.idstage = idstage;
		this.employeeCreator = employeeCreator;
		this.name = name;
		this.idProduct = idProduct;
		this.cost = cost;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.state=state;
		this.area=area;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public long getIdstage() {
		return idstage;
	}
	public void setIdstage(long idstage) {
		this.idstage = idstage;
	}
	public String getEmployeeCreator() {
		return employeeCreator;
	}
	public void setEmployeeCreator(String employeeCreator) {
		this.employeeCreator = employeeCreator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Calendar getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Calendar timeStart) {
		this.timeStart = timeStart;
	}
	public Calendar getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Calendar timeEnd) {
		this.timeEnd = timeEnd;
	}

  
	
}
