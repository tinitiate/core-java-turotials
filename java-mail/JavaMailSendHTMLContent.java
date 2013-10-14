package JavaMail;

import javax.mail.Session;  
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import java.util.*;

// * @PROGRAM JavaMainBasics.java  
// * @AUTHOR  TINITIATE.COM / Venkata Bhattaram

// * PREREQUISITES:
// * Get the latest mail.jar from http://kenai.com/projects/javamail
// * Add it to the JAVA program CLASS_PATH 

//****************************************************************************
// * @CLASS JavaMailBasics
// * @NOTES 1) This Program explains a basic implementation of the JavaMail API.
// *        2) Message Class: Defines From, To, Subject and Message.
// *        3) Folder Class: Stores the Method Object + Flags (Read, Unread ...).
// *        4) Transport Class: Send Method()
// *        5) Session Class: Provides a default authenticated session object.
// *        6) THIS PROGRAM SENDS A TEST MAIL in HTML Format.    
//****************************************************************************
public class JavaMailSendHTMLContent {

        // * @METHOD  main()
        // * @NOTES   1) The main method of the program
        // *          2) This Method sends a simple mail to a Target MailBox
        public static void main(String[] args) {
            try
            {
              String smtpHost        = "mailhost";
              int    smtpPort        = 25;
              String from_emailID    = "fromSender@somemail.com";
              String to_emailID      = "toReceiver@somemail.com";

              String eMailSubject    = "Mail Testing";
              // The HTML eMail Body
              String eMailHTMLBody   ="<head>" + 
                                      "<style type=\"text/css\"> " +
                                      "body {background-color:green} " +
                                      "p {color:blue} " +
                                      "</style> " +
                                      "<p> Tinitiate.com Message </p> " +
                                      "<body> " +
                                      "Hello World, HTML Email " +
                                      "</body> " +
                                      "</head> ";

              // Create PROPERTIES Object
              // Create mail session and specify the Mail Host and port
              java.util.Properties props = new java.util.Properties();
              props.put("mail.smtp.host", smtpHost);
              props.put("mail.smtp.port", smtpPort);

              // Create SESSION Object
              Session session = Session.getDefaultInstance(props, null);

              // Create MESSAGE Object
              // Construct the From, To, Subject and Message 
              Message msg = new MimeMessage(session);
              msg.setFrom(new InternetAddress(from_emailID));
              msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to_emailID));
              msg.setSubject(eMailSubject);
              msg.setContent(eMailHTMLBody, "text/html");

              // Create TRANSPORT Object
              // Send the message
              Transport.send(msg);
            }
            catch (Exception ex) { ex.printStackTrace(); }
    }
}

