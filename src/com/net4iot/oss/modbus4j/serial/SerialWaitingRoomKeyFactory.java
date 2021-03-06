package com.net4iot.oss.modbus4j.serial;

import com.net4iot.oss.modbus4j.sero.messaging.IncomingResponseMessage;
import com.net4iot.oss.modbus4j.sero.messaging.OutgoingRequestMessage;
import com.net4iot.oss.modbus4j.sero.messaging.WaitingRoomKey;
import com.net4iot.oss.modbus4j.sero.messaging.WaitingRoomKeyFactory;
import com.net4iot.oss.modbus4j.sero.messaging.IncomingResponseMessage;
import com.net4iot.oss.modbus4j.sero.messaging.OutgoingRequestMessage;
import com.net4iot.oss.modbus4j.sero.messaging.WaitingRoomKey;

public class SerialWaitingRoomKeyFactory implements WaitingRoomKeyFactory {
    private static final Sync sync = new Sync();

    @Override
    public WaitingRoomKey createWaitingRoomKey(OutgoingRequestMessage request) {
        return sync;
    }

    @Override
    public WaitingRoomKey createWaitingRoomKey(IncomingResponseMessage response) {
        return sync;
    }

    static class Sync implements WaitingRoomKey {
        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            return true;
        }
    }
}
