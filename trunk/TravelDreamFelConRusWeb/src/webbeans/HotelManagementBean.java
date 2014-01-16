package webbeans;
import java.io.Serializable;
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
import userManagement.GenericUserManagementBeanLocal;
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
	
	 public HotelDTO getNewHotel() {
		return newHotel;
	}

	public void setNewHotel(HotelDTO newHotel) {
		this.newHotel = newHotel;
	}
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
	  //non ancora utilizzato
	  @EJB
	  private ProductCRUDBeanLocal productCRUD;
	  
	  
	  //valori di prova
	  static Date data1= new Date();
	  private  List<HotelDTO> hotels;
	  private  List<HotelDTO> filteredHotels;
	  
	  public void nuovoHot(ActionEvent actionEvent) {  
	       
				RequestContext context = RequestContext.getCurrentInstance();
				FacesMessage msg = null;
				boolean loggedIn = true;
				/*  
				if(username != null  &&&& username.equals("admin") && password != null  && password.equals("admin")) {  
				    loggedIn = true;  
				    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);  
				} else {  
				    loggedIn = false;  
				    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");  
				}  */
				newHotel = new HotelDTO(11, "capra", "ciao", 11, data1, data1,
						"ciao", "ciao", "ciao", "ciao", State.AVAILABLE);
				msg = new FacesMessage("", "Welcome");
				loggedIn = productCRUD.createProduct(newHotel);
				
				FacesContext.getCurrentInstance().addMessage(null, msg);
				context.addCallbackParam("loggedIn", loggedIn);
			  
	        
	        
	    }  
	  
	  public void newHotel()
	  {
		  
		  productCRUD.createProduct(newHotel);
		  
	  }
	  
	  public  List<HotelDTO> getFilteredHotels() {
		return filteredHotels;
	}

	public  void setFilteredHotels(List<HotelDTO> filteredHotels) {
		this.filteredHotels = filteredHotels;
	}

	public String addHotel() {		 
	      HotelDTO hot = new HotelDTO(11, "ciao", "ciao",1, 11,data1 ,data1 , "ciao",  "ciao",  "ciao",  "ciao",State.AVAILABLE);
	      
	      hotels.add(hot);
	      
	      return null;
	   }
	 
	  public HotelManagementBean() { 
		  
		  /*Calendar cal = Calendar.getInstance();
		  cal.set(2009, Calendar.DECEMBER, 12);
		  cal.add(Calendar.HOUR, 2);
		  cal.add(Calendar.MONTH, -5);*/
		   /*Arrays.asList(
	      new HotelDTO(11, "ciao", "ciao",1, 11,cal.getTime() ,cal.getTime(), "ciao",  "ciao",  "ciao",  "ciao",State.AVAILABLE)
	      ,new HotelDTO(222, "gciao", "gciao",21, 211,cal.getTime() ,cal.getTime(), "2ciao",  "2ciao",  "2ciao",  "2ciao",State.AVAILABLE)
	    	      )
	      ;	*/
		  
	      
	   }  
	  @PostConstruct
	  public void update()
	  {
		  newHotel = new HotelDTO(11, "capra", "ciao", 11, data1, data1,
					"ciao", "ciao", "ciao", "ciao", State.AVAILABLE);
			productCRUD.createProduct(newHotel);
			
	  hotels
	  = productCRUD.findAllHotels();
	  hotelModel = new HotelDataModel(hotels);  

	  }
	  
	   public HotelDTO[] getSelectedHotels() {
		return selectedHotels;
	}

	public void setSelectedHotels(HotelDTO[] selectedHotels) {
		this.selectedHotels = selectedHotels;
	}

	public void setHotels(List<HotelDTO> hotels) {
		this.hotels = hotels;
	}

	public void deleteHotel(ActionEvent actionEvent) {
		
	    productCRUD.delete(selectedHotel);
	    
	   }
	    
	   public String editHotel(HotelDTO hot){
		 //TODO
		   
		   //hot.setCanEdit(true);
		   return null;
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
      return hotels;
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

	
	 
	 
	

	
}
