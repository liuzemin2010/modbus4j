package com.net4iot.oss.web.controller.test;

import com.net4iot.oss.domain.dto.ElectricityMeter;

/**
 * Created by pangPython on 2017/9/25.
 *
 * 缓存实体类
 */
public class MyCache {
    private String electricityMeterId;//key
    private ElectricityMeter electricityMeter;//value
    private long lastAccessTime;//最后访问时间

    public MyCache(String electricityMeterId, Object cacheObj) {
        this.electricityMeterId = electricityMeterId;
        this.electricityMeter = electricityMeter;
    }

    public MyCache(String electricityMeterId, ElectricityMeter electricityMeter, long lastAccessTime) {
        this.electricityMeterId = electricityMeterId;
        this.electricityMeter = electricityMeter;
        this.lastAccessTime = lastAccessTime;
    }

    public String getElectricityMeterId() {
        return electricityMeterId;
    }

    public void setElectricityMeterId(String electricityMeterId) {
        this.electricityMeterId = electricityMeterId;
    }

    public ElectricityMeter getElectricityMeter() {
        return electricityMeter;
    }

    public void setElectricityMeter(ElectricityMeter electricityMeter) {
        this.electricityMeter = electricityMeter;
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Override
    public String toString() {
        return electricityMeter.toString();
    }
}