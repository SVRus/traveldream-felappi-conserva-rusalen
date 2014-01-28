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

import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;
import dto.CustomizedTravelPackageDTO;
import dto.FlightDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.PrepackedTravelPackageDTO;
import dto.StageDTO;
import dto_entitiesconversion.DTOFactory;
import productManagement.ProductCRUDBeanLocal;
import stateenum.State;
import travelPackageManagement.TravelPackageCRUDBeanLocal;
import travelstateenum.TravelState;
import entities.Code;
import entities.Employee;
import entities.Flight;
import entities.Hotel;
import entities.Outing;
import entities.PrepackedTravelPackage;
import entities.Product;
import entities.Stage;
import entitymanagement.CustomizedTravelPackageEntityManagementLocal;
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
	static TravelPackageCRUDBeanLocal travcrud=null;
	static PrepackedTravelPackageEntityManagementLocal travman=null;
	static  DTOFactory dto=null;
	static HotelDTO hoteldto;
	static Hotel hotelInsert;
	PrepackedTravelPackage travel;
	static OutingDTO  outingdto;
	static FlightDTO flightdto;
	static FlightDTO flightdto1;
	static Outing outingInsert;
	static Flight flightInsert;
	static EmployeeEntityManagementLocal emploMan=null;
	static Employee emplo=null;
	static Employee impiegato=null; 
	static Flight flightInsert1=null;
	static Long timeNow=null;
	static Long timeAfter=null;
	static Long dateEnd=null;
	static CustomizedTravelPackageEntityManagementLocal customizedMan=null;
	static LoginBeanLocal login;
	@BeforeClass
	public static void beforeClass() throws NamingException
	{
		container=EJBContainer.createEJBContainer();
		travcrud=(TravelPackageCRUDBeanLocal) container.getContext().lookup("java:global/classes/TravelPackageCRUDBean!travelPackageManagement.TravelPackageCRUDBeanLocal");
        pre=(PrepackedTravelPackageEntityManagementLocal) container.getContext().lookup("java:global/classes/PrepackedTravelPackageEntityManagement!entitymanagement.PrepackedTravelPackageEntityManagementLocal");
		hot= (HotelEntityManagementLocal) container.getContext().lookup("java:global/classes/HotelEntityManagement!entitymanagement.HotelEntityManagementLocal");
	    out=(OutingEntityManagementLocal) container.getContext().lookup("java:global/classes/OutingEntityManagement!entitymanagement.OutingEntityManagementLocal");
	    fli=(FlightEntityManagementLocal) container.getContext().lookup("java:global/classes/FlightEntityManagement!entitymanagement.FlightEntityManagementLocal");
		prod=(ProductCRUDBeanLocal) container.getContext().lookup("java:global/classes/ProductCRUDBean!productManagement.ProductCRUDBeanLocal");
	    dto=(DTOFactory)container.getContext().lookup("java:global/classes/DTOFactory!dto_entitiesconversion.DTOFactory");
	    reg=(RegistrationBeanLocal) container.getContext().lookup("java:global/classes/RegistrationBean!authentication.RegistrationBean");
	    login=(LoginBeanLocal) container.getContext().lookup("java:global/classes/LoginBean!authentication.LoginBeanLocal");
	    customizedMan=(CustomizedTravelPackageEntityManagementLocal) container.getContext().lookup(" java:global/classes/CustomizedTravelPackageEntityManagement!entitymanagement.CustomizedTravelPackageEntityManagementLocal");

	    emploMan=(EmployeeEntityManagementLocal)container.getContext().lookup("java:global/classes/EmployeeEntityManagement!entitymanagement.EmployeeEntityManagementLocal");
          List <Group> groups=new ArrayList <Group>();
	    groups.add(Group.EMPLOYEE);
	    timeNow=(new Date()).getTime();
	   emplo=new Employee("cello@email.com","cello","cognome","1234567890","questoèuntest","miousername1234",groups,new ArrayList<Product>(),new ArrayList <PrepackedTravelPackage>(),new Code(new Long (123456789)));
       emploMan.create(emplo);	    
       Long dateStart=(new Date()).getTime();
        dateEnd=(new Date()).getTime();
	  hoteldto=new HotelDTO(0, "pippo", "io", 11,new Date(dateStart) ,new Date(dateEnd), State.AVAILABLE,  "area1",  "place1",  "singola","info");
	   hotelInsert=(Hotel)dto.productDTOToEntity(hoteldto) ;
	   impiegato=emploMan.find(emplo.getUsername());
	   List <Product> products=impiegato.getManagedProduct();
   	   products.add(hotelInsert);
      
		outingdto=new OutingDTO(0,"pippo","io",11,new Date() ,new Date(),"descr","area1",State.SOLD,"place");
		outingInsert=(Outing) dto.productDTOToEntity(outingdto);
	
		flightdto=new FlightDTO(0,"pippo","io",11,new Date() ,new Date(),State.RESERVED,"area1","alitalia","areastart1","placestart","placeend","info");
	    flightdto1= new FlightDTO(0,"pippo","io",11,new Date() ,new Date(),State.AVAILABLE,"area2","alitalia","areastart2","placestart","placeend","info");
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
		
        Stage stage1=new Stage("area1",lista1,(new Date()).getTime(),(new Date()).getTime());
        Stage stage2=new Stage ("area2",lista2,(new Date()).getTime(),(new Date()).getTime());
        List <Stage> stages=new ArrayList <Stage> ();
        stages.add(stage1);
        stages.add(stage2);
        impiegato=emploMan.find(impiegato.getUsername());
       
	   travel=new PrepackedTravelPackage((new Date()).getTime(),(new Date()).getTime(),"","",stages,"0",(new Date()).getTime(),TravelState.AVAILABLE);
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
	   System.out.println("vengo prima io");
	}
	
	@org.junit.Test
	public void testFindAreaTime() throws Exception {
		
	Thread.sleep(1000);
	timeAfter=(new Date()).getTime();
	List <HotelDTO> hotelsFound=prod.findALLHotelByStateAndArea(State.AVAILABLE, new Date(timeNow), new Date(timeAfter), hotelInsert.getArea());
	HotelDTO foundHotelDTO=hotelsFound.get(0);
	Hotel foundHotel=(Hotel)dto.productDTOToEntityUpdate(foundHotelDTO);
	List <OutingDTO> outingsFound=prod.findALLOutingByStateAndArea(outingInsert.getState(), new Date(timeNow), new Date(timeAfter), outingInsert.getArea());
	OutingDTO foundOutingDTO=outingsFound.get(0);
	Outing foundOuting=(Outing)dto.productDTOToEntityUpdate(foundOutingDTO);
	List <FlightDTO> flightsFound=prod.findALLFlightByStateAndAreaStart(flightInsert.getState(), new Date(timeNow), new Date(timeAfter),flightInsert.getArea_start());
	FlightDTO foundFlightDTO=flightsFound.get(0);
	Flight foundFlight=(Flight)dto.productDTOToEntityUpdate(foundFlightDTO);
	List <FlightDTO> flightsFound1=prod.findALLByStateAndAreaEnd(flightInsert1.getState(), new Date(timeNow), new Date(timeAfter), flightInsert1.getArea());
	FlightDTO foundFlightDTO1=flightsFound1.get(0);
	Flight foundFlight1=(Flight)dto.productDTOToEntityUpdate(foundFlightDTO1);

	assertTrue(foundHotel.equals(hotelInsert)&& foundOuting.equals(outingInsert)&&foundFlight.equals(flightInsert)&&foundFlight1.equals(flightInsert1));
	
	
	}
	@org.junit.Test
	public void testTrans() throws Exception {
	assertTrue(hotelInsert.equals(dto.productDTOToEntity(hoteldto)));
	}
	@org.junit.Test
	public void testTrans1() throws Exception {
	assertTrue(outingInsert.equals(dto.productDTOToEntity(outingdto)));
	}
	@org.junit.Test
	public void testTrans2() throws Exception {
	assertTrue(flightInsert.equals(dto.productDTOToEntity(flightdto)));
	}

	@org.junit.Test
	public void testFindEqu() throws Exception {
        assertTrue(hot.findBooleanHotelEquivalent(hoteldto, 1)&&hot.findIntegerHotelEquivalent(hoteldto)==1&&!out.findBooleanOutingEquivalent(outingdto, 1)&&out.findIntegerOutingEquivalent(outingdto)==0&&fli.findIntegerFlightEquivalent(flightdto1)==1&&fli.findBooleanFlightEquivalent(flightdto1, 1));		
		
	
	}

	
	public void testFindCloned() throws Exception
	{
		CustomizedTravelPackageDTO cusdto=travcrud.cloneTravelPackage((travcrud.findAllPrepacked().get(0)));
		List <StageDTO> stages=cusdto.getStages();
		System.out.println(stages.toString());
		Iterator <StageDTO> iter=stages.iterator();
		while(iter.hasNext())
		{
			System.out.print(iter.next().getProducts().get(0).toString());
			
		}
	}

}
