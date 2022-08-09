package ru.alishev.springcourse.FirstRestApp.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MeasurementDTO {

    @Min(value = -99, message = "Value should be greater than -100")
    @Max(value = 99, message = "Value should be lesser than 100")
    private double value;

    @NotNull(message = "Field of raining should be true or false")
    private boolean raining;

    private SensorDTO sensor;


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
