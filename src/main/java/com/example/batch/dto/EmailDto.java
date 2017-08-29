package com.example.batch.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by whilemouse on 17. 8. 29.
 */
@Data
public class EmailDto {

    @Email
    @NotNull
    @Size(min = 1, message = "Please, set an email address to send the message to it")
    private String to;

    private String subject;

    private String text;
}
