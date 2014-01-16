package webbeans;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import userManagement.GenericUserManagementBeanLocal;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="EmployeePersonal")
public class EmployeePersonalBean {
	private String	firstName;

	private String lastName;
	private String email;
	//private int phoneNumber;
	private Date birthdate;

//	@EJB
//	private GenericUserManagementBeanLocal generic;
	
	
	public String modify()
	{
		boolean success;
		
		//EmployeeDTO employee= new EmployeeDTO(email,firstName,lastName,"telephone", password,username,new ArrayList<String>(),new ArrayList<Long>(),new ArrayList<Long>(),new ArrayList <GiftListDTO>(),new ArrayList<Long>());
		
		//TODO: modifyCustomer
		//success = generic.modifyEmployee(employee);
		
		/*
		if(success)
		{
		result ="modifica avvenuta";
		}
		else
		result ="modifica avvanuta";
		return result;
		
		*/
		return "";
		
		
		
	}
	
}
