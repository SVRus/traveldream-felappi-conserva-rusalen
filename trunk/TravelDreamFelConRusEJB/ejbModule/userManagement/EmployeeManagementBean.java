package userManagement;

import groupenum.Group;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.ProductDTO;
import productManagement.ProductCreateBeanLocal;

/**
 * Session Bean implementation class EmployeeManagementBean
 */
@Stateless
@LocalBean
public class EmployeeManagementBean implements EmployeeManagementBeanLocal {
@EJB
ProductCreateBeanLocal createproduct;
    /**
     * Default constructor. 
     */
    public EmployeeManagementBean() {
        // TODO Auto-generated constructor stub
    }
    @RolesAllowed({Group._EMPLOYEE})
    public boolean createProduct(ProductDTO productdto)
    {
    	
    	return createproduct.createProduct(productdto);
    }
    
}
