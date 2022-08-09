package ru.alishev.springcourse.FirstRestApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.alishev.springcourse.FirstRestApp.dto.MeasurementDTO;
import ru.alishev.springcourse.FirstRestApp.services.SensorService;

@Component
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return MeasurementDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MeasurementDTO measurementDTO = (MeasurementDTO) o;

        if (sensorService.findSensorByName(measurementDTO.getSensor().getName()).isEmpty()) {
            errors.rejectValue("sensorDTO", "", "Sensor with this name is not exists");
        }
    }
}
