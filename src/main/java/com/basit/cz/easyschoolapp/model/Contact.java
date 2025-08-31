package com.basit.cz.easyschoolapp.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

@Data
public class Contact {
    @NotEmpty(message = "Name shouldn't be empty!")
    String name;

    @NotEmpty(message = "Mobile number is required!")
    @Size(max = 13, message = "Mobile number cannot be longer than 13 digits")
    @Pattern(regexp = "^[0-9]*$", message = "Mobile number must contain only digits")
    String mobileNum;

    @NotEmpty(message = "Email is required!")
    @Email(message = "Invalid email address")
    String email;

    @NotBlank(message = "Subject is required!")
    @Min(value = 10,message = "Subject should be b/w 10 & 255")
    @Max(value = 255,message = "Subject should be b/w 10 & 255")
    String subject;

    @NotBlank(message = "Message is required")
    String message;
}
