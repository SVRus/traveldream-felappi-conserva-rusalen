package authentication;

import java.util.ArrayList;

import javax.ejb.Local;








import dto.CustomizedTravelPackageDTO;
import dto.EmployeeDTO;
import dto.GenericUserDTO;
import dto.GiftListDTO;
import dto.TravelPackageDTO;
import exceptions.FriendNotFoundException;
import exceptions.GiftListNotFoundException;

@Local
public interface LoginBeanLocal {
	public GenericUserDTO findLogIn();
	public boolean isLogged();
	public String getPrincipalUsername() ;
	public boolean updateEmployee(EmployeeDTO emplodto);
	public boolean checkGift(String giftCode);
	public ArrayList <GiftListDTO> checkGiftListException(String giftCode) throws GiftListNotFoundException;
	public CustomizedTravelPackageDTO checkFriendException(String friendCode) throws FriendNotFoundException;

}
