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
public class CompanyInfoJson {
	
	/**
	 *      id                     bigint(20) NOT NULL
			company_name           varchar(120) NOT NULL公司名称
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Long id;

	private String companyName;

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
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
