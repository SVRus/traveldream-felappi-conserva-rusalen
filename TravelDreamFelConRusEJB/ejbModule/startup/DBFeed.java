package startup;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.commons.codec.digest.DigestUtils;

import entities.Employee;
import entities.PrepackedTravelPackage;
import entities.Product;
import entitymanagement.EmployeeEntityManagementLocal;
import groupenum.Group;

/**
 * Session Bean implementation class DBFeed
 */
@Startup
@Singleton
public class DBFeed implements DBFeedLocal {

@EJB
EmployeeEntityManagementLocal emplo;
    /**
     * Default constructor. 
     */
    public DBFeed() {
        // TODO Auto-generated constructor stub
    }
     @PostConstruct
    public void feedEmployee()
    {     List <Group> group=new ArrayList <Group>();
          group.add(Group.EMPLOYEE);
          String email="pippo@email.it";
          String name="pippo";
          String username="impiegato";
    	  Employee e1=new Employee(email,name,"imp","telephone",DigestUtils.sha256Hex("iosonopippo"),"impiegato",group,new ArrayList<Product>(),new ArrayList <PrepackedTravelPackage>());
    	  if(emplo.find(username)==null)
    	  emplo.create(e1);
    }
    
}
