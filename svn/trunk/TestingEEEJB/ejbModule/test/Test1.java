package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test1 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
		
		
		EJBContainer cont=EJBContainer.createEJBContainer(); 
	}

}
