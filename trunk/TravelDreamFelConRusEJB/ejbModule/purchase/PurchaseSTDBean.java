package purchase;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import authentication.LoginBeanLocal;
import dto.CustomizedTravelPackageDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
import dto.StageDTO;
import dto.TravelPackageDTO;
import dto_entitiesconversion.DTOFactory;
import entities.Customer;
import entities.CustomizedTravelPackage;
import entities.PrepackedTravelPackage;
import entities.TravelPackage;
import entitymanagement.CustomerEntityManagementLocal;

/**
 * Session Bean implementation class PurchaseSTDBean
 */
@Stateless
@LocalBean
public class PurchaseSTDBean implements PurchaseSTDBeanLocal {
@EJB
LoginBeanLocal log;
@EJB
CustomerEntityManagementLocal custoEntityMan;
@EJB
DTOFactory dto;
    /**
     * Default constructor. 
     */
    public PurchaseSTDBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean dbpurchaseCustomized(CustomizedTravelPackageDTO travelPackagedto) 
	{
		String username=log.getPrincipalUsername();
		Customer customer=custoEntityMan.find(username);
		CustomizedTravelPackage travel=(CustomizedTravelPackage)dto.travelPackageDTOToEntity(travelPackagedto, true);
		
		List <CustomizedTravelPackage> cusTravList=customer.getCustomizedTravelPackages();
		cusTravList.add(travel);
		customer.setCustomizedTravelPackages(cusTravList);
		List <TravelPackage> purchaseList=customer.getPurchasedTravelPackages();
		purchaseList.add(travel);
		customer.setPurchasedTravelPackages(purchaseList);
		try
		{
			custoEntityMan.edit(customer);
			
			return true;
		}
		catch(Exception e)
		{
		return false;
		}	
		}
	
	public boolean dbpurchasePrepacked(PrepackedTravelPackageDTO travelPackagedto)
	{
		String username=log.getPrincipalUsername();
		Customer customer=custoEntityMan.find(username);
		PrepackedTravelPackage travel=(PrepackedTravelPackage)dto.travelPackageDTOToEntity(travelPackagedto, true);
		List <TravelPackage> purchaseList=customer.getPurchasedTravelPackages();
		purchaseList.add(travel);
		customer.setPurchasedTravelPackages(purchaseList);
		try
		{
			custoEntityMan.edit(customer);
			
			return true;
		}
		catch(Exception e)
		{
		return false;
		}	
	}
	
	public boolean fullPurchase(TravelPackageDTO traveldto)
	{
		boolean ok;
		float cost=getCost(traveldto);
		
		if()
		
		
		
		
	}
	private float getCost(TravelPackageDTO travel)
	{
		float cost=0;
		List <StageDTO> stages=travel.getStages();
		Iterator <StageDTO> iter=stages.iterator();
		while(iter.hasNext())
		{
			StageDTO stage=iter.next();
			List <ProductDTO> products=stage.getProducts();
			Iterator <ProductDTO> iterProduct=products.iterator();
			while(iterProduct.hasNext())
			{
				cost=cost+ iterProduct.next().getCost();
				
				
			}
		}
		return cost;
	}

}
