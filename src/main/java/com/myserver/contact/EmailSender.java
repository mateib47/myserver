package com.myserver.contact;

public interface EmailSender {
    void send(String to, String email);
    boolean validate(String email);

}

