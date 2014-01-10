package dto;


public class EmployeeDTO extends GenericUserDTO {
	 
	/**
	 * Constructor used during the registration phase : it lacks of the username
	 * @param email 
	 * @param name
	 * @param surname
	 * @param telephone
	 * @param password
	 */
	public EmployeeDTO(String email, String name, String surname,
			String telephone, String password) {
		super(email, name, surname, telephone, password,null);
	}

	
/**
 * full constructor of the employeeDTO: it is used during the login phase and to retrieve general information about the employee
 * @param email
 * @param name
 * @param surname
 * @param telephone
 * @param password
 * @param username
 */
	public EmployeeDTO(String email, String name, String surname,
			String telephone, String password, String username) {
		super(email, name, surname, telephone, password, username);
	} 
	   
}
