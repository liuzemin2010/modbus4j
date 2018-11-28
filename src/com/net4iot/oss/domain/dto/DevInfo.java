package com.net4iot.oss.domain.dto;

/**
 *<pre>
 * 作用:
 * 注意:
 * 其他:
 *</pre>
 *
 * @author  yanglijuan
 * @version 1.0, 2017年12月8日
 * @see     
 * @since  
 */
public class DevInfo {
	/*网关或节点的编号 */
	private String eui;
	
	/**
	 * 设备警状态
	 */
	private Integer state;
	
	/**
	 * 设备网络状态 
	 */
	private Integer netState;
	
	/**
	 * 区分网关和节点 0：网关  1：节点
	 */
	private Integer apOrSn;
	
	/**
	 * 设备（节点）类型，网关设备时为null
	 */
	private Integer devType;

	/**
	 * @return the eui
	 */
	public String getEui() {
		return eui;
	}

	/**
	 * @param eui the eui to set
	 */
	public void setEui(String eui) {
		this.eui = eui;
	}

	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * @return the netState
	 */
	public Integer getNetState() {
		return netState;
	}

	/**
	 * @param netState the netState to set
	 */
	public void setNetState(Integer netState) {
		this.netState = netState;
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

	/**
	 * @return the devType
	 */
	public Integer getDevType() {
		return devType;
	}

	/**
	 * @param devType the devType to set
	 */
	public void setDevType(Integer devType) {
		this.devType = devType;
	}
}
