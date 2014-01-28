package startup;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;






























import purchase.PurchaseGiftListBeanLocal;
import dto.CustomizedTravelPackageDTO;
import dto.GiftListDTO;
import dto.PrepackedTravelPackageDTO;
import dto_entitiesconversion.DTOFactory;
import stateenum.State;
import travelPackageManagement.TravelPackageCRUDBeanLocal;
import travelstateenum.TravelState;
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
import entitymanagement.CodeEntityManagementLocal;
import entitymanagement.CustomerEntityManagementLocal;
import entitymanagement.EmployeeEntityManagementLocal;
import entitymanagement.GiftListEntityManagementLocal;
import entitymanagement.PrepackedTravelPackageEntityManagementLocal;
import groupenum.Group;


/**
 * Session Bean implementation class DBFeed
 */
@Startup
@Singleton
public class DBFeed implements DBFeedLocal {

@EJB
CodeEntityManagementLocal codeejb;
@EJB
EmployeeEntityManagementLocal emploejb;
@EJB
CustomerEntityManagementLocal custoejb;
@EJB
TravelPackageCRUDBeanLocal travcrud;
@EJB
PrepackedTravelPackageEntityManagementLocal preejb;
@EJB
DTOFactory factory;
@EJB
PurchaseGiftListBeanLocal gift;
@EJB
GiftListEntityManagementLocal giftMan;
    /**
     * Default constructor. 
     */
    public DBFeed() {
        // TODO Auto-generated constructor stub
    }
    
 
     @PostConstruct
    public void feed() 
    {     
    	 Code code=new Code(123456789);
    	 codeejb.create(code);
    	 code=new Code(12);
    	 codeejb.create(code);
    	 code=new Code(34);
    	 codeejb.create(code);
    	 code=new Code(56);
    	 codeejb.create(code);
    	 code=new Code(78);
    	 codeejb.create(code);
    	 code=new Code(90);
    	 codeejb.create(code);
    	 List <Group> groups=new ArrayList <Group>();
 	     groups.add(Group.EMPLOYEE);
    	 Employee employee=new Employee("cello@email.com","cello","cognome","1234567890","04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb","user",groups,new ArrayList<Product>(),new ArrayList <PrepackedTravelPackage>(),new Code(new Long (123456789)));
 		 //password user
    	 emploejb.create(employee);
    	 ArrayList <Group> groupsCustomer=new ArrayList <Group>();
	     groups.add(Group.CUSTOMER);
		 Customer customer=new Customer("io@email.it","marcello","felappi","036486876","e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855","cello",groupsCustomer,new ArrayList <CustomizedTravelPackage>(),new ArrayList<TravelPackage>(),new ArrayList <GiftList>());
    	//password iosonocello
		 custoejb.create(customer);
    	 String strDateHotel1Start="2014-03-21 2:00PM";
    	 String strDateHotel1End="2014-03-29 18:00PM";
    	   DateFormat formatter ; 
    	   Date dateHotel1Start =null;
    	   Date dateHotel1End=null ;

    	   formatter = new SimpleDateFormat("yyyy-MM-dd hh:mma");
    	   Date dateHotel2Start=null;
		Date dateHotel2End=null;
		Date dateFlight1Start=null;
		Date dateFlight1End=null;
		Date dateFlight2Start=null;
		Date dateFlight2End=null;
		Date dateFlight3Start=null;
		Date dateFlight3End=null;
		Date dateFlight4Start=null;
		Date dateFlight4End=null;
		Date dateHotel3Start=null;
		Date dateHotel3End=null;
		Date dateFlight5Start=null;
		Date dateFlight5End=null;
		Date dateFlight6Start=null;
		Date dateFlight6End=null;
		Date dateHotel4Start=null;
		Date dateHotel4End=null;
		Date dateFlight7Start=null;
		Date dateFlight7End=null;
		Date dateOuting1Start=null;
		Date dateOuting2Start=null;
		Date dateOuting3Start=null;
		Date dateOuting4Start=null;
		Date dateOuting5Start=null;
		Date dateOuting6Start=null;
		Date dateOuting7Start=null;
		Date dateOuting8Start=null;
		Date dateOuting1End=null;
		Date dateOuting2End=null;
		Date dateOuting3End=null;
		Date dateOuting4End=null;
		Date dateOuting5End=null;
		Date dateOuting6End=null;
		Date dateOuting7End=null;
		Date dateOuting8End=null;

		try {
			dateHotel1Start = (Date)formatter.parse(strDateHotel1Start);  
			   dateHotel1End=(Date)formatter.parse(strDateHotel1End);
			   
			   
			   
			  
			    dateOuting1Start=(Date)formatter.parse("2014-03-21 04:00PM");  
			    dateOuting1End=(Date)formatter.parse("2014-03-21 6:00PM"); 
			    dateOuting2Start=(Date)formatter.parse("2014-03-23 10:00AM");  
				
				 dateOuting2End=(Date)formatter.parse("2014-03-23 03:00PM"); 
				 
				
							 
				 dateOuting3Start=(Date)formatter.parse("2014-04-01 10:00AM"); 
				 dateOuting3End=(Date)formatter.parse("2014-04-01 04:00PM"); 

				dateHotel2Start = (Date)formatter.parse("2014-03-30 10:00AM");  
				   dateHotel2End = (Date)formatter.parse("2014-04-10 8:00AM");
			   dateFlight1Start = (Date)formatter.parse("2014-03-20 2:00PM");
			   dateFlight1End = (Date)formatter.parse("2014-03-20 7:00PM");
			   dateFlight2Start = (Date)formatter.parse("2014-03-30 7:00AM");
			   dateFlight2End = (Date)formatter.parse("2014-03-30 9:00AM");
			   dateFlight3Start = (Date)formatter.parse("2014-04-10 7:00AM");
			   dateFlight3End = (Date)formatter.parse("2014-04-10 9:00AM");
			  
			   
			   
			   dateFlight4Start = (Date)formatter.parse("2014-03-30 7:00AM");
			   dateFlight4End = (Date)formatter.parse("2014-03-30 9:00AM");
			   dateOuting4Start=(Date)formatter.parse("2014-04-04 10:00AM"); 
			    dateOuting4End=(Date)formatter.parse("2014-04-04 02:00PM"); 
			   dateHotel3Start = (Date)formatter.parse("2014-03-30 10:00AM");  
			   dateHotel3End = (Date)formatter.parse("2014-04-30 8:00AM");
			   dateFlight5Start = (Date)formatter.parse("2014-04-30 7:00AM");
			   dateFlight5End = (Date)formatter.parse("2014-04-30 9:00AM");
			   
			   
			   dateFlight6Start = (Date)formatter.parse("2012-03-30 7:00AM");
			   dateFlight6End = (Date)formatter.parse("2012-03-30 9:00AM");
			  
				dateOuting5Start=(Date)formatter.parse("2012-03-31 10:00AM"); 
				dateOuting5End=(Date)formatter.parse("2012-03-31 12:00AM"); 

			   dateHotel4Start = (Date)formatter.parse("2012-03-30 10:00AM");  
			   dateHotel4End = (Date)formatter.parse("2012-04-30 8:00AM");
			 
			   
			   dateFlight7Start = (Date)formatter.parse("2012-04-30 7:00AM");
			   dateFlight7End = (Date)formatter.parse("2012-04-30 9:00AM");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
    	
    	
    	/*   public Hotel(float cost, Long timeStart, Long timeEnd, String name,
    				State state, String area, String place, String room_type,
    				String more_info)*/
    	   Flight flight1=new Flight(120,dateFlight2Start.getTime(),dateFlight2End.getTime(),"volo1","italia","alitalia","francia","Parigi","Roma","eventuali e varie",State.INCLUDED);
    	    //francia-italia
    	    Flight flight2=new Flight(125,dateFlight1Start.getTime(),dateFlight1End.getTime(),"volo2","Francia","air","usa","new york","Parigi","eventuali e varie",State.INCLUDED);
    	    //usa-francia
    	    Flight flight3=new Flight(126,dateFlight3Start.getTime(),dateFlight3End.getTime(),"volo3","germania","air","italia","Roma","Francoforte","eventuali e varie",State.INCLUDED);
    	    //italia-germania 
    	    
    	Hotel hotel1=new Hotel(60,dateHotel1Start.getTime(),dateHotel1End.getTime(),"excelsior",State.INCLUDED,"Francia","Parigi","doppia","eventuali e varie");
       	Hotel hotel2=new Hotel(70,dateHotel2Start.getTime(),dateHotel2End.getTime(),"italia",State.INCLUDED,"Italia","Roma","singola","eventuali e varie");
        
       	
       	
       	Flight flight4=new Flight(127,dateFlight4Start.getTime(),dateFlight4End.getTime(),"volo1","Inghilterra","airFrance","francia","Parigi","Londra","eventuali e varie",State.RESERVED);
        Flight flight5=new Flight(128,dateFlight5Start.getTime(),dateFlight5End.getTime(),"volo1","francia","airFrance","Inghilterra","Londra","Parigi","eventuali e varie",State.RESERVED);
       	Hotel hotel3=new Hotel(80,dateHotel3Start.getTime(),dateHotel3End.getTime(),"hilton",State.RESERVED,"Germania","Francoforte","tripla","eventuali e varie");
    	
       	
       	Hotel hotel4=new Hotel(90,dateHotel4Start.getTime(),dateHotel4End.getTime(),"ibis",State.EXPIRED,"Inghilterra","Londra","singola","eventuali e varie");
    	
        Flight flight6=new Flight(129,dateFlight6Start.getTime(),dateFlight6End.getTime(),"volo1","Inghilterra","airFrance","francia","Parigi","Londra","eventuali e varie",State.INCLUDED);
        Flight flight7=new Flight(130,dateFlight7Start.getTime(),dateFlight7End.getTime(),"volo1","francia","airFrance","Inghilterra","Londra","Parigi","eventuali e varie",State.INCLUDED);
     
        Flight flight8=new Flight(120,dateFlight2Start.getTime(),dateFlight2End.getTime(),"volo1","italia","alitalia","francia","Parigi","Roma","eventuali e varie",State.AVAILABLE);
        Flight flight9=new Flight(125,dateFlight1Start.getTime(),dateFlight1End.getTime(),"volo2","Francia","air","usa","new york","Parigi","eventuali e varie",State.AVAILABLE);
        Flight flight10=new Flight(126,dateFlight3Start.getTime(),dateFlight3End.getTime(),"volo3","germania","air","italia","Roma","Francoforte","eventuali e varie",State.AVAILABLE);
       
    	Hotel hotel5=new Hotel(60,dateHotel1Start.getTime(),dateHotel1End.getTime(),"excelsior",State.AVAILABLE,"Francia","Parigi","doppia","eventuali e varie");
       	Hotel hotel6=new Hotel(70,dateHotel2Start.getTime(),dateHotel2End.getTime(),"italia",State.AVAILABLE,"Italia","Roma","singola","eventuali e varie");
       	Hotel hotel7=new Hotel(80,dateHotel3Start.getTime(),dateHotel3End.getTime(),"hilton",State.AVAILABLE,"Germania","Francoforte","tripla","eventuali e varie");

        Flight flight11=new Flight(127,dateFlight4Start.getTime(),dateFlight4End.getTime(),"volo1","Inghilterra","airFrance","francia","Parigi","Londra","eventuali e varie",State.AVAILABLE);
        Flight flight12=new Flight(128,dateFlight5Start.getTime(),dateFlight5End.getTime(),"volo1","francia","airFrance","Inghilterra","Londra","Parigi","eventuali e varie",State.AVAILABLE);

         
        Outing outing1=new Outing(50,dateOuting1Start.getTime(),dateOuting1Start.getTime(),"gita louvre","description","Francia",State.INCLUDED,"Louvre");
        Outing outing2=new Outing(50,dateOuting2Start.getTime(),dateOuting2Start.getTime(),"gita museo d'orsai","description","Francia",State.INCLUDED,"Museo");
        Outing outing3=new Outing(50,dateOuting3Start.getTime(),dateOuting3Start.getTime(),"gita musei vaticani","description","Italia",State.INCLUDED,"Musei vaticani");
        
        
        
        Outing outing4=new Outing(50,dateOuting4Start.getTime(),dateOuting4End.getTime(),"museo francoforte","description","area",State.RESERVED,"Francoforte");
        
        
        
        Outing outing5=new Outing(50,dateOuting5Start.getTime(),dateOuting5End.getTime(),"gita centro londra","description","Inghilterra",State.EXPIRED,"Londra");
        
      

     List <Product> products=Arrays.asList(hotel1,hotel2,hotel3,hotel4,hotel5,hotel6,hotel7,flight1,flight2,flight3,flight4,flight5,flight6,flight7,flight8,flight9,flight10,flight11,flight12,outing1,outing2,outing3 ,outing4,outing5);
     
     
    employee.addProducts(products);;
    
   
    List <Product> stage1apr=Arrays.asList(flight1,flight2,hotel1,outing1,outing2);
    List <Product> stage1bpr=Arrays.asList(flight3,hotel2,outing3);
   Stage stage1a=new Stage(hotel1.getArea(),stage1apr,dateFlight1Start.getTime(),dateFlight2End.getTime());
   Stage stage1b=new Stage(hotel2.getArea(),stage1bpr,dateHotel2Start.getTime(),dateFlight3End.getTime());
   List <Stage> stages1=Arrays.asList(stage1a,stage1b);
   PrepackedTravelPackage travelPre=new  PrepackedTravelPackage(stage1b.getTimeEnd(),stage1a.getTimeStart(),"description", "interrail",stages1,"",null,TravelState.AVAILABLE);
  List <PrepackedTravelPackage> travels=employee.getManagedTravelPackage();
  travels.add(travelPre);
   List <Product> stage2apr=Arrays.asList(flight4,hotel3,flight5,outing4);
   Stage stage2a=new Stage (hotel3.getArea(),stage2apr,dateFlight4Start.getTime(),dateFlight5End.getTime());
   List <Stage> stages2=Arrays.asList(stage2a);
   PrepackedTravelPackage travelPreReserved=new  PrepackedTravelPackage(stage2a.getTimeEnd(),stage2a.getTimeStart(),"description", "singlestage",stages2,"",null,TravelState.RESERVED);
travels.add(travelPreReserved);
   List <Product> stage3apr=Arrays.asList(flight6,hotel4,flight7,outing5);

   Stage stage3a=new Stage (hotel4.getArea(),stage3apr,dateFlight6Start.getTime(),dateFlight7End.getTime());
   List <Stage> stages3=Arrays.asList(stage3a);
   PrepackedTravelPackage travelPreExpired=new  PrepackedTravelPackage(stage3a.getTimeEnd(),stage3a.getTimeStart(),"description", "singlestage",stages3,"",null,TravelState.EXPIRED);
   travels.add(travelPreExpired);
    employee.addPackages(travels);;
   emploejb.edit(employee);
    
   
   
   List <TravelPackage> purchasedTravel=preejb.findAllByParameter(TravelState.AVAILABLE);

   
   CustomizedTravelPackageDTO customized=travcrud.cloneTravelPackage((PrepackedTravelPackageDTO) factory.simpleTravelPackageToDTO(purchasedTravel.get(0)));
   
   CustomizedTravelPackage customizedEntity=(CustomizedTravelPackage) factory.travelPackageDTOToEntity(customized, true);
   
  List <CustomizedTravelPackage> customizedList=Arrays.asList(customizedEntity);
  customer.addCustomized(customizedList);
  List <TravelPackage> purchasedList=new ArrayList<TravelPackage>();
  purchasedList.add(customizedEntity);
  customer.addPurchased(purchasedList);
   
  
   List <TravelPackage> giftListedTravel=preejb.findAllByParameter(TravelState.RESERVED);

   
   PrepackedTravelPackage prepacked=(PrepackedTravelPackage)giftListedTravel.get(0);
   PrepackedTravelPackageDTO preDTO=(PrepackedTravelPackageDTO)factory.simpleTravelPackageToDTO(prepacked);
   ArrayList <GiftListDTO> gifts= gift.giftListCreation(preDTO);
   List <GiftList> giftEntity=factory.giftListDTOToEntity(gifts);
   customer.addGifts(giftEntity);
   custoejb.edit(customer);
   GiftList single=(GiftList) giftMan.findAll().get(0);
   single.setBought(true);
   single.setIdBuyer("compratore");
   giftMan.edit(single);
    }
   
}
