package webbeans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import purchase.PurchaseGiftListBeanLocal;
import authentication.LoginBeanLocal;
import dto.GiftListDTO;
import dto.HotelDTO;
import exceptions.GiftListNotFoundException;

@ManagedBean(name="giftList")
@SessionScoped
public class GiftListBean implements Serializable {
	
	
	private GiftListDTO selectedGiftList;
	
	private GiftListDTO newGiftList;
	
	 //Lista di gift list non ancora acquistate  
	private  List<GiftListDTO> giftLists;
	 

	 private String code;
	 private String nameBuyer;
	 
	 
	  //Lista di gift list non ancora acquistate  
	  private GiftListDataModel giftListModel;  
	  //Lista di gift list acquistate
	  private GiftListDataModel giftListModelBought;  
	  ArrayList<GiftListDTO> giftFree;
	  ArrayList<GiftListDTO> giftBought;
	  		
	  @EJB
	  private LoginBeanLocal login;
	  
	  @EJB
	  private PurchaseGiftListBeanLocal purchase;
	  
	  
	  public void buyProduct(ActionEvent actionEvent)
	  {   checkCode();
		  selectedGiftList.setBought(true);
		  selectedGiftList.setIdBuyer(nameBuyer);
		   purchase.updateGiftList(selectedGiftList);
		  
		  checkCode();
		  
	  }
	  
	  //valori di prova
	  static Date data1= new Date();
	  private  List<HotelDTO> filteredHotels;
	  
	  @PostConstruct
	  public void update()
	  {
		System.out.println("Gift bean inizializzato");
	  
	 
	  }
	  
	 
	  public String checkCode()
	  {
		  try {
			  System.out.println("codice" + code);
			
			 giftLists= login.checkGiftListException(code);			
			
			 giftFree = new ArrayList<GiftListDTO>();
			 giftBought = new ArrayList<GiftListDTO>();
			
			for(int i=0; i<giftLists.size();i++)
			{
				if(giftLists.get(i).isBought())
				{
					giftBought.add(giftLists.get(i));
					
				}
				else
				{
					giftFree.add(giftLists.get(i));

				}
				
			}
			giftListModel = new GiftListDataModel(giftFree);
			giftListModelBought= new GiftListDataModel(giftBought);
			
			return "viewGift";

		} catch (GiftListNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return "codeError";
			
		}
	  }
	  
	  
	  
	  
	public ArrayList<GiftListDTO> getGiftFree() {
		return giftFree;
	}
	public void setGiftFree(ArrayList<GiftListDTO> giftFree) {
		this.giftFree = giftFree;
	}
	public ArrayList<GiftListDTO> getGiftBought() {
		return giftBought;
	}
	public void setGiftBought(ArrayList<GiftListDTO> giftBought) {
		this.giftBought = giftBought;
	}
	public GiftListDTO getSelectedGiftList() {
		return selectedGiftList;
	}
	public void setSelectedGiftList(GiftListDTO selectedGiftList) {
		this.selectedGiftList = selectedGiftList;
	}
	public GiftListDTO getNewGiftList() {
		return newGiftList;
	}
	public void setNewGiftList(GiftListDTO newGiftList) {
		this.newGiftList = newGiftList;
	}
	public List<GiftListDTO> getGiftLists() {
		return giftLists;
	}
	public void setGiftLists(List<GiftListDTO> giftLists) {
		this.giftLists = giftLists;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public GiftListDataModel getGiftListModel() {
		return giftListModel;
	}
	public void setGiftListModel(GiftListDataModel giftListModel) {
		this.giftListModel = giftListModel;
	}
	public LoginBeanLocal getLogin() {
		return login;
	}
	public void setLogin(LoginBeanLocal login) {
		this.login = login;
	}
	public static Date getData1() {
		return data1;
	}
	public static void setData1(Date data1) {
		GiftListBean.data1 = data1;
	}
	public List<HotelDTO> getFilteredHotels() {
		return filteredHotels;
	}
	public void setFilteredHotels(List<HotelDTO> filteredHotels) {
		this.filteredHotels = filteredHotels;
	}
	public String getNameBuyer() {
		return nameBuyer;
	}
	public void setNameBuyer(String nameBuyer) {
		this.nameBuyer = nameBuyer;
	}
	public GiftListDataModel getGiftListModelBought() {
		return giftListModelBought;
	}
	public void setGiftListModelBought(GiftListDataModel giftListModelBought) {
		this.giftListModelBought = giftListModelBought;
	}
	public PurchaseGiftListBeanLocal getPurchase() {
		return purchase;
	}
	public void setPurchase(PurchaseGiftListBeanLocal purchase) {
		this.purchase = purchase;
	}
	  public void onRowSelect(SelectEvent event) {  
	        FacesMessage msg = new FacesMessage("Car Selected", "ciao");  
	  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        System.out.println(selectedGiftList);
	    }  
	  
	    public void onRowUnselect(UnselectEvent event) {  
	        FacesMessage msg = new FacesMessage("Car Unselected", "");  
	  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }  
	  
	
	
	  
	 
	

	  
}
