package productManagement;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ReadBean
 */
@Stateless
@LocalBean
public class ProductReadBean implements ProductReadBeanLocal {

    
    public ProductReadBean() {
    }

}
