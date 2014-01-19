package travelPackageManagement;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.CustomizedTravelPackageDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
import dto.TravelPackageDTO;
import dto_entitiesconversion.DTOFactory;
import entities.CustomizedTravelPackage;
import entities.Employee;
import entities.PrepackedTravelPackage;
import entities.Product;
import entities.TravelPackage;
import entitymanagement.CustomizedTravelPackageEntityManagementLocal;
import entitymanagement.EmployeeEntityManagementLocal;
import entitymanagement.PrepackedTravelPackageEntityManagementLocal;
import entitymanagement.TravelPackageEntityManagementLocal;

/**
 * Session Bean implementation class TravelPackageCreateBean
 */
@Stateless
@LocalBean
public class TravelPackageCRUDBean implements TravelPackageCRUDBeanLocal {
@EJB
PrepackedTravelPackageEntityManagementLocal preman;
@EJB
CustomizedTravelPackageEntityManagementLocal cusman;
@EJB
EmployeeEntityManagementLocal emplo;
@EJB
TravelPackageEntityManagementLocal trav; 
@EJB
DTOFactory dto;
    /**
     * Default constructor. 
     */
    public TravelPackageCRUDBean() {
        
    }

	
	@Override
	public boolean createTravelFromEmployee(TravelPackageDTO prepacked,String username) {
		Employee employee=emplo.find(username);
		TravelPackage travel=dto.travelPackageDTOToEntity(prepacked, true);
    	employee.getManagedTravelPackage().add((PrepackedTravelPackage)travel);
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

	public boolean updateTravelPackage(TravelPackageDTO traveldto)
	{
		TravelPackage travel=dto.travelPackageDTOToEntity(traveldto, false);
		boolean ok=false;
		if(travel instanceof PrepackedTravelPackage)
		{
			try {
				preman.edit((PrepackedTravelPackage)travel);
				ok=true;
			} catch (Exception e) {
				ok=false;
			}
			
		}
		else if(travel instanceof CustomizedTravelPackage)
		{
			try {
				cusman.edit((CustomizedTravelPackage)travel);
				ok=true;
			} catch (Exception e) {
				ok=false;
			}
			
		}
		
		return ok;
		
				
	}
	 public boolean delete(TravelPackageDTO traveldto)
	    {
	    	boolean ok=false;
			try 
			{
					Product product=trav.find(traveldto.getIdtravelpackage());
					trav.remove(product);
					ok=true;
			}
	    	catch (Exception e)
			{
	    		ok=false;
	    		
			}
	    	return ok;  	
	    	
	    }
	
	public List <PrepackedTravelPackageDTO> findAllPrepacked()
	{
		List <PrepackedTravelPackage> prelist=preman.findAll();
		List <PrepackedTravelPackageDTO>prelistdto=dto.prepackedTravelPackageToDTO(prelist);
		return prelistdto;
	}
	public List <CustomizedTravelPackageDTO> findAllCustomized()
	{
		List <CustomizedTravelPackage> prelist=cusman.findAll();
		List <CustomizedTravelPackageDTO>prelistdto=dto.customizedTravelPackageToDTO(prelist);
		return prelistdto;
		
		
		
	}
	
	
}
