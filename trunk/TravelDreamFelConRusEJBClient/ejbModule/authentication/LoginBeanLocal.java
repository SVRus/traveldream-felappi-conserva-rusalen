package authentication;

import javax.ejb.Local;



import dto.GenericUserDTO;

@Local
public interface LoginBeanLocal {
	public GenericUserDTO findLogIn();
	public boolean isLogged();
	public String getPrincipalUsername() ;

}
