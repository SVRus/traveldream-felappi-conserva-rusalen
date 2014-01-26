package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Stage
 *io sono giusto
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

	public Stage(String area, List<Product> products,Long timeStart,Long timeEnd) {
		super();
		this.Area = area;
		this.products = products;
		this.timeStart=timeStart;
		this.timeEnd=timeEnd;
	}
/**
 * 
 * @param idStage
 * @param area
 * @param products
 * @param timeStart
 * @param timeEnd
 */
	public Stage(long idStage, String area, List<Product> products,Long timeStart,Long timeEnd) {
		super();
		this.idStage = idStage;
		this.Area = area;
		this.products = products;
		this.timeStart=timeStart;
		this.timeEnd=timeEnd;
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
	@OneToMany()
	@JoinColumn(name="idStage")
   private List <Product> products;
	private Long timeStart;
	private Long timeEnd;

	public Long getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Long timeStart) {
		this.timeStart = timeStart;
	}

	public Long getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Long timeEnd) {
		this.timeEnd = timeEnd;
	}
}
