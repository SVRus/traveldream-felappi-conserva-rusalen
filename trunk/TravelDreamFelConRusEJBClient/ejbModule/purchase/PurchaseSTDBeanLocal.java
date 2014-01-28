package purchase;

import javax.ejb.Local;

import dto.TravelPackageDTO;

@Local
public interface PurchaseSTDBeanLocal {
public boolean purchase(TravelPackageDTO travel);
}
