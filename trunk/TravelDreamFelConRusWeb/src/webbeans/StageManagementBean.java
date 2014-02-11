package webbeans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import productManagement.ProductCRUDBeanLocal;
import stateenum.State;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.FlightDTO;
import dto.GiftListDTO;
import dto.OutingDTO;
import dto.ProductDTO;
import dto.HotelDTO;
import dto.StageDTO;
import dto.PrepackedTravelPackageDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="stageManagement")
@SessionScoped

public class StageManagementBean {
	
	@ManagedProperty(value="#{packageCommon}")
	private PackageCommonBean shared;
	

	
	private StageDTO currentStage;
	private StageDTO tempCurrentStage;
	
	
	//Lista di hotel
	private HotelDTO selectedHotel;
	private HotelDTO newHotel;
	  
	private HotelDataModel hotelModel;  
	private  ArrayList<HotelDTO> hotels;
	private  ArrayList<HotelDTO> filteredHotels;
	
	//Lista di Voli di partenza
		private FlightDTO selectedFlight;
		private FlightDTO newFlight;
		  
		private FlightDataModel flightModel;  
		private  ArrayList<FlightDTO> flights;
		private  ArrayList<FlightDTO> filteredFlights;
		
		//Lista di Voli di ritorno
		private FlightDTO selectedFlightBack;
		private FlightDTO newFlightBack;
				  
		private FlightDataModel flightModelBack;  
		private  ArrayList<FlightDTO> flightsBack;
		private  ArrayList<FlightDTO> filteredFlightsBack;
		
		//Lista di uscite
		private OutingDTO selectedOuting;
		private OutingDTO newOuting;
		  
		private OutingDataModel outingModel;  
		private  ArrayList<OutingDTO> outings;
		private  ArrayList<OutingDTO> filteredOutings;
		
		//Lista di prodotti da visualizzare
				private OutingDTO selectedOutingView;
				private OutingDTO newOutingView;
				  
				private OutingDataModel outingModelView;  
				private  ArrayList<OutingDTO> outingsView;
				private  ArrayList<OutingDTO> filteredOutingsView;
				
				private FlightDTO flightStartView;
				private FlightDTO flightEndView;
				private HotelDTO hotelView;
				
				private StageHelper stageHelper;
				private ArrayList<FlightDTO> flightList;
			private Date time_start_stage;
			private Date time_end_stage;
			private String areaStage;
	
		ConsistencyChecker consistency;
	
				
					
	
	 @EJB
	 private ProductCRUDBeanLocal productCRUD;
	
	public String addStage()
	{
		
		consistency = new ConsistencyChecker();
		//Controllo di consistenza
		
		//Svuota la tappa corrente e vi inserisce i prodotti selezionati dall'utente nella pagina
		if(currentStage==null)
			currentStage=new StageDTO();
		
		currentStage.setProducts(new ArrayList<ProductDTO>());
		if(flightStartView!=null)
		currentStage.addProduct(flightStartView);
		if(flightEndView!=null)
		currentStage.addProduct(flightEndView);
		if(hotelView!=null)
		currentStage.addProduct(hotelView);
		ArrayList <OutingDTO> outingsViewTrim=new ArrayList <OutingDTO> (outingsView);
		outingsViewTrim.trimToSize();
		for(int i=0; i< outingsViewTrim.size();i++)
		{	
		currentStage.addProduct(outingsViewTrim.get(i));
		}
		
		
		if(consistency.correctStage(currentStage) && (currentStage.getProducts()!=null))
		{
		/*Aggiorna lo stage nel bean comune, per permettere
		 * al packageEdit di aggiornarlo a sua volta. Si è dovuto ricorrere al bean 
		 * comune perchè non è possibile realizzare un riferimento reciproco tra bean
		 * Fonti: http://docs.oracle.com/javaee/1.4/tutorial/doc/JSFConfigure3.html
		 */
	
		shared.setCurrentStage(currentStage);
		shared.setStageUpdated(true);
		shared.setBusyStage(false);
		
		return "addedStage";
		}
		else
		{
			return "inconsistentStage";
		}
		
	}
	 
	  public void update()
	  {	
		shared.aggiorna();
		stageHelper= new StageHelper(tempCurrentStage);	
	  
		 System.out.println("sono in stage management");
	  }
	
	  
	  //METODO INUTILE
	public void editStage()
	{
		shared.setCurrentStage(null);
		if(flightStartView!=null)
		{
			shared.getCurrentStage().addProduct(flightStartView);
		}
		if(flightEndView!=null)
		{
			shared.getCurrentStage().addProduct(flightEndView);
		}
		if(hotelView!=null)
		{
			shared.getCurrentStage().addProduct(hotelView);
		}
		for(int i=0; i<outingsView.size();i++)
		{
			if (outingsView.get(i)!=null)
				
			shared.getCurrentStage().addProduct(outingsView.get(i));
		}
	}
	public String show()
	{
		currentStage= tempCurrentStage;
		update();
		 flightStartView= stageHelper.flightStart();
		  flightEndView= stageHelper.flightEnd();
		  hotelView = stageHelper.hotel();
		  outingsView= stageHelper.outings();
		  outingModelView = new OutingDataModel(outingsView);  
		  return "showStage";
		  
		
	}
	public String allowed()
	{
		if (!shared.isBusyStage())
		{		
			/*informo il bean condiviso usato da PackageManagement che si tratta
			 * di un'operazione di modifica
			 */
			shared.setNewStage(false);
			
			shared.setBusyStage(true);
			//shared.updateStage();
			//currentStage = shared.getCurrentStage();
			currentStage= tempCurrentStage;
			// setto la lista di hotel
			update();
			
			hotels
			  = new ArrayList<HotelDTO>(productCRUD.findALLHotelByStateAndArea(State.AVAILABLE, currentStage.getTimeStart(),  currentStage.getTimeEnd(),  currentStage.getArea()));
			  hotelModel = new HotelDataModel(hotels);  
			  outings
			  =new ArrayList<OutingDTO>(productCRUD.findALLOutingByStateAndArea(State.AVAILABLE, currentStage.getTimeStart(),  currentStage.getTimeEnd(),  currentStage.getArea()));
			  outingModel = new OutingDataModel(outings);  
			  flights
			  = new ArrayList<FlightDTO>(productCRUD.findALLByStateAndAreaEnd(State.AVAILABLE, currentStage.getTimeStart(),  currentStage.getTimeEnd(),  currentStage.getArea()));
			  flightModel = new FlightDataModel(flights);  
			  flightsBack
			  = new ArrayList<FlightDTO>(productCRUD.findALLFlightByStateAndAreaStart(State.AVAILABLE, currentStage.getTimeStart(),  currentStage.getTimeEnd(),  currentStage.getArea()));
			  flightModelBack = new FlightDataModel(flightsBack);  
			 
			  /*Preparo le liste di prodotti già nello stage da visualizzare
			   * passo sotto forma di lista anche le entità con un solo
			   * elemento, per poterle mettere nelle table*/
			  flightStartView= stageHelper.flightStart();
			  flightEndView= stageHelper.flightEnd();
			  hotelView = stageHelper.hotel();
			  outingsView= stageHelper.outings();
			  outingModelView = new OutingDataModel(outingsView);  
				
			  
			  
			return "notBusyStage";
		}
		
		else 
		{	return "errorBusyStage";
		}
	}
	public String allowedNew()
	{
		if (!shared.isBusyStage())
		{		
			/*informo il bean condiviso usato da PackageManagement che si tratta
			 * di un'operazione di inserimento
			 */
			shared.setNewStage(true);
			
			shared.setBusyStage(true);
			shared.setCurrentPackage(new PrepackedTravelPackageDTO());
			
			//Uso uno Stage ausiliario per il controllo di consistenza, che riceve in ingresso uno Stage
			StageDTO stageCheck= new StageDTO(new ArrayList<ProductDTO>(), areaStage, time_start_stage, time_end_stage);
			consistency = new ConsistencyChecker();
			//if(!consistency.CorrectStageInsert(shared.getCurrentPackage(), stageCheck))
			//	return "inconsistentDateStage";
			
			
			currentStage=new StageDTO();
			currentStage.setArea(areaStage);
			currentStage.setTimeStart(time_start_stage);
			currentStage.setTimeEnd(time_end_stage);
			//CONTROLLO DI CONSISTENZA
			
			hotels
			  = new ArrayList<HotelDTO>( productCRUD.findALLHotelByStateAndArea(State.AVAILABLE, time_start_stage,  time_end_stage,  areaStage));
			  hotelModel = new HotelDataModel(hotels);  
			  outings
			  = new ArrayList<OutingDTO>( productCRUD.findALLOutingByStateAndArea(State.AVAILABLE, time_start_stage,  time_end_stage,  areaStage));
			  outingModel = new OutingDataModel(outings);  
			  flights
			  = new ArrayList<FlightDTO>( productCRUD.findALLByStateAndAreaEnd(State.AVAILABLE, time_start_stage,  time_end_stage,  areaStage));
			  flightModel = new FlightDataModel(flights);  
			  flightsBack
			  = new ArrayList<FlightDTO>( productCRUD.findALLFlightByStateAndAreaStart(State.AVAILABLE, time_start_stage,  time_end_stage,  areaStage));
			  flightModelBack = new FlightDataModel(flightsBack);  
			 
			  /*Preparo le liste di prodotti già nello stage da visualizzare
			   * passo sotto forma di lista anche le entità con un solo
			   * elemento, per poterle mettere nelle table*/
				
			return "notBusyStage";
		}
		
		else 
		{	return "errorBusyStage";
		}
	}
	
	public String closeOperation()
	{
		
		shared.setBusyStage(false);
		shared.setCurrentStage(new StageDTO());
		currentStage=new StageDTO();
		
		return "closed";
	}
	
	  
	//METODI DI INSERIMENTO ED ELIMINAZIONE
	
	public void deleteFlight()
	{
		if(flightStartView==null)
			return;
		
		flights.add(flightStartView);
		flightModel = new FlightDataModel(flights);
		flightStartView= null;
		
	}
	public void deleteFlightBack()
	{
		if(flightEndView==null)
			return;
		
		flightsBack.add(flightEndView);
		flightModelBack = new FlightDataModel(flightsBack);
		
		flightEndView= null;
		
	}
	public void deleteHotel ()
	{
		if(hotelView==null)
			return;
		hotels.add(hotelView);
		hotelModel = new HotelDataModel(hotels);
		
		hotelView= null;
		
	}
	public void deleteOuting ()
	{
		if(selectedOutingView==null)
			return;
		outingsView.remove(selectedOutingView);
		outingsView.trimToSize();
		outingModelView = new OutingDataModel(outingsView);
		outings.add(selectedOutingView);
		outingModel= new OutingDataModel(outings);
	}

	public void insertFlight()
	{
		if(flightStartView==selectedFlight)
			return;
		//Se c'è, aggiungo ai voli disponibili il precedente volo occupato nella tappa che sto rimuovendo
		if(flightStartView!=null)
				
		flights.add(flightStartView);
		
		flightStartView= selectedFlight;
		flights.remove(selectedFlight);
		flights.trimToSize();
		
		flightModel = new FlightDataModel(flights);
		
	}
	public void insertFlightBack()
	{
		if(flightEndView==selectedFlightBack)
			return;
		//Se c'è, aggiungo ai voli disponibili il precedente volo occupato nella tappa che sto rimuovendo
		if(flightEndView!=null)
		flightsBack.add(flightEndView);
		
		flightEndView= selectedFlightBack;
		flightsBack.remove(selectedFlightBack);
		flightsBack.trimToSize();
		flightModelBack = new FlightDataModel(flightsBack);
	}
	public void insertHotel ()
	{
		if(hotelView==selectedHotel)
			return;
		//Se c'è, aggiungo agli hotel disponibili il precedente hotel occupato nella tappa che sto rimuovendo
		if(hotelView!=null)
		hotels.add(hotelView);
		
		hotelView= selectedHotel;
		hotels.remove(selectedHotel);
		hotels.trimToSize();
		hotelModel = new HotelDataModel(hotels);
		
	}
	public void insertOuting ()
	{
		if(outingsView==null)
			outingsView= new ArrayList<OutingDTO>();
		
		
		outingsView.add(selectedOuting);
		outingModelView = new OutingDataModel(outingsView);
		outings.remove(selectedOuting);
		outings.trimToSize();
		outingModel= new OutingDataModel(outings);

	}

	public FlightDTO getFlightStart() {
		return flightStartView;
	}



	public void setFlightStart(FlightDTO flightStart) {
		this.flightStartView = flightStart;
	}



	public StageHelper getStageHelper() {
		return stageHelper;
	}



	public void setStageHelper(StageHelper stageHelper) {
		this.stageHelper = stageHelper;
	}




	public PackageCommonBean getShared() {
		return shared;
	}




	public void setShared(PackageCommonBean shared) {
		this.shared = shared;
	}
	
	
	public List<FlightDTO> getFlightList() {
		return flightList;
	}




	public void setFlightList(ArrayList<FlightDTO> flightList) {
		this.flightList = flightList;
	}
	public StageDTO getCurrentStage() {
		return currentStage;
	}
	public void setCurrentStage(StageDTO currentStage) {
		this.currentStage = currentStage;
	}
	public HotelDTO getSelectedHotel() {
		return selectedHotel;
	}
	public void setSelectedHotel(HotelDTO selectedHotel) {
		this.selectedHotel = selectedHotel;
	}
	public HotelDTO getNewHotel() {
		return newHotel;
	}
	public void setNewHotel(HotelDTO newHotel) {
		this.newHotel = newHotel;
	}
	public HotelDataModel getHotelModel() {
		return hotelModel;
	}
	public void setHotelModel(HotelDataModel hotelModel) {
		this.hotelModel = hotelModel;
	}
	public ArrayList<HotelDTO> getHotels() {
		return hotels;
	}
	public void setHotels(ArrayList<HotelDTO> hotels) {
		this.hotels = hotels;
	}
	public ArrayList<HotelDTO> getFilteredHotels() {
		return filteredHotels;
	}
	public void setFilteredHotels(ArrayList<HotelDTO> filteredHotels) {
		this.filteredHotels = filteredHotels;
	}
	public FlightDTO getSelectedFlight() {
		return selectedFlight;
	}
	public void setSelectedFlight(FlightDTO selectedFlight) {
		this.selectedFlight = selectedFlight;
	}
	public FlightDTO getNewFlight() {
		return newFlight;
	}
	public void setNewFlight(FlightDTO newFlight) {
		this.newFlight = newFlight;
	}
	public FlightDataModel getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(FlightDataModel flightModel) {
		this.flightModel = flightModel;
	}
	public ArrayList<FlightDTO> getFlights() {
		return flights;
	}
	public void setFlights(ArrayList<FlightDTO> flights) {
		this.flights = flights;
	}
	public ArrayList<FlightDTO> getFilteredFlights() {
		return filteredFlights;
	}
	public void setFilteredFlights(ArrayList<FlightDTO> filteredFlights) {
		this.filteredFlights = filteredFlights;
	}
	public FlightDTO getSelectedFlightBack() {
		return selectedFlightBack;
	}
	public void setSelectedFlightBack(FlightDTO selectedFlightBack) {
		this.selectedFlightBack = selectedFlightBack;
	}
	public FlightDTO getNewFlightBack() {
		return newFlightBack;
	}
	public void setNewFlightBack(FlightDTO newFlightBack) {
		this.newFlightBack = newFlightBack;
	}
	public FlightDataModel getFlightModelBack() {
		return flightModelBack;
	}
	public void setFlightModelBack(FlightDataModel flightModelBack) {
		this.flightModelBack = flightModelBack;
	}
	public ArrayList<FlightDTO> getFlightsBack() {
		return flightsBack;
	}
	public void setFlightsBack(ArrayList<FlightDTO> flightsBack) {
		this.flightsBack = flightsBack;
	}
	public ArrayList<FlightDTO> getFilteredFlightsBack() {
		return filteredFlightsBack;
	}
	public void setFilteredFlightsBack(ArrayList<FlightDTO> filteredFlightsBack) {
		this.filteredFlightsBack = filteredFlightsBack;
	}
	public OutingDTO getSelectedOuting() {
		return selectedOuting;
	}
	public void setSelectedOuting(OutingDTO selectedOuting) {
		this.selectedOuting = selectedOuting;
	}
	public OutingDTO getNewOuting() {
		return newOuting;
	}
	public void setNewOuting(OutingDTO newOuting) {
		this.newOuting = newOuting;
	}
	public OutingDataModel getOutingModel() {
		return outingModel;
	}
	public void setOutingModel(OutingDataModel outingModel) {
		this.outingModel = outingModel;
	}
	public ArrayList<OutingDTO> getOutings() {
		return outings;
	}
	public void setOutings(ArrayList<OutingDTO> outings) {
		this.outings = outings;
	}
	public ArrayList<OutingDTO> getFilteredOutings() {
		return filteredOutings;
	}
	public void setFilteredOutings(ArrayList<OutingDTO> filteredOutings) {
		this.filteredOutings = filteredOutings;
	}
	public OutingDTO getSelectedOutingView() {
		return selectedOutingView;
	}
	public void setSelectedOutingView(OutingDTO selectedOutingView) {
		this.selectedOutingView = selectedOutingView;
	}
	public OutingDTO getNewOutingView() {
		return newOutingView;
	}
	public void setNewOutingView(OutingDTO newOutingView) {
		this.newOutingView = newOutingView;
	}
	public OutingDataModel getOutingModelView() {
		return outingModelView;
	}
	public void setOutingModelView(OutingDataModel outingModelView) {
		this.outingModelView = outingModelView;
	}
	public ArrayList<OutingDTO> getOutingsView() {
		return outingsView;
	}
	public void setOutingsView(ArrayList<OutingDTO> outingsView) {
		this.outingsView = outingsView;
	}
	public ArrayList<OutingDTO> getFilteredOutingsView() {
		return filteredOutingsView;
	}
	public void setFilteredOutingsView(ArrayList<OutingDTO> filteredOutingsView) {
		this.filteredOutingsView = filteredOutingsView;
	}
	public FlightDTO getFlightStartView() {
		return flightStartView;
	}
	public void setFlightStartView(FlightDTO flightStartView) {
		this.flightStartView = flightStartView;
	}
	public FlightDTO getFlightEndView() {
		return flightEndView;
	}
	public void setFlightEndView(FlightDTO flightEndView) {
		this.flightEndView = flightEndView;
	}
	public HotelDTO getHotelView() {
		return hotelView;
	}
	public void setHotelView(HotelDTO hotelView) {
		this.hotelView = hotelView;
	}
	public ProductCRUDBeanLocal getProductCRUD() {
		return productCRUD;
	}
	public void setProductCRUD(ProductCRUDBeanLocal productCRUD) {
		this.productCRUD = productCRUD;
	}

	public Date getTime_start_stage() {
		return time_start_stage;
	}

	public void setTime_start_stage(Date time_start_stage) {
		this.time_start_stage = time_start_stage;
	}

	public Date getTime_end_stage() {
		return time_end_stage;
	}

	public void setTime_end_stage(Date time_end_stage) {
		this.time_end_stage = time_end_stage;
	}

	public String getAreaStage() {
		return areaStage;
	}

	public void setAreaStage(String areaStage) {
		this.areaStage = areaStage;
	}

	

	public StageDTO getTempCurrentStage() {
		return tempCurrentStage;
	}

	public void setTempCurrentStage(StageDTO tempCurrentStage) {
		this.tempCurrentStage = tempCurrentStage;
	}

	public ConsistencyChecker getConsistency() {
		return consistency;
	}

	public void setConsistency(ConsistencyChecker consistency) {
		this.consistency = consistency;
	}


}
