package com.example.demo.exception;

public class MailSenderException extends RuntimeException {
    public MailSenderException(String message) {
        super(message);
    }
}
