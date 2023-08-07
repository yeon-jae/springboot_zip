package com.springboot.rest.webservices.restfulwebservice.exception;

import java.time.LocalDate;

public class ErrorDetails {
    //timestamp
    private LocalDate timestamp;
    //message
    private String message;
    //details
    private String details;

    //constructor

    public ErrorDetails(LocalDate timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
    //getter

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }


}
