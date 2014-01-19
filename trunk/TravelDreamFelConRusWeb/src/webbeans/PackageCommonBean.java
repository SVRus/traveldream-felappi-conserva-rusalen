package webbeans;
import java.io.Serializable;
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
import dto.ProductDTO;
import dto.HotelDTO;
import dto.StageDTO;
import dto.TravelPackageDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="packageCommon")
@SessionScoped

public class PackageCommonBean implements Serializable{
	private TravelPackageDTO currentPackage;
	private StageDTO currentStage;
	
	
	
	
	
	public PackageCommonBean() {
		FlightDTO 
		
	}
	public TravelPackageDTO getCurrentPackage() {
		return currentPackage;
	}
	public void setCurrentPackage(TravelPackageDTO currentPackage) {
		this.currentPackage = currentPackage;
	}
	public StageDTO getCurrentStage() {
		return currentStage;
	}
	public void setCurrentStage(StageDTO currentStage) {
		this.currentStage = currentStage;
	}
	
	

}