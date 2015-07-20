package com.shine.his.store.pojo;


/**   
 * @Title: Entity
 * @Description: ss
 * @author zhangdaihao
 * @date 2015-07-07 10:14:12
 * @version V1.0   
 *
 */

@SuppressWarnings("serial")
public class StoreCheckDetailEntity implements java.io.Serializable {
	/**药品盘点明细ID*/
	private Long storeCheckDetailId;
	/**货位编号*/
	private String storeGoodsPositionCode;
	/**盘点编号*/
	private String drugCheckNo;
	/**药品编码*/
	private String drugCode;
	/**有效期*/
	private java.util.Date expDate;
	/**批次*/
	private String batchNo;
	/**采购单价*/
	private java.math.BigDecimal purchasePrice;
	/**销售价*/
	private java.math.BigDecimal retailPrice;
	/**库存数量*/
	private Integer storeNum;
	/**实盘数量*/
	private Integer realNum;
	/**盈亏数量*/
	private Integer relativeNum;
	/**供应商*/
	private String supplierCode;
	/**备注*/
	private String remark;
	public Long getStoreCheckDetailId() {
		return storeCheckDetailId;
	}
	public void setStoreCheckDetailId(Long storeCheckDetailId) {
		this.storeCheckDetailId = storeCheckDetailId;
	}
	public String getStoreGoodsPositionCode() {
		return storeGoodsPositionCode;
	}
	public void setStoreGoodsPositionCode(String storeGoodsPositionCode) {
		this.storeGoodsPositionCode = storeGoodsPositionCode;
	}
	public String getDrugCheckNo() {
		return drugCheckNo;
	}
	public void setDrugCheckNo(String drugCheckNo) {
		this.drugCheckNo = drugCheckNo;
	}
	public String getDrugCode() {
		return drugCode;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
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
	public Integer getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(Integer storeNum) {
		this.storeNum = storeNum;
	}
	public Integer getRealNum() {
		return realNum;
	}
	public void setRealNum(Integer realNum) {
		this.realNum = realNum;
	}
	public Integer getRelativeNum() {
		return relativeNum;
	}
	public void setRelativeNum(Integer relativeNum) {
		this.relativeNum = relativeNum;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
