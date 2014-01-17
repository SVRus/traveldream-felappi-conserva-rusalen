package testing;

import static org.junit.Assert.*;

import javax.ejb.embeddable.EJBContainer;

import org.glassfish.embeddable.GlassFish;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import productManagement.ProductCRUDBeanLocal;
import dto.FlightDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import entitymanagement.EmployeeEntityManagement;
import entitymanagement.EmployeeEntityManagementLocal;

public class PersistingEmployeeTest {
	private static EJBContainer container=null;
	private static ProductCRUDBeanLocal crud=null;
	private static EmployeeEntityManagementLocal emplo=null;
	private HotelDTO hotel=null;
	private OutingDTO outing=null;
	private FlightDTO flight=null;
    boolean result;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	GlassFish glassfish=new GlassFish();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		container.close();
	}

	@Before
	public void setUp() throws Exception {
		Employee
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
