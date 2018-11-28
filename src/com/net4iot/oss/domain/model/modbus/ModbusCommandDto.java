package com.net4iot.oss.domain.model.modbus;

public class ModbusCommandDto {


    private String device_code;

    private Integer device_no;

    private String ip;

    private Integer ports;

    private Integer time_out;

    private Integer retries;

    public String getDevice_code() {
        return device_code;
    }

    public void setDevice_code(String device_code) {
        this.device_code = device_code;
    }

    public Integer getDevice_no() {
        return device_no;
    }

    public void setDevice_no(Integer device_no) {
        this.device_no = device_no;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPorts() {
        return ports;
    }

    public void setPorts(Integer ports) {
        this.ports = ports;
    }

    public Integer getTime_out() {
        return time_out;
    }

    public void setTime_out(Integer time_out) {
        this.time_out = time_out;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }
}
