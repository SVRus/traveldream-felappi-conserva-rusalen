package entitymanagement;

import java.util.List;

import javax.ejb.Local;

import dto.CustomizedTravelPackageDTO;

@Local
public interface TravelPackageEntityManagementLocal {

	
	public String findIdCustomerBuyer(Long idTravelPackage);
    public String findIdCustomerFriendOwner(Long idTravelPackage);
    public <TravelPackage>  TravelPackage find(Object id);
	 public <TravelPackage> void remove (TravelPackage travel);
		


}
