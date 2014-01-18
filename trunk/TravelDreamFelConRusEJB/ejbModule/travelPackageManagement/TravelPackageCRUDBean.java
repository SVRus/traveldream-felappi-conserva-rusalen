package travelPackageManagement;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.PrepackedTravelPackageDTO;
import dto.TravelPackageDTO;
import entities.Employee;
import entities.Product;
import entities.TravelPackage;
import entitymanagement.EmployeeEntityManagementLocal;
import entitymanagement.TravelPackageEntityManagementLocal;

/**
 * Session Bean implementation class TravelPackageCreateBean
 */
@Stateless
@LocalBean
public class TravelPackageCRUDBean implements TravelPackageCRUDBeanLocal {
@EJB
TravelPackageEntityManagementLocal travman;
@EJB
EmployeeEntityManagementLocal emplo;
    /**
     * Default constructor. 
     */
    public TravelPackageCRUDBean() {
        // TODO Auto-generated constructor stub
    }

	
	@Override
	public boolean createTravelFromEmployee(TravelPackageDTO prepacked,String username) {
		Employee employee=emplo.find(username);
		TravelPackage travel=productDTOToEntity(product);
    	employee.getManagedTravelPackage().add(prod);
    	try
    	{
    		emplo.edit(employee);
    		
    		return true;
    	}
    	catch(Exception e)
    	{
    	return false;
    	}
    	
		
	}

}
