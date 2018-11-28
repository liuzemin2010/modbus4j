/**
 * packagename = com.whserversales.domain.dto
 * filename = MsgInfo.java
 * author = youpeng
 * date = 2015-7-8
 */
package com.net4iot.oss.domain.dto;

import net.sf.json.JSONObject;

/**
 * 
 * <pre>
 * 作用:错误实体类
 * 注意:
 * 其他:
 * </pre>
 *
 * @author xudan
 * @version 1.0, 2017年11月22日
 * @see
 * @since
 */
public class MsgInfo {

	/**
	 * 错误码 0代表成功，非0代码失败
	 */
	private int code;

	private String message;

	public MsgInfo() {
		code = 0;
		message = new String();
	}

	public MsgInfo(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public void reset(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("code", this.code);
		json.put("message", this.message);

		return json.toString();
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public boolean error() {
		return this.code != 0;
	}

	public boolean success() {
		return this.code == 0;
	}
}
