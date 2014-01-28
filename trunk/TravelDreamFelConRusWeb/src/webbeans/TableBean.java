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
import javax.faces.event.ActionListener;

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

  
@ManagedBean
@SessionScoped
  
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
	private List<Car> cars2;  
  
    private Car selectedCar; 
   
  
    private Car[] selectedCars;  
    private Car[] selectedCars2;  
    private Date time_start;
 
    public Car[] getSelectedCars2() {
		return selectedCars2;
	}
	public void setSelectedCars2(Car[] selectedCars2) {
		this.selectedCars2 = selectedCars2;
	}

	private Car selectedCar2;  
    
    private CarDataModel mediumCarsModel;  
    
    private CarDataModel mediumCarsModel2;  
    
    public TableBean() {  
         }  
    @PostConstruct
	  public void update()
	  {
    	 cars = new ArrayList<Car>();  
         
         populateCars(cars, 5);  
   
         mediumCarsModel = new CarDataModel(cars); 
         cars2 = new ArrayList<Car>();  
         
         populateCars2(cars2, 5);  
   
         mediumCarsModel2 = new CarDataModel(cars2); 
         System.out.println("ciao ho popolato");
         System.out.println(cars.get(2).getColor());
   
	  }
    
    public void dateChange(ActionListener ae) {
    	cars.add(new Car("123321",1999,"Whoooo","Grey"));	
    	cars2.add(new Car("123321",1999,"Whoooo","Grey"));	
    	
    	mediumCarsModel = new CarDataModel(cars); 
    	mediumCarsModel2 = new CarDataModel(cars2); 
        
    
    }
    
    public void aggiorna()
    {
    	cars.add(new Car("66666",1999,"Special Model","Grey"));	
    }
    
	public void aggiornaL(ActionEvent actionEvent) {
	  	cars.add(selectedCar2);	
	    System.out.println(selectedCar2.getModel());
	}
	public void aggiornaL2() {
	  	cars.add(selectedCar2);	
	    System.out.println(selectedCar2.getModel());
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
	public List<Car> getCars2() {
		return cars2;
	}
	public void setCars2(List<Car> cars2) {
		this.cars2 = cars2;
	}
	public Car getSelectedCar2() {
		return selectedCar2;
	}
	public void setSelectedCar2(Car selectedCar2) {
		this.selectedCar2 = selectedCar2;
	}
	public CarDataModel getMediumCarsModel2() {
		return mediumCarsModel2;
	}
	public void setMediumCarsModel2(CarDataModel mediumCarsModel2) {
		this.mediumCarsModel2 = mediumCarsModel2;
	}
	public static String[] getColors() {
		return colors;
	}
	public static String[] getManufacturers() {
		return manufacturers;
	}
	public Date getTime_start() {
		return time_start;
	}
	public void setTime_start(Date time_start) {
		this.time_start = time_start;
	}  
    
}  
                      
