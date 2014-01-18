package dto;

import java.util.List;

public class StageDTO {
private long idStage;
	public long getIdStage() {
	return idStage;
}
public void setIdStage(long idStage) {
	this.idStage = idStage;
}
	public StageDTO(long idStage, List<ProductDTO> products, String area) {
	super();
	this.idStage = idStage;
	this.products = products;
	Area = area;
}
	private List <ProductDTO> products;
	String Area;
	public StageDTO(List<ProductDTO> products, String area) {
		super();
		this.products = products;
		Area = area;
	}
	public List<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	
	
}
