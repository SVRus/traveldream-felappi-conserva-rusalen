package webbeans;

import java.io.Serializable;
import java.util.List;  

import javax.faces.model.ListDataModel;  

import org.primefaces.model.SelectableDataModel;  

import dto.PrepackedTravelPackageDTO;
  
public class PrepackedTravelPackageDataModel extends ListDataModel<PrepackedTravelPackageDTO> implements SelectableDataModel<PrepackedTravelPackageDTO>, Serializable {    
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrepackedTravelPackageDataModel() {  
    }  
  
    public PrepackedTravelPackageDataModel(List<PrepackedTravelPackageDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public PrepackedTravelPackageDTO getRowData(String rowKey) {  
           
        List<PrepackedTravelPackageDTO> travelPackages = (List<PrepackedTravelPackageDTO>) getWrappedData();  
          
        for(PrepackedTravelPackageDTO travelPackage : travelPackages) {  
            if(travelPackage.getName().equals(rowKey))  
                return travelPackage;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(PrepackedTravelPackageDTO travelPackage) {  
        return travelPackage.getName();  
    }  
}  