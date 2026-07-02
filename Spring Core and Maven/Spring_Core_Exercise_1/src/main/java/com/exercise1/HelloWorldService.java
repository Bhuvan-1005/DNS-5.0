package com.exercise1;

public class HelloWorldService implements MessageService {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
