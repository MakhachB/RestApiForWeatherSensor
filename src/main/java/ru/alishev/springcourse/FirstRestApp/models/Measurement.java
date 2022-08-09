package ru.alishev.springcourse.FirstRestApp.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @Min(value = -100, message = "Value should be greater than -100")
    @Max(value = 100, message = "Value should be lesser than 100")
    private double value;

    @Column(name = "raining")
    @NotNull(message = "Field of raining should be true or false")
    private boolean raining;

    @Column(name = "measured_at")
    private LocalDateTime measuredAt;

    @ManyToOne
    @JoinColumn(name = "sensors_id", referencedColumnName = "id")
    private Sensor sensor;

    public Measurement(double value, boolean raining, LocalDateTime measuredAt) {
        this.value = value;
        this.raining = raining;
        this.measuredAt = measuredAt;
    }

    public Measurement() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public LocalDateTime getMeasuredAt() {
        return measuredAt;
    }

    public void setMeasuredAt(LocalDateTime measuredAt) {
        this.measuredAt = measuredAt;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", value=" + value +
                ", raining=" + raining +
                ", measuredAt=" + measuredAt +
                '}';
    }
}
