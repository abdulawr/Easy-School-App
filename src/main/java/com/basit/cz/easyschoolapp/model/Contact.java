package com.basit.cz.easyschoolapp.model;

import lombok.Data;

@Data
public class Contact {
    String name,mobileNum, email,subject,message;


    @Override
    public String toString() {
        return "Contact [name=" + name + ", email=" + email + ", mobileNum=" +
                mobileNum + ", subject=" + subject + ", message=" + message + "]";
    }
}
