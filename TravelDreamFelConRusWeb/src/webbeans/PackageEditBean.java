package webbeans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import purchase.PurchaseGiftListBeanLocal;
import travelPackageManagement.TravelPackageCRUDBeanLocal;
import dto.CustomizedTravelPackageDTO;
import dto.StageDTO;
import dto.PrepackedTravelPackageDTO;


@ManagedBean(name="packageEdit")
@SessionScoped

public class PackageEditBean implements Serializable{

	/**Contiene i valori booleani necessari a consentire o meno le operazioni
	 * di creazione o modifica. Serve a tenere traccia della corrispondenza tra un pacchetto e le sue tappe
	 * e eventuali modifiche. 
	 */
	@ManagedProperty(value="#{packageCommon}")
	private PackageCommonBean shared;

	
	@ManagedProperty(value="#{stageManagement}")
	private StageManagementBean sharedStage;
	
	//Package selezionato correntemente nella pagina con tutti i package
	private PrepackedTravelPackageDTO tempCurrentPackage;
		
	//Package riferito all'operazione in corso. Il suo valore viene prelevato da tempCurrentPackage
	//se l'operazione è stata permessa
	private PrepackedTravelPackageDTO currentTravelPackage;
	
	private StageDTO selectedStage;

	
	private  ArrayList<StageDTO> filteredStages;

	//I suoi valori verranno aggiornati prendendoli dal currentTravelPackage
	private StageDataModel stageModel;

	private PurchaseGiftListBeanLocal purchase;
	
	//Campi del pacchetto
	private Date time_start;
	private Date time_end;
	private String description;
	private String name; 
	
	//per popolare i campi la prima volta in caso di modifica. Utilizzati nei getter
	private boolean modifyForField;
	//per svuotare i campi la prima volta in caso di nuovo pacchetto
	private boolean newForField;
	
	@EJB
	private TravelPackageCRUDBeanLocal packageCRUD;
	
	//true se sto lavorando su un nuovo pacchetto, false se sto modificando un pacchetto esistente
	private boolean newPack;
	
	ConsistencyChecker consistency;
	
	
	
	/**
	 * Metodo che viene lanciato ad ogni aggiornamento della pagina di pacchetto.
	 * Verifica se sono state fatte modifiche sulla tappa corrente e in tal caso le salva nel pacchetto.
	 */
	
	public void update()
	{
	

	//Se si accede alla pagina dalla barra degli indirizzi
	if(currentTravelPackage!=null)
		
	{
	//Controllo se è stato aggiunto uno stage al pacchetto, e in tal caso aggiorno il pacchetto.	
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
		currentTravelPackage.removeStage(shared.getStageToDeleteForModify());
				
		shared.setStageUpdated(false);
	}
	//Aggiorno la struttura dati per la tabella con la lista aggiornata
	stageModel= new StageDataModel(currentTravelPackage.getStages());
	}
	//Dopo il primo accesso alla pagina vengono conservate le modifiche dell'utente.
	modifyForField=false;
	newForField=false;
	
	}
	
	/*
	public void updateState()
	{
		stageModel= new StageDataModel(currentTravelPackage.getStages());
		
		
	}*/
	
	public void updateCurrentStage()
	{
		//Setto lo stage selezionato nella pagina di stageManagement
		sharedStage.setTempCurrentStage(selectedStage);
		/*Salvo lo stage selezionato nello stage condiviso, per memorizzarlo
		 * in vista di operazioni di modifica
		 */
		shared.setStageToDeleteForModify(selectedStage);
		
	}
	
	/**
	 * metodo che setta le strutture dati che consentono la visualizzazione
	 */
	public String show()
	{
		currentTravelPackage = tempCurrentPackage;
		setFields();
		update();
		return "showPackage";
		
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
			//false indica che sto modificando un pacchetto esistente
			newPack = false;
			//permette di mantenere i campi del pacchetto selezionato. Usato nei getter
			modifyForField=true;
			setFields();
			//Indica che in base alla configurazione del file facesConfig occorre reindirizzare alla pagina
			//di modifica del pacchetto
			return "notBusy";
			
			
		}
		
		else 
		{	//Indica che in base alla configurazione del file facesConfig occorre reindirizzare alla pagina
			//di errore
			
			return "errorBusy";
		}
	}
	//Usato per memorizzare i campi in packageEdit.xhtml in seguito a flussi di navigazione che avvengono tramite Bean diversi
	public void setFields(ActionEvent e)
	{
		this.setTime_start(time_start);
		this.setTime_end(time_end);
		this.setDescription(description);
		this.setName(name);
		
	}
	public void setFields()
	{
		this.setTime_start(time_start);
		this.setTime_end(time_end);
		this.setDescription(description);
		this.setName(name);
		
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
			//indica che sto lavorando su un nuovo pacchetto
			newPack = true;
			//permette di svuotare i campi. Usato nei getter
			newForField=true;
			setFields();
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
	
	/**
	 * Metodo che rende persistenti le operazioni di modifica o inserimento pacchetto
	 * @return
	 */
	public String editPackage()
	{
		consistency = new ConsistencyChecker();
		if(newPack)
		{
			
			currentTravelPackage.setName(name);
			currentTravelPackage.setDescription(description);
			currentTravelPackage.setTime_start(time_start);
			currentTravelPackage.setTime_end(time_end);
			if(!consistency.correctPackageWeak(currentTravelPackage))
				return "inconsistentPackage";
			packageCRUD.createTravelFromEmployee(currentTravelPackage);
			shared.setBusy(false);
			return "insertSuccess";
			
		}
		else
		{

			currentTravelPackage.setName(name);
			currentTravelPackage.setDescription(description);
			currentTravelPackage.setTime_start(time_start);
			currentTravelPackage.setTime_end(time_end);
			if(!consistency.correctPackageWeak(currentTravelPackage))
				return "inconsistentPackage";
			
			packageCRUD.updateTravelPackage(currentTravelPackage);
			shared.setBusy(false);
			return "modifySuccess";
			
		}
		
		
		
	}
	
	/**
	 * Metodo che rende persistente la creazione del pacchetto personalizzato
	 * @return
	 */
	public String purchasePersonalized()
	{
		currentTravelPackage.setName(name);
		currentTravelPackage.setDescription(description);
		currentTravelPackage.setTime_start(time_start);
		currentTravelPackage.setTime_end(time_end);
		if(!consistency.correctPackageWeak(currentTravelPackage))
			return "inconsistentPackage";
		
		
		packageCRUD.createCustomizedTravelPackageFromCustomer(new CustomizedTravelPackageDTO(currentTravelPackage));
		
		return "createdCustomized";
		
		
		
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
	
	public ArrayList<StageDTO> getFilteredStages() {
		return filteredStages;
	}
	public void setFilteredStages(ArrayList<StageDTO> filteredStages) {
		this.filteredStages = filteredStages;
	}
	public StageDataModel getStageModel() {
		return stageModel;
	}
	public void setStageModel(StageDataModel stageModel) {
		this.stageModel = stageModel;
	}
	
	public Date getTime_start() {
		if(modifyForField)
			return currentTravelPackage.getTime_start();
		if(newForField)
			return null;
		return time_start;
	}
	public void setTime_start(Date time_start) {
		if(modifyForField)
			this.time_start= currentTravelPackage.getTime_start();
		else if(newForField)
			this.time_start=null;
		else
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
		if(modifyForField)
			this.time_end= currentTravelPackage.getTime_end();
		else if(newForField)
			this.time_end=null;
		else
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
		if(modifyForField)
			this.description= currentTravelPackage.getDescription();
		else if(newForField)
			this.description=null;
		else
		this.description = description;
	}
	public String getName() {
		
		
		return name;
	}
	public void setName(String name) {
		if(modifyForField)
			this.name= currentTravelPackage.getName();
		else if(newForField)
			this.name=null;
		else
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

	public PurchaseGiftListBeanLocal getPurchase() {
		return purchase;
	}

	public void setPurchase(PurchaseGiftListBeanLocal purchase) {
		this.purchase = purchase;
	}

	public ConsistencyChecker getConsistency() {
		return consistency;
	}

	public void setConsistency(ConsistencyChecker consistency) {
		this.consistency = consistency;
	}
	
	
		
	
	
}
