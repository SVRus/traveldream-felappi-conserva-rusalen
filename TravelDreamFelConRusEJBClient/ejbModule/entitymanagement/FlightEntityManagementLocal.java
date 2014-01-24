package entitymanagement;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import dto.FlightDTO;
import stateenum.State;



@Local
public interface FlightEntityManagementLocal {
	public <Flight> void create(Flight flight);
	public <Flight>  Flight find(Object id);
	public <Flight> void edit (Flight flight);
    public <Flight>   List<Flight> findAll(); 	
    public <Flight> List<Flight> findAllByParameter(Object par);
    public <Flight>List<Flight> findALLByStateAndAreaStart(State state, Date timeStart,Date timeEnd,String area);
    public <Flight>List<Flight> findALLByStateAndAreaEnd(State state, Date timeStart,Date timeEnd,String area);
    public boolean findBooleanFlightEquivalent(FlightDTO flightDTO ,int number);
    public int findIntegerFlightEquivalent(FlightDTO  flightDTO);


}
