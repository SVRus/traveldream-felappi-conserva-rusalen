package webbeans;


import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import dto.CustomerDTO;
import dto.CustomizedTravelPackageDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
import dto.TravelPackageDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="provaSession")
@SessionScoped

public class provaSessionBean {
	private Date birthdate;
	private String username;
	
	@PostConstruct
	public void settaValori()
	{
		username= "Zorro";
		birthdate = new Date();
		
	}
	
	public void signUp()
	{}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getUsername() {
		if(true)
		return username;
		else return "";
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	
}
