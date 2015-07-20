package com.shine.his.store.pojo;

import java.util.List;

/**
 * 
 * Class Name:StoreDrugInDetail 入库主表信息
 * 
 * @author 余鑫晨
 * @version (1.0)
 */
public class StoreDrugInMaster {
	/** storeDrugInNo */
	private String storeOrderNo;
	/** storeInTypeId */
	private String storeOrderType;
	/** createUser */
	private String createUser;
	/** createTime */
	private java.util.Date createTime;
	/** totalPurchasePrice */
	private java.math.BigDecimal totalPurchasePrice;
	/** totalRetailPrice */
	private java.math.BigDecimal totalRetailPrice;
	/** department */
	private String department;
	/** remark */
	private String remark;

	private List<StoreDrugInDetail> storeInOrderDetailList;

	public String getStoreOrderNo() {
		return storeOrderNo;
	}

	public void setStoreOrderNo(String storeOrderNo) {
		this.storeOrderNo = storeOrderNo;
	}

	public String getStoreOrderType() {
		return storeOrderType;
	}

	public void setStoreOrderType(String storeOrderType) {
		this.storeOrderType = storeOrderType;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.math.BigDecimal getTotalPurchasePrice() {
		return totalPurchasePrice;
	}

	public void setTotalPurchasePrice(java.math.BigDecimal totalPurchasePrice) {
		this.totalPurchasePrice = totalPurchasePrice;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<StoreDrugInDetail> getStoreInOrderDetailList() {
		return storeInOrderDetailList;
	}

	public void setStoreInOrderDetailList(
			List<StoreDrugInDetail> storeInOrderDetailList) {
		this.storeInOrderDetailList = storeInOrderDetailList;
	}

	public java.math.BigDecimal getTotalRetailPrice() {
		return totalRetailPrice;
	}

	public void setTotalRetailPrice(java.math.BigDecimal totalRetailPrice) {
		this.totalRetailPrice = totalRetailPrice;
	}

}
