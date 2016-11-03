/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingsw;

/**
 *
 * @author shady
 */

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class SendEmail {

    private final String senderEmail;
    private final String senderPassword;
    private final String emailSMTPserver;
    private final String emailServerPort;
    private String receiverEmail = null;
    private String emailSubject = null;
    private String emailBody = null;

    /**
     *
     * @param receiverEmail
     * @param Subject
     * @param message
     * @param html // if true will be uset setContent instead of setText
     */
    public SendEmail(String receiverEmail, String Subject, String message, boolean html) {
        this.senderEmail = "ingsw@informatica-unina.com";
        this.emailSMTPserver = "SMTPSERVER";
        this.emailServerPort = "465";
        this.senderPassword = "PASSWORD";
        this.receiverEmail = receiverEmail;
        this.emailSubject = Subject;
        this.emailBody = message;

        Properties props = new Properties();
        props.put("mail.smtp.user", senderEmail);
        props.put("mail.smtp.host", emailSMTPserver);
        props.put("mail.smtp.port", emailServerPort);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", emailServerPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        SecurityManager security = System.getSecurityManager();

        try {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);

            Message msg = new MimeMessage(session);
            if (html == true) {
                msg.setContent(emailBody, "text/html"); //in order to send HTML email
            }
            else {
                msg.setText(emailBody); // in order to send plain text 
            }
            msg.setSubject(emailSubject);
            msg.setFrom(new InternetAddress(senderEmail));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(receiverEmail));
            Transport.send(msg);
            System.out.println("send successfully"); // NOTE // We need to improve the swing error dialog
            session = null; // GC help
            msg = null;  // GC help
        } catch (Exception ex) {
            System.err.println("Error occurred while sending.!"); // NOTE // We need to improve the swing error dialog
        }
        security = null; // GC help
        
    }
    
    private class SMTPAuthenticator extends javax.mail.Authenticator {

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmail, senderPassword);
        }
    }
    
}