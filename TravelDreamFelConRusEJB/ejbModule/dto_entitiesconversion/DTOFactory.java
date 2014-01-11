package dto_entitiesconversion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dto.CustomerDTO;
import dto.EmployeeDTO;
import entities.Customer;
import entities.Employee;
import entities.TravelPackage;

public class DTOFactory {

	
	private static ArrayList <String> customerListToString(List<Customer> friends)
	{  
		ArrayList <String> cusString=new ArrayList<String> (); 
		Iterator<Customer> iter =friends.iterator();
		while(iter.hasNext())
		{
			cusString.add(iter.next().getUsername());
		}
		
		
		return cusString;
		
	}
	private static ArrayList <Long> travelPackageToLong(List <TravelPackage> travellist)
	{
		ArrayList <Long> travelid=new ArrayList <Long>();
		Iterator <TravelPackage> iter = travellist.iterator();
		while(iter.hasNext())
		{
			travelid.add(iter.next().getIdtravelpackage());
		}
		return travelid;
	}
	
	public static CustomerDTO toTDO(Customer customer)
	{   ArrayList <String> friends=customerListToString(customer.getFriends());
	    ArrayList <Long>  
		CustomerDTO cust=new CustomerDTO(customer.getEmail(),customer.getName(), customer.getSurname(),customer.getTelephone(), customer.getPassword(),customer.getUsername());

		return cust;
		
		
	}
	
	public static EmployeeDTO toTDO(Employee employee)
	{
		EmployeeDTO emplo=new EmployeeDTO(employee.getEmail(),employee.getName(),employee.getSurname(),employee.getTelephone(),employee.getPassword(),employee.getUsername());
		return emplo;
		
		
	}
}
