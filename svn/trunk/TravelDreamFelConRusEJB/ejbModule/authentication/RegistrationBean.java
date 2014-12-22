package authentication;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;







import org.apache.commons.codec.digest.DigestUtils;

import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto_entitiesconversion.DTOFactory;
import entities.Code;
import entities.Customer;
import entities.CustomizedTravelPackage;
import entities.Employee;
import entities.GiftList;
import entities.PrepackedTravelPackage;
import entities.Product;
import entities.TravelPackage;
import entitymanagement.CodeEntityManagementLocal;
import entitymanagement.CustomerEntityManagementLocal;
import entitymanagement.EmployeeEntityManagementLocal;
import groupenum.Group;

/**
 *  
 * Session Bean implementation class RegistrationBean
 * It exploits the beans {@link entitymanagement.EmployeeEntityManagemen} and {@link entitymanagement.CustomerEntityManagement}
 * @overview It is used to handle the registration phase
 */
@Stateless
@LocalBean
public class RegistrationBean implements RegistrationBeanLocal {
@EJB
private EmployeeEntityManagementLocal emploejb;
@EJB
private CustomerEntityManagementLocal custejb;
@EJB
private CodeEntityManagementLocal codeejb;
@EJB
private DTOFactory dto;
    /**
     * Default constructor. 
     */
    public RegistrationBean() {
        // TODO Auto-generated constructor stub
    }
   
    
   
    
    /**
     * @author Marcello
     * This method let the customer register by adding him to the group customer {@link entitymanagement.CustomerEntityManagement#create(Customer)}
     * @param customer --> entity describing the customer in the db
     * @return a boolean value describing the registration outcome
     */
    public boolean customerRegister(CustomerDTO customer)
    {
    	Customer cust=dto.dtoToCustomer(customer);
    	try {
    		custejb.create(cust);
    		
    	}
    	
    	catch(Exception e)
    	{   e.printStackTrace();;
    		return false;
    		
    	}
    	return true;
    	
    }
    public boolean employeeRegister (EmployeeDTO employee)
   
    {   
    	
    	if(employee.getCode()==0)
    		return false;
    	Code code=((Code)(codeejb.find(employee.getCode())));
       
        if (code==null )
    	return false;
        long codelong=code.getCode();
        
        
    	if (employee.getCode()==(codelong))
    	{
    	Employee emp=dto.dtoToEmployee(employee);
    	try {
    		emploejb.create(emp);
    		
    	}
    	
    	catch(Exception e)
    	{   e.printStackTrace();;
    		return false;
    		
    	}
    	}
    	return true;
    	
    	
    }
    
   
    /**
     * @author Marcello
     * @param username
     * @return
     */
    public boolean customerUnregister(String username)
    {   //TODO da finire
    	try
    	{
    	emploejb.find(username);
    	}
    	catch(Exception e){
    	return false;
    	}
    	return true;
    }
    
    
    
    
}
