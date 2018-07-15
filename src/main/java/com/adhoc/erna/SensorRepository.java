package com.adhoc.erna;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Sensor findBySensorId(String sensorId);

    boolean existsBySensorId(String sensorId);
}
