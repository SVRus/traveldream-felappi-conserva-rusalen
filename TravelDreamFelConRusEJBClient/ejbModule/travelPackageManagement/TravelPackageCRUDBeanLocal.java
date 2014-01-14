package travelPackageManagement;

import javax.ejb.Local;

import dto.PrepackedTravelPackageDTO;

@Local
public interface TravelPackageCRUDBeanLocal 
{
public boolean createPrepacked(PrepackedTravelPackageDTO prepacked);


	
	
	
	
}
