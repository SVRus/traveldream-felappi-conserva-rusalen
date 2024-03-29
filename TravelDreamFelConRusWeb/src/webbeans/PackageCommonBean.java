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
import dto.ProductDTO;
import dto.HotelDTO;
import dto.StageDTO;
import dto.PrepackedTravelPackageDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="packageCommon")
@SessionScoped

public class PackageCommonBean implements Serializable{
	
	
	private PrepackedTravelPackageDTO currentPackage;
	/*diventa il vero travelPackageCorrente solo se 
	 *non c'� un'altra creazione in corso 
	 */
	private PrepackedTravelPackageDTO tempCurrentPackage;
	
	//da usare quando si aggiunge una tappa. Verr� prelevato dal PackageEdit
	private StageDTO currentStage;
	
	/*diventa il vero Stage corrente solo se 
	 *non c'� un'altra creazione in corso 
	 */
	
	private StageDTO tempCurrentStage;
	
	//tengo memorizzato lo stage precedente in vista di operazioni di modifica
	private StageDTO stageToDeleteForModify;
	
	
	
	//Da usare per il controllo delle operazioni in corso
	private boolean busy;
	private boolean busyStage;
	
	/* Indica se � appena stato aggiunto uno stage. Da usare nel 
	 * managedBean packageEdit
	 */
	private boolean StageUpdated;
	
	/*
	 * Indica se l'operazione sullo stage � una modifica o un inserimento
	 */
	private boolean newStage;
	
	
	public void updatePackage()
	{
		currentPackage = tempCurrentPackage;
		
	}
	public void updateStage()
	{
		currentStage = tempCurrentStage;
		
	}
	
	
	
	public PackageCommonBean() {
		
		/*FlightDTO volo = new FlightDTO(11, null, "volo strano", 11, new Date(),  new Date(), State.AVAILABLE, "Germania", "Francia", "Berlino", "Parigi", "scemo chi legge", "ciao");
		List<ProductDTO> lista = new ArrayList<ProductDTO>();
		lista.add(volo);
		
		currentStage = new StageDTO( (ArrayList<ProductDTO>) lista, "Germania", new Date(),new Date());	
		
		System.out.println("Ho inizializzato");
	*/
	}
	
	public void aggiorna()
	{
		/*FlightDTO volo = new FlightDTO(11, null, "volo strano", 11, new Date(), new Date(), State.AVAILABLE, "Germania", "Francia", "Berlino", "Parigi", "scemo chi legge", "ciao");
		List<ProductDTO> lista = new ArrayList<ProductDTO>();
		lista.add(volo);
		currentStage = new StageDTO( (ArrayList<ProductDTO>) lista, "Germania",new Date(),new Date());		
		System.out.println("Ho inizializzato lo stage");
		*/
	}
	
	
	public PrepackedTravelPackageDTO getCurrentPackage() {
		return currentPackage;
	}
	public void setCurrentPackage(PrepackedTravelPackageDTO currentPackage) {
		this.currentPackage = currentPackage;
	}
	public PrepackedTravelPackageDTO getTempCurrentPackage() {
		return tempCurrentPackage;
	}
	public void setTempCurrentPackage(PrepackedTravelPackageDTO tempCurrentPackage) {
		this.tempCurrentPackage = tempCurrentPackage;
	}
	public StageDTO getCurrentStage() {
		return currentStage;
	}
	public void setCurrentStage(StageDTO currentStage) {
		this.currentStage = currentStage;
	}
	public StageDTO getTempCurrentStage() {
		return tempCurrentStage;
	}
	public void setTempCurrentStage(StageDTO tempCurrentStage) {
		this.tempCurrentStage = tempCurrentStage;
	}
	public boolean isBusy() {
		return busy;
	}
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	public boolean isBusyStage() {
		return busyStage;
	}
	public void setBusyStage(boolean busyStage) {
		this.busyStage = busyStage;
	}
	public boolean isStageUpdated() {
		return StageUpdated;
	}
	public void setStageUpdated(boolean stageUpdated) {
		StageUpdated = stageUpdated;
	}
	public boolean isNewStage() {
		return newStage;
	}
	public void setNewStage(boolean newStage) {
		this.newStage = newStage;
	}
	public StageDTO getStageToDeleteForModify() {
		return stageToDeleteForModify;
	}
	public void setStageToDeleteForModify(StageDTO stageToDeleteForModify) {
		this.stageToDeleteForModify = stageToDeleteForModify;
	}
	
	
	
	

}
