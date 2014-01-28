package webbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

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
import dto.ProductDTO;
import dto.HotelDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

  
@ManagedBean(name="carStoreManagement")
@ViewScoped
  
public class CarStoreManagementBean implements Serializable {  
  
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CarStore> filteredCars;  
    
    public List<CarStore> getFilteredCars() {
		return filteredCars;
	}
	public void setFilteredCars(List<CarStore> filteredCars) {
		this.filteredCars = filteredCars;
	}

	private List<Car> cars;  
	private List<Car> cars2;  
	private List<CarStore> carStores;  
	
    private CarStore selectedCar; 
   
  
    private CarStore[] selectedCars;  
    private CarStore[] selectedCars2;  
    
 
   

	private CarStore selectedCar2;  
    
    private CarStoreDataModel mediumCarsModel;  
    
   
    public CarStoreManagementBean() {  
         }  
    
    @PostConstruct
	  public void update()
	  {
    	 cars = new ArrayList<Car>();  
         
         populateCars(cars, 5);  
         CarStore cs1 = new CarStore("Store Muccioli", cars);
         CarStore cs2 = new CarStore("Store Franchi", cars);
         carStores = new ArrayList<CarStore>();
         carStores.add(cs1);
         carStores.add(cs2);
         
         
   
         mediumCarsModel = new CarStoreDataModel(carStores); 
         System.out.println("ciao ho popolato CarStore");
         System.out.println(cars.get(2).getColor());
   
	  }
    public void aggiorna()
    {
    	cars.add(new Car("66666",1999,"Special Model","Grey"));	
    }
    
	public void aggiornaL(ActionEvent actionEvent) {
	  	carStores.add(selectedCar2);	
	    System.out.println(selectedCar2.getName());
	}
	public void aggiornaL2() {
	  	carStores.add(selectedCar2);	
	    System.out.println(selectedCar2.getName());
	}
    
    private void populateCars(List<Car> list, int size) {

    	list.add(new Car("111111",1999,"Tayota","White"));
    	list.add(new Car("222222",2000,"Ferari","Red"));
    	list.add(new Car("333333",2001,"Fiat","Blue"));
    	list.add(new Car("444444",2002,"Pontiac","Green"));
    	list.add(new Car("555555",1999,"Honda","Yellow"));
    	}

    private void populateCars2(List<Car> list, int size) {

    	list.add(new Car("88",1999,"Tadhyota","White"));
    	list.add(new Car("99",2000,"Ferdfshari","Red"));
    	list.add(new Car("113",2001,"Fidfdsfhat","Blue"));
    	list.add(new Car("344",2002,"Ponftdiac","Green"));
    	list.add(new Car("88555",1999,"Hodfndda","Yellow"));
    	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public List<Car> getCars2() {
		return cars2;
	}
	public void setCars2(List<Car> cars2) {
		this.cars2 = cars2;
	}
	public List<CarStore> getCarStores() {
		return carStores;
	}
	public void setCarStores(List<CarStore> carStores) {
		this.carStores = carStores;
	}
	public CarStore getSelectedCar() {
		return selectedCar;
	}
	public void setSelectedCar(CarStore selectedCar) {
		this.selectedCar = selectedCar;
	}
	public CarStore[] getSelectedCars() {
		return selectedCars;
	}
	public void setSelectedCars(CarStore[] selectedCars) {
		this.selectedCars = selectedCars;
	}
	public CarStore[] getSelectedCars2() {
		return selectedCars2;
	}
	public void setSelectedCars2(CarStore[] selectedCars2) {
		this.selectedCars2 = selectedCars2;
	}
	public CarStore getSelectedCar2() {
		return selectedCar2;
	}
	public void setSelectedCar2(CarStore selectedCar2) {
		this.selectedCar2 = selectedCar2;
	}
	public CarStoreDataModel getMediumCarsModel() {
		return mediumCarsModel;
	}
	public void setMediumCarsModel(CarStoreDataModel mediumCarsModel) {
		this.mediumCarsModel = mediumCarsModel;
	}
    
    
    
    
}
