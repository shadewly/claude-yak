package com.shine.his.store.pojo;
import java.util.Date;
/**
 * 
 * Class Name:StoreShelfInfo
 * Function:TODO(简单描述功能)
 * @author panda
 * @version (版本1.0)
 */
public class StoreShelfInfo{
	/**
	 * 货架编号
	 */
	private  String storeShelfCode;
	/**
	 * 仓库编号
	 */
	private  String storeCode;
	/**
	 * 货架名字
	 */
	private  String shelfName;
	/**
	 * 货架状态
	 */
	private  String shelfStatus;
	/**
	 * 货架创建时间
	 */
	private  Date createTime;
	/**
	 * 货架修改时间
	 */
	private  Date modifyTime;
	/**
	 * 备注
	 */
	private  String remark;
	
	public String getStoreShelfCode() {
		return storeShelfCode;
	}
	public void setStoreShelfCode(String storeShelfCode) {
		this.storeShelfCode = storeShelfCode;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getShelfName() {
		return shelfName;
	}
	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}
	public String getShelfStatus() {
		return shelfStatus;
	}
	public void setShelfStatus(String shelfStatus) {
		this.shelfStatus = shelfStatus;
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
}
