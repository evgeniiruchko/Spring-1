package ru.geekbrains.app.homework9.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class Errors {
    private int status;
    private String message;
    private Date timeStamp;

    public Errors(int status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = new Date();
    }
}
