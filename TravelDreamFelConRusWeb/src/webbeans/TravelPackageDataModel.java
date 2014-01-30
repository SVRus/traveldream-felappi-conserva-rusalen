package webbeans;

import java.io.Serializable;
import java.util.List;  

import javax.faces.model.ListDataModel;  

import org.primefaces.model.SelectableDataModel;  

import dto.TravelPackageDTO;
  
public class TravelPackageDataModel extends ListDataModel<TravelPackageDTO> implements SelectableDataModel<TravelPackageDTO>, Serializable {    
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TravelPackageDataModel() {  
    }  
  
    public TravelPackageDataModel(List<TravelPackageDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public TravelPackageDTO getRowData(String rowKey) {  
           
        List<TravelPackageDTO> travelPackages = (List<TravelPackageDTO>) getWrappedData();  
          
        for(TravelPackageDTO travelPackage : travelPackages) {  
            if(travelPackage.getIdtravelpackage().equals(Long.parseLong(rowKey)))  
                return travelPackage;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(TravelPackageDTO travelPackage) {  
        return travelPackage.getIdtravelpackage();  
    }  
}  