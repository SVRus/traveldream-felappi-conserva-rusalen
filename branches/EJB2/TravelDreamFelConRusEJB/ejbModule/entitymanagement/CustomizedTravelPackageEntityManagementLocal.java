package entitymanagement;

import java.util.List;

import entities.CustomizedTravelPackage;

public interface CustomizedTravelPackageEntityManagementLocal {
    public String findIdCustomizer(Long idPrepackedTravelPackage);
	public <CustomizedTravelPackage>  CustomizedTravelPackage find(Object id);
	public <CustomizedTravelPackage> void edit(CustomizedTravelPackage customizedTravelPackage);
    public <CustomizedTravelPackage>   List<CustomizedTravelPackage> findAll();
    public CustomizedTravelPackage findCustomizedTravelPackageForFriend(String code);

}
