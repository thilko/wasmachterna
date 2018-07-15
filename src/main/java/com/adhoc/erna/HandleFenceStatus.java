package com.adhoc.erna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class HandleFenceStatus implements ApplicationListener<FenceStatusReceived> {

    private final SensorRepository sensorRepository;

    @Autowired
    public HandleFenceStatus(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public void onApplicationEvent(FenceStatusReceived event) {
        FenceStatus status = event.getStatus();

        Sensor sensor = getOrCreateSensor(status);
        sensor.hasStatus(status);

        sensorRepository.save(sensor);

        System.out.println(status);
    }

    private Sensor getOrCreateSensor(FenceStatus status) {
        if(sensorRepository.existsBySensorId(status.getSensorId())){
            return sensorRepository.findBySensorId(status.getSensorId());

        }else{
            return Sensor.fromStatus(status);
        }
    }
}
