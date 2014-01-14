package entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Code
 *
 */
@Entity

public class Code implements Serializable {

	
	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}


	private static final long serialVersionUID = 1L;

	public Code() {
		super();
	}
   @Id
  
   private long code;

  

public Code(long code) {
	super();
	this.code = code;
	
}




}
