package dto;

import java.util.ArrayList;


public class EmployeeDTO extends GenericUserDTO {
	 
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * 
	 * @param email
	 * @param name
	 * @param surname
	 * @param telephone
	 * @param password
	 * @param username
	 * @param code
	 */
public EmployeeDTO(String email, String name, String surname,
			String telephone, String password, String username, Long code) {
		super(email, name, surname, telephone, password, username);
		this.code = code;
	}

private Long code	;
private ArrayList <ProductDTO> managedproduct;	
private ArrayList <ManagedTravelPackage >		

	   
}
