package pl.serwiszarogiem.service.email;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.serwiszarogiem.service.token.TokenService;
import pl.serwiszarogiem.service.user.UserService;

import java.util.UUID;


@Log4j2
@Component
@Primary
public class MailService implements EmailService {

    private final static String SUBJECT_REGISTER = "Link do rejestracji na stronie serwis za rogiem";
    private final static String URL_REGISTER = "http://localhost:8080/register/";
    private final static String EMAIL_ADDRESS = System.getProperty("EMAIL_USERNAME");

    private final static String SUBJECT_FORGOT_PASSWORD = "Przypomnienie hasła do strony serwis za rogiem";
    private final static String URL_FORGOT_PASSWORD = "http://localhost:8080/forgotPassword/";

    private final JavaMailSender emailSender;
    private final UserService userService;
    private final TokenService tokenService;

    @Autowired
    public MailService(JavaMailSender emailSender, UserService userService, TokenService tokenService) {
        this.emailSender = emailSender;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @Override
    public String sendMailWithNewPassword(String emailTo) {
        if (userService.findByEmailIgnoreCase(emailTo) != null) {
            try {
                final String tokenValue = UUID.randomUUID().toString();
                emailSender.send(prepareMessage(emailTo, URL_FORGOT_PASSWORD + tokenValue, SUBJECT_FORGOT_PASSWORD));
                tokenService.save(emailTo, tokenValue);
            } catch (MailException e) {
                log.error("Error while sending out email..{}", e.getStackTrace());
                log.error("Error while sending out email..{}", e.fillInStackTrace());
                return "Problem podczas wysyłania email, spróbuj jeszcze raz później";
            }
            return "Email został poprawnie wysłany, sprawdź skrzynkę email.";
        } else {
            return "Użytkownik o tym email jest już w bazie danych.";
        }
    }

    @Override
    public String sendMailWithNewToken(String emailTo) {
        if (userService.findByEmailIgnoreCase(emailTo) == null) {
            try {
                final String tokenValue = UUID.randomUUID().toString();
                emailSender.send(prepareMessage(emailTo, URL_REGISTER + tokenValue, SUBJECT_REGISTER));
                tokenService.save(emailTo, tokenValue);
            } catch (MailException e) {
                log.error("Error while sending out email..{}", e.getStackTrace());
                log.error("Error while sending out email..{}", e.fillInStackTrace());
                return "Problem podczas wysyłania email, spróbuj jeszcze raz później.";
            }
            return "Email został poprawnie wysłany, sprawdź skrzynkę email.";
        } else {
            return "Użytkownik o tym email jest już w bazie danych.";
        }
    }

    @Override
    public SimpleMailMessage prepareMessage(String to, String url, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(EMAIL_ADDRESS);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(url);
        return message;
    }
}
