package com.net4iot.oss.service.modbus;

import com.net4iot.oss.modbus4j.BatchRead;
import com.net4iot.oss.modbus4j.BatchResults;
import com.net4iot.oss.modbus4j.ModbusFactory;
import com.net4iot.oss.modbus4j.ModbusMaster;
import com.net4iot.oss.modbus4j.code.DataType;
import com.net4iot.oss.modbus4j.code.RegisterRange;
import com.net4iot.oss.modbus4j.exception.ErrorResponseException;
import com.net4iot.oss.modbus4j.exception.ModbusInitException;
import com.net4iot.oss.modbus4j.exception.ModbusTransportException;
import com.net4iot.oss.modbus4j.ip.IpParameters;
import com.net4iot.oss.modbus4j.locator.BaseLocator;
import com.net4iot.oss.modbus4j.locator.NumericLocator;
import com.net4iot.oss.modbus4j.msg.WriteRegisterRequest;
import com.net4iot.oss.modbus4j.msg.WriteRegisterResponse;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

public class ModbusUtils {

    private static final Logger log = Logger.getLogger(ModbusUtils.class);

    public static void main(String[] args) throws Exception{
        //ModbusUtils modbusUtils = new ModbusUtils();
        //modbusUtils.command();
        //JSONObject jsonObject = modbusUtils.readCommand("10.7.20.253",8899,2000,0,5,85);
        //System.out.println(jsonObject.toString());
//batchRead(String ip, Integer port, Integer timeout, Integer retries,Integer deviceNo)
        // batchRead("10.7.20.253", 8899, 4);
        batchRead("10.7.20.253", 8899, 2000,3,4);

        // WriteRegisterRequest request = new WriteRegisterRequest(5, 83, 3);//机器码----寄存器地址---需要设置的命令值
        //(String ip, Integer port, Integer timeout, Integer retries, Integer writeSlaveId, Integer writeOffset,Integer writeValue)
        //JSONObject jsonObject = modbusUtils.writeCommand("192.168.31.252",8899,2000,0,5,81,4);

        //System.out.println(jsonObject);

    }

    // //读数据
    //int readSlaveId, int range, int readOffset, int dataType

    /**
     *             String ip = "192.168.31.252";
     *             Integer port = 8899;
     *             Integer timeout = 2000;
     *             Integer retries = 0;
     */
    public static JSONObject readCommand(String ip, Integer port, Integer timeout, Integer retries, Integer readSlaveId, Integer readOffset) throws Exception{
        JSONObject jsonObject = new JSONObject();
        ModbusFactory factory = new ModbusFactory();
        IpParameters params = new IpParameters();
        params.setHost(ip);
        params.setPort(port);
        params.setEncapsulated(false);
        ModbusMaster master = factory.createTcpMaster(params, true);
        master.setTimeout(timeout);
        master.setRetries(retries);
        log.info("readCommand参数信息 ip "+ip+" port "+port+" timeout "+timeout+" retries "+retries);
        try {
        master.init();
            String key = "";
            switch(readOffset){
                case 84:
                    key = "power";
                    break;
                case 81:
                    key = "mode";
                    break;
                case 83:
                    key = "fun";
                    break;
                case 82:
                    key = "setTemp";
                    break;
                case 264:
                    key = "nowTemp";
                    break;
                case 85:
                    key = "wlock";
                    break;
            }
            jsonObject.put(key,master.getValue(new NumericLocator(readSlaveId, RegisterRange.HOLDING_REGISTER, readOffset,
                    DataType.TWO_BYTE_INT_SIGNED)));
        } finally {
            master.destroy();
        }
        return jsonObject;
    }

    // //int writeSlaveId, int writeOffset, int writeValue
    public static JSONObject writeCommand(String ip, Integer port, Integer timeout, Integer retries, Integer writeSlaveId, Integer writeOffset,
                                          Integer writeValue) throws Exception{
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
                jsonObject.put("success","false");
            } else {
                jsonObject.put("success","true");
            }
        } finally {
            master.destroy();
        }
        return jsonObject;
    }


    public void command() throws Exception{

        {
            ModbusFactory factory = new ModbusFactory();
            IpParameters params = new IpParameters();

            String ip = "192.168.31.252";
            Integer port = 8899;
            Integer timeout = 2000;
            Integer retries = 0;


            params.setHost(ip);
            params.setPort(port);
            params.setEncapsulated(false);

            ModbusMaster master = factory.createTcpMaster(params, true);
            master.setTimeout(timeout);
            master.setRetries(retries);
            //读数据
            //int slaveId, int range, int offset, int dataType
            int readSlaveId = 5;
            int range;
            int readOffset = 84;
            int dataType;

            //写数据
            //int writeSlaveId, int writeOffset, int writeValue
            int writeSlaveId = 5;
            int writeOffset = 84;
            int writeValue = 1;

            long start = System.currentTimeMillis();
            try {
                master.init();

                System.out.println("设置前：");
                System.out.println("运行状态 = " + master.getValue(new NumericLocator(readSlaveId, RegisterRange.HOLDING_REGISTER, readOffset,
                        DataType.TWO_BYTE_INT_SIGNED)));


                // 创建请求
                // 创建请求对象
                WriteRegisterRequest request = new WriteRegisterRequest(writeSlaveId, writeOffset, writeValue);//机器码----寄存器地址---需要设置的命令值
                WriteRegisterResponse response = (WriteRegisterResponse) master.send(request);
                if (response.isException()) {
                    System.out.println("写入失败");
                } else {
                    System.out.println("写入成功");
                }
                System.out.println("设置后：");
                System.out.println("运行状态 = " + master.getValue(new NumericLocator(5, RegisterRange.HOLDING_REGISTER, 84,
                        DataType.TWO_BYTE_INT_SIGNED)));

            } finally {
                master.destroy();
            }

            System.out.println("耗时: " + (System.currentTimeMillis() - start) + "ms");
        }


    }

    /**
     * 批量读取使用方法
     *
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     * @throws ModbusInitException
     */
                              //(String ip, Integer port, Integer timeout, Integer retries, Integer readSlaveId, Integer readOffset)
    public static JSONObject batchRead(String ip, Integer port, Integer timeout, Integer retries,Integer deviceNo) throws ModbusTransportException, ErrorResponseException, ModbusInitException {

        JSONObject jsonObject = new JSONObject();

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
        master.setTimeout(timeout);
        master.setRetries(retries);

        batch.setContiguousRequests(false);
        BatchResults<Integer> results = master.send(batch);
       /* System.out.println(results.getValue(0));
        System.out.println(results.getValue(1));
        System.out.println(results.getValue(2));
        System.out.println(results.getValue(3));
        System.out.println(results.getValue(4));
        System.out.println(results.getValue(5));*/

        jsonObject.put("power",results.getValue(3));
        jsonObject.put("mode",results.getValue(0));
        jsonObject.put("fun",results.getValue(2));
        jsonObject.put("setTemp",results.getValue(1));
        jsonObject.put("nowTemp",results.getValue(5));
        jsonObject.put("wlock",results.getValue(4));

        return jsonObject;

    }


}
