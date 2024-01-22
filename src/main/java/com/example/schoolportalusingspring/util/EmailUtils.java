package com.example.schoolportalusingspring.util;

import jakarta.mail.internet.MimeMessage;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

@Autowired
    private JavaMailSender javaMailSender;

       public boolean sendEmail(String toAddress, String subject, String body) {
            //create a simple email message
           boolean isSent = false;
           try {
               MimeMessage message = javaMailSender.createMimeMessage();
               MimeMessageHelper helper = new MimeMessageHelper(message);
               helper.setTo(toAddress);
               helper.setSubject(subject);
               helper.setText(body , true);
               javaMailSender.send(message);
                isSent = true;
           }catch (Exception e){
               e.printStackTrace();
           }
            return isSent;
        }

}
