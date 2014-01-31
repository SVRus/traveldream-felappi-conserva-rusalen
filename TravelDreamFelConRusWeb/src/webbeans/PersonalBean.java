package webbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import productManagement.ProductCRUDBeanLocal;
import stateenum.State;
import authentication.LoginBeanLocal;
import dto.EmployeeDTO;
import dto.GenericUserDTO;
import dto.HotelDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
@ManagedBean(name="personal")
public class PersonalBean implements Serializable{
	

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@EJB
private LoginBeanLocal login;
@EJB
private ProductCRUDBeanLocal procrud;
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
private ArrayList<PrepackedTravelPackageDTO> managedTravelPackage;
private String products;
private String managed;
public String getProducts() {
	return products;
}


public void setProducts(String products) {
	this.products = products;
}


public String getManaged() {
	return generic.getManagedTravelPackage().toString();
}


public void setManaged(String managed) {
	this.managed = managed;
}


public PersonalBean() {
	
}
@PostConstruct
public void update()
{
/*
HotelDTO hotel=new HotelDTO(11, "test", "test",0, 11,new Date() ,new Date(), "area1",  "test",  "test",  "test",State.AVAILABLE);
HotelDTO  hotel1=new HotelDTO(11, "test", "test",0, 11,new Date() ,new Date(), "area1",  "test",  "test",  "test",State.AVAILABLE);
HotelDTO  hotel2= new HotelDTO(11, "test", "test",0, 11,new Date() ,new Date(), "are2",  "test",  "test",  "test",State.AVAILABLE);
HotelDTO  hotel3=new HotelDTO(11, "test", "test",0, 11,new Date() ,new Date(), "area2",  "test",  "test",  "test",State.AVAILABLE);

procrud.createProductFromEmployee(hotel, login.getPrincipalUsername());
procrud.createProductFromEmployee(hotel1, login.getPrincipalUsername());
procrud.createProductFromEmployee(hotel2, login.getPrincipalUsername());
procrud.createProductFromEmployee(hotel3, login.getPrincipalUsername());

generic=(EmployeeDTO)login.findLogIn();
*/





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



public ArrayList<PrepackedTravelPackageDTO> getManagedTravelPackage() {
	return generic.getManagedTravelPackage();
}



public void setManagedTravelPackage(ArrayList<PrepackedTravelPackageDTO> managedTravelPackage) {
	this.managedTravelPackage = managedTravelPackage;
}



public void setGeneric(EmployeeDTO generic) {
	this.generic = generic;
}



public GenericUserDTO getGeneric() {
	return generic;
}


	






}
