package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import stateenum.State;
import dto.HotelDTO;
import dto_entitiesconversion.DTOFactory;
import entities.Code;
import entities.Employee;
import entities.Outing;
import entities.PrepackedTravelPackage;
import entities.Product;
import entitymanagement.EmployeeEntityManagementLocal;
import entitymanagement.HotelEntityManagementLocal;
import groupenum.Group;

public class Test1 {
	static EJBContainer container=null;
	static HotelEntityManagementLocal hot=null;
	static HotelDTO hoteldto;
	static Employee impiegato=null; 
	static EmployeeEntityManagementLocal emploMan=null;
	static  DTOFactory dto=null;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		container=EJBContainer.createEJBContainer();
		hot= (HotelEntityManagementLocal) container.getContext().lookup("java:global/classes/HotelEntityManagement!entitymanagement.HotelEntityManagementLocal");
		emploMan=(EmployeeEntityManagementLocal)container.getContext().lookup("java:global/classes/EmployeeEntityManagement!entitymanagement.EmployeeEntityManagementLocal");
	    dto=(DTOFactory)container.getContext().lookup("java:global/classes/DTOFactory!dto_entitiesconversion.DTOFactory");

		  List <Group> groups=new ArrayList <Group>();
		    groups.add(Group.EMPLOYEE);
		
		impiegato=new Employee("cello@email.com","cello","cognome","1234567890","questoèuntest","miousername1234",groups,new ArrayList<Product>(),new ArrayList <PrepackedTravelPackage>(),new Code(new Long (123456789)));
	
		  hoteldto=new HotelDTO(0, "pippo", "io", 11,new Date() ,new Date(), State.AVAILABLE,  "area1",  "place1",  "singola","info");
		   List <Product> products=impiegato.getManagedProduct();
           products.add(dto.productDTOToEntity(hoteldto));
           impiegato.setManagedProduct(products);
           emploMan.edit(impiegato);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(hot.findAll().size());
		System.out.println(hot.findBooleanHotelEquivalent(hoteldto, 1));
		System.out.println(hot.findIntegerHotelEquivalent(hoteldto));
	}

}
