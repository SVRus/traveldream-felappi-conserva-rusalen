package mailSender;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MailSender
 */
@Stateless
@LocalBean
public class MailSender implements MailSenderLocal {

    /**
     * Default constructor. 
     */
    public MailSender() {
        // TODO Auto-generated constructor stub
    }

    public boolean simpleSendMail (String mailAddress,String object,String text)
    {
    	
    	return true;
    	
    }
    
}
