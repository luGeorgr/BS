package www.george.com.service;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    private static Properties prop;
    private static String MAIL_FROM = "18258072760@163.com";
    private static String MAIL_PASSWORD = "lu123456";
    public EmailService(){
        prop = new Properties();
        prop.setProperty("mail.host", "smtp.163.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
    }

    public void sendEmail(final String emailAddr) throws Exception{
        Session session = Session.getInstance(prop);
        session.setDebug(true);
        Transport ts = session.getTransport();
        ts.connect("smtp.163.com", "18258072760", MAIL_PASSWORD);
        Message message = createSimpleMail(session, emailAddr);

        ts.sendMessage(message, message.getAllRecipients());
        ts.close();

    }

    private MimeMessage createSimpleMail(Session session, final String mailTo) throws Exception{
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(MAIL_FROM));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
        message.setSubject("单词背诵账号确认邮件");
        String content = "确认请点击下述地址：http://localhost:9999/ReciteWebApp/account/" + mailTo;
        message.setContent(content, "text/html;charset=UTF-8");
        return message;
    }
}
