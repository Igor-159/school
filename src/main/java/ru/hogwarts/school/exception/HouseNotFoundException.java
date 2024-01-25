package ru.hogwarts.school.exception;

public class HouseNotFoundException extends RuntimeException{
    public HouseNotFoundException(String message) {
        super(message);
    }
}
