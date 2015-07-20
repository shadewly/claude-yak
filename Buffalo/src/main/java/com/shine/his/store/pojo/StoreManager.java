package com.shine.his.store.pojo;

public class StoreManager {
	private int StoreManagerId;
	private String storeManagerName;
	private String phone;
	public int getStoreManagerId() {
		return StoreManagerId;
	}
	public void setStoreManagerId(int storeManagerId) {
		StoreManagerId = storeManagerId;
	}
	public String getStoreManagerName() {
		return storeManagerName;
	}
	public void setStoreManagerName(String storeManagerName) {
		this.storeManagerName = storeManagerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
