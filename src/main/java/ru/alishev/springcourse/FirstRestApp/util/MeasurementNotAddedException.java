package ru.alishev.springcourse.FirstRestApp.util;

public class MeasurementNotAddedException extends RuntimeException{
    public MeasurementNotAddedException(String message) {
        super(message);
    }
}
