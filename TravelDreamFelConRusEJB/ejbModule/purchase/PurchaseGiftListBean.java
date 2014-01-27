package purchase;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
import entitymanagement.CustomerEntityManagementLocal;
import entitymanagement.GiftListEntityManagementLocal;

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


    
}
