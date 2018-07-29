package com.adhoc.erna;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
class FenceStatus {

    @Column
    String sensorId;

    @Column
    private LocalDateTime statusTime;

    @Column
    private boolean connected;

    static FenceStatus from(SensorMessage sensorMessage) {
        FenceStatus status = new FenceStatus();
        status.statusTime = LocalDateTime.now();
        status.connected = sensorMessage.isNew_value();
        status.sensorId = "8773887";

        return status;
    }
}
