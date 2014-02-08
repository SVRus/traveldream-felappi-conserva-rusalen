package purchase;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import stateenum.State;
import travelPackageManagement.TravelPackageCRUDBeanLocal;
import travelstateenum.TravelState;
import authentication.LoginBeanLocal;
import dto.CustomerDTO;
import dto.GiftListDTO;
import dto.ProductDTO;
import dto.StageDTO;
import dto.TravelPackageDTO;
import dto_entitiesconversion.DTOFactory;
import entities.Customer;
import entities.GiftList;
import entities.Stage;
import entities.TravelPackage;
import entitymanagement.CustomerEntityManagementLocal;
import entitymanagement.GiftListEntityManagementLocal;
import entitymanagement.TravelPackageEntityManagementLocal;

/**
 * Session Bean implementation class PurchaseGiftListBean
 */
@Stateless
@LocalBean
public class PurchaseGiftListBean implements PurchaseGiftListBeanLocal {
@EJB
LoginBeanLocal login;
@EJB
CustomerEntityManagementLocal custoMan;
@EJB
GiftListEntityManagementLocal giftMan;
@EJB
DTOFactory dto;

@EJB
TravelPackageCRUDBeanLocal travelcrud;
    /**
     * Default constructor. 
     */
    public PurchaseGiftListBean() {
        // TODO Auto-generated constructor stub
    }

   public ArrayList <GiftListDTO> giftListCreation(TravelPackageDTO travel)
    {   
    	
        List <StageDTO> stages=travel.getStages();
    	Iterator <StageDTO> iter=stages.iterator();
    	ArrayList<GiftListDTO> gifts= new ArrayList <GiftListDTO>();
    	
    	while(iter.hasNext())
    	{
    		StageDTO partial=iter.next();
    		List <ProductDTO> productsPartial=partial.getProducts();
    		
        	Iterator <ProductDTO> iterProduct=productsPartial.iterator();
           while(iterProduct.hasNext())
           {
        	   ProductDTO partialProduct=iterProduct.next();
        	   GiftListDTO giftList= new GiftListDTO(partialProduct,null,null,false,travel.getIdtravelpackage(),null);
        	   gifts.add(giftList);
           }
    	
    	
    	}
      
    	
    	return gifts;
    	
    	
    	
    }
public boolean persistGiftList(TravelPackageDTO travel)
{
	try
	
	{  
		travel.setRecoursiveTravelProductState(TravelState.RESERVED,State.RESERVED);
		travelcrud.updateTravelPackage(travel);
		Customer customer=custoMan.find(login.getPrincipalUsername());
		List <GiftList> giftLists=customer.getGiftLists();
		giftLists.addAll(dto.giftListDTOToEntity(giftListCreation( travel)));
		customer.setGiftLists(giftLists);
		custoMan.edit(customer);
		return true;
	}
	catch(Exception e)
	{
			return false;
		
		
	}
	
	
	
	
}

public boolean updateGiftList(GiftListDTO giftList)
{
	GiftList gift=dto.simpleGiftListDTOToEntity(giftList);
    try{
    	giftMan.edit(gift);
    	return true;
    }
   catch(Exception e)
   { 
	   return false;
   }

}

public boolean simpleBuyGiftList(GiftListDTO giftlist)
{
	if (isEnoughMoney(giftlist.getProduct().getCost())) {
		giftlist.setProductReserved();
		giftlist.setBought(true);
		GiftList gift = dto.simpleGiftListDTOToEntity(giftlist);
		TravelPackage travel = gift.getTravelPackage();
		if (travel.isAllSold())
			travel.setTravelState(TravelState.SOLD);
		gift.setTravelPackage(travel);
		try {
			giftMan.edit(gift);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	else return false;



}
    private boolean isEnoughMoney(float cost)
    {
		return true;
    	
    	
    	
    }
}
