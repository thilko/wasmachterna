package com.adhoc.erna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorController(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @GetMapping("/{sensorId}")
    public Sensor getSensor(@PathVariable String sensorId) {
        return sensorRepository.findBySensorId(sensorId);
    }
}
