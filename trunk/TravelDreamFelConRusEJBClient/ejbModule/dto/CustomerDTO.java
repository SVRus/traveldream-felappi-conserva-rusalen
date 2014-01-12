package dto;

import java.util.ArrayList;





public class CustomerDTO extends GenericUserDTO{

	public ArrayList<String> getFriends() {
		return friends;
	}



	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}



	public ArrayList<Long> getPurchasedTravelPackage() {
		return purchasedTravelPackage;
	}



	public void setPurchasedTravelPackage(ArrayList<Long> purchasedTravelPackage) {
		this.purchasedTravelPackage = purchasedTravelPackage;
	}



	public ArrayList<Long> getPreparedForAFriendTravelPackage() {
		return preparedForAFriendTravelPackage;
	}



	public void setPreparedForAFriendTravelPackage(
			ArrayList<Long> preparedForAFriendTravelPackage) {
		this.preparedForAFriendTravelPackage = preparedForAFriendTravelPackage;
	}



	public ArrayList<GiftListDTO> getGiftlist() {
		return giftlist;
	}



	public void setGiftlist(ArrayList<GiftListDTO> giftlist) {
		this.giftlist = giftlist;
	}



	public ArrayList<Long> getCustomizedTravelPackage() {
		return customizedTravelPackage;
	}



	public void setCustomizedTravelPackage(ArrayList<Long> customizedTravelPackage) {
		this.customizedTravelPackage = customizedTravelPackage;
	}



	private ArrayList <String> friends;
	private ArrayList <Long> purchasedTravelPackage; 
	private ArrayList <Long> preparedForAFriendTravelPackage;
	private ArrayList <GiftListDTO> giftlist;
	private ArrayList <Long> customizedTravelPackage;
	
	
	
	public CustomerDTO(String email, String name, String surname,
			String telephone, String password, String username,
			ArrayList<String> friends, ArrayList<Long> purchasedTravelPackage,
			ArrayList<Long> preparedForAFriendTravelPackage,
			ArrayList<GiftListDTO> giftlist,
			ArrayList<Long> customizedTravelPackage) {
		super(email, name, surname, telephone, password, username);
		this.friends = friends;
		this.purchasedTravelPackage = purchasedTravelPackage;
		this.preparedForAFriendTravelPackage = preparedForAFriendTravelPackage;
		this.giftlist = giftlist;
		this.customizedTravelPackage = customizedTravelPackage;
	}
	
	
	
	
	


	
}
