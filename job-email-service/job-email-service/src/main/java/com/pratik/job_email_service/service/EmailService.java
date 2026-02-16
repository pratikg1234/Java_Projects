package com.pratik.job_email_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendConfirmationEmail(String toEmail, String applicantName, String jobTitle) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Application Received for " + jobTitle);
        message.setText("Dear " + applicantName + ",\n\nThank you for applying for the role of " + jobTitle + ". We will review your application and get back to you.\n\nBest regards,\nJob Board Lite Team");

        mailSender.send(message);
    }
}
