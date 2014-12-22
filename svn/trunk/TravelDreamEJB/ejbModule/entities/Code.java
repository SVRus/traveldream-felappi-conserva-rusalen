package entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Code
 *
 */
@Entity

public class Code implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Code() {
		super();
	}
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long code;
}
