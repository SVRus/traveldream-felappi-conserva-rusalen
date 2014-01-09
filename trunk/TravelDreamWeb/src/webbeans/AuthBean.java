package webbeans;



import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dto.CustomerDTO;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="auth")



public class AuthBean {
	private String	firstName;

	private String lastName;
	private String email;
	//private int phoneNumber;
	private String password;
	private Date birthdate;
	private String acceptedTerms;
	private String username;
	private String passwordIn;
	private String result;
	
	@EJB
	private RegistrationBeanLocal registration;
	// private LoginBean login


	public String signIn()
	{
		boolean success;
		//success= login.login(firstName, lastName, email, password, birthdate);
		
		//if(success)
		result = /* utente preso dal db + */ " registrato ";
		//else
		//result = "login fallito
			
		return "";
		
	}
	
	
	public String signUp()
	{
		boolean success;
		CustomerDTO customer= new CustomerDTO(email,firstName,lastName,"telephone", password,username);
		success = registration.customerRegister(customer);
		if(success)
		{
		result ="registrato";
		}
		else
		result ="registrazione fallita";
		return result;
		
		
		
	}
	
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}
	public String getFirstName() {
	return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}*/
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getAcceptedTerms() {
		return acceptedTerms;
	}
	public void setAcceptedTerms(String acceptedTerms) {
		this.acceptedTerms = acceptedTerms;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswordIn() {
		return passwordIn;
	}
	public void setPasswordIn(String passwordIn) {
		this.passwordIn = passwordIn;
	}
	



}
