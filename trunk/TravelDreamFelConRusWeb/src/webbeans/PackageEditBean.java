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

@ManagedBean(name="packageEdit")
@SessionScoped

public class PackageEditBean {

	@ManagedProperty(value="#{packageCommon}")
	private PackageCommonBean shared;
	
	private TravelPackageDTO currentTravelPackage;

	@PostConstruct
	public void update()
	{
		/* Se ho fatto accesso alla pagina di edit tramite
		 * la pagina contenente tutti i pacchetti, devo aggiornare
		 * il pacchetto corrente
		 */
			System.out.println("ciao ho eseguito il post construct");
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
		
		return "closed";
	}
	

	public TravelPackageDTO getCurrentTravelPackage() {
		return currentTravelPackage;
	}

	public void setCurrentTravelPackage(TravelPackageDTO currentTravelPackage) {
		this.currentTravelPackage = currentTravelPackage;
	}

	public PackageCommonBean getShared() {
		return shared;
	}

	public void setShared(PackageCommonBean shared) {
		this.shared = shared;
	}
	
	
}
