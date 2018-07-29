package com.adhoc.erna;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Sensor {

    @Id
    @GeneratedValue
    public long id;

    @Column
    private String sensorId;

    @Column
    private boolean connected;

    @Column
    private LocalDateTime lastSeen;

    static Sensor fromStatus(FenceStatus status) {
        Sensor sensor = new Sensor();
        sensor.lastSeen = status.getStatusTime();
        sensor.connected = status.isConnected();
        sensor.sensorId = status.getSensorId();

        return sensor;
    }

    void hasStatus(FenceStatus status) {
        this.connected = status.isConnected();
        this.lastSeen = status.getStatusTime();
    }
}
