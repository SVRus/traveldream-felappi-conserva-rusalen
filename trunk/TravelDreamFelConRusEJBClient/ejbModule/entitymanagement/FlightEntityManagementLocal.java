package entitymanagement;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;

import stateenum.State;



@Local
public interface FlightEntityManagementLocal {
	public <Flight> void create(Flight flight);
	public <Flight>  Flight find(Object id);
	public <Flight> void edit (Flight flight);
    public <Flight>   List<Flight> findAll(); 	
    public <Flight> List<Flight> findAllByParameter(Object par);
    public <Flight>List<Flight> findALLByStateAndAreaStart(State state, Calendar timeStart,Calendar timeEnd,String area);
    public <Flight>List<Flight> findALLByStateAndAreaEnd(State state, Calendar timeStart,Calendar timeEnd,String area);


}
