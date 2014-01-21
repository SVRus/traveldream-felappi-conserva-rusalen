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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.context.RequestContext;

import productManagement.ProductCRUDBeanLocal;
import stateenum.State;
import userManagement.GenericUserManagementBeanLocal;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.ProductDTO;
import dto.HotelDTO;
import dto.StageDTO;
import dto.TravelPackageDTO;

import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="packageManagement")
@ViewScoped

public class PackageManagementBean implements Serializable{


private Calendar time_end;

private Calendar time_start;
private String description;
private String name;
private List<StageDTO> stages;
private TravelPackageDTO selectedTravelPackage;

//non so se sia ridondante rispetto a packageList
private List<TravelPackageDTO> TravelPackages;

private  List<TravelPackageDTO> filteredTravelPackages;



private String friendCode;

private Calendar purchaseTime;

private TravelPackageDataModel packageModel;

private List<TravelPackageDTO> packageList;


@PostConstruct
public void update()
{
ArrayList<ProductDTO> prodotti = new ArrayList<ProductDTO>();
prodotti.add(new HotelDTO(11, "Gianni", "Marina", 33,new GregorianCalendar(), new GregorianCalendar(), "Africa", "Etiopia", "brutta" , "Bud Spencer",State.AVAILABLE));
prodotti.add(new HotelDTO(11, "Gianni", "Marina", 33,new GregorianCalendar(), new GregorianCalendar(), "Africa", "Etiopia", "brutta" , "Bud Spencer",State.AVAILABLE));

StageDTO stage= new StageDTO(prodotti, "Africa");	
ArrayList<StageDTO> listaStage = new ArrayList<StageDTO>();

listaStage.add(stage);
packageList= new ArrayList<TravelPackageDTO>();
packageList.add(new TravelPackageDTO(new GregorianCalendar(), new GregorianCalendar(), "Io sto con gli ippopotami", "Ippo", listaStage, "11", "22", "33", new GregorianCalendar()));
packageModel= new TravelPackageDataModel(packageList);
System.out.println("Ciao ho popolato i pacchetti");

}



public Calendar getTime_end() {
	return time_end;
}

public void setTime_end(Calendar time_end) {
	this.time_end = time_end;
}

public Calendar getTime_start() {
	return time_start;
}

public void setTime_start(Calendar time_start) {
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

public String getFriendCode() {
	return friendCode;
}

public void setFriendCode(String friendCode) {
	this.friendCode = friendCode;
}

public Calendar getPurchaseTime() {
	return purchaseTime;
}

public void setPurchaseTime(Calendar purchaseTime) {
	this.purchaseTime = purchaseTime;
}

public TravelPackageDataModel getPackageModel() {
	return packageModel;
}

public void setPackageModel(TravelPackageDataModel packageModel) {
	this.packageModel = packageModel;
}



public TravelPackageDTO getSelectedTravelPackage() {
	return selectedTravelPackage;
}



public void setSelectedTravelPackage(TravelPackageDTO selectedTravelPackage) {
	this.selectedTravelPackage = selectedTravelPackage;
}



public List<TravelPackageDTO> getFilteredTravelPackages() {
	return filteredTravelPackages;
}



public void setFilteredTravelPackages(
		List<TravelPackageDTO> filteredTravelPackages) {
	this.filteredTravelPackages = filteredTravelPackages;
}



public List<TravelPackageDTO> getPackageList() {
	return packageList;
}



public void setPackageList(List<TravelPackageDTO> packageList) {
	this.packageList = packageList;
}



public List<TravelPackageDTO> getTravelPackages() {
	return TravelPackages;
}



public void setTravelPackages(List<TravelPackageDTO> travelPackages) {
	TravelPackages = travelPackages;
}


	
	
	

}
