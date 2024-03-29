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
	private Long idstage;
	private String employeeCreator;
    private String name;
	private Long idProduct;
	private float cost;
	private Date timeStart;
	private Date timeEnd;
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
	public ProductDTO(Long idstage, String employeeCreator, String name,
			float cost, Date timeStart, Date timeEnd,State state,String area) {
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
	public ProductDTO(Long idstage, String employeeCreator, String name,
			long idProduct, float cost, Date timeStart, Date timeEnd,State state,String area) {
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
	
	public Long getIdstage() {
		return idstage;
	}
	public void setIdstage(Long idstage) {
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
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
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

  @Override
	public boolean equals(Object object)
	{
		if(object instanceof ProductDTO)
			return(equals((ProductDTO)object));
		else return false;
		
	}
  
  private boolean equals (ProductDTO product)
  {
	  return this.idProduct.equals(product.getIdProduct());
	  
	  
  }
}
