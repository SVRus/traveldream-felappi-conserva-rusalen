package dto;

import java.util.Date;


public class ProductDTO {

	private long idProduct=-1;
	private float cost;
	private Date timeStart;
	private Date timeEnd;
	public ProductDTO(long idProduct, float cost, Date timeStart, Date timeEnd) {
		super();
		this.idProduct = idProduct;
		this.cost = cost;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	public ProductDTO(float cost, Date timeStart, Date timeEnd) {
		super();
		this.cost = cost;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
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
