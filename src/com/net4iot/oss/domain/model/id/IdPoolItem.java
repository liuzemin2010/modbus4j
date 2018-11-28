package com.net4iot.oss.domain.model.id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.net4iot.oss.domain.model.base.IdEntity;

/**
 * <pre>
 * 作用:
 * 注意:
 * 其他:
 * </pre>
 * 
 * @author chenwentao
 * @version 1.0, 2016-5-5
 * @see
 * @since
 */
@Entity
@Table(name = "id_pool_item")
public class IdPoolItem extends IdEntity {

	private static final long serialVersionUID = -4879043078481298549L;

	@Column(name = "dev_addr")
	private String devAddr;

	/**
	 * @return the devAddr
	 */
	public String getDevAddr() {
		return devAddr;
	}

	/**
	 * @param devAddr
	 *            the devAddr to set
	 */
	public void setDevAddr(String devAddr) {
		this.devAddr = devAddr;
	}
}
