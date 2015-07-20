package com.shine.his.store.pojo;

/**
 * 
 * Class Name:StoreDrugInDetail 出库详细信息
 * 
 * @author 余鑫晨
 * @version (1.0)
 */
public class StoreDrugOutDetail {
	/** storeOutNo */
	private String storeOrderNo;
	/** storeDrugOutDetailId */
	private Integer storeDrugOutDetailId;
	/** drugCode */
	private String drugCode;
	/** purchasePrice */
	private java.math.BigDecimal purchasePrice;
	/** retailPrice */
	private java.math.BigDecimal retailPrice;
	/** expDate */
	private java.util.Date expDate;
	/** batchNo */
	private String batchNo;
	/** quantity */
	private Integer quantity;
	/** supplierCode */
	private String supplierCode;
	/** storeCode */
	private String storeCode;
	/** storeGoodsPositionCode */
	private String storeGoodsPositionCode;
	/** purchaseAmount */
	private java.math.BigDecimal purchaseAmount;
	/** purchaseAmount */
	private java.math.BigDecimal retailAmount;
	/** drugSource */
	private String drugSource;
	/** remark */
	private String remark;

	public String getStoreOrderNo() {
		return storeOrderNo;
	}

	public void setStoreOrderNo(String storeOrderNo) {
		this.storeOrderNo = storeOrderNo;
	}

	public Integer getStoreDrugOutDetailId() {
		return storeDrugOutDetailId;
	}

	public void setStoreDrugOutDetailId(Integer storeDrugOutDetailId) {
		this.storeDrugOutDetailId = storeDrugOutDetailId;
	}

	public String getDrugCode() {
		return drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	public java.math.BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(java.math.BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public java.math.BigDecimal getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(java.math.BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public java.util.Date getExpDate() {
		return expDate;
	}

	public void setExpDate(java.util.Date expDate) {
		this.expDate = expDate;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreGoodsPositionCode() {
		return storeGoodsPositionCode;
	}

	public void setStoreGoodsPositionCode(
			String storeGoodsPositionCode) {
		this.storeGoodsPositionCode = storeGoodsPositionCode;
	}

	public java.math.BigDecimal getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(java.math.BigDecimal purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public java.math.BigDecimal getRetailAmount() {
		return retailAmount;
	}

	public void setRetailAmount(java.math.BigDecimal retailAmount) {
		this.retailAmount = retailAmount;
	}

	public String getDrugSource() {
		return drugSource;
	}

	public void setDrugSource(String drugSource) {
		this.drugSource = drugSource;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
