package com.workiva.todo2;

import com.workiva.frugal.server.FDefaultNatsServerEventHandler;

import java.time.Clock;
import java.util.Map;

public class NatsServerEventHandler extends FDefaultNatsServerEventHandler {
    NatsServerEventHandler(long watermark) {
        super(watermark);
    }

    @Override
    public void onRequestReceived(Map<Object, Object> ephemeralProperties) {
        System.out.println("request recieved at: " + Clock.systemUTC().instant());
        super.onRequestReceived(ephemeralProperties);
    }

    @Override
    public void onRequestStarted(Map<Object, Object> ephemeralProperties) {
        if (ephemeralProperties.get(REQUEST_RECEIVED_MILLIS_KEY) != null) {
            long started = (Long)ephemeralProperties.get("request_received_millis");
            long duration = this.clock.millis() - started;
            System.out.println("request spent " + duration + "ms in the transport buffer");
        }
        super.onRequestStarted(ephemeralProperties);
    }

    @Override
    public void onRequestEnded(Map<Object, Object> ephemeralProperties) {
        System.out.println("request finished at: " + Clock.systemUTC().instant());
        super.onRequestEnded(ephemeralProperties);
    }
}
