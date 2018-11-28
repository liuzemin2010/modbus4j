/*
 * ============================================================================
 * GNU General Public License
 * ============================================================================
 *
 * Copyright (C) 2006-2011 Serotonin Software Technologies Inc. http://serotoninsoftware.com
 * @author Matthew Lohbihler
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.net4iot.oss.modbus4j;

import com.net4iot.oss.modbus4j.base.ModbusUtils;
import com.net4iot.oss.modbus4j.code.RegisterRange;
import com.net4iot.oss.modbus4j.exception.ModbusIdException;
import com.net4iot.oss.modbus4j.ip.IpParameters;
import com.net4iot.oss.modbus4j.ip.listener.TcpListener;
import com.net4iot.oss.modbus4j.ip.tcp.TcpSlave;
import com.net4iot.oss.modbus4j.ip.udp.UdpMaster;
import com.net4iot.oss.modbus4j.ip.udp.UdpSlave;
import com.net4iot.oss.modbus4j.base.ModbusUtils;
import com.net4iot.oss.modbus4j.code.RegisterRange;
import com.net4iot.oss.modbus4j.exception.ModbusIdException;
import com.net4iot.oss.modbus4j.exception.ModbusTransportException;
import com.net4iot.oss.modbus4j.ip.IpParameters;
import com.net4iot.oss.modbus4j.ip.listener.TcpListener;
import com.net4iot.oss.modbus4j.ip.tcp.TcpMaster;
import com.net4iot.oss.modbus4j.ip.tcp.TcpSlave;
import com.net4iot.oss.modbus4j.ip.udp.UdpMaster;
import com.net4iot.oss.modbus4j.ip.udp.UdpSlave;
import com.net4iot.oss.modbus4j.msg.*;
import com.net4iot.oss.modbus4j.serial.SerialPortWrapper;
import com.net4iot.oss.modbus4j.serial.ascii.AsciiMaster;
import com.net4iot.oss.modbus4j.serial.ascii.AsciiSlave;
import com.net4iot.oss.modbus4j.serial.rtu.RtuMaster;
import com.net4iot.oss.modbus4j.serial.rtu.RtuSlave;
import com.net4iot.oss.modbus4j.msg.ModbusRequest;
import com.net4iot.oss.modbus4j.msg.ReadCoilsRequest;
import com.net4iot.oss.modbus4j.msg.ReadDiscreteInputsRequest;
import com.net4iot.oss.modbus4j.msg.ReadInputRegistersRequest;
import com.net4iot.oss.modbus4j.serial.SerialPortWrapper;
import com.net4iot.oss.modbus4j.serial.ascii.AsciiSlave;
import com.net4iot.oss.modbus4j.serial.rtu.RtuMaster;

public class ModbusFactory {
    //
    // Modbus masters
    //
    public ModbusMaster createRtuMaster(SerialPortWrapper wrapper) {
        return new RtuMaster(wrapper);
    }
    
    public ModbusMaster createAsciiMaster(SerialPortWrapper wrapper) {
        return new AsciiMaster(wrapper);
    }

    public ModbusMaster createTcpMaster(IpParameters params, boolean keepAlive) {
        return new TcpMaster(params, keepAlive);
    }

    public ModbusMaster createUdpMaster(IpParameters params) {
        return new UdpMaster(params);
    }

    public ModbusMaster createTcpListener(IpParameters params) {
        return new TcpListener(params);
    }

    //
    // Modbus slaves
    //
    public ModbusSlaveSet createRtuSlave(SerialPortWrapper wrapper) {
        return new RtuSlave(wrapper);
    }

    public ModbusSlaveSet createAsciiSlave(SerialPortWrapper wrapper) {
        return new AsciiSlave(wrapper);
    }

    public ModbusSlaveSet createTcpSlave(boolean encapsulated) {
        return new TcpSlave(encapsulated);
    }

    public ModbusSlaveSet createUdpSlave(boolean encapsulated) {
        return new UdpSlave(encapsulated);
    }

    //
    // Modbus requests
    //
    public ModbusRequest createReadRequest(int slaveId, int range, int offset, int length)
            throws ModbusTransportException, ModbusIdException {
        ModbusUtils.validateRegisterRange(range);

        if (range == RegisterRange.COIL_STATUS)
            return new ReadCoilsRequest(slaveId, offset, length);

        if (range == RegisterRange.INPUT_STATUS)
            return new ReadDiscreteInputsRequest(slaveId, offset, length);

        if (range == RegisterRange.INPUT_REGISTER)
            return new ReadInputRegistersRequest(slaveId, offset, length);

        return new ReadHoldingRegistersRequest(slaveId, offset, length);
    }
}
