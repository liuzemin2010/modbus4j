package com.net4iot.oss.domain.dto;

/**
 * 
 * <pre>
 * 作用:权限实体类
 * 注意:
 * 其他:
 * </pre>
 *
 * @author xudan
 * @version 1.0, 2017年11月22日
 * @see
 * @since
 */
public class CategoryNodeInfo {
	private String name;
	private Long id;
	private boolean isLeaf;
	private boolean isChosen;
	private Long parentId;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
	 * @return the isLeaf
	 */
	public boolean isLeaf() {
		return isLeaf;
	}

	/**
	 * @param isLeaf
	 *            the isLeaf to set
	 */
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the isChosen
	 */
	public boolean isChosen() {
		return isChosen;
	}

	/**
	 * @param isChosen
	 *            the isChosen to set
	 */
	public void setChosen(boolean isChosen) {
		this.isChosen = isChosen;
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
