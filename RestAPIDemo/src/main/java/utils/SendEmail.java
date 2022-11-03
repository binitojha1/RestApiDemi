package utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmail {

    public void sendMail(String fileNAme) {
        // Create the attachment
        try{
            EmailAttachment attachment = new EmailAttachment();

            attachment.setPath(System.getProperty("user.dir") + "//target\\extentreports//" + fileNAme+".html");


            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription(" Test Execution Report");
            attachment.setName("Automation Test Execution Report");

            // Create the email message
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.gmail.com");
            // email.setSSLOnConnect(true);
            email.setSSL(true);
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("binit1998ojha@gmail.com", "123456Noida"));
            email.addTo("binito@testvagrant.com", "Binit Ojha");
            email.setFrom("binit1998ojha@gmail.com", "Me");
            email.setSubject("API Automation Test Execution Report");
            email.setMsg("Dear all ! Please find the attached report.");

            // add the attachment
            email.attach(attachment);

            // send the email
            email.send();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
