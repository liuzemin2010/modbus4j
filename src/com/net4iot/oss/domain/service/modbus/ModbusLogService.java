package com.net4iot.oss.domain.service.modbus;

import com.net4iot.oss.domain.model.modbus.ModbusLog;
import com.net4iot.oss.domain.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("modbusLogService")
public class ModbusLogService extends AbstractService {

    @Transactional
    public List<ModbusLog> queryBydateDiff(String dateDiff) {
        //List<ModbusLog> list = find("from ModbusLog where create_time <", "'"+dateDiff+"'");
        List<ModbusLog> list = findBySQLSimple(ModbusLog.class," select  *  from modbus_log where create_time <  "+"'"+dateDiff+"'");
        return list;
    }

    @Transactional
    public void delete(Object entity) {
        super.delete(entity);
    }

    public ModbusLog findById(Long id) {
        return this.findUnique("from  ModbusLog where id =?", id);
    }
}
