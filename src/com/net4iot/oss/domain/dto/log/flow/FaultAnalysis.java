package com.net4iot.oss.domain.dto.log.flow;

/**
 * 
 * <pre>
 * 作用:
 * 注意:
 * 其他:
 * </pre>
 *
 * @author xudan
 * @version 1.0, 2017年11月22日
 * @see
 * @since
 */
public class FaultAnalysis {
	private Integer type;
	private String mac;
	private String beginTime;
	private String endTime;
	private Long period;
	private Long cycle;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * @param mac
	 *            the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * @return the beginTime
	 */
	public String getBeginTime() {
		return beginTime;
	}

	/**
	 * @param beginTime
	 *            the beginTime to set
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the period
	 */
	public Long getPeriod() {
		return period;
	}

	/**
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(Long period) {
		this.period = period;
	}

	/**
	 * @return the cycle
	 */
	public Long getCycle() {
		return cycle;
	}

	/**
	 * @param cycle
	 *            the cycle to set
	 */
	public void setCycle(Long cycle) {
		this.cycle = cycle;
	}

}
