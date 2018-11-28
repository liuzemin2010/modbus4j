package com.net4iot.oss.domain.service.modbus;

import com.net4iot.oss.domain.model.modbus.ModbusProtocolBasic;
import com.net4iot.oss.domain.service.AbstractService;
import org.springframework.stereotype.Service;

@Service("modbusProtocolBasicService")
public class ModbusProtocolBasicService extends AbstractService {

    public ModbusProtocolBasic findById(Long id) {
        return this.findUnique("from  ModbusProtocolBasic where id =?", id);
    }
}
