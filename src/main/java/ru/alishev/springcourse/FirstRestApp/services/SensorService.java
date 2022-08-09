package ru.alishev.springcourse.FirstRestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.FirstRestApp.models.Measurement;
import ru.alishev.springcourse.FirstRestApp.models.Sensor;
import ru.alishev.springcourse.FirstRestApp.repositories.MeasurementRepository;
import ru.alishev.springcourse.FirstRestApp.repositories.SensorRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    @Transactional
    public void save(Sensor sensor) {
        enrichSensor(sensor);
        sensorRepository.save(sensor);
    }

    @Transactional
    public Optional<Sensor> findSensorByName(String name) {
        return sensorRepository.findSensorByName(name);
    }

    private void enrichSensor(Sensor sensor) {

    }
}
