package JavaMail;

import javax.mail.Multipart;
import javax.mail.Session;  
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//import java.util.*;

// * @PROGRAM JavaMainBasics.java  
// * @AUTHOR  TINITIATE.COM / Venkata Bhattaram

//* PREREQUISITES:
//* Get the latest mail.jar from http://kenai.com/projects/javamail
//* Add it to the JAVA program CLASS_PATH 

//****************************************************************************
// * @CLASS JavaMailBasics
// * @NOTES 1) This Program explains a basic implementation of the JavaMail API.
// *        2) Message Class: Defines From, To, Subject and Message.
// *        3) Folder Class: Stores the Method Object + Flags (Read, Unread ...).
// *        4) Transport Class: Send Method()
// *        5) Session Class: Provides a default authenticated session object.
// *        6) THIS PROGRAM SENDS A TEST MAIL with an ATTACHMENT(s). 
// *        7) Make sure there are files (Or Edit the Program to change (Attachment1Path/Attachment2Path) 
// *            c:\\MyFiles\\Attachment1.txt
// *            c:\\MyFiles\\Attachment2.txt

//****************************************************************************
public class JavaMailSendAttachments {

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
              String eMailSubject    = "Test Mail";
              String eMailBody       = "Please see the attachment for more details -TINITIATE";

              // Specify the Attachments path
              // MAKE SURE there are files exist
              // c:\\MyFiles\\Attachment1.txt
              // c:\\MyFiles\\Attachment2.txt
              String Attachment1Path  = "c:\\MyFiles\\Attachment1.txt";
              String Attachment2Path  = "c:\\MyFiles\\Attachment2.txt";

              // * PROPERTIES OBJECT
              // Create mail session and specify the Mail Host and port
              java.util.Properties props = new java.util.Properties();
              props.put("mail.smtp.host", smtpHost);
              props.put("mail.smtp.port", smtpPort);

              // * Create SESSION OBJECT
              Session session = Session.getDefaultInstance(props, null);

              // * MESSAGE OBJECT
              // Construct the From, To, Subject and Message
              Message msg = new MimeMessage(session);
              msg.setFrom(new InternetAddress(from_emailID));
              msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to_emailID));
              msg.setSubject(eMailSubject);

              // * MIMEBODYPART OBJECT
              // Create MineBodyPart for eMailBody
              MimeBodyPart mailBody = new MimeBodyPart();
              mailBody.setText(eMailBody);

              // Create MineBodyPart ONE for Each Attachment
              MimeBodyPart mbp1 = new MimeBodyPart();
              // Add attachment
              mbp1.attachFile(Attachment1Path);

              // Create MineBodyPart
              MimeBodyPart mbp2 = new MimeBodyPart();
              // Add attachment
              mbp2.attachFile(Attachment2Path);

              // * MULITPART OBEJCT 
              // Create Multipart Object 
              Multipart mp = new MimeMultipart();

              // Assign MailBody to Multipart Object 
              mp.addBodyPart(mailBody);

              // Assign Attachments to Multipart Object
              mp.addBodyPart(mbp1);
              mp.addBodyPart(mbp2);

              // * ASSIGN ALL MULITPART to MESSAGE OBJECT 
              // add the Multipart to the message
              msg.setContent(mp);

              // * ASSIGN ALL MESSAGE to TRANSPORT OBJECT
              // Send the message
              Transport.send(msg);
            }
            catch (Exception ex) { ex.printStackTrace(); }
    }
}
