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
  
public class TaBean implements Serializable {  
  
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

	private List<Car> cars3;  
	
    private Car selectedCar3;  
  
    private Car[] selectedCars3;  
   
 
  
	
	
    private CarDataModel mediumCarsModel3;  
    

 
    public TaBean() {  
         }  
    @PostConstruct
	  public void update()
	  {
    	 cars3 = new ArrayList<Car>();  
         
         populateCars(cars3, 5);  
   
         mediumCarsModel3 = new CarDataModel(cars3); 
       
         System.out.println("ciao ho popolato");
         System.out.println(cars3.get(2).getColor());
   
	  }
    public void aggiorna()
    {
    	cars3.add(new Car("66666",1999,"Special Model","Grey"));	
    }
    
	public void aggiornaL(ActionEvent actionEvent) {
	  	cars3.add(selectedCar3);	
	    System.out.println(selectedCar3.getModel());
	}
	public void aggiornaL3() {
	  	cars3.add(selectedCar3);	
	    System.out.println(selectedCar3.getModel());
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
        return selectedCars3;  
    }  
    public void setSelectedCars(Car[] selectedCars3) {  
        this.selectedCars3 = selectedCars3;  
    }  
  
    public Car getSelectedCar3() {  
        return selectedCar3;  
    }  
  
    public void setSelectedCar3(Car selectedCar3) {  
        this.selectedCar3 = selectedCar3;  
    }  
  
    private void populateRandomCars(List<Car> list, int size) {  
        for(int i = 0 ; i < size ; i++)  
            list.add(new Car(getRandomModel(), getRandomYear(), getRandomManufacturer(), getRandomColor()));  
    }  
  
    private int getRandomYear() {  
        return (int) (Math.random() * 50 + 1960);  
    }  
  
    public List<Car> getCars() {
		return cars3;
	}
	public void setCars(List<Car> cars3) {
		this.cars3 = cars3;
	}
	public void setMediumCarsModel3(CarDataModel mediumCarsModel3) {
		this.mediumCarsModel3 = mediumCarsModel3;
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
  
    public CarDataModel getMediumCarsModel3() {  
        return mediumCarsModel3;  
    }
	
	
	
	public static String[] getColors() {
		return colors;
	}
	public static String[] getManufacturers() {
		return manufacturers;
	}  
    
}  
                      
