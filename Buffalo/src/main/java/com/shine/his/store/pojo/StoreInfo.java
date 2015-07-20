package com.shine.his.store.pojo;

import java.util.Date;
/**
 * 
 * Class Name:StoreInfo
 * Function:TODO(仓库实体)
 * @author panda
 * @version (版本1.0)
 */
public class StoreInfo{
	/**
	 * 仓库编号
	 */
	private  String storeCode;
	/**
	 * 仓库名字
	 */
	private  String storeName;
	/**
	 * 仓库位置
	 */
	private  String storeLocation;
	/**
	 * 仓库状态
	 */
	private  String status;
	/**
	 * 仓库创建时间
	 */
	private  Date createTime;
	/**
	 * 仓库修改时间
	 */
	private  Date modifyTime;
	/**
	 * 备注
	 */
	private  String remark;
	private StoreManagerStore storeManagerStore;
	private StoreManager storeManager;
	
	public StoreManagerStore getStoreManagerStore() {
		return storeManagerStore;
	}
	public void setStoreManagerStore(StoreManagerStore storeManagerStore) {
		this.storeManagerStore = storeManagerStore;
	}
	public StoreManager getStoreManager() {
		return storeManager;
	}
	public void setStoreManager(StoreManager storeManager) {
		this.storeManager = storeManager;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreLocation() {
		return storeLocation;
	}
	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "StoreInfo [storeCode=" + storeCode + ", storeName=" + storeName
				+ ", storeLocation=" + storeLocation + ", status=" + status
				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime
				+ ", remark=" + remark + ", storeManagerStore="
				+ storeManagerStore + ", storeManager=" + storeManager + "]";
	}
}
