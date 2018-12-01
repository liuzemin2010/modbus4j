package com.net4iot.oss.domain.service.modbus;

import com.net4iot.oss.domain.model.modbus.ModbusLog;
import com.net4iot.oss.domain.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("modbusLogService")
public class ModbusLogService extends AbstractService {

    public List<ModbusLog> queryBydateDiff(String dateDiff) {
        return this.find("from ModbusLog where create_time <", dateDiff);
    }

    public ModbusLog findById(Long id) {
        return this.findUnique("from  ModbusLog where id =?", id);
    }
}
