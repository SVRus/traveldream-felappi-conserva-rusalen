package entitymanagement;

import java.util.List;

import javax.ejb.Local;

import entities.TravelPackage;

@Local
public interface GiftListEntityManagementLocal {
public List <Long> giftListAuthenticationCheck();
public <GiftList> List <GiftList> findGiftListForPackage(TravelPackage id);
public String findCustomerCreator(long idProduct);
public <GiftList> void edit (GiftList gift);
public <GiftList>List <GiftList > findAll();
}
