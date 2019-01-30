package com.contest.notification.notificationMedium.Mail;

import com.contest.notification.dto.Header;
import com.contest.notification.notificationMedium.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MailSender implements Sender {
    @Autowired
    private JavaMailSender sender;

    @Override
    public void send(Header header, String message) {
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setTo(header.getReceiver());
            helper.setText(message);
            helper.setSubject("Mail From Spring Boot");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        sender.send(mimeMessage);
    }
}

