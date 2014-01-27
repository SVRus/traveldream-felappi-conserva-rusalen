package entitymanagement;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GiftListEntityManagementLocal {
public List <Long> giftListAuthenticationCheck();
public <GiftList> List <GiftList> findGiftListForPackage(long id);
public String findCustomerCreator(long idProduct);

}
