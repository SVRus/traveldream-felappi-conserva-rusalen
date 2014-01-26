package productManagement;

import java.util.List;

import javax.ejb.Local;

import stateenum.State;
import dto.FlightDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.ProductDTO;

@Local
public interface ProductCRUDBeanLocal {
    public boolean createProduct(ProductDTO productdto);
    public boolean delete(ProductDTO productdto);
    public boolean updateProduct(ProductDTO productdto);
    public List <HotelDTO> findAllHotels();
    public List <FlightDTO> findAllFlights();
    public List <OutingDTO> findAllOutings();
    public boolean createProductFromEmployee(ProductDTO product);
    public List <FlightDTO> findAllFlightsByParameter(State state);
    public List <OutingDTO> findAllOutingsByParameter(State state);
    public List <HotelDTO> findAllHotelsByParameter(State state);
   // public ProductDTO findClonedProduct(ProductDTO toClone);

    
    
    

}
