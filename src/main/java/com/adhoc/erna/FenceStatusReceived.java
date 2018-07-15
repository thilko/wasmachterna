package com.adhoc.erna;

import org.springframework.context.ApplicationEvent;

class FenceStatusReceived extends ApplicationEvent {

    private final FenceStatus status;

    FenceStatusReceived(Object source, FenceStatus status) {
        super(source);
        this.status = status;
    }

    FenceStatus getStatus() {
        return status;
    }
}
