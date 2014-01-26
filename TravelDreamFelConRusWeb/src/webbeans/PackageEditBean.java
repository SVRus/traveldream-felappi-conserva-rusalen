package webbeans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.context.RequestContext;

import productManagement.ProductCRUDBeanLocal;
import stateenum.State;
import travelstateenum.TravelState;
import userManagement.GenericUserManagementBeanLocal;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.ProductDTO;
import dto.HotelDTO;
import dto.StageDTO;
import dto.PrepackedTravelPackageDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="packageEdit")
@SessionScoped

public class PackageEditBean {

	@ManagedProperty(value="#{packageCommon}")
	private PackageCommonBean shared;
	@ManagedProperty(value="#{stageManagement}")
	private StageManagementBean sharedStage;
	
	private PrepackedTravelPackageDTO currentTravelPackage;
	private StageDTO selectedStage;

	//non so se sia ridondante rispetto a packageList
	private List<StageDTO> stages;

	private  List<StageDTO> filteredStages;


	private StageDataModel stageModel;

	private List<StageDTO> stageList;
	
	private Date time_start;
	private Date time_end;
	private String description;
	private String name; 
	
	
	@PostConstruct
	public void update()
	{
	ArrayList<ProductDTO> prodotti = new ArrayList<ProductDTO>();
	prodotti.add(new HotelDTO(11, "Gianni", "Marina", 33,new Date(), new Date(), State.AVAILABLE, "Etiopia", "brutta" , "Bud Spencer","Africa"));
	prodotti.add(new HotelDTO(11, "Gianni", "Marina", 33,new Date(), new Date(), State.AVAILABLE, "Etiopia", "brutta" , "Bud Spencer","Africa"));

	StageDTO stage= new StageDTO(prodotti, "Africa",new Date(),new Date());	
	ArrayList<StageDTO> listaStage = new ArrayList<StageDTO>();

	listaStage.add(stage);
	
	stageModel= new StageDataModel(listaStage);
	System.out.println("Ciao ho popolato gli stage");

	}
	public void updateCurrentStage()
	{
		shared.setTempCurrentStage(selectedStage);
		System.out.println("Ho modificato lo stage corrente");
		
	}
	
	public String allowed()
	{
		if (!shared.isBusy())
		{		
			shared.setBusy(true);
			shared.updatePackage();
			currentTravelPackage = shared.getCurrentPackage();
			
			return "notBusy";
		}
		
		else 
		{	return "errorBusy";
		}
	}
	public String allowedNew()
	{
		if (!shared.isBusy())
		{		
			shared.setBusy(true);
			shared.setCurrentPackage(null);
			currentTravelPackage=null;
			
			return "notBusy";
		}
		
		else 
		{	return "errorBusy";
		}
	}
	
	public String closeOperation()
	{
		shared.setBusy(false);
		shared.setCurrentPackage(null);
		currentTravelPackage=null;
		/*quando termino l'operazione su un pacchetto
		  devo chiuderla automaticamente anche sulla tappa
		*/
		shared.setBusyStage(false);
		shared.setCurrentStage(null);
		
		sharedStage.setCurrentStage(null);
		
		return "closed";
	}
	
	public void editPackage()
	{
		
	}
	public PackageCommonBean getShared() {
		return shared;
	}
	public void setShared(PackageCommonBean shared) {
		this.shared = shared;
	}
	public StageManagementBean getSharedStage() {
		return sharedStage;
	}
	public void setSharedStage(StageManagementBean sharedStage) {
		this.sharedStage = sharedStage;
	}
	public PrepackedTravelPackageDTO getCurrentTravelPackage() {
		return currentTravelPackage;
	}
	public void setCurrentTravelPackage(
			PrepackedTravelPackageDTO currentTravelPackage) {
		this.currentTravelPackage = currentTravelPackage;
	}
	public StageDTO getSelectedStage() {
		return selectedStage;
	}
	public void setSelectedStage(StageDTO selectedStage) {
		this.selectedStage = selectedStage;
	}
	public List<StageDTO> getStages() {
		return stages;
	}
	public void setStages(List<StageDTO> stages) {
		this.stages = stages;
	}
	public List<StageDTO> getFilteredStages() {
		return filteredStages;
	}
	public void setFilteredStages(List<StageDTO> filteredStages) {
		this.filteredStages = filteredStages;
	}
	public StageDataModel getStageModel() {
		return stageModel;
	}
	public void setStageModel(StageDataModel stageModel) {
		this.stageModel = stageModel;
	}
	public List<StageDTO> getStageList() {
		return stageList;
	}
	public void setStageList(List<StageDTO> stageList) {
		this.stageList = stageList;
	}
	public Date getTime_start() {
		return time_start;
	}
	public void setTime_start(Date time_start) {
		this.time_start = time_start;
	}
	public Date getTime_end() {
		return time_end;
	}
	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	};

	
	
}
