package com.shine.his.store.pojo;


/**   
 * @Title: Entity
 * @Description: ss
 * @author zhangdaihao
 * @date 2015-07-07 10:13:40
 * @version V1.0   
 *
 */

public class StoreCheckMasterEntity implements java.io.Serializable {
	/**盘点编号*/
	private String drugCheckNo;
	/**盘点时间*/
	private java.util.Date checkTime;
	/**盘点部门*/
	private String storeCode;
	/**盘点药品类型*/
	private String type;
	/**填制人*/
	private String makeUser;
	/**状态*/
	private String status;
	/**确认人*/
	private String confirmUser;
	/**确认时间*/
	private java.util.Date configTime;
	/**审核人*/
	private String auditUser;
	/**审核时间*/
	private java.util.Date auditTime;
	/**备注*/
	private String remark;
	public String getDrugCheckNo() {
		return drugCheckNo;
	}
	public void setDrugCheckNo(String drugCheckNo) {
		this.drugCheckNo = drugCheckNo;
	}
	public java.util.Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(java.util.Date checkTime) {
		this.checkTime = checkTime;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMakeUser() {
		return makeUser;
	}
	public void setMakeUser(String makeUser) {
		this.makeUser = makeUser;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getConfirmUser() {
		return confirmUser;
	}
	public void setConfirmUser(String confirmUser) {
		this.confirmUser = confirmUser;
	}
	public java.util.Date getConfigTime() {
		return configTime;
	}
	public void setConfigTime(java.util.Date configTime) {
		this.configTime = configTime;
	}
	public String getAuditUser() {
		return auditUser;
	}
	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}
	public java.util.Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(java.util.Date auditTime) {
		this.auditTime = auditTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
