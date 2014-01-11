package dto;

import java.util.ArrayList;





public class CustomerDTO extends GenericUserDTO{

	private ArrayList <String> friends;
	private ArrayList <Long> purchasedTravelPackage; 
	private ArrayList <Long> preparedForAFriendTravelPackage;
	private ArrayList <ProductDTO> giftlist;
	private ArrayList <Long> customizedTravelPackage;
	
	
	
	public CustomerDTO(String email, String name, String surname,
			String telephone, String password, String username,
			ArrayList<String> friends, ArrayList<Long> purchasedTravelPackage,
			ArrayList<Long> preparedForAFriendTravelPackage,
			ArrayList<ProductDTO> giftlist,
			ArrayList<Long> customizedTravelPackage) {
		super(email, name, surname, telephone, password, username);
		this.friends = friends;
		this.purchasedTravelPackage = purchasedTravelPackage;
		this.preparedForAFriendTravelPackage = preparedForAFriendTravelPackage;
		this.giftlist = giftlist;
		this.customizedTravelPackage = customizedTravelPackage;
	}
	
	
	
	
	


	
}
