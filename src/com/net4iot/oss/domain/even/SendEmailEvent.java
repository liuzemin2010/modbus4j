package com.net4iot.oss.domain.even;

public class SendEmailEvent {

	public Long companyId;

	public String from;

	public String toStrDirect;
	
	public String toStr;

	public String[] to;

	public String subject;

	public String content;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getToStrDirect() {
		return toStrDirect;
	}

	public void setToStrDirect(String toStrDirect) {
		this.toStrDirect = toStrDirect;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String getToStr() {
		return toStr;
	}

	public void setToStr(String toStr) {
		this.toStr = toStr;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
