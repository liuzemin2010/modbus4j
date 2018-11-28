package com.net4iot.oss.domain.dto;

import java.util.Date;

/**
 *<pre>
 * 作用:
 * 注意:
 * 其他:
 *</pre>
 *
 * @author  liuzemin
 * @version 1.0, 2018年6月12日
 * @see     
 * @since  
 */
public class CompanyInfo {
	
	/**
	 *      id                     bigint(20) NOT NULL
			company_name           varchar(120) NOT NULL公司名称
			short_name             varchar(255) NOT NULL公司简称
			company_code           varchar(50) NOT NULL公司编码
			industry_type          varchar(20) NULL行业类型
			address                varchar(200) NULL公司地址
			contact                varchar(60) NULL公司联系人
			phone                  varchar(60) NULL公司联系电话
			logo_url               varchar(120) NULL公司logo地址
			create_time            datetime NULL
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Long id;
	
	protected Date createTime = new Date();

	private String companyName;
	
	private String shortName;
	
	private String companyCode;
	
	private String industryType;
	
	private String address;
	
	private String contact;
	
	private String phone;
	
	private String logoUrl;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyInfo [id=" + id + ", createTime=" + createTime + ", companyName=" + companyName + ", shortName="
				+ shortName + ", companyCode=" + companyCode + ", industryType=" + industryType + ", address=" + address
				+ ", contact=" + contact + ", phone=" + phone + ", logoUrl=" + logoUrl + "]";
	}

	
}
