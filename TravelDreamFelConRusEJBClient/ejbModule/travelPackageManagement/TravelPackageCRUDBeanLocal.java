package travelPackageManagement;

import java.util.List;

import javax.ejb.Local;

import dto.CustomizedTravelPackageDTO;
import dto.PrepackedTravelPackageDTO;
import dto.TravelPackageDTO;

@Local
public interface TravelPackageCRUDBeanLocal 
{
	public boolean createTravelFromEmployee(TravelPackageDTO prepacked,String username) ;
	public boolean updateTravelPackage(TravelPackageDTO traveldto);
	public boolean delete(TravelPackageDTO traveldto);
	public List <PrepackedTravelPackageDTO> findAllPrepacked();
    public List <CustomizedTravelPackageDTO> findAllCustomized();

	
	
	
}
