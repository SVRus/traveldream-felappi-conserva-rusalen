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
import dto.FlightDTO;
import dto.ProductDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="flightManagement")
@ViewScoped
public class FlightManagementBean {

	 
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
		  private FlightDataModel flightModel;  
		  public FlightDataModel getFlightModel() {
			return flightModel;
		}



		@EJB
		  private ProductCRUDBeanLocal productCRUD;
		  
		  
		  //valori di prova
		  static Date data1= new Date();
		  private  List<FlightDTO> flights;
		  private  List<FlightDTO> filteredFlights;
		  
		  
		  @PostConstruct
		  public void update()
		  {
			
		  flights
		  = productCRUD.findAllFlights();
		  flightModel = new FlightDataModel(flights);  

		  }
		  
		 
		  
		  public void newFlight(ActionEvent actionEvent)
		  {
				newFlight = new FlightDTO(23, name, name, 23, data1, data1,
						name, name, name, name, State.AVAILABLE);
				productCRUD.createProduct(newFlight);
				System.out.println("avrei dovuto creare un flight");
				flights.add(newFlight);
			
			  
		  }
		  public void deleteFlight(ActionEvent actionEvent) {
				
			    productCRUD.delete(selectedFlight);
			    flights.remove(selectedFlight);
			    
			   }
		  public void updateFlight(ActionEvent actionEvent){
				
					flights.remove(selectedFlight);
				   newFlight = new FlightDTO(23, selectedFlight.getName(), selectedFlight.getName(), 23, data1, data1,
						   selectedFlight.getName(), selectedFlight.getName(), selectedFlight.getName(), selectedFlight.getName(), State.AVAILABLE);
					productCRUD.updateProduct(newFlight);
					System.out.println("avrei dovuto creare un flight");
					flights.add(newFlight);
				   
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



		public ProductCRUDBeanLocal getProductCRUD() {
			return productCRUD;
		}



		public void setProductCRUD(ProductCRUDBeanLocal productCRUD) {
			this.productCRUD = productCRUD;
		}



		public static Date getData1() {
			return data1;
		}



		public static void setData1(Date data1) {
			FlightManagementBean.data1 = data1;
		}



		public List<FlightDTO> getFlights() {
			return flights;
		}



		public void setFlights(List<FlightDTO> flights) {
			this.flights = flights;
		}



		public List<FlightDTO> getFilteredFlights() {
			return filteredFlights;
		}



		public void setFilteredFlights(List<FlightDTO> filteredFlights) {
			this.filteredFlights = filteredFlights;
		}



		public void setFlightModel(FlightDataModel flightModel) {
			this.flightModel = flightModel;
		}
		  



}
