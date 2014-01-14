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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	private static final long serialVersionUID = 1L;

	public Code() {
		super();
	}
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long code;

   @OneToOne(mappedBy="code",cascade=CascadeType.ALL)
   private Employee employee;

public Code(long code) {
	super();
	this.code = code;
	
}
}
