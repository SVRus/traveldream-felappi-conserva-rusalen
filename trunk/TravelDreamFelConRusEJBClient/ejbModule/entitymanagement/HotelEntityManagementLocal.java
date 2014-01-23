package entitymanagement;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;

import stateenum.State;



@Local
public interface HotelEntityManagementLocal {

	public <Hotel> void create(Hotel hotel);
	public <Hotel>  Hotel find(Object id);
	public <Hotel> void edit (Hotel hotel);
    public <Hotel>   List<Hotel> findAll(); 	
    public <Hotel> List<Hotel> findAllByParameter(Object par);
    public <Hotel>List<Hotel> findAllByStateAndArea(State state,Calendar timeStart,Calendar timeEnd,String area);

}
