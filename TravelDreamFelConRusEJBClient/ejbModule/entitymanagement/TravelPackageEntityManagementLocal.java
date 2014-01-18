package entitymanagement;

import javax.ejb.Local;

@Local
public interface TravelPackageEntityManagementLocal {

	
	public String findIdCustomerBuyer(Long idTravelPackage);
    public String findIdCustomerFriendOwner(Long idTravelPackage);
}
