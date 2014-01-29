package mailSender;

import javax.ejb.Local;

@Local
public interface MailSenderLocal {
    public boolean simpleSendMail (String mailAddress,String object,String text);

}
