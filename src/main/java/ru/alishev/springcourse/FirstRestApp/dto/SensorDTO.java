package ru.alishev.springcourse.FirstRestApp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SensorDTO {

    @NotNull(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
