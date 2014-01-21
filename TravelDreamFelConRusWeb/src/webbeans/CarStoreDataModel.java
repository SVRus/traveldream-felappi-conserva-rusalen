package webbeans;

import java.util.List;  
import javax.faces.model.ListDataModel;  

import org.primefaces.model.SelectableDataModel;  

public class CarStoreDataModel extends ListDataModel<CarStore> implements SelectableDataModel<CarStore> {    
  
    public CarStoreDataModel() {
    	
    }  
  
    public CarStoreDataModel(List<CarStore> data) {  
        super(data);  
    }  
      
    @Override  
    public CarStore getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        List<CarStore> cars = (List<CarStore>) getWrappedData();  
          
        for(CarStore car : cars) {  
            if(car.getName().equals(rowKey))  
                return car;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(CarStore car) {  
        return car.getName();  
    }  
}  
