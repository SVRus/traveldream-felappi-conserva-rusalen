package webbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import dto.CustomizedTravelPackageDTO;
  
public class CustomizedTravelPackageDataModel extends ListDataModel<CustomizedTravelPackageDTO> implements SelectableDataModel<CustomizedTravelPackageDTO>, Serializable {    
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomizedTravelPackageDataModel() {  
    }  
  
    public CustomizedTravelPackageDataModel(List<CustomizedTravelPackageDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public CustomizedTravelPackageDTO getRowData(String rowKey) {  
           
        List<CustomizedTravelPackageDTO> travelPackages = (List<CustomizedTravelPackageDTO>) getWrappedData();  
          
        for(CustomizedTravelPackageDTO travelPackage : travelPackages) {  
            if(travelPackage.getIdtravelpackage().equals(Long.parseLong(rowKey)))  
                return travelPackage;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(CustomizedTravelPackageDTO travelPackage) {  
        return travelPackage.getIdCustomerBuyer();  
    }  
}  