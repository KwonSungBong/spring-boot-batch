package com.example.batch.controller;

import com.example.batch.component.EmailComponent;
import com.example.batch.dto.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by whilemouse on 17. 8. 29.
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    public EmailComponent emailComponent;

    @Value("${email-upload-path}")
    private String attachmentPath;

    @Autowired
    public SimpleMailMessage template;

    private static final Map<String, Map<String, String>> labels;

    static {
        labels = new HashMap<>();

        //Simple email
        Map<String, String> props = new HashMap<>();
        props.put("headerText", "Send Simple Email");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "");
        labels.put("send", props);

        //Email with template
        props = new HashMap<>();
        props.put("headerText", "Send Email Using Template");
        props.put("messageLabel", "Template Parameter");
        props.put("additionalInfo",
                "The parameter value will be added to the following message template:<br>" +
                        "<b>This is the test email template for your email:<br>'Template Parameter'</b>"
        );
        labels.put("sendTemplate", props);

        //Email with attachment
        props = new HashMap<>();
        props.put("headerText", "Send Email With Attachment");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "To make sure that you send an attachment with this email, change the value for the 'attachment.invoice' in the application.properties file to the path to the attachment.");
        labels.put("sendAttachment", props);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        emailComponent.test();
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void createMail() {
        Map<String, String> props = labels.get("send");

        EmailDto mailObject = new EmailDto();
        mailObject.setTo("rnjstjdqhd39@naver.com");
        mailObject.setSubject("TSET");
        mailObject.setText("TSETTEST");

        emailComponent.sendSimpleMessage(mailObject.getTo(),
                mailObject.getSubject(), mailObject.getText());
    }

    @RequestMapping(value = "/sendTemplate", method = RequestMethod.GET)
    public void createMailWithTemplate() {
        Map<String, String> props = labels.get("sendTemplate");

        EmailDto mailObject = new EmailDto();

        emailComponent.sendSimpleMessageUsingTemplate(mailObject.getTo(),
                mailObject.getSubject(),
                template,
                mailObject.getText());
    }

    @RequestMapping(value = "/sendAttachment", method = RequestMethod.GET)
    public void createMailWithAttachment() {
        Map<String, String> props = labels.get("sendAttachment");

        EmailDto mailObject = new EmailDto();

        emailComponent.sendMessageWithAttachment(
                mailObject.getTo(),
                mailObject.getSubject(),
                mailObject.getText(),
                attachmentPath
        );
    }
}
