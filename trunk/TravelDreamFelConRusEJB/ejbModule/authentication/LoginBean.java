package authentication;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;





















import org.apache.commons.codec.digest.DigestUtils;

import dto.CustomizedTravelPackageDTO;
import dto.EmployeeDTO;
import dto.GenericUserDTO;
import dto.GiftListDTO;
import dto.TravelPackageDTO;
import dto_entitiesconversion.DTOFactory;
import entities.Customer;
import entities.CustomizedTravelPackage;
import entities.Employee;
import entities.GiftList;
import entities.TravelPackage;
import entitymanagement.CustomerEntityManagementLocal;
import entitymanagement.CustomizedTravelPackageEntityManagementLocal;
import entitymanagement.EmployeeEntityManagementLocal;
import entitymanagement.GiftListEntityManagementLocal;
import entitymanagement.TravelPackageEntityManagementLocal;
import exceptions.FriendNotFoundException;
import exceptions.GiftListNotFoundException;
import groupenum.Group;

/**
 * Session Bean implementation class LoginBean
 * It exploits the beans {@link entitymanagement.EmployeeEntityManagemen} and {@link entitymanagement.CustomerEntityManagement}
 * @overview this bean is used to handle the login phase
 */
@Stateless
@LocalBean
public class LoginBean implements LoginBeanLocal {

@EJB
CustomerEntityManagementLocal customer;
@EJB
CustomizedTravelPackageEntityManagementLocal custoMan;
@EJB
EmployeeEntityManagementLocal employee;
@EJB
DTOFactory factory;
@EJB
GiftListEntityManagementLocal gift;
@EJB
TravelPackageEntityManagementLocal travelMan;

@Resource
EJBContext context;


	/**
     * Default constructor. 
     */
    
public LoginBean() 
{
        
}

/**
 * @author Marcello
 * This method is used to obtain the Object representation of the user (Customer or Employee)
 * @return the GenericUserDTO representing the logged in user
 */
@Override
@RolesAllowed({Group._CUSTOMER,Group._EMPLOYEE})
public GenericUserDTO findLogIn()
{
	String username=getPrincipalUsername();
	GenericUserDTO generic=null;
	System.out.print(username);
	
	if (context.isCallerInRole("EMPLOYEE"))
	{
		generic=factory.toTDO((Employee)employee.find(username));
		System.out.println(generic.toString()+"impiegato");
	}
	else if(context.isCallerInRole("CUSTOMER"))
	{
		generic=factory.toTDO((Customer)customer.find(username));
		System.out.println(generic.toString()+"cliente");
	}
	
	System.out.print(generic.toString());
	return generic;
	

}
/**
 * @author Marcello
 * Thid method is used to get the primary key (username) of the user holding the session
 * @return the username of the user holding the session
 */
public String getPrincipalUsername() 
{
	
	return context.getCallerPrincipal().getName();
}


/**
 * @author Marcello
 * This method verify whether the user is logged (as a Customer or as an Employee)
 * @return the boolean value stating the authentication of the user
 */
@Override
public boolean isLogged() {
	
	return context.isCallerInRole(Group._CUSTOMER) ||context.isCallerInRole(Group._EMPLOYEE);
}


public boolean updateEmployee(EmployeeDTO emplodto)
{
	Employee emplo=factory.employeeDTOToEntityUpdate(emplodto);
	try {
		employee.edit(emplo);
		return true;
	} catch (Exception e) {
		return false;
	}
}

public boolean checkGift(String giftCode  )
{  
	List <Long> codeList=gift.giftListAuthenticationCheck();
	Iterator <Long> iter=codeList.iterator();
	boolean ok=false;
	while(ok||iter.hasNext())
	{
		ok=ok ||DigestUtils.sha256Hex(iter.next().toString()).equals(giftCode);
		
	}
	
	return ok;
}
/**
 * method that check the correctness of the giftList code launching an exception when wrong
 */
public ArrayList <GiftListDTO> checkGiftListException(String giftCode) throws GiftListNotFoundException
{
	
	List <Long> codeList=gift.giftListAuthenticationCheck();
	Iterator <Long> iter=codeList.iterator();
	Long idFound=null;
	boolean ok=false;
	while(iter.hasNext()&&!ok)
	{   idFound =iter.next();
		ok=ok ||DigestUtils.sha256Hex(idFound.toString()).equals(giftCode);
		
	}
	
	if(ok)
	{
		List <GiftList> giftList=gift.findGiftListForPackage((TravelPackage)travelMan.find(idFound));
		ArrayList <GiftListDTO> giftListDTO=factory.giftListCollectionTODTO(giftList);
		return giftListDTO;
	}
	else throw new GiftListNotFoundException();
	
	
}

/**
 * method that check the correctness of the friend code launching an exception when wrong
 */
public CustomizedTravelPackageDTO checkFriendException(String friendCode) throws FriendNotFoundException
{
	CustomizedTravelPackage customized=custoMan.findCustomizedTravelPackageForFriend(friendCode);
	if(customized!=null)	{
    	return (CustomizedTravelPackageDTO)factory.simpleTravelPackageToDTO(customized);
	}
    else
    	throw new FriendNotFoundException();
}



    
}
