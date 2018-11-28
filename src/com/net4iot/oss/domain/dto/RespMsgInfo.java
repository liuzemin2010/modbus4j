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
 * @author liuzemin
 * @version 1.0, 2018年05月31日
 * @see
 * @since
 */
public class RespMsgInfo {

	/**
	 * 错误码 0代表成功，非0代码失败
	 */
	private int code;

	private String msg;

	public RespMsgInfo() {
		code = 0;
		msg = new String();
	}

	public RespMsgInfo(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public void reset(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("code", this.code);
		json.put("msg", this.msg);

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

	public boolean error() {
		return this.code != 0;
	}

	public boolean success() {
		return this.code == 0;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
