package webbeans;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dto.FlightDTO;
import dto.HotelDTO;
import dto.StageDTO;
import dto.OutingDTO;



public class StageHelper {
	
	private StageDTO stage;
	private int stageSize;
	
	
	
	public StageHelper(StageDTO stage) {
		super();
		this.stage = stage;
		this.stageSize= stage.getProducts().size();
	}
	public HotelDTO hotel()
	{
		for (int i = 0; i < this.getStageSize(); i++) {
			if(stage.getProducts().get(i) instanceof HotelDTO)
				return (HotelDTO) stage.getProducts().get(i);
				
		}
		return null;
		
	}
	
	public List<OutingDTO> outings()
	{
		
		List<OutingDTO> temp = new ArrayList<OutingDTO>();
		for (int i = 0; i < this.getStageSize(); i++) {
			if(stage.getProducts().get(i) instanceof OutingDTO)
			{
				temp.add((OutingDTO) stage.getProducts().get(i));
			}
			
				
		}
		return temp;
		
		
		
	}
	
	public FlightDTO flightStart()
	{
		
		for (int i = 0; i < this.getStageSize(); i++) {
			if(stage.getProducts().get(i) instanceof FlightDTO)
			{
				FlightDTO flightTemp = (FlightDTO) stage.getProducts().get(i);
				if( !flightTemp.getArea_start().equals(this.stage.getArea()))
				return flightTemp;
			}
		}
		return null;
		
		
	}
	public FlightDTO flightEnd()
	{
		for (int i = 0; i < this.getStageSize(); i++) {
			if(stage.getProducts().get(i) instanceof FlightDTO)
			{
				FlightDTO flightTemp = (FlightDTO) stage.getProducts().get(i);
				if( flightTemp.getArea_start().equals(this.stage.getArea()))
				return flightTemp;
			}
		}
		return null;
		
		
	}

	public StageDTO getStage() {
		return stage;
	}


	public void setStage(StageDTO stage) {
		this.stage = stage;
	}


	public int getStageSize() {
		return stageSize;
	}


	public void setStageSize(int stageSize) {
		this.stageSize = stageSize;
	}


	
}
