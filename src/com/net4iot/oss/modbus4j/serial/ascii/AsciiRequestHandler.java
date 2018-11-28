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
package com.net4iot.oss.modbus4j.serial.ascii;

import com.net4iot.oss.modbus4j.ModbusSlaveSet;
import com.net4iot.oss.modbus4j.base.BaseRequestHandler;
import com.net4iot.oss.modbus4j.ModbusSlaveSet;
import com.net4iot.oss.modbus4j.base.BaseRequestHandler;
import com.net4iot.oss.modbus4j.msg.ModbusRequest;
import com.net4iot.oss.modbus4j.msg.ModbusResponse;
import com.net4iot.oss.modbus4j.sero.messaging.IncomingRequestMessage;
import com.net4iot.oss.modbus4j.sero.messaging.OutgoingResponseMessage;
import com.net4iot.oss.modbus4j.msg.ModbusRequest;

public class AsciiRequestHandler extends BaseRequestHandler {
    public AsciiRequestHandler(ModbusSlaveSet slave) {
        super(slave);
    }

    public OutgoingResponseMessage handleRequest(IncomingRequestMessage req) throws Exception {
        AsciiMessageRequest asciiRequest = (AsciiMessageRequest) req;
        ModbusRequest request = asciiRequest.getModbusRequest();
        ModbusResponse response = handleRequestImpl(request);
        if (response == null)
            return null;
        return new AsciiMessageResponse(response);
    }
}
