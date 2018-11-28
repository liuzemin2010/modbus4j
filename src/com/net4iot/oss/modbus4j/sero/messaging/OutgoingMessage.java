package com.net4iot.oss.modbus4j.sero.messaging;

public interface OutgoingMessage {
    /**
     * Return the byte array representing the serialization of the request.
     * 
     * @return byte array representing the serialization of the request
     */
    byte[] getMessageData();
}
