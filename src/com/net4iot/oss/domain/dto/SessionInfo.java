package com.net4iot.oss.domain.dto;

import java.io.Serializable;

/**
 * 
 * <pre>
 * 作用:会话实体类
 * 注意:
 * 其他:
 * </pre>
 *
 * @author xudan
 * @version 1.0, 2017年11月22日
 * @see
 * @since
 */
public class SessionInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;
	
	private String userName;

	private Long companyId;

	private Long rootMenuId;

	private Long rootUserId;
	
	
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId
	 *            the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the rootMenuId
	 */
	public Long getRootMenuId() {
		return rootMenuId;
	}

	/**
	 * @param rootMenuId
	 *            the rootMenuId to set
	 */
	public void setRootMenuId(Long rootMenuId) {
		this.rootMenuId = rootMenuId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}