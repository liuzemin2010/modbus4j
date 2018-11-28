package com.net4iot.oss.domain.dto;

import java.util.Date;

/**
 *<pre>
 * 作用:
 * 注意:
 * 其他:
 *</pre>
 *
 * @author  like
 * @version 1.0, 2018年1月22日
 * @see     
 * @since  
 */
public class Company {
private String contactNumber;

	private Long id;
	
	private Date createTime;

	private String name;
	
	private Long port;
	
	private Long state;
	
	private String url;
	

	private String ghId;
	
	private String number;
	

	private String logoUrl;
	
	private String title;


	private Long rootUserId;


	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}


	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the port
	 */
	public Long getPort() {
		return port;
	}


	/**
	 * @param port the port to set
	 */
	public void setPort(Long port) {
		this.port = port;
	}


	/**
	 * @return the state
	 */
	public Long getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(Long state) {
		this.state = state;
	}


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	/**
	 * @return the ghId
	 */
	public String getGhId() {
		return ghId;
	}


	/**
	 * @param ghId the ghId to set
	 */
	public void setGhId(String ghId) {
		this.ghId = ghId;
	}


	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}


	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}


	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl() {
		return logoUrl;
	}


	/**
	 * @param logoUrl the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the rootUserId
	 */
	public Long getRootUserId() {
		return rootUserId;
	}


	/**
	 * @param rootUserId the rootUserId to set
	 */
	public void setRootUserId(Long rootUserId) {
		this.rootUserId = rootUserId;
	}


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
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}


	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
