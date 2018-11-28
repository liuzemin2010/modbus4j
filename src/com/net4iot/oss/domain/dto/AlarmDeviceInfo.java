package com.net4iot.oss.domain.dto;

/**
 *<pre>
 * 作用:
 * 注意:
 * 其他:
 *</pre>
 *
 * @author  yanglijuan
 * @version 1.0, 2017年11月28日
 * @see     
 * @since  
 */
public class AlarmDeviceInfo {
	private Long id;
	
	private String devEui;
	
	private Long companyId;

	private Integer deviceType;

	private String name;
	

	/**
	 * <pre>
	 * 报警级别:
	 * 0 低
	 * 1 中
	 * 2 高
	 * </pre>
	 */
	private Integer level;

	/**
	 * <pre>
	 * 报警类型:
	 * 0 邮件
	 * 1 手机
	 * 2 邮件+手机
	 * </pre>
	 */
	private Integer typeOfNotice;

	/**
	 * 持续时长。单位：分钟
	 */
	private Integer sustainedTime;

	/**
	 * 描述
	 */
	private String description;

	private String expression;

	private String beginTime;

	private String endTime;

	/**
	 * <pre>
	 * 数值说明： 
	 * 1.默认值为0； 
	 * 2.重置时值为0；
	 * 3.发送一次报警，数据+1；
	 * </pre>
	 */
	private Integer sendTimes;

	/**
	 * <pre>
	 * 0：表示开
	 * 1：表示关
	 * </pre>
	 */
	private Integer state;

	private String mobiles;

	private String emails;
	
	
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the devEui
	 */
	public String getDevEui() {
		return devEui;
	}

	/**
	 * @param devEui the devEui to set
	 */
	public void setDevEui(String devEui) {
		this.devEui = devEui;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getTypeOfNotice() {
		return typeOfNotice;
	}

	public void setTypeOfNotice(Integer typeOfNotice) {
		this.typeOfNotice = typeOfNotice;
	}

	public Integer getSustainedTime() {
		return sustainedTime;
	}

	public void setSustainedTime(Integer sustainedTime) {
		this.sustainedTime = sustainedTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(Integer sendTimes) {
		this.sendTimes = sendTimes;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMobiles() {
		return mobiles;
	}

	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	
}
