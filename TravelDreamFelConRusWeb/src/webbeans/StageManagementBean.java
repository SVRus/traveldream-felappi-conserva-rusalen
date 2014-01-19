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
import javax.faces.bean.ManagedProperty;
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
import dto.FlightDTO;
import dto.GiftListDTO;
import dto.ProductDTO;
import dto.HotelDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="stageManagement")
@ViewScoped

public class StageManagementBean {
	private FlightDTO flightStart;
	private StageHelper stageHelper;
	private List<FlightDTO> flightList;
	
	@ManagedProperty(value="#{PackageCommon}")
	private PackageCommonBean common;
	
	@PostConstruct
	  public void update()
	  {
		common.aggiorna();
		stageHelper= new StageHelper(common.getCurrentStage());	
	  
		flightStart= stageHelper.flightStart();
		flightList.add(flightStart);
	  System.out.println("sono in stage management");
	  

	  }
	
	  
	
	
	public PackageCommonBean getCommon() {
		return common;
	}
	public void setCommon(PackageCommonBean common) {
		this.common = common;
	}



	public FlightDTO getFlightStart() {
		return flightStart;
	}



	public void setFlightStart(FlightDTO flightStart) {
		this.flightStart = flightStart;
	}



	public StageHelper getStageHelper() {
		return stageHelper;
	}



	public void setStageHelper(StageHelper stageHelper) {
		this.stageHelper = stageHelper;
	}
	
	
	

}
