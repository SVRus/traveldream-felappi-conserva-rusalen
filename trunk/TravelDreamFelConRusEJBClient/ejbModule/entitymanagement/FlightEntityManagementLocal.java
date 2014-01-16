package entitymanagement;

import java.util.List;

import javax.ejb.Local;

@Local
public interface FlightEntityManagementLocal {
	public <Flight> void create(Flight flight);
	public <Flight>  Flight find(Object id);
	public <Flight> void edit (Flight flight);
    public <Flight>   List<Flight> findAll(); 	

}
