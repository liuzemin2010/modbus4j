package com.net4iot.oss.domain.even;

/**
 * 
 * <pre>
 * 作用:
 * 注意:
 * 其他:
 * </pre>
 *
 * @author yanglijuan
 * @version 1.0, 2017年11月30日
 * @see
 * @since
 */
public class SendSmsEvent {

	private Long companyId;

	/**
	 * 移动电话
	 */
	private String mobilePhone;

	private String content;

	public SendSmsEvent(String mobilePhone, String content) {
		this.mobilePhone = mobilePhone;
		this.content = content;
	}

	public SendSmsEvent(Long companyId, String mobilePhone, String content) {
		this.companyId = companyId;
		this.mobilePhone = mobilePhone;
		this.content = content;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
