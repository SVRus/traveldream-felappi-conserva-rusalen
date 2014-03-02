package webbeans;



import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionListener;

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
@ViewScoped

public class AuthBean {
	private String	firstName;

	private String lastName;
	private String email;
	//private int phoneNumber;
	private String password;
	private Date birthdate;
	private boolean acceptedTerms;
	private String username;
	private String passwordIn;
	private String result;
	private String description;
	private Long code;
	private boolean checked;
	private boolean userEmployee;
	private boolean userNone;
	private boolean userCustomer;
	
	
	
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
	
	/**
	 * Metodo che verifica se un utente è loggato e lo indirizza nella sua home personale
	 * @return
	 */
	@PostConstruct
	public void redirect()
	{
		acceptedTerms=false;
		
		if(login.isLogged())
		{
			
		if(login.findLogIn() instanceof EmployeeDTO)
		{
			userEmployee=true;
			userCustomer=false;
			userNone=false;
			
			return;
		}
			//return "/employee/employeehome?faces-redirect=true";  
			//return "redirectEmployee";
		if(login.findLogIn() instanceof CustomerDTO)
		{
			userEmployee=false;
			userCustomer=true;
			userNone=false;
			return;
		}
		}
		userEmployee=false;
		userCustomer=false;
		userNone=true;
			//return "redirectCustomer";
			return;
			
		//return "";
		
	}
	public String redirect(ActionListener a)
	{
		if(login.isLogged())
		{
			
		if(login.findLogIn() instanceof EmployeeDTO)
			return "redirectEmployee";
		if(login.findLogIn() instanceof CustomerDTO)
			return "redirectCustomer";
		
		}	
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
			checked=false;
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
	
	public boolean isAcceptedTerms() {
		return acceptedTerms;
	}


	public void setAcceptedTerms(boolean acceptedTerms) {
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


	public boolean isUserEmployee() {
		return userEmployee;
	}


	public void setUserEmployee(boolean userEmployee) {
		this.userEmployee = userEmployee;
	}


	public boolean isUserNone() {
		return userNone;
	}


	public void setUserNone(boolean userNone) {
		this.userNone = userNone;
	}


	public boolean isUserCustomer() {
		return userCustomer;
	}


	public void setUserCustomer(boolean userCustomer) {
		this.userCustomer = userCustomer;
	}


	public RegistrationBeanLocal getGeneric() {
		return generic;
	}


	public void setGeneric(RegistrationBeanLocal generic) {
		this.generic = generic;
	}


	public LoginBeanLocal getLogin() {
		return login;
	}


	public void setLogin(LoginBeanLocal login) {
		this.login = login;
	}
	



}
