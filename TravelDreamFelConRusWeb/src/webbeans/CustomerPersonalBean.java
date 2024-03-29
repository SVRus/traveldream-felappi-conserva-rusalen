package webbeans;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import travelPackageManagement.TravelPackageCRUDBeanLocal;
import travelstateenum.TravelState;
import dto.CustomerDTO;
import dto.CustomizedTravelPackageDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
import dto.StageDTO;
import dto.TravelPackageDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;


@ManagedBean(name="customerPersonal")
@ViewScoped
public class CustomerPersonalBean {
	private String	firstName;

	private String lastName;
	private String email;
	//private int phoneNumber;
	private Date birthdate;
	private String friendCode;
	private String message;
	
	private CustomizedTravelPackageDTO selectedTravelPackage;

	private  List<CustomizedTravelPackageDTO> filteredTravelPackages;


	private List<CustomizedTravelPackageDTO> packageList;


	private CustomizedTravelPackageDataModel packageModel;
	
	private List<TravelPackageDTO> allPackages;
	


	@EJB
	private TravelPackageCRUDBeanLocal packageCRUD;
	
	@EJB
	private LoginBeanLocal login;
	
	@PostConstruct
	public void update()
	{

	/*
	 * aggiorna la lista dei pacchetti personalizzati acquistati dall'utente	
	 */
	packageList= new ArrayList<CustomizedTravelPackageDTO>();
	packageList.addAll(packageCRUD.findAllCustomizedForCustomer());
	packageModel= new CustomizedTravelPackageDataModel(packageList);
	allPackages = packageCRUD.findAllPackageForCustomer();
	
	}
	
	public void modify(ActionEvent e)
	{
		CustomerDTO cus = (CustomerDTO) login.findLogIn();
		cus.setEmail(email);
		cus.setName(firstName);
		cus.setSurname(lastName);
		if(login.updateCustomer(cus))
		{
			message= "Dati correttamente aggiornati";
			return;
		}
		message= "Si � verificato un errore durante l'aggiornamento";
		
		
		
	}
	public void modify()
	{
		CustomerDTO cus = (CustomerDTO) login.findLogIn();
		cus.setEmail(email);
		cus.setName(firstName);
		cus.setSurname(lastName);
		if(login.updateCustomer(cus))
		{
			message= "Dati correttamente aggiornati";
			return;
		}
		message= "Si � verificato un errore durante l'aggiornamento";
		
		
		
	}
	
	public void viewCode(ActionEvent e)
	{
		friendCode = packageCRUD.createCustomizedTravelPackageForFriend(selectedTravelPackage);
		return;
		
	}


	public String getFirstName() {
		return login.findLogIn().getName();
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return login.findLogIn().getSurname();
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return login.findLogIn().getEmail();
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public CustomizedTravelPackageDTO getSelectedTravelPackage() {
		return selectedTravelPackage;
	}


	public void setSelectedTravelPackage(
			CustomizedTravelPackageDTO selectedTravelPackage) {
		this.selectedTravelPackage = selectedTravelPackage;
	}


	public List<CustomizedTravelPackageDTO> getFilteredTravelPackages() {
		return filteredTravelPackages;
	}


	public void setFilteredTravelPackages(
			List<CustomizedTravelPackageDTO> filteredTravelPackages) {
		this.filteredTravelPackages = filteredTravelPackages;
	}


	public List<CustomizedTravelPackageDTO> getPackageList() {
		return packageList;
	}


	public void setPackageList(List<CustomizedTravelPackageDTO> packageList) {
		this.packageList = packageList;
	}


	public CustomizedTravelPackageDataModel getPackageModel() {
		return packageModel;
	}


	public void setPackageModel(CustomizedTravelPackageDataModel packageModel) {
		this.packageModel = packageModel;
	}


	public TravelPackageCRUDBeanLocal getPackageCRUD() {
		return packageCRUD;
	}


	public void setPackageCRUD(TravelPackageCRUDBeanLocal packageCRUD) {
		this.packageCRUD = packageCRUD;
	}
	public String getFriendCode() {
		return friendCode;
	}
	public void setFriendCode(String friendCode) {
		this.friendCode = friendCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<TravelPackageDTO> getAllPackages() {
		return allPackages;
	}

	public void setAllPackages(List<TravelPackageDTO> allPackages) {
		this.allPackages = allPackages;
	}

	public LoginBeanLocal getLogin() {
		return login;
	}

	public void setLogin(LoginBeanLocal login) {
		this.login = login;
	}
	
	
	
	
	



	
	
	
	
	

}
