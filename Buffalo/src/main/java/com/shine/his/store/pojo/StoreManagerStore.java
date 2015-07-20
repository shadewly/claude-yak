package com.shine.his.store.pojo;

/**
 * 
 * Class Name:StoreManagerStore
 * Function:TODO(仓库管理员_仓库信息实体)
 * @author panda
 * @version (版本)
 */
public class StoreManagerStore {
	/**
	 * 仓库编号
	 */
	private String storeCode;
	/**
	 * 管理员ID
	 */
	private int storeManagerId;
	/**
	 * 管理员仓库ID
	 */
	private int storeManagerStoreId;
	
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public int getStoreManagerId() {
		return storeManagerId;
	}
	public void setStoreManagerId(int storeManagerId) {
		this.storeManagerId = storeManagerId;
	}
	public int getStoreManagerStoreId() {
		return storeManagerStoreId;
	}
	public void setStoreManagerStoreId(int storeManagerStoreId) {
		this.storeManagerStoreId = storeManagerStoreId;
	}
	
}
