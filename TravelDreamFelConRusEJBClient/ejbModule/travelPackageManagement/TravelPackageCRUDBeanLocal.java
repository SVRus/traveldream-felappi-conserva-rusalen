package travelPackageManagement;

import javax.ejb.Local;

import dto.TravelPackageDTO;

@Local
public interface TravelPackageCRUDBeanLocal 
{
	public boolean createTravelFromEmployee(TravelPackageDTO prepacked,String username) ;

	
	
	
	
}
