package webbeans;
import java.io.Serializable;
import java.util.GregorianCalendar;
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
	  @EJB
	  private ProductCRUDBeanLocal productCRUD;
	  
	  
	  //valori di prova
	  static GregorianCalendar data1= new GregorianCalendar();
	  private  List<HotelDTO> hotels;
	  private  List<HotelDTO> filteredHotels;
	  
	  @PostConstruct
	  public void update()
	  {
		
	  hotels
	  = productCRUD.findAllHotels();
	  hotelModel = new HotelDataModel(hotels);  

	  }
	  
	 
	  
	  public void newHotel(ActionEvent actionEvent)
	  {
			newHotel = new HotelDTO(23, name, name, 23, data1, data1,
					State.AVAILABLE, name, name, name, name);
			productCRUD.createProductFromEmployee(newHotel);
			System.out.println("creato un hotel");
			hotels=productCRUD.findAllHotels();
		     hotelModel=new HotelDataModel(hotels);
		  
	  }
	  public void deleteHotel(ActionEvent actionEvent) {
			
		    productCRUD.delete(selectedHotel);
		    hotels.remove(selectedHotel);
		    
		   }
	  public void updateHotel(ActionEvent actionEvent){
			
				hotels.remove(selectedHotel);
			    newHotel = new HotelDTO(23, selectedHotel.getName(), selectedHotel.getName(),selectedHotel.getIdProduct(), 23, data1, data1,
			    State.AVAILABLE, selectedHotel.getName(), selectedHotel.getName(), selectedHotel.getName(), selectedHotel.getName());
				productCRUD.updateProduct(newHotel);
				System.out.println("avrei dovuto creare un hotel");
				hotels.add(newHotel);
			   
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
