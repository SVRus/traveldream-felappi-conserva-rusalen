package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Stage
 *
 */
@Entity

public class Stage implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Stage() {
		super();
	}
	
	public long getIdStage() {
		return idStage;
	}

	public void setIdStage(long idStage) {
		this.idStage = idStage;
	}

	public Stage(String area, List<Product> products) {
		super();
		Area = area;
		this.products = products;
	}

	public Stage(long idStage, String area, List<Product> products) {
		super();
		this.idStage = idStage;
		Area = area;
		this.products = products;
	}

	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public List<Product> getProducts() {
		return new ArrayList <Product> (products);
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStage;
	private String Area;
	@OneToMany
	@JoinColumn(name="idStage")
   private List <Product> products;
}
