package com.basit.cz.easyschoolapp.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Contact {
    String name,mobileNum, email,subject,message;
}
