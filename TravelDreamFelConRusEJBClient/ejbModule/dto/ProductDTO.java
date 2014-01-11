package dto;

import java.util.Date;


public class ProductDTO {
	
	
	private long idtravelpackage;
	private String employeeCreator;
    private String name;
	private long idProduct;
	private float cost;
	private Date timeStart;
	private Date timeEnd;
	
	/**
	 * constructor without the idproduct: used during the creation phase
	 * @param idtravelpackage
	 * @param employeeCreator
	 * @param name
	 * @param cost
	 * @param timeStart
	 * @param timeEnd
	 */
	public ProductDTO(long idtravelpackage, String employeeCreator, String name,
			float cost, Date timeStart, Date timeEnd) {
		super();
		this.idtravelpackage = idtravelpackage;
		this.employeeCreator = employeeCreator;
		this.name = name;
		this.cost = cost;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
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
	 */
	public ProductDTO(long idtravelpackage, String employeeCreator, String name,
			long idProduct, float cost, Date timeStart, Date timeEnd) {
		super();
		this.idtravelpackage = idtravelpackage;
		this.employeeCreator = employeeCreator;
		this.name = name;
		this.idProduct = idProduct;
		this.cost = cost;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	public long getIdtravelpackage() {
		return idtravelpackage;
	}
	public void setIdtravelpackage(long idtravelpackage) {
		this.idtravelpackage = idtravelpackage;
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
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

  
	
}
