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

@ManagedBean(name="packageManagement")
@SessionScoped

public class PackageManagementBean implements Serializable{


private Date time_end;

private Date time_start;
private String description;
private String name;
private List<StageDTO> stages;
private PrepackedTravelPackageDTO selectedTravelPackage;

//non so se sia ridondante rispetto a packageList
private List<PrepackedTravelPackageDTO> TravelPackages;

private  List<PrepackedTravelPackageDTO> filteredTravelPackages;



private String friendCode;

private Date purchaseTime;

private PrepackedTravelPackageDataModel packageModel;

private List<PrepackedTravelPackageDTO> packageList;
@EJB
private TravelPackageCRUDBeanLocal packageCRUD;


@ManagedProperty(value="#{packageCommon}")
private PackageCommonBean shared;

@ManagedProperty(value="#{packageEdit}")
private PackageEditBean packBean;

@PostConstruct
public void update()
{
/*
	ArrayList<ProductDTO> prodotti = new ArrayList<ProductDTO>();
prodotti.add(new HotelDTO(11, "Gianni", "Marina", 33,new Date(), new Date(), State.AVAILABLE, "Etiopia", "brutta" , "Bud Spencer","Africa"));
prodotti.add(new HotelDTO(11, "Gianni", "Marina", 33,new Date(), new Date(), State.AVAILABLE, "Etiopia", "brutta" , "Bud Spencer","Africa"));

StageDTO stage= new StageDTO(prodotti, "Africa", new Date(), new Date());	
ArrayList<StageDTO> listaStage = new ArrayList<StageDTO>();

listaStage.add(stage);
*/
packageList= new ArrayList<PrepackedTravelPackageDTO>();
//packageList.add(new PrepackedTravelPackageDTO(new Date(), new Date(), "Io sto con gli ippopotami", "Ippo", listaStage, "11", "22", new Date(),"ciao", TravelState.AVAILABLE));
//packageList.add(new PrepackedTravelPackageDTO(new Date(), new Date(), "Viaggio su marte", "Mission to mars", listaStage, "11", "22", new Date(),"ciao", TravelState.AVAILABLE));
packageList.addAll(packageCRUD.findAllPrepacked());

packageModel= new PrepackedTravelPackageDataModel(packageList);
System.out.println("Ciao ho popolato i pacchetti");

}
public void updateCurrentPackage()
{
	packBean.setTempCurrentPackage(selectedTravelPackage);
	System.out.println("Ho modificato il pacchetto corrente");
	
}


public void deletePackage(ActionEvent actionEvent) {
	
    packageCRUD.delete(selectedTravelPackage);
	TravelPackages= packageCRUD.findAllPrepacked();
	packageModel=new PrepackedTravelPackageDataModel(TravelPackages);
   
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
public List<PrepackedTravelPackageDTO> getTravelPackages() {
	return TravelPackages;
}
public void setTravelPackages(List<PrepackedTravelPackageDTO> travelPackages) {
	TravelPackages = travelPackages;
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
public PackageCommonBean getShared() {
	return shared;
}
public void setShared(PackageCommonBean shared) {
	this.shared = shared;
}
public PackageEditBean getPackBean() {
	return packBean;
}
public void setPackBean(PackageEditBean packBean) {
	this.packBean = packBean;
}


	
	

}
