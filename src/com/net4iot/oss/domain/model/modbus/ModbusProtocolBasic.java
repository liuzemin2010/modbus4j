package com.net4iot.oss.domain.model.modbus;

import com.net4iot.oss.domain.model.base.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "modbus_protocol_basic")
public class ModbusProtocolBasic extends IdEntity {

    @Column(name = "ip")
    private String ip;

    @Column(name = "port")
    private Integer port;

    @Column(name = "time_out")
    private Integer timeOut;

    @Column(name = "retries")
    private Integer retries;

    @Column(name = "remark")
    private String remark;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }
}
