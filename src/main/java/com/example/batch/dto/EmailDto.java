package com.example.batch.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by whilemouse on 17. 8. 29.
 */
public class EmailDto {

    @Data
    public static class Message {
        @Email
        @NotNull
        @Size(min = 1, message = "Please, set an email address to send the message to it")
        private String to;
        private String subject;
        private String text;
    }

}
