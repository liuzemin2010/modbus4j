package com.net4iot.oss.modbus4j.sero.messaging;

public class DefaultMessagingExceptionHandler implements MessagingExceptionHandler {
    public void receivedException(Exception e) {
        e.printStackTrace();
    }
}
