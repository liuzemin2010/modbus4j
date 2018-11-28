/**
 * com.ovu_ibms.domain.dto.log.alarm
 */
package com.net4iot.oss.domain.dto;

/**
 * 
 *<pre>
 * 作用:
 * 注意:
 * 其他:
 *</pre>
 *
 * @author  yanglijuan
 * @version 1.0, 2017年11月24日
 * @see     
 * @since
 */
public class LogAlarmInfo {
	private Long id;
	private Integer state;
	private String result;
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
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
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
	
	
}
