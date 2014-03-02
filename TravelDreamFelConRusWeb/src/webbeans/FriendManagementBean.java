package webbeans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.util.Date;
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
import purchase.PurchaseGiftListBeanLocal;
import stateenum.State;
import travelPackageManagement.TravelPackageCRUDBeanLocal;
import travelstateenum.TravelState;
import dto.CustomerDTO;
import dto.CustomizedTravelPackageDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.ProductDTO;
import dto.HotelDTO;
import dto.StageDTO;
import dto.PrepackedTravelPackageDTO;
import exceptions.FriendNotFoundException;
import exceptions.GiftListNotFoundException;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;
/**
 * Classe che gestisce le funzionalità adibite al flusso di navigazione di un invitato,
 * quali la verifica della disponibilità di un pacchetto e i corretti reindirizzamenti
 * in caso di utente non loggato.
 * @author Giovanni 
 *
 */
@ManagedBean(name="friendManagement")
@SessionScoped

public class FriendManagementBean implements Serializable{


private Date time_end;
private Date time_start;
private String description;
private String name;
private List<StageDTO> stages;

private PrepackedTravelPackageDTO selectedTravelPackage;

private  List<PrepackedTravelPackageDTO> filteredTravelPackages;


private List<PrepackedTravelPackageDTO> packageList;
private List<PrepackedTravelPackageDTO> packageListAvailable;


private String friendCode;

private Date purchaseTime;

private PrepackedTravelPackageDataModel packageModel;
private PrepackedTravelPackageDataModel packageModelAvailable;

//Pacchetto che verrà usato come scheletro per l'acquisto di un nuovo pacchetto
private CustomizedTravelPackageDTO packageClone;



@EJB
private TravelPackageCRUDBeanLocal packageCRUD;



@ManagedProperty(value="#{packageEdit}")
private PackageEditBean packBean;

@ManagedProperty(value="#{customerPackageEdit}")
private CustomerPackageEditBean customerPackBean;

@EJB
private LoginBeanLocal login;





/**
 * Metodo che controlla la corrispondenza tra il codice inserito 
 * e il pacchetto, e che esistano pacchetti clone disponibili.
 * Viene richiamato quando si inserisce il codice pacchetto dalla pagina di index
 * 
 * @return
 */
public String checkFriendCode()
{
	try { 
		
		packageClone = login.checkFriendException(friendCode);
		if(packageCRUD.getNumberEquivalentPackage(packageClone)==0 )
			return "friendSoldOut";	 
		
		
		packBean.setTempCurrentPackage(new PrepackedTravelPackageDTO(packageClone));
		
		String temp= packBean.show();
		
		return "friendCodeCorrect";
		
	} catch (FriendNotFoundException e) {
		
		return "friendCodeError";

	}	
}

/**
 * Metodo che controlla la corrispondenza tra il codice inserito 
 * e il pacchetto, e che esistano pacchetti clone disponibili.
 * Viene richiamato quando si inserisce il codice pacchetto dalla pagine personale di customer.
 * 
 * @return
 */

public String checkFriendCodeByLogged()
{
	try { 
		
		packageClone = login.checkFriendException(friendCode);
		if(packageCRUD.getNumberEquivalentPackage(packageClone)==0 )
			return "friendSoldOut";
		
	customerPackBean.setTempCurrentPackage(new PrepackedTravelPackageDTO(packageClone));
	String temp= customerPackBean.show();
	
	return "friendCodeCorrect";
		
	} catch (FriendNotFoundException e) {
		
		return "friendCodeError";

	}	
}





public void update()
{

packageList= new ArrayList<PrepackedTravelPackageDTO>();
packageList.addAll(packageCRUD.findAllPrepacked());
packageListAvailable= new ArrayList<PrepackedTravelPackageDTO>();
packageListAvailable.addAll(packageCRUD.findAllPrepackedTravelPackageByParameter(TravelState.AVAILABLE));

packageModel= new PrepackedTravelPackageDataModel(packageList);
packageModelAvailable= new PrepackedTravelPackageDataModel(packageList);



}
public void updateCurrentPackage()
{
	packBean.setTempCurrentPackage(selectedTravelPackage);
	
}


public void deletePackage(ActionEvent actionEvent) {
	if(selectedTravelPackage==null)
		return;
    packageCRUD.delete(selectedTravelPackage);
    packageList= packageCRUD.findAllPrepacked();
	packageModel=new PrepackedTravelPackageDataModel(packageList);
   
   }

public Date getTime_end() {
	return time_end;
}
public void setTime_end(Date time_end) {
	this.time_end = time_end;
}
public Date getTime_start() {
	return time_start;
}
public void setTime_start(Date time_start) {
	this.time_start = time_start;
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
}
public List<StageDTO> getStages() {
	return stages;
}
public void setStages(List<StageDTO> stages) {
	this.stages = stages;
}
public PrepackedTravelPackageDTO getSelectedTravelPackage() {
	return selectedTravelPackage;
}
public void setSelectedTravelPackage(
		PrepackedTravelPackageDTO selectedTravelPackage) {
	this.selectedTravelPackage = selectedTravelPackage;
}

public List<PrepackedTravelPackageDTO> getFilteredTravelPackages() {
	return filteredTravelPackages;
}
public void setFilteredTravelPackages(
		List<PrepackedTravelPackageDTO> filteredTravelPackages) {
	this.filteredTravelPackages = filteredTravelPackages;
}
public String getFriendCode() {
	return friendCode;
}
public void setFriendCode(String friendCode) {
	this.friendCode = friendCode;
}
public Date getPurchaseTime() {
	return purchaseTime;
}
public void setPurchaseTime(Date purchaseTime) {
	this.purchaseTime = purchaseTime;
}
public PrepackedTravelPackageDataModel getPackageModel() {
	return packageModel;
}
public void setPackageModel(PrepackedTravelPackageDataModel packageModel) {
	this.packageModel = packageModel;
}
public List<PrepackedTravelPackageDTO> getPackageList() {
	return packageList;
}
public void setPackageList(List<PrepackedTravelPackageDTO> packageList) {
	this.packageList = packageList;
}
public TravelPackageCRUDBeanLocal getPackageCRUD() {
	return packageCRUD;
}
public void setPackageCRUD(TravelPackageCRUDBeanLocal packageCRUD) {
	this.packageCRUD = packageCRUD;
}

public PackageEditBean getPackBean() {
	return packBean;
}
public void setPackBean(PackageEditBean packBean) {
	this.packBean = packBean;
}
public List<PrepackedTravelPackageDTO> getPackageListAvailable() {
	return packageListAvailable;
}
public void setPackageListAvailable(
		List<PrepackedTravelPackageDTO> packageListAvailable) {
	this.packageListAvailable = packageListAvailable;
}
public PrepackedTravelPackageDataModel getPackageModelAvailable() {
	return packageModelAvailable;
}
public void setPackageModelAvailable(
		PrepackedTravelPackageDataModel packageModelAvailable) {
	this.packageModelAvailable = packageModelAvailable;
}



public CustomizedTravelPackageDTO getPackageClone() {
	return packageClone;
}

public void setPackageClone(CustomizedTravelPackageDTO packageClone) {
	this.packageClone = packageClone;
}

public LoginBeanLocal getLogin() {
	return login;
}

public void setLogin(LoginBeanLocal login) {
	this.login = login;
}

public CustomerPackageEditBean getCustomerPackBean() {
	return customerPackBean;
}

public void setCustomerPackBean(CustomerPackageEditBean customerPackBean) {
	this.customerPackBean = customerPackBean;
}


	
	

}

