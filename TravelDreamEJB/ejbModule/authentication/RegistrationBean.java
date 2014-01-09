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
 * Session Bean implementation class RegistrationBean
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
    
    
    public boolean employeeRegister(EmployeeDTO employee)
    {
    	Employee emplo=dtoToEmployee(employee);
    try{
    	emploejb.create(employee);
       }	
    	
    	catch(Exception e)
    	{
    		
    		return false;
    	}
    return true;
    }
    
    
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
    private Employee dtoToEmployee(EmployeeDTO employee)
    {   
    	List<Group> groups=new ArrayList <Group>();
        groups.add(Group.EMPLOYEE);
        List <Product> prod=new ArrayList <Product> ();
        List <PrepackedTravelPackage> prep=new ArrayList <PrepackedTravelPackage> ();
		Employee real=new Employee(employee.getEmail(),employee.getName(),employee.getSurname(),employee.getTelephone(), DigestUtils.sha256Hex(employee.getPassword()),employee.getUsername(),groups,prod, prep);
		  	
    	return real;
    	
    	
    }
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
    public boolean customerUnregister(String username)
    {   
    	try{
    	emploejb.find(username);
    	}
    	catch(Exception e){
    	return false;
    	}
    	return true;
    }
    
    
    
    
}
