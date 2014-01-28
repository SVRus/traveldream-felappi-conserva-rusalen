package webbeans;

import java.io.Serializable;
import java.util.List;  

import javax.faces.model.ListDataModel;  

import org.primefaces.model.SelectableDataModel;  

import dto.GiftListDTO;
  
public class GiftListDataModel extends ListDataModel<GiftListDTO> implements SelectableDataModel<GiftListDTO>, Serializable {    
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GiftListDataModel() {  
    }  
  
    public GiftListDataModel(List<GiftListDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public GiftListDTO getRowData(String rowKey) {  
           
        List<GiftListDTO> giftLists = (List<GiftListDTO>) getWrappedData();  
          
        for(GiftListDTO giftList : giftLists) {  
            if(giftList.getProduct().getName().equals(rowKey))  
                return giftList;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(GiftListDTO giftList) {  
        return giftList.getProduct().getName();  
    }  
}  
