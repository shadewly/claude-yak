package com.shine.his.store.pojo;
/**
 * 
 * Class Name:PurchaseApplicationDetail采购计划详情
 * Function:TODO(简单描述功能)
 * @author lily
 * @version (版本1.0)
 */
public class PurchaseApplicationDetail {
	/** 采购计划编码 */
	private String storeProcurementPlanNo;
	/** 采购计划详细列表ID */
	private Integer procurementPlanDetailId;
	/** 药品编码 */
	private String drugCode;
	/** 采购数量 */
	private Integer quantity;
	/** 采购价格 */
	private Integer purchasePrice;
	/** 供应商 */
	private String supplierCode;
	/** 备注 */
	private String remark;
	
	public String getStoreProcurementPlanNo() {
		return storeProcurementPlanNo;
	}
	public void setStoreProcurementPlanNo(String storeProcurementPlanNo) {
		this.storeProcurementPlanNo = storeProcurementPlanNo;
	}
	public Integer getProcurementPlanDetailId() {
		return procurementPlanDetailId;
	}
	public void setProcurementPlanDetailId(Integer procurementPlanDetailId) {
		this.procurementPlanDetailId = procurementPlanDetailId;
	}
	public String getDrugCode() {
		return drugCode;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
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
	@Override
	public String toString() {
		return "PurchaseApplicationDetail [storeProcurementPlanNo=" + storeProcurementPlanNo
				+ ", procurementPlanDetailId=" + procurementPlanDetailId + ", drugCode=" + drugCode + ", quantity="
				+ quantity + ", purchasePrice=" + purchasePrice + ", supplierCode=" + supplierCode + ", remark="
				+ remark + "]";
	}
	


}
