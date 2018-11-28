package com.net4iot.oss.domain.dto;

/**
 * 
 * <pre>
 * 作用:登录实体类
 * 注意:
 * 其他:
 * </pre>
 *
 * @author xudan
 * @version 1.0, 2017年11月22日
 * @see
 * @since
 */
public class LoginInfo {
	private String name;
	private String password;
	private String company;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
}
