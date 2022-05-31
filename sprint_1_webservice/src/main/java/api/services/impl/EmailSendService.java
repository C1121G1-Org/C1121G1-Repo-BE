package api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/*
    Created by KhaiTT
    Date: 23:19 31/05/2022
    Function: Config email sender.
*/
@Service
public class EmailSendService {
    @Autowired
    private JavaMailSender mailSender;

    public void setMail(String toEmail,
                        String subject,
                        String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("c1121g1.codegym@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Email sent successfully");
    }
}
