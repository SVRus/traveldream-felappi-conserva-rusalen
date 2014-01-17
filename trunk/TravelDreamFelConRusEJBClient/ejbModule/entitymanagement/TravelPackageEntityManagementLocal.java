package entitymanagement;

import javax.ejb.Local;

@Local
public interface TravelPackageEntityManagementLocal {

	
	public Long findIdCustomerBuyer(Long idTravelPackage);
    public Long findIdCustomerFriendOwner(Long idTravelPackage);
}
