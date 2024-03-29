package productManagement;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import stateenum.State;
import travelstateenum.TravelState;
import authentication.LoginBeanLocal;
import dto.EmployeeDTO;
import dto.FlightDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.ProductDTO;
import dto.TravelPackageDTO;
import dto_entitiesconversion.DTOFactory;
import entities.Employee;
import entities.Flight;
import entities.Hotel;
import entities.Outing;
import entities.Product;
import entities.TravelPackage;
import entitymanagement.EmployeeEntityManagementLocal;
import entitymanagement.FlightEntityManagementLocal;
import entitymanagement.HotelEntityManagementLocal;
import entitymanagement.OutingEntityManagementLocal;
import entitymanagement.PrepackedTravelPackageEntityManagementLocal;
import entitymanagement.ProductEntityManagementLocal;
import entitymanagement.StageEntityManagementLocal;
import entitymanagement.TravelPackageEntityManagementLocal;

/**
 * Session Bean implementation class ProductCreateBean
 */
@Stateless
@LocalBean
public class ProductCRUDBean implements ProductCRUDBeanLocal {
@EJB
OutingEntityManagementLocal outing;
@EJB
HotelEntityManagementLocal hotel;
@EJB
FlightEntityManagementLocal flight;
@EJB
ProductEntityManagementLocal prod;
@EJB
DTOFactory dto;
@EJB
EmployeeEntityManagementLocal emplo;
@EJB
LoginBeanLocal log;
@EJB
StageEntityManagementLocal stageman;
@EJB
TravelPackageEntityManagementLocal travman;


    /**
     * Default constructor. 
     */
    public ProductCRUDBean() {
       
    }
   /**
    * method that makes the productdto persistent
    */
    public boolean createProduct(ProductDTO productdto)
    {   Product product=dto.productDTOToEntity(productdto);
   
   
		boolean ok=false;
		if( product instanceof Hotel)
		{
			try
			{   
				hotel.create(product);
				
				ok=true;
			}
			catch(Exception e)
			{
				ok=false;
				
			}
		}
		else if(product instanceof Outing)
		{
			try
			{   
				outing.create(product);
				
				ok=true;
			}
			catch(Exception e)
			{
				ok=false;
				
			}
			
			
		}
		else if(product instanceof Flight)
		{
			try
			{   
				flight.create(product);
				
				ok=true;
			}
			catch(Exception e)
			{
				ok=false;
				
			}
			
		}
    	    	
    	
    	return ok;
    	
   }
    
    /**
     * method that permit an employee to persist a product
     */
    public boolean createProductFromEmployee(ProductDTO product)
    {   
		Employee employee=(Employee)emplo.find(log.getPrincipalUsername());
		Product prod=dto.productDTOToEntityUpdate(product);
    	List <Product> products=employee.getManagedProduct();
    	products.add(prod);
    	employee.setManagedProduct(products);
    	try
    	{  
    		emplo.edit(employee);
    		
    		
    		return true;
    	}
    	catch(Exception e)
    	{
    	return false;
    	}
    	
    	
    	
    }
 /**
  * method that delete a product
  */
    public boolean delete(ProductDTO productdto)
    {
    	boolean ok=false;
		try 
		{  
				if (productdto.getState()!=State.INCLUDED) {
					Product product = prod.find(productdto.getIdProduct());
					prod.remove(product);
				}
				else
				{
					Long idStage=productdto.getIdstage();
					TravelPackage travel=travman.find(stageman.findIdTravelPackageContainer(idStage));
					TravelPackageDTO tradto=dto.simpleTravelPackageToDTO(travel);
					tradto.setRecoursiveTravelProductState(TravelState.AVAILABLE, State.AVAILABLE);
					travel=dto.travelPackageDTOToEntity(tradto, false);
					travman.edit(travel);
					travman.remove(travel);
				}
				ok=true;
		}
    	catch (Exception e)
		{
    		ok=false;
    		
		}
    	return ok;  	
    	
    }
    /**
     * method that update a product
     */
    public boolean updateProduct(ProductDTO productdto)
    {   Product product=dto.productDTOToEntityUpdate(productdto);
    	boolean ok=false;
    	if( product instanceof Hotel)
    	{
    		try
    		{   
    			hotel.edit(product);
    			
    			ok=true;
    		}
    		catch(Exception e)
    		{
    			ok=false;
    			
    		}
    	}
    	else if(product instanceof Outing)
    	{
    		try
    		{   
    			outing.edit(product);
    			
    			ok=true;
    		}
    		catch(Exception e)
    		{
    			ok=false;
    			
    		}
    		
    		
    	}
    	else if(product instanceof Flight)
    	{
    		try
    		{   
    			flight.edit(product);
    			
    			ok=true;
    		}
    		catch(Exception e)
    		{
    			ok=false;
    			
    		}
    		
    	}
    	    	
    	
    	return ok;
    	
    }
/**
 * method that find all hotels given a state
 */
    public List <HotelDTO> findAllHotelsByParameter(State state)
    {
    	
    	List <Hotel> lista=hotel.findAllByParameter(state);
    	System.out.println("lista parametrica"+lista.toString());
    	List <Product> listaProduct=new ArrayList <Product> ();
    	Iterator <Hotel> iter=lista.iterator();
    	while (iter.hasNext())
    	{Hotel parziale=iter.next();
    	System.out.println(parziale.toString());
    		listaProduct.add(parziale);
    		System.out.println("aggiunto 1");
    	}
    	List <ProductDTO> hotels=dto.productListToDTO(listaProduct);
    	Iterator <ProductDTO> iter1=hotels.iterator();
    	
    	List <HotelDTO> listaa =new ArrayList <HotelDTO>();
    	
    	while (iter1.hasNext())
    	{
    		listaa.add((HotelDTO)iter1.next());
    		
    	}
    	
    	return listaa;
    	
    	
    	
    }

  /**
   * method that find all hotels
   */
    public List <HotelDTO> findAllHotels()
    {
    	List <Hotel> lista=hotel.findAll();
    	System.out.println("sono una lista di hotel"+lista.toString());
    	List <Product> listaProduct=new ArrayList <Product> ();
    	Iterator <Hotel> iter=lista.iterator();
    	while (iter.hasNext())
    	{Hotel parziale=iter.next();
    	System.out.println(parziale.toString());
    		listaProduct.add(parziale);
    		System.out.println("aggiunto 1");
    	}
    	List <ProductDTO> hotels=dto.productListToDTO(listaProduct);
    	Iterator <ProductDTO> iter1=hotels.iterator();
    	
    	List <HotelDTO> listaa =new ArrayList <HotelDTO>();
    	
    	while (iter1.hasNext())
    	{
    		listaa.add((HotelDTO)iter1.next());
    		
    	}
    	
    	return listaa;
    	
    	
    	
    }
    
    
    
    /**
     * method tha finds all outing given a state
     */
    public List <OutingDTO> findAllOutingsByParameter(State state)
    {
    	
    	List <Outing> lista=outing.findAllByParameter(state);
    	List <Product> listaProduct=new ArrayList <Product> ();
    	Iterator <Outing> iter=lista.iterator();
    	while (iter.hasNext())
    	{
    		Outing parziale=iter.next();
    		listaProduct.add(parziale);
    	}
    	List <ProductDTO> outings=dto.productListToDTO(listaProduct);
    	Iterator <ProductDTO> iter1=outings.iterator();
    	
    	List <OutingDTO> listaa =new ArrayList <OutingDTO>();
    	
    	while (iter1.hasNext())
    	{
    		listaa.add((OutingDTO)iter1.next());
    		
    	}
    	
    	return listaa;
    	
    	
    	
    }
    /**
     * method that finds all outings
     */
    public List <OutingDTO> findAllOutings()
    {
    	
    	List <Outing> lista=outing.findAll();
    	List <Product> listaProduct=new ArrayList <Product> ();
    	Iterator <Outing> iter=lista.iterator();
    	while (iter.hasNext())
    	{
    		Outing parziale=iter.next();
    		listaProduct.add(parziale);
    	}
    	List <ProductDTO> outings=dto.productListToDTO(listaProduct);
    	Iterator <ProductDTO> iter1=outings.iterator();
    	
    	List <OutingDTO> listaa =new ArrayList <OutingDTO>();
    	
    	while (iter1.hasNext())
    	{
    		listaa.add((OutingDTO)iter1.next());
    		
    	}
    	
    	return listaa;
    	
    	
    	
    }
    /**
     * method that finds all flights given a state
     */
    public List <FlightDTO> findAllFlightsByParameter(State state)
    {
    	
    	List <Flight> lista=flight.findAllByParameter(state);
    	List <Product> listaProduct=new ArrayList <Product> ();
    	Iterator <Flight> iter=lista.iterator();
    	while (iter.hasNext())
    	{
    		Flight parziale=iter.next();
    		listaProduct.add(parziale);
    	}
    	List <ProductDTO> outings=dto.productListToDTO(listaProduct);
    	Iterator <ProductDTO> iter1=outings.iterator();
    	
    	List <FlightDTO> listaa =new ArrayList <FlightDTO>();
    	
    	while (iter1.hasNext())
    	{
    		listaa.add((FlightDTO)iter1.next());
    		
    	}
    	
    	return listaa;
    	
    	
    	
    }
    /**
     * method that finds all flights
     */
    public List <FlightDTO> findAllFlights()
    {
    	
    	List <Flight> lista=flight.findAll();
    	List <Product> listaProduct=new ArrayList <Product> ();
    	Iterator <Flight> iter=lista.iterator();
    	while (iter.hasNext())
    	{
    		Flight parziale=iter.next();
    		listaProduct.add(parziale);
    	}
    	List <ProductDTO> outings=dto.productListToDTO(listaProduct);
    	Iterator <ProductDTO> iter1=outings.iterator();
    	
    	List <FlightDTO> listaa =new ArrayList <FlightDTO>();
    	
    	while (iter1.hasNext())
    	{
    		listaa.add((FlightDTO)iter1.next());
    		
    	}
    	
    	return listaa;
    	
    	
    	
    }
    
    	
   /**
    * method that finds all outing given a state , an area , a start Date and an end Date
    */
	public List<OutingDTO> findALLOutingByStateAndArea(State state, Date  timeStart,Date timeEnd,String area)
	{
		List <Outing> outingList=outing.findALLByStateAndArea(state, timeStart.getTime(), timeEnd.getTime(), area);
		List <OutingDTO> outingDTOList=dto.outingListToDTO(outingList);
		return outingDTOList;
		
	}
	/**
	    * method that finds all outing given a state , an area , a start Date and an end Date
	    */
	public List<HotelDTO> findALLHotelByStateAndArea(State state, Date  timeStart,Date timeEnd,String area)
	{
		List <Hotel> hotelList=hotel.findAllByStateAndArea(state, timeStart.getTime(), timeEnd.getTime(), area);
		List <HotelDTO> hotelDTOList=dto.hotelListToDTO(hotelList);
		return hotelDTOList;
		
	}
	/**
	    * method that finds all flights given a state , an area , a start Date and an end Date
	    */
	public List<FlightDTO> findALLFlightByStateAndAreaStart(State state, Date  timeStart,Date timeEnd,String area)
	{
		List <Flight> outingList=flight.findALLByStateAndAreaStart(state, timeStart.getTime(), timeEnd.getTime(), area);
		List <FlightDTO> flightDTOList=dto.flightListToDTO(outingList);
		return flightDTOList;
		
	}
	/**
	    * method that finds all outings given a state , an area , a start Date and an end Date
	    */
	public List<FlightDTO> findALLByStateAndAreaEnd(State state, Date  timeStart,Date timeEnd,String area)
	{
		List <Flight> outingList=flight.findALLByStateAndAreaEnd(state,  timeStart.getTime(), timeEnd.getTime(), area);
		List <FlightDTO> flightDTOList=dto.flightListToDTO(outingList);
		return flightDTOList;
		
	}
	
	public ArrayList <ProductDTO> findAllForEmployee()
	{
		EmployeeDTO emplo=(EmployeeDTO)log.findLogIn();
		
		return new ArrayList <ProductDTO>(emplo.getManagedproduct());
		
	}
	
	
	
}
