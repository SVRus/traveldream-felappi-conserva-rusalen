package travelPackageManagement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import travelstateenum.TravelState;
import dto.CustomizedTravelPackageDTO;
import dto.PrepackedTravelPackageDTO;
import dto.TravelPackageDTO;

@Local
public interface TravelPackageCRUDBeanLocal 
{
	public boolean createTravelFromEmployee(TravelPackageDTO prepacked) ;
	public boolean updateTravelPackage(TravelPackageDTO traveldto);
	public boolean delete(TravelPackageDTO traveldto);
	public List <PrepackedTravelPackageDTO> findAllPrepacked();
    public List <CustomizedTravelPackageDTO> findAllCustomized();
    public CustomizedTravelPackageDTO cloneTravelPackage(PrepackedTravelPackageDTO preDTO);
    public boolean createCustomizedTravelPackageFromCustomer(CustomizedTravelPackageDTO custo);
	public int getNumberEquivalentPackage(TravelPackageDTO travel);
	public List <PrepackedTravelPackageDTO> findAllPrepackedTravelPackageByParameter(TravelState state);
	public PrepackedTravelPackageDTO cloneTravelPackageToPrepacked(PrepackedTravelPackageDTO preDTO);
	public ArrayList<TravelPackageDTO>  findAllPackageForCustomer();
	public ArrayList <PrepackedTravelPackageDTO> findAllPackageForEmployee();


	
	
	
}
