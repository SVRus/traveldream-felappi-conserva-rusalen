package entitymanagement;

import java.util.List;

import javax.ejb.Local;


@Local
public interface HotelEntityManagementLocal {

	public <Hotel> void create(Hotel hotel);
	public <Hotel>  Hotel find(Object id);
	public <Hotel> void edit (Hotel hotel);
    public <Hotel>   List<Hotel> findAll(); 	
}
