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
import userManagement.GenericUserManagementBeanLocal;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.GiftListDTO;
import dto.ProductDTO;
import dto.HotelDTO;
import authentication.LoginBeanLocal;
import authentication.RegistrationBeanLocal;

  
@ManagedBean
@ViewScoped
  
public class TableBean implements Serializable {  
  
    private final static String[] colors;  
  
    private final static String[] manufacturers;  
  
    static {  
        colors = new String[10];  
        colors[0] = "Black";  
        colors[1] = "White";  
        colors[2] = "Green";  
        colors[3] = "Red";  
        colors[4] = "Blue";  
        colors[5] = "Orange";  
        colors[6] = "Silver";  
        colors[7] = "Yellow";  
        colors[8] = "Brown";  
        colors[9] = "Maroon";  
  
        manufacturers = new String[10];  
        manufacturers[0] = "Mercedes";  
        manufacturers[1] = "BMW";  
        manufacturers[2] = "Volvo";  
        manufacturers[3] = "Audi";  
        manufacturers[4] = "Renault";  
        manufacturers[5] = "Opel";  
        manufacturers[6] = "Volkswagen";  
        manufacturers[7] = "Chrysler";  
        manufacturers[8] = "Ferrari";  
        manufacturers[9] = "Ford";  
    }  
    private List<Car> filteredCars;  
    
    public List<Car> getFilteredCars() {
		return filteredCars;
	}
	public void setFilteredCars(List<Car> filteredCars) {
		this.filteredCars = filteredCars;
	}

	private List<Car> cars;  
  
    private Car selectedCar;  
  
    private Car[] selectedCars;  
  
    private CarDataModel mediumCarsModel;  
  
    public TableBean() {  
         }  
    @PostConstruct
	  public void update()
	  {
    	 cars = new ArrayList<Car>();  
         
         populateCars(cars, 5);  
   
         mediumCarsModel = new CarDataModel(cars); 
         System.out.println("ciao ho popolato");
         System.out.println(cars.get(2).getColor());
   
	  }
    public void aggiorna()
    {
    	cars.add(new Car("66666",1999,"Special Model","Grey"));	
    }
	public void aggiornaL(ActionEvent actionEvent) {
	  	cars.add(new Car("7777",1999,"Special Model","Grey"));	
	    
	}

    
    private void populateCars(List<Car> list, int size) {

    	list.add(new Car("111111",1999,"Tayota","White"));
    	list.add(new Car("222222",2000,"Ferari","Red"));
    	list.add(new Car("333333",2001,"Fiat","Blue"));
    	list.add(new Car("444444",2002,"Pontiac","Green"));
    	list.add(new Car("555555",1999,"Honda","Yellow"));
    	}

  
    public Car[] getSelectedCars() {  
        return selectedCars;  
    }  
    public void setSelectedCars(Car[] selectedCars) {  
        this.selectedCars = selectedCars;  
    }  
  
    public Car getSelectedCar() {  
        return selectedCar;  
    }  
  
    public void setSelectedCar(Car selectedCar) {  
        this.selectedCar = selectedCar;  
    }  
  
    private void populateRandomCars(List<Car> list, int size) {  
        for(int i = 0 ; i < size ; i++)  
            list.add(new Car(getRandomModel(), getRandomYear(), getRandomManufacturer(), getRandomColor()));  
    }  
  
    private int getRandomYear() {  
        return (int) (Math.random() * 50 + 1960);  
    }  
  
    public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public void setMediumCarsModel(CarDataModel mediumCarsModel) {
		this.mediumCarsModel = mediumCarsModel;
	}
	private String getRandomColor() {  
        return colors[(int) (Math.random() * 10)];  
    }  
  
    private String getRandomManufacturer() {  
        return manufacturers[(int) (Math.random() * 10)];  
    }  
  
    private String getRandomModel() {  
        return UUID.randomUUID().toString().substring(0, 8);  
    }  
  
    public CarDataModel getMediumCarsModel() {  
        return mediumCarsModel;  
    }  
}  
                      
