package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Group
 *
 */
@Entity

public class Groups implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Groups() {
		super();
	}
	@Id
	
 private String idGroup;
@ManyToMany(mappedBy="groups",cascade=CascadeType.ALL)
 private List <RegisteredUser> users;
}
