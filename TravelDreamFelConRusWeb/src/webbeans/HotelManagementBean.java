package webbeans;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

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

@ManagedBean(name="hotelManagement", eager = true)
@SessionScoped
public class HotelManagementBean {
	private HotelDTO selectedHotel;
	
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
	  private ProductCRUDBeanLocal productCRUD;
	  
	  
	  //valori di prova
	  static Date data1= new Date();
	  private static ArrayList<HotelDTO> hotels;
      
	  
	  public String addHotel() {		 
	      HotelDTO hot = new HotelDTO(11, "ciao", "ciao",1, 11,data1 ,data1 , "ciao",  "ciao",  "ciao",  "ciao",State.AVAILABLE);
	      
	      hotels.add(hot);
	      return null;
	   }
	 
	  public HotelManagementBean() { 
		  Calendar cal = Calendar.getInstance();
		  cal.set(2009, Calendar.DECEMBER, 12);
		  cal.add(Calendar.HOUR, 2);
		  cal.add(Calendar.MONTH, -5);
		  hotels
	      = new ArrayList<HotelDTO>(Arrays.asList(
	      new HotelDTO(11, "ciao", "ciao",1, 11,cal.getTime() ,cal.getTime(), "ciao",  "ciao",  "ciao",  "ciao",State.AVAILABLE)
	      ));	
		  
	       hotelModel = new HotelDataModel(hotels);  
	   }  

	   public String deleteHotel(HotelDTO hot) {
	      hotels.remove(hot);		
	      return null;
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
	  

   public ArrayList<HotelDTO> getHotels() {
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