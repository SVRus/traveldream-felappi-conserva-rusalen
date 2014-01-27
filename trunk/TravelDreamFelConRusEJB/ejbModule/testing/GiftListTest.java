package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import productManagement.ProductCRUDBeanLocal;
import purchase.PurchaseGiftListBeanLocal;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;
import stateenum.State;
import travelPackageManagement.TravelPackageCRUDBeanLocal;
import travelstateenum.TravelState;
import dto.FlightDTO;
import dto.GiftListDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.TravelPackageDTO;
import dto_entitiesconversion.DTOFactory;
import entities.Code;
import entities.Customer;
import entities.CustomizedTravelPackage;
import entities.Employee;
import entities.Flight;
import entities.GiftList;
import entities.Hotel;
import entities.Outing;
import entities.PrepackedTravelPackage;
import entities.Product;
import entities.Stage;
import entities.TravelPackage;
import entitymanagement.CustomerEntityManagementLocal;
import entitymanagement.EmployeeEntityManagementLocal;
import entitymanagement.FlightEntityManagementLocal;
import entitymanagement.HotelEntityManagementLocal;
import entitymanagement.OutingEntityManagementLocal;
import entitymanagement.PrepackedTravelPackageEntityManagementLocal;
import exceptions.GiftListNotFoundException;
import groupenum.Group;

public class GiftListTest {
	static EJBContainer container=null;
	static PrepackedTravelPackageEntityManagementLocal pre=null;
	static HotelEntityManagementLocal hot=null;
	static OutingEntityManagementLocal out=null;
	static FlightEntityManagementLocal fli=null;
	static ProductCRUDBeanLocal prod=null;
	static RegistrationBeanLocal reg=null;
	static TravelPackageCRUDBeanLocal travcrud=null;
	static PrepackedTravelPackageEntityManagementLocal travman=null;
	static LoginBeanLocal login=null;
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
	static CustomerEntityManagementLocal custoMan=null;
	static Employee emplo=null;
	static Employee impiegato=null; 
	static Flight flightInsert1=null;
	static Long timeNow=null;
	static Long timeAfter=null;
	static Long dateEnd=null;
	static Customer customer=null;
	static PurchaseGiftListBeanLocal giftMan=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		container=EJBContainer.createEJBContainer();
		travcrud=(TravelPackageCRUDBeanLocal) container.getContext().lookup("java:global/classes/TravelPackageCRUDBean!travelPackageManagement.TravelPackageCRUDBeanLocal");
        pre=(PrepackedTravelPackageEntityManagementLocal) container.getContext().lookup("java:global/classes/PrepackedTravelPackageEntityManagement!entitymanagement.PrepackedTravelPackageEntityManagementLocal");
		hot= (HotelEntityManagementLocal) container.getContext().lookup("java:global/classes/HotelEntityManagement!entitymanagement.HotelEntityManagementLocal");
	    out=(OutingEntityManagementLocal) container.getContext().lookup("java:global/classes/OutingEntityManagement!entitymanagement.OutingEntityManagementLocal");
	    fli=(FlightEntityManagementLocal) container.getContext().lookup("java:global/classes/FlightEntityManagement!entitymanagement.FlightEntityManagementLocal");
		prod=(ProductCRUDBeanLocal) container.getContext().lookup("java:global/classes/ProductCRUDBean!productManagement.ProductCRUDBeanLocal");
	    dto=(DTOFactory)container.getContext().lookup("java:global/classes/DTOFactory!dto_entitiesconversion.DTOFactory");
	    reg=(RegistrationBeanLocal) container.getContext().lookup("java:global/classes/RegistrationBean!authentication.RegistrationBean");
	    emploMan=(EmployeeEntityManagementLocal)container.getContext().lookup("java:global/classes/EmployeeEntityManagement!entitymanagement.EmployeeEntityManagementLocal");
        custoMan=(CustomerEntityManagementLocal) container.getContext().lookup("java:global/classes/CustomerEntityManagement!entitymanagement.CustomerEntityManagementLocal");
	    giftMan=(PurchaseGiftListBeanLocal) container.getContext().lookup("java:global/classes/PurchaseGiftListBean!purchase.PurchaseGiftListBeanLocal");
		login=(LoginBeanLocal) container.getContext().lookup("java:global/classes/LoginBean!authentication.LoginBeanLocal");
	    
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
	   	   products.add((Hotel)dto.productDTOToEntity(hoteldto));

			outingdto=new OutingDTO(0,"pippo","io",11,new Date() ,new Date(),"descr","area2",State.AVAILABLE,"place");
			outingInsert=(Outing) dto.productDTOToEntity(outingdto);
		
			flightdto=new FlightDTO(0,"pippo","io",11,new Date() ,new Date(),State.RESERVED,"area1","alitalia","areastart1","placestart","placeend","info");
		    flightdto1= new FlightDTO(0,"pippo","io",11,new Date() ,new Date(),State.AVAILABLE,"area2","alitalia","areastart2","placestart","placeend","info");
		    flightInsert=(Flight)dto.productDTOToEntity(flightdto);
			flightInsert1=(Flight)dto.productDTOToEntity(flightdto1);
			products.add(outingInsert);
			products.add((Outing) dto.productDTOToEntity(outingdto));

			products.add(flightInsert);
			products.add(flightInsert1);
	    	impiegato.setManagedProduct(products);
		    emploMan.edit(impiegato);
		    impiegato=emploMan.find(impiegato.getUsername());
		    List <Stage> stages=new ArrayList <Stage> ();
		    List <Hotel> hotelAvailable=hot.findAllByParameter(State.AVAILABLE);
		    Hotel hotelParziale =hotelAvailable.get(0);
		    hotelParziale.setState(State.INCLUDED);
		    List <Product> products1=new ArrayList <Product>();
		    products1.add(hotelParziale);
		   Stage stage1=new Stage("area1",products1,(new Date()).getTime(),(new Date()).getTime());
		   stages.add(stage1);
		   
		   List <Outing> outingAvailable=out.findAllByParameter(State.AVAILABLE);
		   Outing outingParziale=outingAvailable.get(0);
		   outingParziale.setState(State.INCLUDED);
		   List <Product> products2=new ArrayList  <Product> ();
		   products2.add(outingParziale);
		   
	       List <Flight> flightAvailable=fli.findAllByParameter(State.AVAILABLE);
	       Flight flightParziale=flightAvailable.get(0);
	       flightParziale.setState(State.INCLUDED);
	       products2.add(flightParziale);
		   Stage stage2= new Stage("area2",products2,(new Date()).getTime(),(new Date()).getTime());
		   stages.add(stage2);
		   PrepackedTravelPackage prepacked=new PrepackedTravelPackage((new Date()).getTime(),(new Date()).getTime(),"","",stages,"0",(new Date()).getTime(),TravelState.AVAILABLE);
		   List <PrepackedTravelPackage> prelist= impiegato.getManagedTravelPackage();
		   prelist.add(prepacked);
		   impiegato.setManagedTravelPackage(prelist);
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
	public void testGiftListCreationPrepackedTravelPackage() 
	{
		TravelPackageDTO travelDTO= dto.simpleTravelPackageToDTO((PrepackedTravelPackage)pre.findAll().get(0));
		ArrayList <GiftListDTO> giftListsDTO=giftMan.giftListCreation(travelDTO);
		ArrayList <Group> groups=new ArrayList <Group>();
	    groups.add(Group.CUSTOMER);
        List <GiftList> giftLists=new ArrayList <GiftList> ();
        giftLists.addAll(dto.giftListDTOToEntity(giftListsDTO));
        ArrayList <TravelPackage> travels=new ArrayList <TravelPackage> ();
        travels.add(dto.travelPackageDTOToEntity(travelDTO, false));
		Customer customer=new Customer("io@email.it","marcello","felappi","036486876","iosonocello","cello",groups,new ArrayList <CustomizedTravelPackage>(),travels,giftLists);
		custoMan.edit(customer);
		ArrayList<GiftListDTO> giftListDTOFound=new ArrayList <GiftListDTO> ();
		boolean ok;
		try {
			giftListDTOFound=login.checkGiftListException(DigestUtils.sha256Hex(new Long(travelDTO.getIdtravelpackage()).toString()));
		ok=true;
		} catch (GiftListNotFoundException e) {
			ok=false;
		}
		Iterator <GiftListDTO> iter=giftListDTOFound.iterator();
		while(iter.hasNext())
		{
			GiftListDTO giftDTO=iter.next();
			System.out.println(giftDTO.getProduct().toString());
			
		}
		assertTrue(ok);
	}

}
