package entitymanagement;

import javax.ejb.Local;

@Local
public interface FlightEntityManagementLocal {
	public <Flight> void create(Flight flight);
	public <Flight>  Flight find(Object id);
}
