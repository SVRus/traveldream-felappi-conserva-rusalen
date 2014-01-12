package entitymanagement;

import javax.ejb.Local;

@Local
public interface HotelEntityManagementLocal {

	public <Hotel> void create(Hotel hotel);
	public <Hotel>  Hotel find(Object id);
	
	
}
