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

import org.jboss.weld.event.CurrentEventMetadata;
import org.primefaces.context.RequestContext;

import productManagement.ProductCRUDBeanLocal;
import stateenum.State;
import travelPackageManagement.TravelPackageCRUDBeanLocal;
import travelstateenum.TravelState;
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
	
	//Package riferito all'operazione in corso. Il suo valore viene prelevato da tempCurrentPackage
	//se l'operazione è stata permessa
	private PrepackedTravelPackageDTO currentTravelPackage;
	//Package che viene modificato quando si seleziona un package nella pagina con tutti i package
	private PrepackedTravelPackageDTO tempCurrentPackage;
	
	private StageDTO selectedStage;

	//non so se sia ridondante rispetto a packageList
	private List<StageDTO> stages;

	private  List<StageDTO> filteredStages;

	//I suoi valori verranno aggiornati prendendoli dal currentTravelPackage
	private StageDataModel stageModel;

	private List<StageDTO> stageList;
	
	private Date time_start;
	private Date time_end;
	private String description;
	private String name; 
	
	//per popolare i campi la prima volta in caso di modifica
	private boolean modifyForField;
	//per svuotere i campi la prima volta in caso di nuovo pacchetto
	private boolean newForField;
	@EJB
	private TravelPackageCRUDBeanLocal packageCRUD;
	
	//true se sto lavorando su un nuovo pacchetto, false se sto modificando un pacchetto esistente
	private boolean newPack;
	
	
	
	
	public void update()
	{
	
	//Controllo inutile
	if(currentTravelPackage!=null)
		
	{
	if(shared.isStageUpdated())
	{
		/*
		 * La modifica si compone di due operazioni: eliminazione dello stage precedente e
		 * aggiunta del nuovo stage
		 * 
		 */
		//aggiungo il nuovo stage
		currentTravelPackage.addStage(sharedStage.getCurrentStage());
		//rimuovo lo stage precedente
		currentTravelPackage.getStages().remove(shared.getStageToDeleteForModify());
		
		shared.setStageUpdated(false);
	}
	else
	{
		//currentTravelPackage.addStage(sharedStage.getCurrentStage());
		
	}
	stageModel= new StageDataModel(currentTravelPackage.getStages());
	}
	System.out.println("Ciao ho popolato gli stage");
	
	modifyForField=false;
	newForField=false;
	
	}
	public void updateState()
	{
		stageModel= new StageDataModel(currentTravelPackage.getStages());
		
		
	}
	public void updateCurrentStage()
	{
		//Setto lo stage selezionato nella pagina di stageManagement
		sharedStage.setTempCurrentStage(selectedStage);
		/*Salvo lo stage selezionato nello stage condiviso, per memorizzarlo
		 * in vista di operazioni di modifica
		 */
		shared.setStageToDeleteForModify(selectedStage);
		System.out.println("Ho modificato lo stage corrente");
		
	}
	
	/**
	 * metodo che controlla che non ci sia un'operazione in corso su un pacchetto, e in tal caso
	 * abilita la modifica sul pacchetto selezionato settando i parametri necessari
	 * @return
	 */
	public String allowed()
	{
		if (!shared.isBusy())
		{		
			shared.setBusy(true);
			
			currentTravelPackage = tempCurrentPackage;
			update();
			newPack = false;
			//permette di mantenere i campi del pacchetto selezionato. Usato nei getter
			modifyForField=true;
			
			return "notBusy";
			
			
		}
		
		else 
		{	return "errorBusy";
		}
	}
	/**
	 * metodo che controlla che non ci sia un'operazione in corso su un pacchetto, e in tal caso
	 * abilita la creazione di un nuovo pacchetto settando i parametri necessari
	 * @return
	 */
	public String allowedNew()
	{
		if (!shared.isBusy())
		{		
			
			shared.setBusy(true);
			//shared.setCurrentPackage(null);
			currentTravelPackage= new PrepackedTravelPackageDTO();
			newPack = true;
			//permette di svuotare i campi. Usato nei getter
			newForField=true;
			return "notBusy";
		}
		
		else 
		{	return "errorBusy";
		}
	}
	
	public String closeOperation()
	{
		shared.setBusy(false);
		shared.setCurrentPackage(new PrepackedTravelPackageDTO());
		currentTravelPackage=new PrepackedTravelPackageDTO();
		/*quando termino l'operazione su un pacchetto
		  devo chiuderla automaticamente anche sulla tappa
		*/
		shared.setBusyStage(false);
		shared.setCurrentStage(new StageDTO());
		
		sharedStage.setCurrentStage(new StageDTO());
		
		return "closed";
	}
	
	
	public void editPackage()
	{
		if(newPack)
		{
			
			currentTravelPackage.setName(name);
			currentTravelPackage.setDescription(description);
			currentTravelPackage.setTime_start(time_start);
			currentTravelPackage.setTime_end(time_end);
			packageCRUD.createTravelFromEmployee(currentTravelPackage);
			
			System.out.println("Ho creato un pacchetto");
			
		}
		else
		{

			currentTravelPackage.setName(name);
			currentTravelPackage.setDescription(description);
			currentTravelPackage.setTime_start(time_start);
			currentTravelPackage.setTime_end(time_end);
			packageCRUD.updateTravelPackage(currentTravelPackage);
		
			System.out.println("Ho modificato un pacchetto");
			
		}
		shared.setBusy(false);
		
		
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
		if(modifyForField)
			return currentTravelPackage.getTime_start();
		if(newForField)
			return null;
		return time_start;
	}
	public void setTime_start(Date time_start) {
		this.time_start = time_start;
	}
	public Date getTime_end() {
		if(modifyForField)
			return currentTravelPackage.getTime_end();
		if(newForField)
			return null;
		return time_end;
	}
	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}
	public String getDescription() {
		if(modifyForField)
			return currentTravelPackage.getDescription();
		if(newForField)
			return "";
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		
		if(modifyForField)
			return currentTravelPackage.getName();
		if(newForField)
			return "";
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PrepackedTravelPackageDTO getTempCurrentPackage() {
		return tempCurrentPackage;
	}
	public void setTempCurrentPackage(PrepackedTravelPackageDTO tempCurrentPackage) {
		this.tempCurrentPackage = tempCurrentPackage;
	}
	public TravelPackageCRUDBeanLocal getPackageCRUD() {
		return packageCRUD;
	}
	public void setPackageCRUD(TravelPackageCRUDBeanLocal packageCRUD) {
		this.packageCRUD = packageCRUD;
	}
	public boolean isNewPack() {
		return newPack;
	}
	public void setNewPack(boolean newPack) {
		this.newPack = newPack;
	}
	public boolean isModifyForField() {
		return modifyForField;
	}
	public void setModifyForField(boolean modifyForField) {
		this.modifyForField = modifyForField;
	}
	public boolean isNewForField() {
		return newForField;
	}
	public void setNewForField(boolean newForField) {
		this.newForField = newForField;
	}
	
	
		
	
	
}
