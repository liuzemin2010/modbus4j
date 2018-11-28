package com.net4iot.oss.service.modbus;

import com.net4iot.oss.modbus4j.ModbusFactory;
import com.net4iot.oss.modbus4j.ModbusMaster;
import com.net4iot.oss.modbus4j.code.DataType;
import com.net4iot.oss.modbus4j.code.RegisterRange;
import com.net4iot.oss.modbus4j.ip.IpParameters;
import com.net4iot.oss.modbus4j.locator.NumericLocator;
import com.net4iot.oss.modbus4j.msg.WriteRegisterRequest;
import com.net4iot.oss.modbus4j.msg.WriteRegisterResponse;

public class ModbusDataHandle {


    public static void main(String[] args) throws Exception {
        ModbusFactory factory = new ModbusFactory();
        IpParameters params = new IpParameters();

        params.setHost("192.168.31.252");
        params.setPort(8899);
        params.setEncapsulated(false);

        ModbusMaster master = factory.createTcpMaster(params, true);
        master.setTimeout(2000);
        master.setRetries(0);

        long start = System.currentTimeMillis();
        try {
            master.init();

           /* System.out.println("设置前：");
            System.out.println("运行状态 = " + master.getValue(new NumericLocator(5, RegisterRange.HOLDING_REGISTER, 22,
                    DataType.TWO_BYTE_INT_SIGNED)));*/


            // 创建请求
            // 创建请求对象
            WriteRegisterRequest request = new WriteRegisterRequest(5, 83, 3);//机器码----寄存器地址---需要设置的命令值
            WriteRegisterResponse response = (WriteRegisterResponse) master.send(request);
            if (response.isException()) {
                System.out.println("写入失败");
            } else {
                System.out.println("写入成功");
            }
            System.out.println("设置后：");
            System.out.println("运行状态 = " + master.getValue(new NumericLocator(5, RegisterRange.HOLDING_REGISTER, 83,
                    DataType.TWO_BYTE_INT_SIGNED)));

        } finally {
            master.destroy();
        }

        System.out.println("耗时: " + (System.currentTimeMillis() - start) + "ms");
    }
}
