package com.shine.his.store.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Class Name:StoreDrugDetail
 * Function:药品库存明细
 * @author ducheng
 * @version 1.0
 */
public class StoreDrugDetail implements Serializable {
	private static final long serialVersionUID = -5543257574130964548L;
	//库存表STORE_DRUG_DETAIL
	/**
	 * 药品库存明细ID(STORE_DRUG_DETAIL_ID)
	 */
	private Integer storeDrugDetailId;
	/**
	 * 药品编码(DRUG_CODE)
	 */
	private String drugCode;
	/**
	 * 药品目录，通过DRUG_CODE关联
	 */
	private DrugList drugCatalog;
	/**
	 * 供应商编码(SUPPLIER_CODE)
	 */
	private String supplierCode;
	/**
	 * TODO 供应商名称，冗余字段(SUPPLIER_NAME)
	 */
	private String supplierName;
	/**
	 * 有效期(EXP_DATE)
	 */
	private Date expDate;
	/**
	 * 批号(BATCH_NO)
	 */
	private String batchNo;
	/**
	 * 库存数量(QUANTITY)
	 */
	private Integer quantity;
	/**
	 * 货位编号(STORE_GOODS_POSITION_CODE)
	 */
	private String storeGoodsPositionCode;
	/**
	 * 药品状态:0已过近效期 1没过近效期(STATUS)
	 */
	private String status;
	//--------------库存配置表字段
	/**
	 * TODO 近效期，冗余字段（OFFSET_EXP_DATE）
	 */
	private Integer offsetExpDate;
	/**
	 * TODO 上限，冗余字段(UPPER_LEVEL)
	 */
	private Integer upperLevel;
	/**
	 * TODO 下限，冗余字段（LOW_LEVEL）
	 */
	private Integer lowLevel;
	private Double price;
	public Integer getStoreDrugDetailId() {
		return storeDrugDetailId;
	}
	public void setStoreDrugDetailId(Integer storeDrugDetailId) {
		this.storeDrugDetailId = storeDrugDetailId;
	}
	public String getDrugCode() {
		return drugCode;
	}
	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
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
	public String getStoreGoodsPositionCode() {
		return storeGoodsPositionCode;
	}
	public void setStoreGoodsPositionCode(String storeGoodsPositionCode) {
		this.storeGoodsPositionCode = storeGoodsPositionCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public DrugList getDrugCatalog() {
		return drugCatalog;
	}
	public void setDrugCatalog(DrugList drugCatalog) {
		this.drugCatalog = drugCatalog;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Integer getOffsetExpDate() {
		return offsetExpDate;
	}
	public void setOffsetExpDate(Integer offsetExpDate) {
		this.offsetExpDate = offsetExpDate;
	}
	public Integer getUpperLevel() {
		return upperLevel;
	}
	public void setUpperLevel(Integer upperLevel) {
		this.upperLevel = upperLevel;
	}
	public Integer getLowLevel() {
		return lowLevel;
	}
	public void setLowLevel(Integer lowLevel) {
		this.lowLevel = lowLevel;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "StoreDrugDetail [storeDrugDetailId=" + storeDrugDetailId
				+ ", drugCode=" + drugCode + ", drugCatalog=" + drugCatalog
				+ ", supplierCode=" + supplierCode + ", supplierName="
				+ supplierName + ", expDate=" + expDate + ", batchNo="
				+ batchNo + ", quantity=" + quantity
				+ ", storeGoodsPositionCode=" + storeGoodsPositionCode
				+ ", status=" + status + ", offsetExpDate=" + offsetExpDate
				+ ", upperLevel=" + upperLevel + ", lowLevel=" + lowLevel
				+ ", price=" + price + "]";
	}
	
}
