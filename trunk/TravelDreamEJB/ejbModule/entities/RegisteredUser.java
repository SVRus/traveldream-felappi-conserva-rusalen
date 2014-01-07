package entities;

import java.io.Serializable;
import java.util.List;




import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Entity implementation class for Entity: RegisteredUser
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="REGISTEREDUSER_TYPE")

public class RegisteredUser implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idRegisteredUser;
	 @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
             message="{invalid.email}")
private String email;
private String name;
private String surname;
private String telephone;
private String password;

@Column(unique=true)
private String username;


@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(
	name="USER_GROUP"
	, joinColumns={
		@JoinColumn(name="USERNAME", referencedColumnName="username")
		}
	, inverseJoinColumns={
		@JoinColumn(name="GROUPID", referencedColumnName="idGroup")
		}
	)
private List <Groups> groups;
	public RegisteredUser() {
		super();
	}
   
}
