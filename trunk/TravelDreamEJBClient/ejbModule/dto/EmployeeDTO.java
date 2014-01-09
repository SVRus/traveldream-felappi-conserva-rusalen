package dto;

import java.util.List;

public class EmployeeDTO extends GenericUserDTO {
	 
	
	private long code;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public EmployeeDTO(String email, String name, String surname,
			String telephone, String password, String username, long code) {
		super(email, name, surname, telephone, password, username);
		this.code = code;
	} 
	   
}
