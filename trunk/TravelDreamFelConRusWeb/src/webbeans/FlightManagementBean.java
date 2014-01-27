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
import dto.FlightDTO;
import dto.FlightDTO;
import dto.ProductDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="flightManagement")
@ViewScoped
public class FlightManagementBean {

	private FlightDTO selectedFlight;
	private FlightDTO[] selectedFlights;  
	private FlightDTO newFlight;
		private long idtravelpackage;
		 private String employeeCreator;
		 private long idProduct;
		 private String name;
		 private float cost;
		 private Date timeStart;
		 private Date timeEnd;
		 private String area;
		 private String area_start;
		 private String place;
		 private String flight_company;
		 private String place_start;
		 private String place_end;
		 
		 private String more_info;
		  private FlightDataModel flightModel;  
		  public FlightDataModel getFlightModel() {
			return flightModel;
		}



		@EJB
		  private ProductCRUDBeanLocal productCRUD;
		@EJB
		private LoginBeanLocal login;
		  
		  
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
			 		
				newFlight = new FlightDTO(0, login.getPrincipalUsername(), name,
						 cost, timeStart, timeEnd, State.AVAILABLE, area,  
						 flight_company, area_start, place_start, place_end,
						 more_info);
		
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
					  
					newFlight = FlightDTO(selectedFlight.getIdstage(), selectedFlight.getEmployeeCreator(), 
							    selectedFlight.getName(), selectedFlight.getCost(),
							    selectedFlight.getTimeStart(), selectedFlight.getTimeEnd(),State.AVAILABLE, 
							    selectedFlight.getArea(), selectedFlight.getFlight_company(),
							    selectedFlight.getArea_start(),selectedFlight.getPlace_start(), 
							    selectedFlight.getPlace_end(), selectedFlight.getMore_info());
					productCRUD.updateProduct(newFlight);
					System.out.println("Lo modifichiamo 'sto volo?");
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



		public String getArea_start() {
			return area_start;
		}



		public void setArea_start(String area_start) {
			this.area_start = area_start;
		}



		public String getFlight_company() {
			return flight_company;
		}



		public void setFlight_company(String flight_company) {
			this.flight_company = flight_company;
		}



		public String getPlace_start() {
			return place_start;
		}



		public void setPlace_start(String place_start) {
			this.place_start = place_start;
		}



		public String getPlace_end() {
			return place_end;
		}



		public void setPlace_end(String place_end) {
			this.place_end = place_end;
		}



		public String getPlace() {
			return place;
		}



		public void setPlace(String place) {
			this.place = place;
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



		public FlightDTO getSelectedFlight() {
			return selectedFlight;
		}



		public void setSelectedFlight(FlightDTO selectedFlight) {
			this.selectedFlight = selectedFlight;
		}



		public FlightDTO[] getSelectedFlights() {
			return selectedFlights;
		}



		public void setSelectedFlights(FlightDTO[] selectedFlights) {
			this.selectedFlights = selectedFlights;
		}



		public FlightDTO getNewFlight() {
			return newFlight;
		}



		public void setNewFlight(FlightDTO newFlight) {
			this.newFlight = newFlight;
		}
		  



}
