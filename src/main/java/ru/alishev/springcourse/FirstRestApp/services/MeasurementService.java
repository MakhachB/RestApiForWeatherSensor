package ru.alishev.springcourse.FirstRestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.FirstRestApp.models.Measurement;
import ru.alishev.springcourse.FirstRestApp.models.Sensor;
import ru.alishev.springcourse.FirstRestApp.repositories.MeasurementRepository;
import ru.alishev.springcourse.FirstRestApp.repositories.SensorRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    public Optional<Measurement> findOne(int id) {
        return measurementRepository.findById(id);
    }

    public int getRainyDaysCount() {
        return measurementRepository.countByRainingIsTrue();
    }

    @Transactional
    public void save(Measurement measurement) {
        Optional<Sensor> sensor = sensorRepository.findSensorByName(measurement.getSensor().getName());

        sensor.ifPresent(measurement::setSensor);

        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setMeasuredAt(LocalDateTime.now());

    }
}
