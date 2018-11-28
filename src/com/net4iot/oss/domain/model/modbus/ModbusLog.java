package com.net4iot.oss.domain.model.modbus;

import com.net4iot.oss.domain.model.base.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "modbus_log")
public class ModbusLog extends IdEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "params_in")
    private String params_in;

    @Column(name = "device_code")
    private String device_code;

    @Column(name = "business_code")//fun
    private String business_code;

    @Column(name = "business_value")//3
    private String business_value;

    @Column(name = "business_name")//高档   FUN_3("fun", "设定风速", "高档", "3"),
    private String business_name;

    @Column(name = "params_out")
    private String params_out;

    @Column(name = "status")
    private String status;

    @Column(name = "create_time")
    private String create_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParams_in() {
        return params_in;
    }

    public void setParams_in(String params_in) {
        this.params_in = params_in;
    }

    public String getParams_out() {
        return params_out;
    }

    public void setParams_out(String params_out) {
        this.params_out = params_out;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getDevice_code() {
        return device_code;
    }

    public void setDevice_code(String device_code) {
        this.device_code = device_code;
    }

    public String getBusiness_code() {
        return business_code;
    }

    public void setBusiness_code(String business_code) {
        this.business_code = business_code;
    }

    public String getBusiness_value() {
        return business_value;
    }

    public void setBusiness_value(String business_value) {
        this.business_value = business_value;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }
}
