
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class testemail {
  public static void main(String[] args) {
  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.qq.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
	 //用户名，授权码
     final String username = "fubin199410@qq.com";
     final String password = "ldhhumywyezgbbfg";
     try{
     Session session = Session.getDefaultInstance(props, 
                          new Authenticator(){
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }});

   // -- Create a new message --
     Message msg = new MimeMessage(session);

  // -- Set the FROM and TO fields --
     msg.setFrom(new InternetAddress("fubin199410@qq.com"));
     msg.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse("18202418154@163.com",false));
  
     msg.setSubject("to you");
     msg.setText("how are you ?");
    

     msg.setSentDate(new Date());
     Transport.send(msg);

     System.out.println("Message sent.");
  }catch (MessagingException e){ System.out.println("Error: " + e);}
  }
}