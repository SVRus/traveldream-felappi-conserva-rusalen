package dto;

import java.util.ArrayList;

public class EmployeeDTO extends GenericUserDTO {
	 
	public ArrayList<ProductDTO> getManagedproduct() {
		return managedproduct;
	}

	public void setManagedproduct(ArrayList<ProductDTO> managedproduct) {
		this.managedproduct = managedproduct;
	}

	public ArrayList<PrepackedTravelPackageDTO> getManagedTravelPackage() {
		return managedTravelPackage;
	}

	public void setManagedTravelPackage(ArrayList<PrepackedTravelPackageDTO> managedTravelPackage) {
		this.managedTravelPackage = managedTravelPackage;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}



public EmployeeDTO(String email, String name, String surname,
			String telephone, String password, String username, long code,
			ArrayList<ProductDTO> managedproduct,
			ArrayList<PrepackedTravelPackageDTO> managedTravelPackage) {
		super(email, name, surname, telephone, password, username);
		this.code = code;
		this.managedproduct = managedproduct;
		this.managedTravelPackage = managedTravelPackage;
	}



private long code	;
private ArrayList <ProductDTO> managedproduct;	
private ArrayList <PrepackedTravelPackageDTO> managedTravelPackage;

public void addProduct(ArrayList <ProductDTO> products)
{
managedproduct.addAll(products);
}
public void addPackage(ArrayList <PrepackedTravelPackageDTO> prepackage)
{
managedTravelPackage.addAll(prepackage);
}
}
