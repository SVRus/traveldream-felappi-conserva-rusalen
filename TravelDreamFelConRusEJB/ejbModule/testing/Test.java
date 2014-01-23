package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;

import authentication.RegistrationBeanLocal;
import dto.FlightDTO;
import dto.HotelDTO;
import dto.OutingDTO;
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
	static FlightDTO flightdto1;
	static Outing outingInsert;
	static Flight flightInsert;
	static EmployeeEntityManagementLocal emploMan=null;
	static Employee emplo=null;
	static Employee impiegato=null; 
	static Flight flightInsert1=null;
	static Calendar timeNow=null;
	static Calendar timeAfter=null;
	static Calendar dateEnd=null;
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
	    timeNow=new GregorianCalendar();
	   emplo=new Employee("cello@email.com","cello","cognome","1234567890","questoèuntest","miousername1234",groups,new ArrayList<Product>(),new ArrayList <PrepackedTravelPackage>(),new Code(new Long (123456789)));
       emploMan.create(emplo);	    
       Calendar dateStart=new GregorianCalendar();
        dateEnd=new GregorianCalendar();
	  hoteldto=new HotelDTO(0, "pippo", "io", 11,dateStart ,dateEnd, State.AVAILABLE,  "area1",  "place1",  "singola","info");
	   hotelInsert=(Hotel)dto.productDTOToEntity(hoteldto) ;
	   impiegato=emploMan.find(emplo.getUsername());
	   List <Product> products=impiegato.getManagedProduct();
   	   products.add(hotelInsert);
      
		outingdto=new OutingDTO(0,"pippo","io",11,new GregorianCalendar() ,new GregorianCalendar(),"descr","area1",State.SOLD,"place");
		outingInsert=(Outing) dto.productDTOToEntity(outingdto);
	
		flightdto=new FlightDTO(0,"pippo","io",11,new GregorianCalendar() ,new GregorianCalendar(),State.RESERVED,"area1","alitalia","areastart1","placestart","placeend","info");
	    flightdto1= new FlightDTO(0,"pippo","io",11,new GregorianCalendar() ,new GregorianCalendar(),State.AVAILABLE,"area2","alitalia","areastart2","placestart","placeend","info");
		flightInsert=(Flight)dto.productDTOToEntity(flightdto);
		flightInsert1=(Flight)dto.productDTOToEntity(flightdto1);
		products.add(outingInsert);
		products.add(flightInsert);
		products.add(flightInsert1);
    	impiegato.setManagedProduct(products);
	    emploMan.edit(impiegato);
	}
	public static void afterClass()
	{
		
	
	}
	
	@Before
	public  void before()
	
	{

		
	}
	
	
	
	
	@org.junit.Test
	public void testProductInsert()
	{
		List <Hotel> hotelListAvailable=hot.findAll();
		Hotel hote=hotelListAvailable.get(0);
		
		List <Outing> outingListNull=out.findAllByParameter(State.AVAILABLE);

		List <Flight> flightListReserved=fli.findAllByParameter(State.RESERVED);
		Flight flight=flightListReserved.get(0);
		
		assertTrue(hote!=null && hote.equals(hotelInsert)&&flight.equals(flightInsert)&&flightListReserved.size()==1&&outingListNull.size()==0);

	
	}
	@org.junit.Test
	public void testPrepackedPackageInsert() {
	    List <Product> lista1=hot.findAllByParameter(State.AVAILABLE);
		List <Product> lista2=fli.findAllByParameter(State.AVAILABLE);
		
        Stage stage1=new Stage("area1",lista1);
        Stage stage2=new Stage ("area2",lista2);
        List <Stage> stages=new ArrayList <Stage> ();
        stages.add(stage1);
        stages.add(stage2);
        impiegato=emploMan.find(impiegato.getUsername());
	    PrepackedTravelPackage travel=new PrepackedTravelPackage(new GregorianCalendar(),new GregorianCalendar(),"","",stages,"0",new GregorianCalendar());
	     List <PrepackedTravelPackage> managedPackages=impiegato.getManagedTravelPackage();
	     managedPackages.add(travel);
	    impiegato.setManagedTravelPackage(managedPackages);
	    emploMan.edit(impiegato);
	    PrepackedTravelPackage travel2=(( Employee)emploMan.find(impiegato.getUsername())).getManagedTravelPackage().get(0);
	    List <Stage> stages1=travel2.getStages();
  
       Stage stage1Test2= stages1.get(0);
       Hotel hotelTest2=(Hotel)stage1Test2.getProducts().get(0);
       Stage stage2Test2=stages1.get(1);
	   Flight flightTest2 =(Flight)stage2Test2.getProducts().get(0);
	   assertTrue(hotelTest2.equals(hotelInsert)&&flightTest2.equals(flightInsert1));
	}
	
	@org.junit.Test
	public void testFindAreaTime() throws Exception {
		
	Thread.sleep(1000);
	timeAfter=new GregorianCalendar();
	System.out.print(timeAfter.after(dateEnd));
	List <Hotel> hotelsFound=hot.findAllByStateAndArea(State.AVAILABLE, timeNow, timeAfter, hotelInsert.getArea());
	Hotel foundHotel=hotelsFound.get(0);
	List <Outing> outingsFound=out.findALLByStateAndArea(outingInsert.getState(), timeNow, timeAfter, outingInsert.getArea());
	Outing foundOuting=outingsFound.get(0);
	List <Flight> flightsFound=fli.findALLByStateAndAreaStart(flightInsert.getState(), timeNow, timeAfter,flightInsert.getArea_start());
	Flight foundFlight=flightsFound.get(0);
	List <Flight> flightsFound1=fli.findALLByStateAndAreaEnd(flightInsert1.getState(), timeNow, timeAfter, flightInsert1.getArea());
	Flight foundFlight1=flightsFound1.get(0);
	assertTrue(foundHotel.equals(hotelInsert)&& foundOuting.equals(outingInsert)&&foundFlight.equals(flightInsert)&&foundFlight1.equals(flightInsert1));
	
	
	}
	
	
	
	

}
