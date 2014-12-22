package webbeans;

import java.io.Serializable;
import java.util.List;  

import javax.faces.model.ListDataModel;  

import org.primefaces.model.SelectableDataModel;  

import dto.OutingDTO;
  
public class OutingDataModel extends ListDataModel<OutingDTO> implements SelectableDataModel<OutingDTO>, Serializable {    
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OutingDataModel() {  
    }  
  
    public OutingDataModel(List<OutingDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public OutingDTO getRowData(String rowKey) {  
           
        List<OutingDTO> outings = (List<OutingDTO>) getWrappedData();  
          
        for(OutingDTO outing : outings) {  
            if(outing.getIdProduct().equals(Long.parseLong(rowKey)))  
                return outing;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(OutingDTO outing) {  
        return outing.getIdProduct();  
    }  
}  