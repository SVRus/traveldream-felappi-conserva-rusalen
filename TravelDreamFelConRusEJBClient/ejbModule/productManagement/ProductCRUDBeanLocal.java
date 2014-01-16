package productManagement;

import java.util.List;

import javax.ejb.Local;

import dto.HotelDTO;
import dto.ProductDTO;

@Local
public interface ProductCRUDBeanLocal {
    public boolean createProduct(ProductDTO productdto);
    public boolean delete(ProductDTO productdto);
    public boolean updateProduct(ProductDTO productdto);
    public List <HotelDTO> findAllHotels();
    
    
    
    
    

}
