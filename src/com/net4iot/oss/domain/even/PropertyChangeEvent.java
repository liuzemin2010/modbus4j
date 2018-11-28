package com.net4iot.oss.domain.even;

import java.util.Date;

/**
 * 
 *<pre>
 * 作用:设备属性发生改变事件
 * 注意:
 * 其他:
 *</pre>
 *
 * @author  yanglijuan
 * @version 1.0, 2017年11月30日
 * @see     
 * @since
 */
public class PropertyChangeEvent {

	/*设备devEui*/
	private String deviceMac;

	/*设备(节点)类型*/
	private Integer deviceType;
    
	/*属性名称*/
	private String propertyName;
	
	/*属性展示名称*/
	private String propertyDisplayName;

	/*属性值*/
	private String propertyValue;

	/*最后更新时间*/
	private Date lastUpdateTime;
	
	/*告警类型：0；离线报警  1：设备状态报警*/
	private Integer alarmType;
	
	/*区分网关和节点0：网关  1：节点*/
	private Integer apOrSn;
	
	public PropertyChangeEvent(){
	}

	/**
	 * 
	 * @param deviceMac 设备Eui
	 * @param deviceType 设备(节点设备)类型，若为离线在线报警置为 0
	 * @param propertyName 属性名称
	 * @param propertyDisplayName 属性展示名称
	 * @param propertyValue  属性值
	 * @param lastUpdateTime 最后更新时间
	 * @param alarmType 告警类型：0；离线报警  1：设备状态报警
	 * @param apOrSn 区分网关和节点0：网关  1：节点
	 */
	public PropertyChangeEvent(String deviceMac, Integer deviceType,
			String propertyName, String propertyDisplayName,
			String propertyValue, Date lastUpdateTime,Integer alarmType,Integer apOrSn) {
		this.deviceMac = deviceMac;
		this.deviceType = deviceType;
		this.propertyName = propertyName;
		this.propertyDisplayName = propertyDisplayName;
		this.propertyValue = propertyValue;
		this.lastUpdateTime = lastUpdateTime;
		this.alarmType = alarmType;
		this.apOrSn = apOrSn;
	}

	/**
	 * @param deviceMac 设备Eui
	 * @param deviceType 设备(节点设备)类型，若为离线在线报警置为 0
	 * @param propertyName 属性名称
	 * @param propertyValue  属性值
	 * @param lastUpdateTime 最后更新时间
	 * @param alarmType 告警类型：0；离线报警  1：设备状态报警
	 * @param apOrSn 区分网关和节点0：网关  1：节点
	 */
	public PropertyChangeEvent(String deviceMac, Integer deviceType,
			String propertyName, String propertyValue, Date lastUpdateTime,Integer alarmType,Integer apOrSn) {
		this.deviceMac = deviceMac;
		this.deviceType = deviceType;
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
		this.lastUpdateTime = lastUpdateTime;
		this.alarmType = alarmType;
		this.apOrSn = apOrSn;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getDeviceMac() {
		return deviceMac;
	}

	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}
	

	public String getPropertyDisplayName() {
		return propertyDisplayName;
	}

	public void setPropertyDisplayName(String propertyDisplayName) {
		this.propertyDisplayName = propertyDisplayName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	/**
	 * @return the alarmType
	 */
	public Integer getAlarmType() {
		return alarmType;
	}

	/**
	 * @param alarmType the alarmType to set
	 */
	public void setAlarmType(Integer alarmType) {
		this.alarmType = alarmType;
	}

	/**
	 * @return the apOrSn
	 */
	public Integer getApOrSn() {
		return apOrSn;
	}

	/**
	 * @param apOrSn the apOrSn to set
	 */
	public void setApOrSn(Integer apOrSn) {
		this.apOrSn = apOrSn;
	}
	
	
	
	
	
}
