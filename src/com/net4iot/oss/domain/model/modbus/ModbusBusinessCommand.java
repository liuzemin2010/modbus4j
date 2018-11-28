package com.net4iot.oss.domain.model.modbus;

import com.net4iot.oss.domain.model.base.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "modbus_business_command")
public class ModbusBusinessCommand extends IdEntity {

    @Column(name = "modbus_protocol_basic_id")
    private Long modbusProtocolBasicId;


    @Column(name = "device_code")
    private String deviceCode;

    @Column(name = "device_no")
    private Integer deviceNo;


    @Column(name = "command_value")
    private String commandValue;

    @Column(name = "remark")
    private String remark;

    @Column(name = "wdms_company_id")
    private Long wdmsCompanyId;

    @Column(name = "company_id")
    private Long companyId;

    public Long getModbusProtocolBasicId() {
        return modbusProtocolBasicId;
    }

    public void setModbusProtocolBasicId(Long modbusProtocolBasicId) {
        this.modbusProtocolBasicId = modbusProtocolBasicId;
    }

    public String getCommandValue() {
        return commandValue;
    }

    public void setCommandValue(String commandValue) {
        this.commandValue = commandValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getWdmsCompanyId() {
        return wdmsCompanyId;
    }

    public void setWdmsCompanyId(Long wdmsCompanyId) {
        this.wdmsCompanyId = wdmsCompanyId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public Integer getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(Integer deviceNo) {
        this.deviceNo = deviceNo;
    }
}
