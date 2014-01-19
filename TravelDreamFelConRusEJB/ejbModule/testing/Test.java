package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;

import dto.FlightDTO;
import dto.HotelDTO;
import dto.PrepackedTravelPackageDTO;
import dto_entitiesconversion.DTOFactory;
import productManagement.ProductCRUDBeanLocal;
import stateenum.State;
import entities.Hotel;
import entities.PrepackedTravelPackage;
import entities.Product;
import entities.Stage;
import entitymanagement.HotelEntityManagementLocal;
import entitymanagement.PrepackedTravelPackageEntityManagementLocal;

public class Test {
	static EJBContainer container=null;
	static PrepackedTravelPackageEntityManagementLocal pre=null;
	static HotelEntityManagementLocal hot=null;
	static ProductCRUDBeanLocal prod=null;
	static  DTOFactory dto=null;
	@BeforeClass
	public static void beforeClass() throws NamingException
	{
		container=EJBContainer.createEJBContainer();
        pre=(PrepackedTravelPackageEntityManagementLocal) container.getContext().lookup("java:global/classes/PrepackedTravelPackageEntityManagement!entitymanagement.PrepackedTravelPackageEntityManagementLocal");
		hot= (HotelEntityManagementLocal) container.getContext().lookup("java:global/classes/HotelEntityManagement!entitymanagement.HotelEntityManagementLocal");
	    prod=(ProductCRUDBeanLocal) container.getContext().lookup("java:global/classes/ProductCRUDBean!productManagement.ProductCRUDBeanLocal");
	    dto=(DTOFactory)container.getContext().lookup("java:global/classes/DTOFactory!dto_entitiesconversion.DTOFactory");

	}
	
	@Before
	public  void before()
	{HotelDTO hotel=new HotelDTO(0, "test", "test",0, 11,new Date() ,new Date(), "area1",  "test",  "test",  "test",State.AVAILABLE);
	 HotelDTO  hotel1=new HotelDTO(0, "test", "test",0, 11,new Date() ,new Date(), "area1",  "test",  "test",  "test",State.AVAILABLE);
	 HotelDTO  hotel2= new HotelDTO(0, "test", "test",0, 11,new Date() ,new Date(), "are2",  "test",  "test",  "test",State.AVAILABLE);
	 HotelDTO  hotel3=new HotelDTO(0, "test", "test",0, 11,new Date() ,new Date(), "area2",  "test",  "test",  "test",State.AVAILABLE);

	 prod.createProduct(hotel);
	 prod.createProduct(hotel1);
	 prod.createProduct(hotel2);
	 prod.createProduct(hotel3);
		
	}
	
	@org.junit.Test
	public void test() {
		
		
		 
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
        	
        }

	    
	}
	
	
	
	public void test1()
	{
		List <HotelDTO> lista=prod.findAllHotels();
		Iterator <HotelDTO> iter=lista.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next().toString());
			
		}
		
	}


}
