package webbeans;

import java.io.Serializable;
import java.util.List;  

import javax.faces.model.ListDataModel;  

import org.primefaces.model.SelectableDataModel;  

import dto.StageDTO;
  
public class StageDataModel extends ListDataModel<StageDTO> implements SelectableDataModel<StageDTO>, Serializable {    
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StageDataModel() {  
    }  
  
    public StageDataModel(List<StageDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public StageDTO getRowData(String rowKey) {  
           
        List<StageDTO> stages = (List<StageDTO>) getWrappedData();  
          
        for(StageDTO stage : stages) {  
            if(stage.getArea().equals(rowKey))  
                return stage;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(StageDTO stage) {  
        return stage.getArea();  
    }  
}  