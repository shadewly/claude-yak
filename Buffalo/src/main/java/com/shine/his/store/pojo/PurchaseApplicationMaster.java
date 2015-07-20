package com.shine.his.store.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 
 * Class Name:PurchaseApplicationMaster 采购计划主表信息
 * Function:TODO(简单描述功能)
 * @author lily
 * @version (版本1.0)
 */
public class PurchaseApplicationMaster implements Serializable{
	/** 采购计划编码 */
	private String storeProcurementPlanNo;
	/** 计划标题 */
	private String title;
	/** 优先级 */
	private String priority;
	/** 申请人 */
	private String createUser;
	/** 申请时间*/
	private Date createTime;
	/** 完善人*/
	private String improveUser;
	/** 完善时间*/
	private Date improveTime;
	/** 审核人*/
	private String auditUser;
	/** 审核时间*/
	private Date auditTime;
	/** 状态*/
	private String status;
	/** 备注*/
	private String remark;
	/**开始时间*/
	private String startTime;
	/**结束时间*/
	private String endTime;
	private List<PurchaseApplicationDetail> purchaseApplicationDetail;
	private String storeOrderNo;
	
	
	public String getStoreProcurementPlanNo() {
		return storeProcurementPlanNo;
	}
	public void setStoreProcurementPlanNo(String storeProcurementPlanNo) {
		this.storeProcurementPlanNo = storeProcurementPlanNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getImproveUser() {
		return improveUser;
	}
	public void setImproveUser(String improveUser) {
		this.improveUser = improveUser;
	}
	public Date getImproveTime() {
		return improveTime;
	}
	public void setImproveTime(Date improveTime) {
		this.improveTime = improveTime;
	}
	public String getAuditUser() {
		return auditUser;
	}
	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public List<PurchaseApplicationDetail> getPurchaseApplicationDetail() {
		return purchaseApplicationDetail;
	}
	public void setPurchaseApplicationDetail(
			List<PurchaseApplicationDetail> purchaseApplicationDetail) {
		this.purchaseApplicationDetail = purchaseApplicationDetail;
	}
	
	public String getStoreOrderNo() {
		return storeOrderNo;
	}
	public void setStoreOrderNo(String storeOrderNo) {
		this.storeOrderNo = storeOrderNo;
	}
	@Override
	public String toString() {
		return "PurchaseApplicationMaster [storeProcurementPlanNo=" + storeProcurementPlanNo + ", title=" + title
				+ ", priority=" + priority + ", createUser=" + createUser + ", createTime=" + createTime
				+ ", improveUser=" + improveUser + ", improveTime=" + improveTime + ", auditUser=" + auditUser
				+ ", auditTime=" + auditTime + ", status=" + status + ", remark=" + remark + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", purchaseApplicationDetail=" + purchaseApplicationDetail
				+ ", storeOrderNo=" + storeOrderNo + "]";
	}
	
	
	

}
