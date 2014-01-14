package entities;


import groupenum.Group;

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

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public RegisteredUser(String email, String name, String surname,
			String telephone, String password, String username,
			List<Group> groups) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.password = password;
		this.username = username;
		this.groups = groups;
	}
	private static final long serialVersionUID = 1L;

	 @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
             message="{invalid.email}")
private String email;
private String name;
private String surname;
private String telephone;
private String password;

@Id
private String username;




@ElementCollection(targetClass = Group.class)
@CollectionTable(name = "USER_GROUP",
                joinColumns = @JoinColumn(name = "username"))
@Enumerated(EnumType.STRING)
@Column(name="groupname")
private List<Group> groups;
	public RegisteredUser() {
		super();
	}
   
}
