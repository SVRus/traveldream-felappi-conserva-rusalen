package productManagement;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import stateenum.State;
import authentication.LoginBeanLocal;
import concistencyCheck.ConsistencyCheckBeanLocal;
import dto.FlightDTO;
import dto.HotelDTO;
import dto.OutingDTO;
import dto.ProductDTO;
import dto_entitiesconversion.DTOFactory;
import entities.Employee;
import entities.Flight;
import entities.Hotel;
import entities.Outing;
import entities.Product;
import entitymanagement.EmployeeEntityManagementLocal;
import entitymanagement.FlightEntityManagementLocal;
import entitymanagement.HotelEntityManagementLocal;
import entitymanagement.OutingEntityManagementLocal;
import entitymanagement.ProductEntityManagementLocal;

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


    /**
     * Default constructor. 
     */
    public ProductCRUDBean() {
       
    }
   
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
    
    
    public boolean createProductFromEmployee(ProductDTO product)
    {   System.out.print(log.getPrincipalUsername()+"sono io");
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
    
   
    public boolean delete(ProductDTO productdto)
    {
    	boolean ok=false;
		try 
		{
				Product product=prod.find(productdto.getIdProduct());
				prod.remove(product);
				ok=true;
		}
    	catch (Exception e)
		{
    		ok=false;
    		
		}
    	return ok;  	
    	
    }
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

    public List <HotelDTO> findAllHotelsByParameter(State state)
    {
    	
    	List <Hotel> lista=hotel.findAllByParameter(state);
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

  
    public List <HotelDTO> findAllHotels()
    {
    	
    	List <Hotel> lista=hotel.findAll();
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
    
    
  
}
