package productManagement;

import java.util.Date;
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

	public List<FlightDTO> findALLByStateAndAreaEnd(State state, Date  timeStart,Date timeEnd,String area);
	public List<FlightDTO> findALLFlightByStateAndAreaStart(State state, Date  timeStart,Date timeEnd,String area);
	public List<HotelDTO> findALLHotelByStateAndArea(State state, Date  timeStart,Date timeEnd,String area);
	public List<OutingDTO> findALLOutingByStateAndArea(State state, Date  timeStart,Date timeEnd,String area);
	public List <ProductDTO> findAllForEmployee();

    
    

}
