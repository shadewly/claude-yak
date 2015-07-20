package com.shine.his.store.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Class Name:DrugList
 * Function:药品目录
 * @author ducheng
 * @version 1.0
 */
public class DrugList implements Serializable{
	private static final long serialVersionUID = -4124543185924387421L;
	/**
	 * 药品编码
	 */
	private String drugCode;
	/**
	 * 药品字典编码(DRUG_DICT_CODE)
	 */
    private String drugDictCode;
    /**
     * 药品通用名称(DRUG_NAME)
     */
    private String drugName;
    /**
     * 商品名(COMM_NAME)
     */
    private String commName;
    /**
     * 其他别名(OTHER_NAME)
     */
    private String otherName;
    /**
     * 药品包装规格(DRUG_SPEC)
     */
    private String drugSpec;
    /**
     * 处方职务(PRESC_DOCTOR_TITLE)
     */
    private String prescDoctorTitle;
    /**
     * 药品剂型(DRUG_DOSE)
     */
    private String drugDose;
    /**
     * 是否新药(IS_NEW)
     */
    private String isNew;
    /**
     * 是否皮试(IS_SKINTEST)
     */
    private String isSkintest;
    /**
     * 生产商(MANUFACT)
     */
    private String manufact;
    /**
     * 来源类型(DRUG_FROM)
     */
    private String drugFrom;
    /**
     * 产地(ORIGIN)
     */
    private String origin;
    /**
     * 批准文号(APPROVAL)
     */
    private String approval;
    /**
     * 计价单位(VALUATION_UNIT)
     */
    private String valuationUnit;
    /**
     * 计量单位(MEASURE_UNIT)
     */
    private String measureUnit;
    /**
     * 分装规格(PACK_SPEC)
     */
    private Integer packSpec;
    /**
     * 剂量单位(DOSE_UNIT)
     */
    private String doseUnit;
    /**
     * 剂量系数(DOSE_AMOUNT)
     */
    private Integer doseAmount;
    /**
     * 住院单位(INP_UNIT)
     */
    private String inpUnit;
    /**
     * 住院包装(INP_PACK)
     */
    private Integer inpPack;
    /**
     * 门诊单位(OUTP_UNIT)
     */
    private String outpUnit;
    /**
     * 门诊包装(OUTP_PACK)
     */
    private Integer outpPack;
    /**
     * 药库单位(STORE_UNIT)
     */
    private String storeUnit;
    /**
     * 药库包装(DRUGSTORE_PACK)
     */
    private Integer drugstorePack;
    /**
     * 申领单位(CLAIM_UNIT)
     */
    private String claimUnit;
    /**
     * 是否拆分(IS_SPLIT)
     */
    private String isSplit;

    private String status;

    private String createUser;

    private Date createTime;

    private Date eliminateTime;
	
    /**
     * 药品大类DRUG_CATEGORY_NAME
     * TODO 这里后台直接关联字典表和大类表查询结果
     */
    private String drugCategoryName;
    
    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode == null ? null : drugCode.trim();
    }

    public String getDrugDictCode() {
        return drugDictCode;
    }

    public void setDrugDictCode(String drugDictCode) {
        this.drugDictCode = drugDictCode == null ? null : drugDictCode.trim();
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName == null ? null : otherName.trim();
    }

    public String getDrugSpec() {
        return drugSpec;
    }

    public void setDrugSpec(String drugSpec) {
        this.drugSpec = drugSpec == null ? null : drugSpec.trim();
    }

    public String getDrugDose() {
        return drugDose;
    }

    public void setDrugDose(String drugDose) {
        this.drugDose = drugDose == null ? null : drugDose.trim();
    }

    public String getPrescDoctorTitle() {
        return prescDoctorTitle;
    }

    public void setPrescDoctorTitle(String prescDoctorTitle) {
        this.prescDoctorTitle = prescDoctorTitle == null ? null : prescDoctorTitle.trim();
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew == null ? null : isNew.trim();
    }

    public String getIsSkintest() {
        return isSkintest;
    }

    public void setIsSkintest(String isSkintest) {
        this.isSkintest = isSkintest == null ? null : isSkintest.trim();
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact == null ? null : manufact.trim();
    }

    public String getDrugFrom() {
        return drugFrom;
    }

    public void setDrugFrom(String drugFrom) {
        this.drugFrom = drugFrom == null ? null : drugFrom.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval == null ? null : approval.trim();
    }

    public String getValuationUnit() {
        return valuationUnit;
    }

    public void setValuationUnit(String valuationUnit) {
        this.valuationUnit = valuationUnit == null ? null : valuationUnit.trim();
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit == null ? null : measureUnit.trim();
    }

    public Integer getPackSpec() {
        return packSpec;
    }

    public void setPackSpec(Integer packSpec) {
        this.packSpec = packSpec;
    }

    public String getDoseUnit() {
        return doseUnit;
    }

    public void setDoseUnit(String doseUnit) {
        this.doseUnit = doseUnit == null ? null : doseUnit.trim();
    }

    public Integer getDoseAmount() {
        return doseAmount;
    }

    public void setDoseAmount(Integer doseAmount) {
        this.doseAmount = doseAmount;
    }

    public String getInpUnit() {
        return inpUnit;
    }

    public void setInpUnit(String inpUnit) {
        this.inpUnit = inpUnit == null ? null : inpUnit.trim();
    }

    public Integer getInpPack() {
        return inpPack;
    }

    public void setInpPack(Integer inpPack) {
        this.inpPack = inpPack;
    }

    public String getOutpUnit() {
        return outpUnit;
    }

    public void setOutpUnit(String outpUnit) {
        this.outpUnit = outpUnit == null ? null : outpUnit.trim();
    }

    public Integer getOutpPack() {
        return outpPack;
    }

    public void setOutpPack(Integer outpPack) {
        this.outpPack = outpPack;
    }

    public String getStoreUnit() {
        return storeUnit;
    }

    public void setStoreUnit(String storeUnit) {
        this.storeUnit = storeUnit == null ? null : storeUnit.trim();
    }

    public Integer getDrugstorePack() {
        return drugstorePack;
    }

    public void setDrugstorePack(Integer drugstorePack) {
        this.drugstorePack = drugstorePack;
    }

    public String getClaimUnit() {
        return claimUnit;
    }

    public void setClaimUnit(String claimUnit) {
        this.claimUnit = claimUnit == null ? null : claimUnit.trim();
    }

    public String getIsSplit() {
        return isSplit;
    }

    public void setIsSplit(String isSplit) {
        this.isSplit = isSplit == null ? null : isSplit.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEliminateTime() {
        return eliminateTime;
    }

    public void setEliminateTime(Date eliminateTime) {
        this.eliminateTime = eliminateTime;
    }

	public String getDrugCategoryName() {
		return drugCategoryName;
	}

	public void setDrugCategoryName(String drugCategoryName) {
		this.drugCategoryName = drugCategoryName;
	}

	@Override
	public String toString() {
		return "DrugList [drugCode=" + drugCode + ", drugDictCode="
				+ drugDictCode + ", drugName=" + drugName + ", commName="
				+ commName + ", otherName=" + otherName + ", drugSpec="
				+ drugSpec + ", prescDoctorTitle=" + prescDoctorTitle
				+ ", drugDose=" + drugDose + ", isNew=" + isNew
				+ ", isSkintest=" + isSkintest + ", manufact=" + manufact
				+ ", drugFrom=" + drugFrom + ", origin=" + origin
				+ ", approval=" + approval + ", valuationUnit=" + valuationUnit
				+ ", measureUnit=" + measureUnit + ", packSpec=" + packSpec
				+ ", doseUnit=" + doseUnit + ", doseAmount=" + doseAmount
				+ ", inpUnit=" + inpUnit + ", inpPack=" + inpPack
				+ ", outpUnit=" + outpUnit + ", outpPack=" + outpPack
				+ ", storeUnit=" + storeUnit + ", drugstorePack="
				+ drugstorePack + ", claimUnit=" + claimUnit + ", isSplit="
				+ isSplit + ", status=" + status + ", createUser=" + createUser
				+ ", createTime=" + createTime + ", eliminateTime="
				+ eliminateTime + ", drugCategoryName=" + drugCategoryName
				+ "]";
	}
    
}