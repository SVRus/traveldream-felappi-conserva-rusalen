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
	
	private CustomizedTravelPackageDTO selectedTravelPackage;

	private  List<CustomizedTravelPackageDTO> filteredTravelPackages;


	private List<CustomizedTravelPackageDTO> packageList;


	private CustomizedTravelPackageDataModel packageModel;


	@EJB
	private TravelPackageCRUDBeanLocal packageCRUD;
	
	@PostConstruct
	public void update()
	{

	packageList= new ArrayList<CustomizedTravelPackageDTO>();
	packageList.addAll(packageCRUD.findAllCustomizedForCustomer());
	packageModel= new CustomizedTravelPackageDataModel(packageList);

	}
	public void viewCode(ActionEvent e)
	{
		friendCode = packageCRUD.createCustomizedTravelPackageForFriend(selectedTravelPackage);
		return;
		
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
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
	
	
	
	
	



	
	
	
	
	

}
