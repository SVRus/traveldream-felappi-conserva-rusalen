package entitymanagement;

import java.util.List;

public interface CustomizedTravelPackageEntityManagementLocal {
    public Long findIdCustomizer(Long idPrepackedTravelPackage);
	public <CustomizedTravelPackage>  CustomizedTravelPackage find(Object id);
	public <CustomizedTravelPackage> void edit(CustomizedTravelPackage customizedTravelPackage);
    public <CustomizedTravelPackage>   List<CustomizedTravelPackage> findAll();

}
