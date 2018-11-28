package com.net4iot.oss.domain.model.id;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.net4iot.oss.domain.model.base.IdEntity;

/**
 * <pre>
 * 作用:
 * 注意:
 * 其他:
 * </pre>
 * 
 * @author chenwentao
 * @version 1.0, 2016-5-4
 * @see
 * @since
 */
@Entity
@Table(name = "id_generator_sensor")
public class IdGenerator extends IdEntity {

	private static final long serialVersionUID = -9060016923948113324L;

	@Column(name = "net_id_hex", unique = true)
	private String netIdHex;

	@Column(name = "net_id_dec", unique = true)
	private Integer netIdDec;

	@Column(name = "current_index")
	private Integer currentIndex;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	protected Date updateTime;

	/**
	 * @return the netIdHex
	 */
	public String getNetIdHex() {
		return netIdHex;
	}

	/**
	 * @param netIdHex
	 *            the netIdHex to set
	 */
	public void setNetIdHex(String netIdHex) {
		this.netIdHex = netIdHex;
	}

	/**
	 * @return the netIdDec
	 */
	public Integer getNetIdDec() {
		return netIdDec;
	}

	/**
	 * @param netIdDec
	 *            the netIdDec to set
	 */
	public void setNetIdDec(Integer netIdDec) {
		this.netIdDec = netIdDec;
	}

	/**
	 * @return the currentIndex
	 */
	public Integer getCurrentIndex() {
		return currentIndex;
	}

	/**
	 * @param currentIndex
	 *            the currentIndex to set
	 */
	public void setCurrentIndex(Integer currentIndex) {
		this.currentIndex = currentIndex;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
