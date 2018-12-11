package com.net4iot.oss.web.controller.modbus;

import com.net4iot.oss.domain.model.modbus.ModbusBusinessCommand;
import com.net4iot.oss.domain.model.modbus.ModbusCommandDto;
import com.net4iot.oss.domain.model.modbus.ModbusLog;
import com.net4iot.oss.domain.model.modbus.ModbusProtocolBasic;
import com.net4iot.oss.domain.service.modbus.ModbusBusinessCommandService;
import com.net4iot.oss.domain.service.modbus.ModbusLogService;
import com.net4iot.oss.domain.service.modbus.ModbusProtocolBasicService;
import com.net4iot.oss.infra.constants.CommandEnum;
import com.net4iot.oss.modbus4j.sero.messaging.WaitingRoomException;
import com.net4iot.oss.service.modbus.ModbusUtils;
import com.sqlite.SqliteHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/modbus")
public class ModbusController {

    private static final Logger log = Logger.getLogger(ModbusController.class);

    @Inject
    private ModbusBusinessCommandService modbusBusinessCommandService;

    @Inject
    private ModbusProtocolBasicService modbusProtocolBasicService;

    @Inject
    private ModbusLogService modbusLogService;



    /**
     * 定时任务，每天晚上0点删除数据日志表中的两天前的所有记录
     */
    @Scheduled(cron= "0 0 0 * * ?")
    public void deleteLog(){
        log.info("删除日志数据");

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        date = calendar.getTime();

         List<ModbusLog> list = modbusLogService.queryBydateDiff(sdf.format(date));
            if(list!=null&&list.size()>0){
                for(int i=0;i<list.size();i++){
                    modbusLogService.delete(list.get(i));
                }
            }
    }


    @RequestMapping(value = {"/readCommand"})
    @ResponseBody
    public JSONObject readCommand(HttpServletRequest request, HttpServletResponse response) {

        JSONObject jsonObject = new JSONObject();

        String deviceCode = request.getParameter("deviceCodes");

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        jsonObject.put("date", sdf.format(date));
        jsonObject.put("deviceCode", deviceCode);
        if (StringUtils.isEmpty(deviceCode)) {
            jsonObject.put("code", "-1");//参数为空
            jsonObject.put("msg", "deviceCodes为空");
            log.info("readCommand deviceCodes为空");
            return jsonObject;
        }
        //根据deviceCode查询modbus信息
        List<ModbusCommandDto> modbusCommandDtoList = modbusBusinessCommandService.queryByDeviceCodes(deviceCode);
        if (modbusCommandDtoList == null || modbusCommandDtoList.size() == 0) {
            jsonObject.put("code", "-1");//参数为空
            jsonObject.put("msg", "deviceCodes  " + deviceCode + " 不存在");
            log.info("readCommand deviceCodes  " + deviceCode + " 不存在");
            return jsonObject;
        }
        JSONArray tempJsonArray = new JSONArray();
        String jsonObjectCode = "";
        String jsonObjectMsg = "";
        for (int i = 0; i < modbusCommandDtoList.size(); i++) {
            String ip = modbusCommandDtoList.get(i).getIp();
            Integer port = modbusCommandDtoList.get(i).getPorts();
            Integer timeout = modbusCommandDtoList.get(i).getTime_out();
            Integer retries = modbusCommandDtoList.get(i).getRetries();
            JSONObject tempJson = new JSONObject();
            ModbusLog modbusLog = new ModbusLog();
            modbusLog.setName("readCommand");
            modbusLog.setCreate_time(sdf.format(date));
            String strArr[] = deviceCode.split(",");
            tempJson.put("deviceCode", strArr[i]);
            modbusLog.setParams_in(strArr[i]);
            modbusLog.setDevice_code(strArr[i]);
            modbusLog.setParams_out(tempJson.toString());
            //modbusLog.setStatus("success");
            //modbusLogService.save(modbusLog);
            // 执行批量读取命令
            JSONObject retJsonObject = new  JSONObject ();
            try {
               retJsonObject = ModbusUtils.batchRead(ip, port, timeout, retries,
                        modbusCommandDtoList.get(i).getDevice_no());
                modbusLog.setStatus("success");
                jsonObjectCode = "0000";
                jsonObjectMsg = "命令执行成功,正确返回!";
            }catch (Exception e){
                //e.printStackTrace();
                modbusLog.setStatus("failure");
                modbusLog.setExceptions_info(e.toString());
                jsonObjectCode = "9999";
                jsonObjectMsg = e.toString();
            }finally{
                modbusLogService.save(modbusLog);
            }
            Iterator<String> it = retJsonObject.keys();
            while (it.hasNext()) {
                String key = it.next();
                String value = retJsonObject.getString(key);
                if (key.equals("nowTemp")) {
                    Double dValue = Double.valueOf(value);
                    value = Double.toString(dValue / 100);
                }
                tempJson.put(key, value);
            }
            tempJsonArray.add(tempJson);
            log.info(" readCommand 返回的信息如下 " + tempJsonArray);
        }

        jsonObject.put("data", tempJsonArray);
        jsonObject.put("code", jsonObjectCode);
        jsonObject.put("msg", jsonObjectMsg);
        return jsonObject;
    }

    @RequestMapping(value = {"/writeCommand"})
    @ResponseBody
    public JSONObject writeCommand(HttpServletRequest request, HttpServletResponse response) {

        JSONObject jsonObject = new JSONObject();
        String businessCode = request.getParameter("businessCode");
        String deviceCode = request.getParameter("deviceCode");
        String commandValue = request.getParameter("commandValue");

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonObject.put("date", sdf.format(date));
        jsonObject.put("deviceCode", deviceCode);

        if (StringUtils.isEmpty(businessCode)) {
            jsonObject.put("code", "-1");//参数为空
            jsonObject.put("msg", "businessCode为空");
            log.info("writeCommand  businessCode为空");
            return jsonObject;
        }

        if (StringUtils.isEmpty(deviceCode)) {
            jsonObject.put("code", "-1");//参数为空
            jsonObject.put("msg", "deviceCode为空");
            log.info("writeCommand  deviceCode为空");
            return jsonObject;
        }

        if (StringUtils.isEmpty(commandValue)) {
            jsonObject.put("code", "-1");//参数为空
            jsonObject.put("msg", "commandValue为空");
            log.info("writeCommand  commandValue为空");
            return jsonObject;
        }

        //根据deviceCode查询modbus信息
        //ModbusBusinessCommand modbusBusinessCommand = modbusBusinessCommandService.queryByBusinessCodeAndDeviceCode(businessCode,deviceCode);
        ModbusBusinessCommand modbusBusinessCommand = modbusBusinessCommandService.getByDeviceCode(deviceCode);
        if (modbusBusinessCommand == null) {
            jsonObject.put("code", "-1");//参数为空
            jsonObject.put("msg", "deviceCode  " + deviceCode + " 或者 businessCode " + businessCode + " 不存在");
            log.info("writeCommand  " + "deviceCode  " + deviceCode + " 或者 businessCode " + businessCode + " 不存在");
            return jsonObject;
        }
        ModbusProtocolBasic modbusProtocolBasic = modbusProtocolBasicService.findById(modbusBusinessCommand.getModbusProtocolBasicId());
        JSONObject commandObject = new JSONObject();
        commandObject.put("ip", modbusProtocolBasic.getIp());
        commandObject.put("port", modbusProtocolBasic.getPort());
        String ip = modbusProtocolBasic.getIp();
        Integer port = modbusProtocolBasic.getPort();
        Integer timeout = modbusProtocolBasic.getTimeOut();
        Integer retries = modbusProtocolBasic.getRetries();

        JSONObject object = new JSONObject();
        object.put("businessCode", businessCode);
        object.put("deviceCode", deviceCode);
        object.put("commandValue", commandValue);

        ModbusLog modbusLog = new ModbusLog();
        modbusLog.setCreate_time(sdf.format(date));
        modbusLog.setName("writeCommand");
        modbusLog.setParams_in(object.toString());
        modbusLog.setDevice_code(deviceCode);
        modbusLog.setBusiness_code(businessCode);
        modbusLog.setBusiness_value(commandValue);
        //modbusLogService.save(modbusLog);

        JSONObject retJsonObject = new JSONObject();
        try {
            retJsonObject = ModbusUtils.writeCommand(ip, port, timeout, retries, modbusBusinessCommand.getDeviceNo(),
                    CommandEnum.getValueByKey(businessCode), Integer.parseInt(commandValue));
            modbusLog.setStatus("success");
            if ("true".equals(retJsonObject.get("success").toString())) {
                jsonObject.put("code", "0000");
                jsonObject.put("msg", "命令执行成功,正确返回");
                log.info("writeCommand 命令执行成功,正确返回 ");
                modbusLog.setStatus("success");
            } else {
                jsonObject.put("code", "9999");
                jsonObject.put("msg", "命令发送三次失败");
                log.info("writeCommand 命令发送三次失败");
                modbusLog.setStatus("failure");
            }
        }catch (WaitingRoomException e){
            e.printStackTrace();
            modbusLog.setStatus("failure");
            modbusLog.setExceptions_info(e.toString());
            jsonObject.put("code", "9999");
            jsonObject.put("msg", "命令发送三次失败");
        }catch (Exception e){
            e.printStackTrace();
            modbusLog.setStatus("failure");
            modbusLog.setExceptions_info(e.toString());
            jsonObject.put("code", "9999");
            jsonObject.put("msg", "命令发送三次失败");
        }finally {
            modbusLogService.save(modbusLog);
        }

        //modbusLog.setBusiness_name();
        //modbusLog.setParams_out();

        commandObject.put("registerAddress", CommandEnum.getValueByKey(businessCode));
        commandObject.put("commandValue", commandValue);
        jsonObject.put("command", commandObject);

        return jsonObject;
    }

    public static void main(String[] args) {

        try {
            //SqliteHelper h = new SqliteHelper("modbus4j.db");
            SqliteHelper h = new SqliteHelper("resources\\db\\modbus4j.db");

            StringBuffer sbf = new StringBuffer();
            //sbf.append("INSERT INTO "+"modbus_log""("id", "name", "params_in", "params_out", "status", "create_time", "device_code", "business_code", "business_value", "business_name") VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1');

            sbf.append(" insert into modbus_log (business_code, business_name, business_value, create_time, device_code, name, params_in, params_out, status )");
            sbf.append("VALUES ");
            sbf.append("	('11', '21', '31', '41', '51', '16', '17', '18', '19'); ");
            h.executeUpdate(sbf.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
