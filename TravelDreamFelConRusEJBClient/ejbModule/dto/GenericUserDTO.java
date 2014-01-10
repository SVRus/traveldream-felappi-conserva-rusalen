package dto;

import javax.validation.constraints.Pattern;

public class GenericUserDTO {
private String email;
private String name;
private String surname;
private String telephone;
private String password;
private String username;
public GenericUserDTO(String email, String name, String surname,
		String telephone, String password, String username) {
	super();
	this.email = email;
	this.name = name;
	this.surname = surname;
	this.telephone = telephone;
	this.password = password;
	this.username = username;
}

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



}
