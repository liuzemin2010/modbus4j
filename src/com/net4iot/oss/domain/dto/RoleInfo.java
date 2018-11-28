/**
 * com.ovu_ibms.domain.dto
 */
package com.net4iot.oss.domain.dto;

/**
 * @author like
 *
 */
public class RoleInfo {
	private Long id;
	private String name;
	private String remark;
	private Long companyId;
	private Long wdmsCompanyId;
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
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getWdmsCompanyId() {
		return wdmsCompanyId;
	}

	public void setWdmsCompanyId(Long wdmsCompanyId) {
		this.wdmsCompanyId = wdmsCompanyId;
	}
}
