package com.contest.notification.notificationMedium.Mail;

import com.contest.notification.dto.Header;
import com.contest.notification.entity.User;
import com.contest.notification.notificationMedium.Sender;
import com.contest.notification.notificationMedium.SenderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service(value = "MailSender")
public class MailSender implements  Sender {

    @Autowired
    private JavaMailSender sender;

    public void send(Header header, String message, String title, User user) {
        LOGGER.info("header:{}",header.toString());
        LOGGER.info("title:{}",title);
        LOGGER.info("User:{}",user.toString());
        LOGGER.info("message:{}",message);

        if (user.getEmailId()==null){
            return;
        }
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        try {
            helper.setTo(user.getEmailId());
            helper.setText(message);
            helper.setSubject(title);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(mimeMessage);



//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo(user.getEmailId());
//        mailMessage.setSubject(title);
//        mailMessage.setText(message);
//        mailSender.send(mailMessage);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MailSender.class);

}

