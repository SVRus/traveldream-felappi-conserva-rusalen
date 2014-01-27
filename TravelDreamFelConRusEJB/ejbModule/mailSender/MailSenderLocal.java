package mailSender;

import javax.ejb.Local;

@Local
public interface MailSenderLocal {
    public boolean sendMail (String mailAddress,String object,String text);

}
