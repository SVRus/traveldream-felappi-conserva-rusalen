package dto;

import java.util.ArrayList;
import java.util.Date;

public class StageDTO {
private Long idStage;
	public Long getIdStage() {
	return idStage;
}
public void setIdStage(Long idStage) {
	this.idStage = idStage;
}

	public StageDTO(Long idStage, ArrayList<ProductDTO> products, String area, Date timeStart, Date timeEnd) {
	super();
	this.idStage = idStage;
	this.products = products;
	Area = area;
	this.timeStart=timeStart;
	this.timeEnd=timeEnd;
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
	private ArrayList <ProductDTO> products=new ArrayList <ProductDTO>();
	public StageDTO() {
		super();
	}
	private String Area;
private Date timeStart;
private Date timeEnd;
	
	public StageDTO(ArrayList<ProductDTO> products, String area, Date timeStart, Date timeEnd) {
		super();
		this.products = products;
		Area = area;
		this.timeStart=timeStart;
		this.timeEnd=timeEnd;
	}
	public ArrayList<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<ProductDTO> products) {
		this.products = products;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public void addProduct(ProductDTO product)
	{
		products.add(product);
	}
	
}
