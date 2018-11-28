package com.net4iot.oss.modbus4j.serial;

import com.net4iot.oss.modbus4j.msg.ModbusMessage;
import com.net4iot.oss.modbus4j.msg.ModbusMessage;

abstract public class SerialMessage {
    protected final ModbusMessage modbusMessage;

    public SerialMessage(ModbusMessage modbusMessage) {
        this.modbusMessage = modbusMessage;
    }

    public ModbusMessage getModbusMessage() {
        return modbusMessage;
    }

    @Override
    public String toString() {
        return "SerialMessage [modbusMessage=" + modbusMessage + "]";
    }
}
