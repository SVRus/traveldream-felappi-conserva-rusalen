package webbeans;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import productManagement.ProductCRUDBeanLocal;
import stateenum.State;

import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.ProductDTO;
import dto.HotelDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="hotelManagement")
@ViewScoped
public class HotelManagementBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HotelDTO selectedHotel;
	private HotelDTO[] selectedHotels;  
	private HotelDTO newHotel;
	private String messageDelete;
	 private String messageModify;
	  

	 private long idtravelpackage;
	 private String employeeCreator;
	 private long idProduct;
	 private String name;
	 private float cost;
	 private Date timeStart;
	 private Date timeEnd;
	 private String area;
	 private String place;
	 private String room_type;
	 private String more_info;
	 
	    
	  private HotelDataModel hotelModel;  
	  
	  @EJB
	  private ProductCRUDBeanLocal productCRUD;
	  @EJB
		private LoginBeanLocal login;
	  
	  
	  //valori di prova
	  static Date data1= new Date();
	  private  List<HotelDTO> hotels;
	  private  List<HotelDTO> filteredHotels;
	  
	  @PostConstruct
	  public void update()
	  {
		
	  hotels = productCRUD.findAllHotels();
	  hotelModel = new HotelDataModel(hotels);  

	  }
	  
	 
	  
	  public void newHotel(ActionEvent actionEvent)
	  {
		  if (	    name != null && !name.isEmpty() &&
					Float.toString(cost) != null && 
					timeStart != null && !timeStart.toString().isEmpty() &&
					timeEnd != null && !timeEnd.toString().isEmpty() &&
					timeStart.before(timeEnd) &&
					area != null && !area.isEmpty() &&
					place != null && !place.isEmpty() &&
					room_type != null && ! room_type.isEmpty() &&
			        more_info != null && ! more_info.isEmpty()
					)
		  {
			newHotel = new HotelDTO((long) 0, login.getPrincipalUsername(), name, cost, timeStart, timeEnd, State.AVAILABLE, 
					   area, place, room_type, more_info);
			productCRUD.createProductFromEmployee(newHotel);
			System.out.println("creato un hotel");
			hotels= productCRUD.findAllHotels();
			hotelModel=new HotelDataModel(hotels);
		  }
		  
	  }
	  public void deleteHotel(ActionEvent actionEvent) {
		  
		    if(selectedHotel.getState()==State.AVAILABLE)
		    	messageDelete="Prodotto eliminato correttamente";
		    if(selectedHotel.getState()==State.INCLUDED)
		    	messageDelete="Il prodotto è stato eliminato. E'stato eliminato anche il pacchetto ad esso associato." ;
		    if(selectedHotel.getState()==State.SOLD)
		    	messageDelete="Il prodotto eliminato era venduto. Il prodotto rimarrà nel sistema, ma è stata inviata una notifica al cliente.";
		    if(selectedHotel.getState()==State.RESERVED)
		    	messageDelete="Il prodotto eliminato era in una gift list. Il prodotto rimarrà nel sistema, ma è stata inviata una notifica al cliente.";
		   
		    productCRUD.delete(selectedHotel);
			hotels= productCRUD.findAllHotels();
			hotelModel=new HotelDataModel(hotels);
		   
		   }
	  
	  public void updateHotel(ActionEvent actionEvent){
		  
		  if (	    selectedHotel.getName() != null && !selectedHotel.getName().isEmpty() &&
					Float.toString(selectedHotel.getCost()) != null && 
					selectedHotel.getTimeStart() != null && !selectedHotel.getTimeStart().toString().isEmpty() &&
					selectedHotel.getTimeEnd() != null && !selectedHotel.getTimeEnd().toString().isEmpty() &&
					selectedHotel.getTimeStart().before(selectedHotel.getTimeEnd()) &&
					selectedHotel.getArea() != null && !selectedHotel.getArea().isEmpty() &&
					selectedHotel.getPlace()  != null && !selectedHotel.getPlace().isEmpty() && 
				    selectedHotel.getRoom_type() != null && !selectedHotel.getRoom_type().isEmpty() &&
					selectedHotel.getMore_info() != null && !selectedHotel.getMore_info().isEmpty()
					)
		  {
			 if(selectedHotel.getState()==State.AVAILABLE)
		    	messageModify="Prodotto modificato correttamente";
		    if(selectedHotel.getState()==State.INCLUDED)
		    	messageModify="Il prodotto è stato modificato. E'stato eliminato il pacchetto ad esso associato." ;
		    if(selectedHotel.getState()==State.SOLD)
		    	messageModify="Il prodotto modificato era venduto. Il prodotto rimarrà nel sistema, ma è stata inviata una notifica al cliente.";
		    if(selectedHotel.getState()==State.RESERVED)
		    	messageModify="Il prodotto modificato era in una gift list. Il prodotto rimarrà nel sistema, ma è stata inviata una notifica al cliente.";
		  
		  hotels.remove(selectedHotel);
		  newHotel = new HotelDTO(selectedHotel.getIdstage(), selectedHotel.getEmployeeCreator(),selectedHotel.getName(), 
				   selectedHotel.getIdProduct(), selectedHotel.getCost(),
				  selectedHotel.getTimeStart(), selectedHotel.getTimeEnd(),
				  selectedHotel.getState(), selectedHotel.getArea(), 
				  selectedHotel.getPlace(), selectedHotel.getRoom_type(),
				  selectedHotel.getMore_info());  productCRUD.updateProduct(newHotel);
		  hotels= productCRUD.findAllHotels();
	      hotelModel=new HotelDataModel(hotels);
   	      System.out.println("hotel modificato");
   	      
		  }
		   }
	  
	  public HotelDTO[] getSelectedHotels() {
			return selectedHotels;
		}
	  public  List<HotelDTO> getFilteredHotels() {
		return filteredHotels;
	}

	public  void setFilteredHotels(List<HotelDTO> filteredHotels) {
		this.filteredHotels = filteredHotels;
	}

	
	 
	  public HotelManagementBean() { 
		        
	   }  
	

	public void setSelectedHotels(HotelDTO[] selectedHotels) {
		this.selectedHotels = selectedHotels;
	}

	public void setHotels(List<HotelDTO> hotels) {
		this.hotels = hotels;
	}

	
	    
	 

	   public String saveHotel(){
		 //TODO
		   
	      //set "canEdit" of all employees to false 
	     // for (HotelDTO hot : hotels){
	         //hotel.setCanEdit(false);
	      //}		
	      return null;
	   }
	  

   public List<HotelDTO> getHotels() {
      return productCRUD.findAllHotels();
   }
	 
   public HotelDTO getNewHotel() {
		return newHotel;
	}

	public void setNewHotel(HotelDTO newHotel) {
		this.newHotel = newHotel;
	}
	
	public HotelDTO getSelectedHotel() {
		return selectedHotel;
	}
	public void setSelectedHotel(HotelDTO selectedHotel) {
		this.selectedHotel = selectedHotel;
	}
	public HotelDataModel getHotelModel() {
		return hotelModel;
	}
	public void setHotelModel(HotelDataModel hotelModel) {
		this.hotelModel = hotelModel;
	}
	public long getIdtravelpackage() {
		return idtravelpackage;
	}
	public void setIdtravelpackage(long idtravelpackage) {
		this.idtravelpackage = idtravelpackage;
	}
	public String getEmployeeCreator() {
		return employeeCreator;
	}
	public void setEmployeeCreator(String employeeCreator) {
		this.employeeCreator = employeeCreator;
	}
	public long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getMore_info() {
		return more_info;
	}
	public void setMore_info(String more_info) {
		this.more_info = more_info;
	}



	public String getMessageDelete() {
		return messageDelete;
	}



	public void setMessageDelete(String messageDelete) {
		this.messageDelete = messageDelete;
	}



	public String getMessageModify() {
		return messageModify;
	}



	public void setMessageModify(String messageModify) {
		this.messageModify = messageModify;
	}



	public ProductCRUDBeanLocal getProductCRUD() {
		return productCRUD;
	}



	public void setProductCRUD(ProductCRUDBeanLocal productCRUD) {
		this.productCRUD = productCRUD;
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
		HotelManagementBean.data1 = data1;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	 
	 
	

	
}





