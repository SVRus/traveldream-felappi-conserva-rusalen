package webbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import productManagement.ProductCRUDBeanLocal;
import stateenum.State;
import travelPackageManagement.TravelPackageCRUDBeanLocal;
import authentication.LoginBeanLocal;
import dto.EmployeeDTO;
import dto.GenericUserDTO;
import dto.HotelDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
@ManagedBean(name="personal")
@ViewScoped
public class PersonalBean implements Serializable{
	

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@EJB
private LoginBeanLocal login;
@EJB
private ProductCRUDBeanLocal procrud;
@EJB
private TravelPackageCRUDBeanLocal packcrud;

private ArrayList<PrepackedTravelPackageDTO> allPackages;


public LoginBeanLocal getLogin() {
	return login;
}


public void setLogin(LoginBeanLocal login) {
	this.login = login;
}


private EmployeeDTO generic;

private String firstName;
private String lastName;
private String email;
private String message;


boolean loggato;
private ArrayList<ProductDTO> managedproduct;
private ArrayList<PrepackedTravelPackageDTO> managedTravelPackage;

public PersonalBean() {
	
}
@PostConstruct
public void update()
{
System.out.println("inizializzato");
allPackages= packcrud.findAllPackageForEmployee();


}

public void modify(ActionEvent e)
{
	EmployeeDTO emp = (EmployeeDTO) login.findLogIn();
	emp.setEmail(email);
	emp.setName(firstName);
	emp.setSurname(lastName);
	if(login.updateEmployee(emp))
	{
		message= "Dati correttamente aggiornati";
		return;
	}
	message= "Si è verificato un errore durante l'aggiornamento";
	
	
}

public void modify()
{
	EmployeeDTO emp = (EmployeeDTO) login.findLogIn();
	emp.setEmail(email);
	emp.setName(firstName);
	emp.setSurname(lastName);
	if(login.updateEmployee(emp))
	{
		message= "Dati correttamente aggiornati";
		return;
	}
	message= "Si è verificato un errore durante l'aggiornamento";
	
	
}

public ProductCRUDBeanLocal getProcrud() {
	return procrud;
}


public void setProcrud(ProductCRUDBeanLocal procrud) {
	this.procrud = procrud;
}


public EmployeeDTO getGeneric() {
	return generic;
}


public void setGeneric(EmployeeDTO generic) {
	this.generic = generic;
}


public String getFirstName() {
	
	return login.findLogIn().getName();
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return login.findLogIn().getSurname();
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public String getEmail() {
	return login.findLogIn().getEmail();
}


public void setEmail(String email) {
	this.email = email;
}


public boolean isLoggato() {
	return loggato;
}


public void setLoggato(boolean loggato) {
	this.loggato = loggato;
}


public ArrayList<ProductDTO> getManagedproduct() {
	return managedproduct;
}


public void setManagedproduct(ArrayList<ProductDTO> managedproduct) {
	this.managedproduct = managedproduct;
}


public ArrayList<PrepackedTravelPackageDTO> getManagedTravelPackage() {
	return managedTravelPackage;
}


public void setManagedTravelPackage(
		ArrayList<PrepackedTravelPackageDTO> managedTravelPackage) {
	this.managedTravelPackage = managedTravelPackage;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}


public String getMessage() {
	return message;
}


public void setMessage(String message) {
	this.message = message;
}


public TravelPackageCRUDBeanLocal getPackcrud() {
	return packcrud;
}


public void setPackcrud(TravelPackageCRUDBeanLocal packcrud) {
	this.packcrud = packcrud;
}


public ArrayList<PrepackedTravelPackageDTO> getAllPackages() {
	return allPackages;
}


public void setAllPackages(ArrayList<PrepackedTravelPackageDTO> allPackages) {
	this.allPackages = allPackages;
}


	







}
