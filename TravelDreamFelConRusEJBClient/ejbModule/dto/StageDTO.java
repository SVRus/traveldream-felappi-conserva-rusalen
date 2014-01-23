package dto;

import java.util.ArrayList;

public class StageDTO {
private long idStage;
	public long getIdStage() {
	return idStage;
}
public void setIdStage(long idStage) {
	this.idStage = idStage;
}
	public StageDTO(long idStage, ArrayList<ProductDTO> products, String area) {
	super();
	this.idStage = idStage;
	this.products = products;
	Area = area;
}
	private ArrayList <ProductDTO> products;
	String Area;
	public StageDTO(ArrayList<ProductDTO> products, String area) {
		super();
		this.products = products;
		Area = area;
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
