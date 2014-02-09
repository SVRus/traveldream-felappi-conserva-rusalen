package purchase;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import dto.GiftListDTO;
import dto.TravelPackageDTO;

@Local
public interface PurchaseGiftListBeanLocal {
	   public ArrayList <GiftListDTO> giftListCreation(TravelPackageDTO travel);
	   public boolean persistGiftList(TravelPackageDTO travel);
	   public boolean updateGiftList(GiftListDTO giftList);
	   public boolean simpleBuyGiftList(GiftListDTO giftlist);
	    public ArrayList <GiftListDTO> findAllGiftListForClient();


}
