package authentication;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;



import org.apache.commons.codec.digest.DigestUtils;

import dto.CustomerDTO;
import dto.EmployeeDTO;
import entities.Customer;
import entities.CustomizedTravelPackage;
import entities.Employee;
import entities.GiftList;
import entities.PrepackedTravelPackage;
import entities.Product;
import entities.TravelPackage;
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
EmployeeEntityManagementLocal emploejb;
@EJB
CustomerEntityManagementLocal custejb;
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
    	Customer cust=dtoToCustomer(customer);
    	try {
    		custejb.create(cust);
    		
    	}
    	
    	catch(Exception e)
    	{   e.printStackTrace();;
    		return false;
    		
    	}
    	return true;
    	
    }
    /**
     * @author Marcello
     * Private method that transform the EmployeeDTO in the entity employee
     * @param employee -->the employee DTO acquired from the web tier 
     * @return the entity Employee translated from the EmployeeDTO
     */
    private Employee dtoToEmployee(EmployeeDTO employee)
    //TODO da finire
    {   String username=employee.getUsername();
    	List<Group> groups=new ArrayList <Group>();
        groups.add(Group.EMPLOYEE);
        List <Product> prod=new ArrayList <Product> ();
        List <PrepackedTravelPackage> prep=new ArrayList <PrepackedTravelPackage> ();
		Employee real=new Employee(employee.getEmail(),employee.getName(),employee.getSurname(),employee.getTelephone(), DigestUtils.md5Hex(employee.getPassword()),,groups,prod, prep);
		  	
    	return real;
    	
    	
    }
    /**
     * @author Marcello
     * Private method that transform the CustomerDTO in the entity customer
     * @param customer -->the customer DTO acquired from the web tier
     * @return the entity Customer translated from the CustomerDTO
     */
    private Customer dtoToCustomer(CustomerDTO customer)
    {
    	List<Group> groups=new ArrayList <Group>();
        groups.add(Group.CUSTOMER);
        List<CustomizedTravelPackage> customizedTravelPackages=new ArrayList <CustomizedTravelPackage>();
        List<Customer> friends=new ArrayList <Customer>();
        List<TravelPackage> purchasedTravelPackages=new ArrayList<TravelPackage>();
        List<TravelPackage> preparedForAFriendTravelPackages=new ArrayList <TravelPackage>();
        List<GiftList> giftLists=new ArrayList <GiftList>();
        Customer real=new Customer(customer.getEmail(),customer.getName(),customer.getSurname(),customer.getTelephone(),DigestUtils.sha256Hex(customer.getPassword()),customer.getUsername(),groups,customizedTravelPackages,friends,purchasedTravelPackages,preparedForAFriendTravelPackages,giftLists); 
        
   	   return real;
    	
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
