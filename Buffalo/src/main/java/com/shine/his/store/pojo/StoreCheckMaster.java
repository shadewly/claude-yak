package com.shine.his.store.pojo;


import java.util.ArrayList;
import java.util.List;

/**
 * @author claude wang
 * @version V1.0
 * @Title: Entity
 * @Description: ss
 * @date 2015-07-07 10:13:40
 */

public class StoreCheckMaster implements java.io.Serializable {

    /**
     * 盘点编号
     */
    private String drugCheckNo;
    /**
     * 盘点时间
     */
    private java.util.Date checkTime;
    /**
     * 盘点部门
     */
    private String storeCode;
    /**
     * 盘点药品类型
     */
    private String type;
    /**
     * 填制人
     */
    private String makeUser;
    /**
     * 状态
     */
    private String status;
    /**
     * 确认人
     */
    private String confirmUser;
    /**
     * 确认时间
     */
    private java.util.Date configTime;
    /**
     * 审核人
     */
    private String auditUser;
    /**
     * 审核时间
     */
    private java.util.Date auditTime;
    /**
     * 备注
     */
    private String remark;
    private List<StoreCheckDetail> storeCheckDetails;

    public List<StoreCheckDetail> getStoreCheckDetails() {
        return storeCheckDetails == null ? new ArrayList<StoreCheckDetail>() : storeCheckDetails;
    }

    public void setStoreCheckDetails(List<StoreCheckDetail> storeCheckDetails) {
        this.storeCheckDetails = storeCheckDetails;
    }

    public void addDetail(StoreCheckDetail storeCheckDetail) {
        if (storeCheckDetails == null) {
            storeCheckDetails = new ArrayList<StoreCheckDetail>();
        }
        storeCheckDetail.setDrugCheckNo(this.getDrugCheckNo());
        this.storeCheckDetails.add(storeCheckDetail);
    }

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

    public StoreCheckStatus getStoreCheckStatus() {
        return StoreCheckStatus.getStoreCheckStatusByCode(this.status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(StoreCheckStatus status) {
        this.status = status.getStatusCode();
    }

    public void setStatus(String status) {
        this.setStatus(StoreCheckStatus.getStoreCheckStatusByCode(status));
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

    @Override
    public String toString() {
        return "StoreCheckMaster{" +
                "drugCheckNo='" + drugCheckNo + '\'' +
                ", checkTime=" + checkTime +
                ", storeCode='" + storeCode + '\'' +
                ", type='" + type + '\'' +
                ", makeUser='" + makeUser + '\'' +
                ", status='" + status + '\'' +
                ", confirmUser='" + confirmUser + '\'' +
                ", configTime=" + configTime +
                ", auditUser='" + auditUser + '\'' +
                ", auditTime=" + auditTime +
                ", remark='" + remark + '\'' +
                ", storeCheckDetails=" + storeCheckDetails +
                '}';
    }

    public enum StoreCheckStatus {
        DELETED("3"), WAIT_CONFIRM("0"), WAIT_AUDIT("1"), COMPLETED("2");

        private String statusCode;

        StoreCheckStatus(String statusCode) {
            this.statusCode = statusCode;
        }

        static StoreCheckStatus getStoreCheckStatusByCode(String statusCode) {
            for (StoreCheckStatus status : StoreCheckStatus.values()) {
                if (status.statusCode.equals(statusCode)) return status;
            }
            return null;
        }

        public String getStatusCode() {
            return statusCode;
        }
        @Override
        public String toString() {
            return "StoreCheckStatus[" + this.name() + "]{" +
                    "statusCode='" + statusCode + '\'' +
                    '}';
        }
    }
}
