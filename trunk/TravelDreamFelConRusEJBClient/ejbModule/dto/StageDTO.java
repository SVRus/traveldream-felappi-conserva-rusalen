package dto;

import java.util.List;

public class StageDTO {

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
