package entities;

import java.io.Serializable;
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
   String area;
   @OneToMany()
   @JoinColumn
   List <Product> products;
}
