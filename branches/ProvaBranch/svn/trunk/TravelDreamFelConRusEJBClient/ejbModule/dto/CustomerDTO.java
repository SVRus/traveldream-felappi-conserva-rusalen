package dto;

import java.util.ArrayList;





public class CustomerDTO extends GenericUserDTO{

/*	public ArrayList<String> getFriends() {
		return friends;
	}



	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}*/



	public ArrayList<TravelPackageDTO> getPurchasedTravelPackage() {
		return purchasedTravelPackage;
	}



	public void setPurchasedTravelPackage(ArrayList<TravelPackageDTO> purchasedTravelPackage) {
		this.purchasedTravelPackage = purchasedTravelPackage;
	}


/*
	public ArrayList<TravelPackageDTO> getPreparedForAFriendTravelPackage() {
		return preparedForAFriendTravelPackage;
	}



	public void setPreparedForAFriendTravelPackage(
			ArrayList<TravelPackageDTO> preparedForAFriendTravelPackage) {
		this.preparedForAFriendTravelPackage = preparedForAFriendTravelPackage;
	}
*/


	public ArrayList<GiftListDTO> getGiftlist() {
		return giftlist;
	}



	public void setGiftlist(ArrayList<GiftListDTO> giftlist) {
		this.giftlist = giftlist;
	}



	public ArrayList<CustomizedTravelPackageDTO> getCustomizedTravelPackage() {
		return customizedTravelPackage;
	}



	public void setCustomizedTravelPackage(ArrayList<CustomizedTravelPackageDTO> customizedTravelPackage) {
		this.customizedTravelPackage = customizedTravelPackage;
	}



	//private ArrayList <String> friends;
	private ArrayList <TravelPackageDTO> purchasedTravelPackage; 
	//private ArrayList <TravelPackageDTO> preparedForAFriendTravelPackage;
	private ArrayList <GiftListDTO> giftlist;
	private ArrayList <CustomizedTravelPackageDTO> customizedTravelPackage;
	
	
	
	public CustomerDTO(String email, String name, String surname,
			String telephone, String password, String username,
			/*ArrayList<String> friends,*/ ArrayList<TravelPackageDTO> purchasedTravelPackage,
			/*ArrayList<TravelPackageDTO> preparedForAFriendTravelPackage,*/
			ArrayList<GiftListDTO> giftlist,
			ArrayList<CustomizedTravelPackageDTO> customizedTravelPackage) {
		super(email, name, surname, telephone, password, username);
		//this.friends = friends;
		this.purchasedTravelPackage = purchasedTravelPackage;
		//this.preparedForAFriendTravelPackage = preparedForAFriendTravelPackage;
		this.giftlist = giftlist;
		this.customizedTravelPackage = customizedTravelPackage;
	}
	
	
	public void addCustomized(ArrayList <CustomizedTravelPackageDTO> customized)
	{
      customizedTravelPackage.addAll(customized);
	}
	
	public void addPurchsed(ArrayList <TravelPackageDTO> purchased)
	{
		this.purchasedTravelPackage.addAll(purchased);		
	}

public void addGift(ArrayList <GiftListDTO> gifts)
{
	giftlist.addAll(gifts);

}
	
}
