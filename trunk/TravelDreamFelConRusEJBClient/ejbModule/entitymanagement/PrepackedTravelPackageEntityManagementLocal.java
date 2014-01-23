package entitymanagement;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface PrepackedTravelPackageEntityManagementLocal {

	
	public <PrepackedTravelPackage> void create(PrepackedTravelPackage p);
	public <PrepackedTravelPackage>  PrepackedTravelPackage find(Object id);
	public <PrepackedTravelPackage> void edit (PrepackedTravelPackage p);
    public <PrepackedTravelPackage>   List<PrepackedTravelPackage> findAll();
    public Long findIdEmployeeCreator(Long idPrepackedTravelPackage);
}
