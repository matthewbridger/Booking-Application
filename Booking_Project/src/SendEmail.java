    import java.util.*;  
    import javax.mail.*;  
    import javax.mail.internet.*;   
    import javax.activation.*;
    
    
    public class SendEmail  
    {  
     public static void main(String[] args) throws Exception{
          DBManager manager = new DBManager();
          String accountEmail = " ";//change accordingly
          String password = ""; //change accordingly
      
         //Get the session object  
          Properties properties = System.getProperties(); 
          properties.put("mail.smtp.auth", "true");
          properties.put("mail.smtp.starttls.enable", "true");
          properties.put("mail.smtp.host", "smtp.live.com");
          properties.put("mail.smtp.port","587");
          
          Session session = Session.getInstance(properties, new Authenticator() {
          @Override
          protected PasswordAuthentication getPasswordAuthentication() {
        	  return new PasswordAuthentication(accountEmail, password);
          }
          
          });
          
          
          Message message = prepareMessage(session, accountEmail);
          
          // Send message  
          try {
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
          System.out.println("message sent successfully...."); 
     }
private static Message prepareMessage(Session session, String accountEmail) {​​​​​         //compose the message          
     try{​​​​​            
     MimeMessage message = new MimeMessage(session);             
message.setFrom(new InternetAddress(accountEmail));             
DBManager manager = new DBManager();             
message.addRecipient(Message.RecipientType.TO,new InternetAddress(manager.getEmail();));            
 message.setSubject("Ping");            
  message.setText("Hello, this is example of sending email  ");            
   return message;          
   }​​​​​ catch (Exception ex) {​​​​​          
   return null;          
   }​​​​​       
      }​​​​​        


          
   }

          

