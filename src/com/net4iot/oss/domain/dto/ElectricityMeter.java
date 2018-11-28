package com.net4iot.oss.domain.dto;

/**
 *
 * 电量仪对象,用来存储电量仪返回的三段设备数据属性
 * 分别为   1.三相有功 无功 功率因素
 *          2.三相电压 电流 总电能
 *          3.频率
 *
 */
public class ElectricityMeter {

    private String powerProp;//1
    private String totalPowerProp;//2
    private String frequencyProp;//3

    public String getPowerProp() {
        return powerProp;
    }

    public void setPowerProp(String powerProp) {
        this.powerProp = powerProp;
    }

    public String getTotalPowerProp() {
        return totalPowerProp;
    }

    public void setTotalPowerProp(String totalPowerProp) {
        this.totalPowerProp = totalPowerProp;
    }

    public String getFrequencyProp() {
        return frequencyProp;
    }

    public void setFrequencyProp(String frequencyProp) {
        this.frequencyProp = frequencyProp;
    }

    @Override
    public String toString() {
        return (powerProp == null?"":powerProp)+(totalPowerProp == null ? "" : totalPowerProp)+
                (frequencyProp == null ? "" : frequencyProp);
    }
}
