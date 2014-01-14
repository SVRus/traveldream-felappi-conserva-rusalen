package travelPackageManagement;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.PrepackedTravelPackageDTO;

/**
 * Session Bean implementation class TravelPackageCreateBean
 */
@Stateless
@LocalBean
public class TravelPackageCRUDBean implements TravelPackageCRUDBeanLocal {

    /**
     * Default constructor. 
     */
    public TravelPackageCRUDBean() {
        // TODO Auto-generated constructor stub
    }

	
	@Override
	public boolean createPrepacked(PrepackedTravelPackageDTO prepacked) {
		// TODO Auto-generated method stub
		return false;
	}

}
