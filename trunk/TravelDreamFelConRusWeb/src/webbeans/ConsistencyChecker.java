package webbeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import travelstateenum.TravelState;
import dto.FlightDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.PrepackedTravelPackageDTO;
import dto.ProductDTO;
import dto.StageDTO;

public class ConsistencyChecker {
	
	/**true se il prodotto che si vuole inserire in una tappa non rende 
	 * inconsistente la tappa
	 * 
	 * @param product
	 * @param stage
	 * @return
	 */
	public boolean CorrectProductInsert(ProductDTO product, StageDTO stage)
	{
	//Controllo che la data del prodotto sia compresa tra quelle della tappa
	if((product.getTimeStart().before(stage.getTimeStart()) || (product.getTimeEnd().after(stage.getTimeEnd()))))
		return false;
	/*
	 * -se il prodotto è un volo di andata controllo che venga prima degli altri prodotti
	 * -se il prodotto e un volo di ritorno controllo che venga dopo gli altri prodotti
	   -se il prodotto è un outing o un hotel e se ci sono voli nella tappa, 
		controllo che la data del prodotto sia >voloInizio e <Volofine
	 */
	if((product instanceof FlightDTO) )
	{
		FlightDTO flightTemp = (FlightDTO) product;
	
		//volo di andata
		if( !flightTemp.getArea_start().equals(stage.getArea()))
		{
			for(int i=0; i<stage.getProducts().size();i++)
			{
				if(! (stage.getProducts().get(i) instanceof HotelDTO))
				if(flightTemp.getTimeEnd().after(stage.getProducts().get(i).getTimeStart()) )
					return false;
				else
				// se è un hotel faccio il controllo solo sul giorno
				{
				if(getDayOfMonth(flightTemp.getTimeEnd())> getDayOfMonth(stage.getProducts().get(i).getTimeStart())) 
						return false;
				}
					
			}
		}
		
		else
		//volo di ritorno
		{
				
			for(int i=0; i<stage.getProducts().size();i++)
			{
				if(! (stage.getProducts().get(i) instanceof HotelDTO))
				if(flightTemp.getTimeStart().before(stage.getProducts().get(i).getTimeEnd()) )
					return false;
				else
				// se è un hotel faccio il controllo solo sul giorno
				{
				if(getDayOfMonth(flightTemp.getTimeStart())< getDayOfMonth(stage.getProducts().get(i).getTimeEnd())) 
						return false;
				}
					
			}
		}
	}
	if((product instanceof OutingDTO) )
	{
		
		for(int i=0; i<stage.getProducts().size();i++)
		{
			if((stage.getProducts().get(i) instanceof FlightDTO))
			{
				
				FlightDTO flightTemp = (FlightDTO) stage.getProducts().get(i);
				
				//se c'è un volo di andata
				if( !flightTemp.getArea_start().equals(stage.getArea()))
				{
					if(flightTemp.getTimeEnd().after(product.getTimeStart()))
						return false;
				}
				else
				//se c'è un volo di ritorno
				{
					if(flightTemp.getTimeStart().before(product.getTimeEnd()))
						return false;
					
				}	
				
			}
			if((stage.getProducts().get(i) instanceof OutingDTO))
			{
				OutingDTO outingTemp = (OutingDTO) stage.getProducts().get(i);
				
				// se l'uscita nello stage comincia dopo l'inizio di quella da inserire
				if(outingTemp.getTimeStart().after(product.getTimeStart()))
				{
					// se l'uscita nello stage comincia prima della fine di quella da inserire
					
					if(product.getTimeEnd().after(outingTemp.getTimeStart()))
						return false;
						
				}
				else
				{
					//se l'uscita da inserire comincia prima della fine di quello nello stage
					if(product.getTimeStart().before(outingTemp.getTimeEnd()))
						return false;
					
				}
				
			}
			
				
		}
		
		
	}
	
		return true;
		
	}
	
	/**
	 * true se lo stage che si vuole inserire in un package non rende inconsistente 
	 * il package 
	 * @param pack
	 * @param stage
	 * @return
	 */
	public boolean CorrectStageInsert(PrepackedTravelPackageDTO pack,StageDTO stage )
	{
		if((stage.getTimeStart().before(pack.getTime_start())) || (stage.getTimeEnd().after(pack.getTime_end())) )
		return false;
		
		for(int i=0; i<pack.getStages().size();i++)
		{
			//se uno stage nel pacchetto comincia prima di quello da verificare
			if(pack.getStages().get(i).getTimeStart().before(stage.getTimeStart()))
			{
				//se lo stage nel pacchetto finisce dopo l'inizio di quello da verificare
				if(pack.getStages().get(i).getTimeEnd().after(stage.getTimeStart()))
					return false;
					
			}	
			//se uno stage nel pacchetto finisce dopo di quello da verificare
			
			if(pack.getStages().get(i).getTimeEnd().after(stage.getTimeEnd()))
			{
				//se lo stage nel pacchetto inizia prima della fine di quello da verificare
				if(pack.getStages().get(i).getTimeStart().before(stage.getTimeEnd()))
					return false;
					
			}	
			
				
		}
		
		return true;
		
	}
	
	/**
	 * true se i valori di dataStart e dataEnd del pacchetto sono coerenti
	 * con le tappe
	 * @param pack
	 * @return
	 */
	public boolean correctDateStartEndPackage(PrepackedTravelPackageDTO pack)
	{
		/*verifica che la data inizio del pacchetto
		 * sia minore di quelle di tutti gli stage, e viceversa per la data fine
		 */
		for(int i=0; i<pack.getStages().size();i++)
		{
			if((pack.getStages().get(i).getTimeStart().before(pack.getTime_start())) || (pack.getStages().get(i).getTimeEnd().after(pack.getTime_end())) )
				return false;
			
			
		}
		
		return true;
		
	}
	/**
	 * true se la tappa è coerente
	 * @param stage
	 * @return
	 */
	
	public boolean correctStage(StageDTO stage )
	{
		StageDTO stageTemp = new StageDTO(new ArrayList<ProductDTO>(), stage.getArea(), stage.getTimeStart(), stage.getTimeEnd());
		for(int i=0; i<stage.getProducts().size();i++)
		{
			if((CorrectProductInsert(stage.getProducts().get(i),stageTemp)))
			{
				stageTemp.addProduct(stage.getProducts().get(i));
			}
			else
			return false;
			
		}
		
		
		return true;
		
	}
	/**
	 * true se il pacchetto è coerente (assumendo già verificata la coerenza interna delle tappe)
	 */
	
	public boolean correctPackageWeak(PrepackedTravelPackageDTO pack )
	{
		PrepackedTravelPackageDTO packTemp = new PrepackedTravelPackageDTO(pack.getTime_end(),pack.getTime_start(),pack.getDescription(), pack.getName(), new ArrayList<StageDTO>(),"0", "0", pack.getPurchaseTime(), "", TravelState.AVAILABLE);
		for(int i=0; i<pack.getStages().size();i++)
		{
			if((CorrectStageInsert(packTemp,pack.getStages().get(i))))
			{
				packTemp.addStage(pack.getStages().get(i));
			}
			else
			return false;
			
		}
		
		
		return true;
		
	}
	/**
	 * true se il pacchetto è coerente 
	 */
	
	public boolean correctPackage(PrepackedTravelPackageDTO pack )
	{
		PrepackedTravelPackageDTO packTemp = new PrepackedTravelPackageDTO(pack.getTime_end(),pack.getTime_start(),pack.getDescription(), pack.getName(), new ArrayList<StageDTO>(),"0", "0", pack.getPurchaseTime(), "", TravelState.AVAILABLE);
		for(int i=0; i<pack.getStages().size();i++)
		{
			if(!correctStage(pack.getStages().get(i)))
				return false;
			if((CorrectStageInsert(packTemp,pack.getStages().get(i))))
			{
				packTemp.addStage(pack.getStages().get(i));
			}
			else
			return false;
			
		}
		
		
		return true;
		
	}
	
	
	
	
	
	
	private static int getDayOfMonth(Date aDate) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(aDate);
	    return cal.get(Calendar.DAY_OF_MONTH);
	}

	
}
