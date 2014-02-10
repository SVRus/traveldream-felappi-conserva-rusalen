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

@ManagedBean(name="customerPackageManagement")
@SessionScoped

public class CustomerPackageManagementBean implements Serializable{


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Date time_end;
private Date time_start;
private String description;
private String name;
private List<StageDTO> stages;

private PrepackedTravelPackageDTO selectedTravelPackage;

private  List<PrepackedTravelPackageDTO> filteredTravelPackages;


private List<PrepackedTravelPackageDTO> packageList;



private String friendCode;

private Date purchaseTime;

private PrepackedTravelPackageDataModel packageModel;



@EJB
private TravelPackageCRUDBeanLocal packageCRUD;



@ManagedProperty(value="#{customerPackageEdit}")
private CustomerPackageEditBean packBean;


public void update()
{

packageList= new ArrayList<PrepackedTravelPackageDTO>();
packageList.addAll(packageCRUD.findAllPrepackedTravelPackageByParameter(TravelState.AVAILABLE));

packageModel= new PrepackedTravelPackageDataModel(packageList);

}
public void updateCurrentPackage()
{
	packBean.setTempCurrentPackage(selectedTravelPackage);
	System.out.println("Ho modificato il pacchetto corrente");
	
}


public void deletePackage(ActionEvent actionEvent) {
	
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

public CustomerPackageEditBean getPackBean() {
	return packBean;
}
public void setPackBean(CustomerPackageEditBean packBean) {
	this.packBean = packBean;
}


	
	

}

