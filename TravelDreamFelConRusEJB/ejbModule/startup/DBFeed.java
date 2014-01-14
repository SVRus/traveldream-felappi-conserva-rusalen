package startup;



import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;


import entities.Code;

import entitymanagement.CodeEntityManagementLocal;


/**
 * Session Bean implementation class DBFeed
 */
@Startup
@Singleton
public class DBFeed implements DBFeedLocal {

@EJB
CodeEntityManagementLocal codeejb;
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
    }
    
}
