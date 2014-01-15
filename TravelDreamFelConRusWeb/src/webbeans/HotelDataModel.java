package webbeans;

import java.io.Serializable;
import java.util.List;  

import javax.faces.model.ListDataModel;  

import org.primefaces.model.SelectableDataModel;  

import dto.HotelDTO;
  
public class HotelDataModel extends ListDataModel<HotelDTO> implements SelectableDataModel<HotelDTO>, Serializable {    
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelDataModel() {  
    }  
  
    public HotelDataModel(List<HotelDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public HotelDTO getRowData(String rowKey) {  
           
        List<HotelDTO> hotels = (List<HotelDTO>) getWrappedData();  
          
        for(HotelDTO hotel : hotels) {  
            if(hotel.getName().equals(rowKey))  
                return hotel;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(HotelDTO hotel) {  
        return hotel.getName();  
    }  
}  