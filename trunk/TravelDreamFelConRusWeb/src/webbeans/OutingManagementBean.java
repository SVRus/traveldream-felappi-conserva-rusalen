package webbeans;
import java.io.Serializable;
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
import userManagement.GenericUserManagementBeanLocal;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.OutingDTO;
import dto.OutingDTO;
import dto.OutingDTO;
import dto.ProductDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

@ManagedBean(name="outingManagement")
@ViewScoped
public class OutingManagementBean {
	private OutingDTO selectedOuting;
	private OutingDTO[] selectedOutings;  
	private OutingDTO newOuting;
	


	private long idtravelpackage;
	 private String employeeCreator;
	 private long idProduct;
	 private String name;
	 private float cost;
	 private Date timeStart;
	 private Date timeEnd;
	 private String area;
	 private String place;
	 private String room_type;
	 private String more_info;
	  private OutingDataModel outingModel;  
	  public OutingDataModel getOutingModel() {
		return outingModel;
	}



	@EJB
	  private ProductCRUDBeanLocal productCRUD;
	  
	  
	  //valori di prova
	  static GregorianCalendar data1= new GregorianCalendar();
		 private  List<OutingDTO> outings;
	  private  List<OutingDTO> filteredOutings;
	  
	  
	  @PostConstruct
	  public void update()
	  {
		
	  outings
	  = productCRUD.findAllOutings();
	  outingModel = new OutingDataModel(outings);  

	  }
	  
	 
	  
	  public void newOuting(ActionEvent actionEvent)
	  {
			newOuting = new OutingDTO(23, name, name, 23, data1, data1,
					name, name, State.AVAILABLE);
			productCRUD.createProduct(newOuting);
			System.out.println("avrei dovuto creare un outing");
			outings.add(newOuting);
		
		  
	  }
	  public void deleteOuting(ActionEvent actionEvent) {
			
		    productCRUD.delete(selectedOuting);
		    outings.remove(selectedOuting);
		    
		   }
	  public void updateOuting(ActionEvent actionEvent){
			
				outings.remove(selectedOuting);
			   newOuting = new OutingDTO(23, selectedOuting.getName(), selectedOuting.getName(), 23, data1, data1,
					   selectedOuting.getName(), selectedOuting.getName(), State.AVAILABLE);
				productCRUD.updateProduct(newOuting);
				System.out.println("avrei dovuto creare un outing");
				outings.add(newOuting);
			   
		   }
	  

		public void setOutingModel(OutingDataModel outingModel) {
			this.outingModel = outingModel;
		}
	public long getIdtravelpackage() {
		return idtravelpackage;
	}
	public void setIdtravelpackage(long idtravelpackage) {
		this.idtravelpackage = idtravelpackage;
	}
	public String getEmployeeCreator() {
		return employeeCreator;
	}
	public void setEmployeeCreator(String employeeCreator) {
		this.employeeCreator = employeeCreator;
	}
	public long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getMore_info() {
		return more_info;
	}
	public void setMore_info(String more_info) {
		this.more_info = more_info;
	}
	
	public ProductCRUDBeanLocal getProductCRUD() {
		return productCRUD;
	}
	public void setProductCRUD(ProductCRUDBeanLocal productCRUD) {
		this.productCRUD = productCRUD;
	}
	public static GregorianCalendar getData1() {
		return data1;
	}
	public static void setData1(GregorianCalendar data1) {
		OutingManagementBean.data1 = data1;
	}
	public List<OutingDTO> getOutings() {
		return outings;
	}
	public void setOutings(List<OutingDTO> outings) {
		this.outings = outings;
	}
	public List<OutingDTO> getFilteredOutings() {
		return filteredOutings;
	}
	public void setFilteredOutings(List<OutingDTO> filteredOutings) {
		this.filteredOutings = filteredOutings;
	}
	public OutingDTO getSelectedOuting() {
		return selectedOuting;
	}



	public void setSelectedOuting(OutingDTO selectedOuting) {
		this.selectedOuting = selectedOuting;
	}



	public OutingDTO[] getSelectedOutings() {
		return selectedOutings;
	}



	public void setSelectedOutings(OutingDTO[] selectedOutings) {
		this.selectedOutings = selectedOutings;
	}



	public OutingDTO getNewOuting() {
		return newOuting;
	}



	public void setNewOuting(OutingDTO newOuting) {
		this.newOuting = newOuting;
	}

	 
}