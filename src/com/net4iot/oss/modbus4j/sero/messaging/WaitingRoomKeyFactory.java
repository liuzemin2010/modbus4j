package com.net4iot.oss.modbus4j.sero.messaging;


public interface WaitingRoomKeyFactory {
    WaitingRoomKey createWaitingRoomKey(OutgoingRequestMessage request);

    WaitingRoomKey createWaitingRoomKey(IncomingResponseMessage response);
}
