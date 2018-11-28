package com.net4iot.oss.domain.service.modbus;

import com.net4iot.oss.domain.model.modbus.ModbusBusinessCommand;
import com.net4iot.oss.domain.model.modbus.ModbusCommandDto;
import com.net4iot.oss.domain.service.AbstractService;
import com.net4iot.oss.modbus4j.ModbusFactory;
import com.net4iot.oss.modbus4j.ModbusMaster;
import com.net4iot.oss.modbus4j.code.DataType;
import com.net4iot.oss.modbus4j.code.RegisterRange;
import com.net4iot.oss.modbus4j.ip.IpParameters;
import com.net4iot.oss.modbus4j.locator.NumericLocator;
import com.net4iot.oss.modbus4j.msg.WriteRegisterRequest;
import com.net4iot.oss.modbus4j.msg.WriteRegisterResponse;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("modbusBusinessCommandService")
public class ModbusBusinessCommandService extends AbstractService {


    public ModbusBusinessCommand queryByBusinessCodeAndDeviceCode(String businessCode,String deviceCode) {
        return this.findUnique("from ModbusBusinessCommand where businessCode =? and deviceCode=?", businessCode,deviceCode);
    }

    public List<ModbusBusinessCommand> queryByDeviceCode(String deviceCode) {
        return this.find("from ModbusBusinessCommand where deviceCode=?", deviceCode);
    }


    public ModbusBusinessCommand getByDeviceCode(String deviceCode) {
        return this.findUnique("from ModbusBusinessCommand where deviceCode=?", deviceCode);
    }

    public List<ModbusCommandDto> queryByDeviceCodes(String deviceCode) {
        StringBuilder builder = new StringBuilder(" SELECT comm.device_code,comm.device_no,basic.ip,basic.port as ports,basic.time_out,basic.retries FROM modbus_business_command comm left join modbus_protocol_basic basic on comm.modbus_protocol_basic_id = basic.id ");
        builder.append("  where comm.device_code in  (");
        String strArr[] = deviceCode.split(",");
        StringBuilder values = new StringBuilder();
        for(int i=0;i<strArr.length;i++) {
            values.append("'").append(strArr[i]).append("'").append(",") ;
        }
        builder.append(values.substring(0,values.length()-1));
        builder.append(")");
        return this.findBySQLtoBean(ModbusCommandDto.class,builder.toString());
    }

    //读取数据
    public JSONObject readCommand(String ip, Integer port, Integer timeout, Integer retries, Integer readSlaveId, Integer readOffset) throws Exception{

        JSONObject jsonObject = new JSONObject();

        ModbusFactory factory = new ModbusFactory();
        IpParameters params = new IpParameters();

        params.setHost(ip);
        params.setPort(port);
        params.setEncapsulated(false);

        ModbusMaster master = factory.createTcpMaster(params, true);
        master.setTimeout(timeout);
        master.setRetries(retries);

        try {
            master.init();
            jsonObject.put(readOffset,master.getValue(new NumericLocator(readSlaveId, RegisterRange.HOLDING_REGISTER, readOffset,
                    DataType.TWO_BYTE_INT_SIGNED)));
        } finally {
            master.destroy();
        }
        return jsonObject;

    }

    //发送指令
    public JSONObject writeCommand(String ip, Integer port, Integer timeout, Integer retries, Integer writeSlaveId, Integer writeOffset,Integer writeValue) throws Exception{

        JSONObject jsonObject = new JSONObject();

        ModbusFactory factory = new ModbusFactory();
        IpParameters params = new IpParameters();

        params.setHost(ip);
        params.setPort(port);
        params.setEncapsulated(false);

        ModbusMaster master = factory.createTcpMaster(params, true);
        master.setTimeout(timeout);
        master.setRetries(retries);

        try {
            master.init();

            WriteRegisterRequest request = new WriteRegisterRequest(writeSlaveId, writeOffset, writeValue);//机器码----寄存器地址---需要设置的命令值
            WriteRegisterResponse response = (WriteRegisterResponse) master.send(request);
            if (response.isException()) {
                jsonObject.put("success",false);

            } else {
                jsonObject.put("success",true);
            }

        } finally {
            master.destroy();
        }

        return jsonObject;
    }


}
