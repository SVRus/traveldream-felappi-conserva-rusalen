package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;

import authentication.RegistrationBeanLocal;
import dto.EmployeeDTO;
import dto.FlightDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
import dto_entitiesconversion.DTOFactory;
import productManagement.ProductCRUDBeanLocal;
import stateenum.State;
import entities.Code;
import entities.Employee;
import entities.Flight;
import entities.Hotel;
import entities.Outing;
import entities.PrepackedTravelPackage;
import entities.Product;
import entities.Stage;
import entitymanagement.EmployeeEntityManagementLocal;
import entitymanagement.FlightEntityManagementLocal;
import entitymanagement.HotelEntityManagementLocal;
import entitymanagement.OutingEntityManagementLocal;
import entitymanagement.PrepackedTravelPackageEntityManagementLocal;
import groupenum.Group;

public class Test {
	static EJBContainer container=null;
	static PrepackedTravelPackageEntityManagementLocal pre=null;
	static HotelEntityManagementLocal hot=null;
	static OutingEntityManagementLocal out=null;
	static FlightEntityManagementLocal fli=null;
	static ProductCRUDBeanLocal prod=null;
	static RegistrationBeanLocal reg=null;
	static  DTOFactory dto=null;
	static HotelDTO hoteldto;
	static Hotel hotelInsert;
	static OutingDTO  outingdto;
	static FlightDTO flightdto;
	static Outing outingInsert;
	static Flight flightInsert;
	static EmployeeEntityManagementLocal emploMan=null;
	static Employee emplo=null;
	@BeforeClass
	public static void beforeClass() throws NamingException
	{
		container=EJBContainer.createEJBContainer();
        pre=(PrepackedTravelPackageEntityManagementLocal) container.getContext().lookup("java:global/classes/PrepackedTravelPackageEntityManagement!entitymanagement.PrepackedTravelPackageEntityManagementLocal");
		hot= (HotelEntityManagementLocal) container.getContext().lookup("java:global/classes/HotelEntityManagement!entitymanagement.HotelEntityManagementLocal");
	    out=(OutingEntityManagementLocal) container.getContext().lookup("java:global/classes/OutingEntityManagement!entitymanagement.OutingEntityManagementLocal");
	    fli=(FlightEntityManagementLocal) container.getContext().lookup("java:global/classes/FlightEntityManagement!entitymanagement.FlightEntityManagementLocal");
		prod=(ProductCRUDBeanLocal) container.getContext().lookup("java:global/classes/ProductCRUDBean!productManagement.ProductCRUDBeanLocal");
	    dto=(DTOFactory)container.getContext().lookup("java:global/classes/DTOFactory!dto_entitiesconversion.DTOFactory");
	    reg=(RegistrationBeanLocal) container.getContext().lookup("java:global/classes/RegistrationBean!authentication.RegistrationBean");
	    		emploMan=(EmployeeEntityManagementLocal)container.getContext().lookup("java:global/classes/EmployeeEntityManagement!entitymanagement.EmployeeEntityManagementLocal");
List <Group> groups=new ArrayList <Group>();
	    groups.add(Group.EMPLOYEE);
	    //emplo=new Employee("cello@email.com","cello","cognome","1234567890","questoèuntest","miousername",groups,new ArrayList<Product>(),new ArrayList <PrepackedTravelPackage>(),new Code(new Long (123456789)));
	  
	    EmployeeDTO emplodto=new EmployeeDTO("cello@email.com","cello","cognome","1234567890","questoèuntest","miousername12",new Long (123456789),new ArrayList<ProductDTO>(),new ArrayList <PrepackedTravelPackageDTO>());
	    reg.employeeRegister(emplodto);
	    hoteldto=new HotelDTO(0, "pippo", "io", 11,new GregorianCalendar() ,new GregorianCalendar(), State.AVAILABLE,  "area1",  "place1",  "singola","info");
	    
	    System.out.println(prod.createProductFromEmployee(hoteldto, emplodto.getUsername()));
		hotelInsert=(Hotel) dto.productDTOToEntity(hoteldto);
		outingdto=new OutingDTO(0,"pippo","io",11,new GregorianCalendar() ,new GregorianCalendar(),"descr","area1",State.SOLD);
		prod.createProductFromEmployee(outingdto, emplodto.getUsername());
		outingInsert=(Outing) dto.productDTOToEntity(outingdto);
		flightdto=new FlightDTO(0,"pippo","io",11,new GregorianCalendar() ,new GregorianCalendar(),State.RESERVED,"area1","alitalia","areastart","placestart","placeend","info");
	    prod.createProductFromEmployee(flightdto, emplodto.getUsername());
		flightInsert=(Flight)dto.productDTOToEntity(flightdto);
		
	}
	public static void afterClass()
	{
		
	
	}
	
	@Before
	public  void before()
	
	{
	 /*=new HotelDTO(0, "test", "test",0, 11,new Date() ,new Date(), "area1",  "test",  "test",  "test",State.AVAILABLE);
	 HotelDTO  hotel2= new HotelDTO(0, "test", "test",0, 11,new Date() ,new Date(), "are2",  "test",  "test",  "test",State.AVAILABLE);
	 HotelDTO  hotel3=new HotelDTO(0, "test", "test",0, 11,new Date() ,new Date(), "area2",  "test",  "test",  "test",State.AVAILABLE);
*/
	
	/* prod.createProduct(hotel1);
	 prod.createProduct(hotel2);
	 prod.createProduct(hotel3);*/
		
	}
	
	@org.junit.Test
	public void test() {
		
		Hotel hotel=hot.find(new Long(1));
		Outing outing=out.find(new Long(2));
		Flight flight=fli.find(new Long(3));
		assertTrue(hotelInsert.equals(hotel)&&flightInsert.equals(flight)&&outingInsert.equals(outing));
		
		
	/*	 
		 List <Product> lista1=new ArrayList <Product> ();
		List <Product> lista2=new ArrayList <Product> ();
		lista1.add((Hotel)hot.find(new Long(1)));
		lista1.add((Hotel)hot.find(new Long(2)));
		lista2.add((Hotel)hot.find(new Long(3)));
		lista2.add((Hotel)hot.find(new Long(4)));
          Stage stage1=new Stage("area1",lista1);
          Stage stage2=new Stage ("area2",lista2);
          List <Stage> stages=new ArrayList <Stage> ();
          stages.add(stage1);
          stages.add(stage2);
	    PrepackedTravelPackage travel=new PrepackedTravelPackage(new Date(),new Date(),"","",stages,"0",new Date());
	    pre.edit(travel);
	    PrepackedTravelPackage travel2=pre.find(new Long(1));
	    System.out.println(travel2.toString());
	   List <Stage> stages1=travel2.getStages();
	   ArrayList <Stage> stages2=new ArrayList <Stage> (stages1);
	    System.out.println(stages2.toString());
	    
        Iterator <Stage> iter=stages2.iterator();
        while(iter.hasNext())
        {
        	System.out.print(iter.next().getProducts().toString());
        	
        }*/

	    
	}
	
	
	@org.junit.Test
	public void test1()
	{
		List <Hotel> hotelListAvailable=hot.findAllByParameter(State.AVAILABLE);
		Hotel hote=hotelListAvailable.get(0);
		
		List <Outing> outingListNull=out.findAllByParameter(State.AVAILABLE);

		List <Flight> flightListReserved=fli.findAllByParameter(State.RESERVED);
		
		assertTrue(hote!=null && hote.equals(hotelInsert)&&flightListReserved.size()==1&&outingListNull.size()==0);

	
	}


}
