package pl.serwiszarogiem.service.email;

import org.springframework.mail.MailMessage;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface EmailService {
    String sendMailWithNewPassword(String emailTo) throws MessagingException;
    String sendMailWithNewToken(String emailTo) throws MessagingException;
    MailMessage prepareMessage(String to, String url, String subject);
}
