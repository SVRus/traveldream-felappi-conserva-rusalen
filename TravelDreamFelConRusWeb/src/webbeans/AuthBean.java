package webbeans;



import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;
import dto.CustomerDTO;
import dto.CustomizedTravelPackageDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
import dto.TravelPackageDTO;

@ManagedBean(name="auth")
@SessionScoped

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
	private String description;
	private Long code;
	private boolean checked;
	
	
		public boolean isChecked() {
		return checked;
	}


	public void setChecked(boolean checked) {
		this.checked = checked;
	}


		
		public Long getCode() {
		return code;
	}


	public void setCode(Long code) {
		this.code = code;
	}



		@EJB
	private RegistrationBeanLocal generic;
	@EJB
		private LoginBeanLocal login;


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
	
	
	public String getDescription() {
		if (login.isLogged())
		return login.findLogIn().toString();
		else
			return "non loggato";
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String signUp()
	{
		boolean success;
		if (!checked)
		{
		CustomerDTO customer= new CustomerDTO(email,firstName,lastName,"telephone", password,username,new ArrayList<TravelPackageDTO>(),new ArrayList <GiftListDTO>(),new ArrayList<CustomizedTravelPackageDTO>());
		///da modificare
		success = generic.customerRegister(customer);
			
		if(success)
		{
		result ="cliente registrato";
		}
		else
		result ="registrazione fallita";
		return result;
		}
		else
		{
			EmployeeDTO employee= new EmployeeDTO(email,firstName,lastName,"telephone", password,username,code,new ArrayList<ProductDTO>(),new ArrayList<PrepackedTravelPackageDTO> ());
			
			success = generic.employeeRegister(employee);
				
			if(success)
			{
			result ="impiegato registrato";
			}
			else
			result ="registrazione fallita";
			return result;
		}
		
		
		
		
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
