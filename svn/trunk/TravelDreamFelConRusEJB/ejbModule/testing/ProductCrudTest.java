package testing;

import static org.junit.Assert.*;

import java.util.Date;

import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dto.EmployeeDTO;
import dto.FlightDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto_entitiesconversion.DTOFactory;
import entities.Employee;
import entitymanagement.EmployeeEntityManagementLocal;
import productManagement.ProductCRUDBeanLocal;
import stateenum.State;

public class ProductCrudTest {
	private static EJBContainer container=null;
	private static ProductCRUDBeanLocal crud=null;
	private static EmployeeEntityManagementLocal emplo=null;
	private static DTOFactory dto=null;
	private HotelDTO hotel=null;
	private OutingDTO outing=null;
	private FlightDTO flight=null;
    boolean result;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		container=EJBContainer.createEJBContainer();
		crud=(ProductCRUDBeanLocal)container.getContext().lookup("java:global/classes/ProductCRUDBean!productManagement.ProductCRUDBeanLocal");
		emplo=(EmployeeEntityManagementLocal)container.getContext().lookup("java:global/classes/EmployeeEntityManagement!entitymanagement.EmployeeEntityManagementLocal");
	    dto=(DTOFactory)container.getContext().lookup("java:global/classes/DTOFactory!dto_entitiesconversion.DTOFactory");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		container.close();
	}

	@Before
	public void setUp() throws Exception {
		 hotel=new HotelDTO(11, "test", "test",0, 11,new Date() ,new Date(), "test",  "test",  "test",  "test",State.AVAILABLE);
		 result=crud.createProduct(hotel);
		 
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		assertTrue(result);
	}

	
	
	
	
	
	
	
	
	
	
}
