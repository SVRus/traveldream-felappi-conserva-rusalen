package webbeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import authentication.LoginBeanLocal;
import dto.EmployeeDTO;
import dto.GenericUserDTO;
import dto.ProductDTO;
@ManagedBean(name="personal")
public class PersonalBean implements Serializable{
	

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@EJB
private LoginBeanLocal login;

public LoginBeanLocal getLogin() {
	return login;
}


public void setLogin(LoginBeanLocal login) {
	this.login = login;
}


private EmployeeDTO generic;
private String username;
private String firstname;
private String surname;
private String email;
private long code;
boolean loggato;
private ArrayList<ProductDTO> managedproduct;
private ArrayList<Long> managedTravelPackage;
public PersonalBean() {
	
}
@PostConstruct
public void update()
{
generic=(EmployeeDTO)login.findLogIn();


}
public boolean isLoggato() {
	return login.isLogged();
}


public void setLoggato(boolean loggato) {
	this.loggato =loggato ;
}


public String getUsername() {
	
	return generic.toString();
	
}



public void setUsername(String username) {
	this.username = username;
}



public String getFirstname() {
	return generic.getName();
}



public void setFirstname(String firstname) {
	this.firstname = firstname;
}



public String getSurname() {
	return generic.getSurname();
}



public void setSurname(String surname) {
	this.surname = surname;
}



public String getEmail() {
	return generic.getEmail();
}



public void setEmail(String email) {
	this.email = email;
}



public long getCode() {
	return (generic).getCode();
}



public void setCode(long code) {
	this.code = code;
}



public ArrayList<ProductDTO> getManagedproduct() {
	return generic.getManagedproduct();
}



public void setManagedproduct(ArrayList<ProductDTO> managedproduct) {
	this.managedproduct = managedproduct;
}



public ArrayList<Long> getManagedTravelPackage() {
	return generic.getManagedTravelPackage();
}



public void setManagedTravelPackage(ArrayList<Long> managedTravelPackage) {
	this.managedTravelPackage = managedTravelPackage;
}



public void setGeneric(EmployeeDTO generic) {
	this.generic = generic;
}



public GenericUserDTO getGeneric() {
	return generic;
}


	






}
