package ru.geekbrains.app.homework9.exceptions;

public class ResourceExistsException extends RuntimeException {

    public ResourceExistsException(String message) {
        super(message);
    }

}