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
	 private String description;
	 private String more_info;
	 
	 private String messageDelete;
	 private String messageModify;
	 
	  private OutingDataModel outingModel;  
	  public OutingDataModel getOutingModel() {
		return outingModel;
	}



	@EJB
	  private ProductCRUDBeanLocal productCRUD;
	
	@EJB
	private LoginBeanLocal login;
	  
	  
	  //valori di prova
	  static Date data1= new Date();
	  private  List<OutingDTO> outings;
	  private  List<OutingDTO> filteredOutings;
	  
	  
	  @PostConstruct
	  public void update()
	  {
		
	  outings = productCRUD.findAllOutings();
	  outingModel = new OutingDataModel(outings);  

	  }
	  
	 
	  
	  public void newOuting(ActionEvent actionEvent)
	  {
		  if (	    name != null && !name.isEmpty() &&
					Float.toString(cost) != null && 
					timeStart != null && !timeStart.toString().isEmpty() &&
					timeEnd != null && !timeEnd.toString().isEmpty() &&
					timeStart.before(timeEnd) &&
					area != null && !area.isEmpty() &&
					place != null && !place.isEmpty() &&
					description != null && ! description.isEmpty() 
					)
		  {
			newOuting = new OutingDTO((long) 0, login.getPrincipalUsername(), name, cost,  timeStart,  timeEnd,  
					    description, area, State.AVAILABLE,place);
			productCRUD.createProduct(newOuting);
			System.out.println("Escursione creata.");
			//outings.add(newOuting);
			outings= productCRUD.findAllOutings();
			outingModel=new OutingDataModel(outings);
		  }
		
		  
	  }
	  public void deleteOuting(ActionEvent actionEvent) {
		  
		    if(selectedOuting.getState()==State.AVAILABLE)
		    	messageDelete="Prodotto eliminato correttamente";
		    if(selectedOuting.getState()==State.INCLUDED)
		    	messageDelete="Il prodotto è stato eliminato. E'stato eliminato anche il pacchetto ad esso associato." ;
		    if(selectedOuting.getState()==State.SOLD)
		    	messageDelete="Il prodotto eliminato era venduto. Il prodotto rimarrà nel sistema, ma è stata inviata una notifica al cliente.";
		    if(selectedOuting.getState()==State.RESERVED)
		    	messageDelete="Il prodotto eliminato era in una gift list. Il prodotto rimarrà nel sistema, ma è stata inviata una notifica al cliente.";
		   
			
		    productCRUD.delete(selectedOuting);
		   // outings.remove(selectedOuting);
		    outings= productCRUD.findAllOutings();
			outingModel=new OutingDataModel(outings);
		    
		   }
	  public void updateOuting(ActionEvent actionEvent){
			
		  if (	    selectedOuting.getName() != null && !selectedOuting.getName().isEmpty() &&
					Float.toString(selectedOuting.getCost()) != null && 
					selectedOuting.getTimeStart() != null && !selectedOuting.getTimeStart().toString().isEmpty() &&
					selectedOuting.getTimeEnd() != null && !selectedOuting.getTimeEnd().toString().isEmpty() &&
					selectedOuting.getTimeStart().before(selectedOuting.getTimeEnd()) &&
					selectedOuting.getArea() != null && !selectedOuting.getArea().isEmpty() &&
					selectedOuting.getPlace()  != null && !selectedOuting.getPlace().isEmpty() && 
					selectedOuting.getDescription() != null && !selectedOuting.getDescription().isEmpty()
					)
		  {
			  if(selectedOuting.getState()==State.AVAILABLE)
			    	messageModify="Prodotto modificato correttamente.";
			    if(selectedOuting.getState()==State.INCLUDED)
			    	messageModify="Il prodotto è stato modificato. E' stato eliminato il pacchetto ad esso associato." ;
			    if(selectedOuting.getState()==State.SOLD)
			    	messageModify="Il prodotto modificato era venduto. Il prodotto rimarrà nel sistema, ma è stata inviata una notifica al cliente.";
			    if(selectedOuting.getState()==State.RESERVED)
			    	messageModify="Il prodotto modificato era in una gift list. Il prodotto rimarrà nel sistema, ma è stata inviata una notifica al cliente.";
			  
	            outings.remove(selectedOuting);
			    newOuting = new OutingDTO(selectedOuting.getIdstage(), selectedOuting.getEmployeeCreator(),
			    		                  selectedOuting.getName(), selectedOuting.getIdProduct(),
			    		                  selectedOuting.getCost(),  
			    		                  selectedOuting.getTimeStart(),  selectedOuting.getTimeEnd(), 
			    		                  selectedOuting.getDescription(), selectedOuting.getArea(),
                                          State.AVAILABLE,selectedOuting.getPlace());
				productCRUD.updateProduct(newOuting);
				System.out.println("Escursione modificata. Forse.");
			//	outings.add(newOuting);
				outings= productCRUD.findAllOutings();
				outingModel=new OutingDataModel(outings);
		  }
			   
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getMessageDelete() {
		return messageDelete;
	}



	public void setMessageDelete(String messageDelete) {
		this.messageDelete = messageDelete;
	}



	public String getMessageModify() {
		return messageModify;
	}



	public void setMessageModify(String messageModify) {
		this.messageModify = messageModify;
	}



	public static Date getData1() {
		return data1;
	}
	public static void setData1(Date data1) {
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


