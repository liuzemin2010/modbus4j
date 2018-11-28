package com.net4iot.oss.service.job;


import com.net4iot.oss.domain.model.modbus.ModbusLog;
import com.net4iot.oss.domain.service.modbus.ModbusLogService;
import com.net4iot.oss.modbus4j.BatchRead;
import com.net4iot.oss.modbus4j.BatchResults;
import com.net4iot.oss.modbus4j.ModbusFactory;
import com.net4iot.oss.modbus4j.ModbusMaster;
import com.net4iot.oss.modbus4j.code.DataType;
import com.net4iot.oss.modbus4j.exception.ErrorResponseException;
import com.net4iot.oss.modbus4j.exception.ModbusInitException;
import com.net4iot.oss.modbus4j.exception.ModbusTransportException;
import com.net4iot.oss.modbus4j.ip.IpParameters;
import com.net4iot.oss.modbus4j.locator.BaseLocator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("modbusLogProcessJob")
public class ModbusLogProcessJob {

    @Autowired
    private ModbusLogService modbusLogService;


    private static Logger log = Logger.getLogger(ModbusLogProcessJob.class);

    public void doJob(){

        log.info("开始执行 ===================ModbusLogProcessJob========doJob======================");
        System.out.println("开始执行 ===================ModbusLogProcessJob========doJob======================");

        List<ModbusLog> list = modbusLogService.queryBydateDiff("2018-11-27 17:48:49");
        if(list!=null&&list.size()>0){
            for(int i=0;i<list.size();i++){
                modbusLogService.delete(list.get(i));
            }
        }
    }

    /**
     * 批量读取使用方法
     *
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     * @throws ModbusInitException
     */
    public static void batchRead(String ip, Integer port, Integer deviceNo) throws ModbusTransportException, ErrorResponseException, ModbusInitException {

        BatchRead<Integer> batch = new BatchRead<Integer>();

        batch.addLocator(0, BaseLocator.holdingRegister(deviceNo, 81, DataType.TWO_BYTE_INT_SIGNED));
        batch.addLocator(1, BaseLocator.holdingRegister(deviceNo, 82, DataType.TWO_BYTE_INT_SIGNED));
        batch.addLocator(2, BaseLocator.holdingRegister(deviceNo, 83, DataType.TWO_BYTE_INT_SIGNED));
        batch.addLocator(3, BaseLocator.holdingRegister(deviceNo, 84, DataType.TWO_BYTE_INT_SIGNED));
        batch.addLocator(4, BaseLocator.holdingRegister(deviceNo, 85, DataType.TWO_BYTE_INT_SIGNED));
        batch.addLocator(5, BaseLocator.holdingRegister(deviceNo, 264, DataType.TWO_BYTE_INT_SIGNED));

        ModbusFactory factory = new ModbusFactory();
        IpParameters params = new IpParameters();
        params.setHost(ip);
        params.setPort(port);
        params.setEncapsulated(false);


        ModbusMaster master = factory.createTcpMaster(params, true);
        master.init();
        //ModbusMaster master = getMaster();

        batch.setContiguousRequests(false);
        BatchResults<Integer> results = master.send(batch);
        System.out.println("81 = " + results.getValue(0));
        System.out.println("82 = " + results.getValue(1));
        System.out.println("83 = " + results.getValue(2));
        System.out.println("84 = " + results.getValue(3));
        System.out.println("85 = " + results.getValue(4));
        System.out.println("264 = " + results.getValue(5));

    }

    public static void main(String[] args) throws Exception{
        batchRead("10.7.20.253", 8899, 4);
    }
}
