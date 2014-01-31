package webbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import dto.FlightDTO;
  
public class FlightDataModel extends ListDataModel<FlightDTO> implements SelectableDataModel<FlightDTO>, Serializable {    
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlightDataModel() {  
    }  
  
    public FlightDataModel(List<FlightDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public FlightDTO getRowData(String rowKey) {  
           
        List<FlightDTO> flights = (List<FlightDTO>) getWrappedData();  
          
        for(FlightDTO flight : flights) {  
            if(flight.getIdProduct().equals(Long.parseLong(rowKey)))  
                return flight;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(FlightDTO flight) {  
        return flight.getIdProduct();  
    }  
}  
