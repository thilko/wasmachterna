package com.adhoc.erna;

import lombok.Data;

@Data
class SensorMessage {

    private String type;
    private boolean old_value;
    private boolean new_value;
    private String value_name;

    boolean isEvent() {
        return "event".equals(type);
    }
}



