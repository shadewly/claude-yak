package com.shine.his.store.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.shine.his.common.mybatis.MybatisMapperAnnotation;
import com.shine.his.store.pojo.PurchaseApplicationDetail;
import com.shine.his.store.pojo.PurchaseApplicationMaster;

/**
 * 
 * Class Name:PurchaseApplicationDao
 * Function:TODO(简单描述功能)
 * @author lily
 * @version (版本1.0)
 */
@Repository
@Scope("singleton")
@MybatisMapperAnnotation
public interface IPurchaseApplicationDao {
	/**
	 * 
	 * addPurchaseApplication:(添加采购申请).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param purForm
	 * @return
	 */
	public int addPurchaseApplicationMaster(PurchaseApplicationMaster purForm);
	public int addPurchaseApplicationDetail(@Param("purchaseApplicationDetail") List<PurchaseApplicationDetail> purchaseApplicationDetail);
	/**
	 * 
	 * delPurchaseApplication:(删除采购计划).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param purchaseID
	 * @return
	 */
	public int delPurchaseApplicationMaster(String storeProcurementPlanNo);
	/**
	 * 
	 * delPurchaseApplicationDetail:(删除采购申请详情单某一条记录).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param purchaseID
	 * @return
	 */
	public int delPurchaseApplicationDetail(String procurementPlanDetailId);
	/**
	 * 
	 * updatePurchaseApplication:(修改采购申请单).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param purForm
	 * @return
	 */
	public int updatePurchaseApplicationAll(PurchaseApplicationMaster purForm);
	/**
	 * 
	 * updatePurchaseApplicationStatus:(更新申请表状态).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param purForm
	 * @return
	 */
	public int updatePurchaseApplication(PurchaseApplicationMaster purForm);
	/**
	 * 
	 * getPurchaseApplication:(查询采购申请单).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param purForm
	 * @return
	 */
	public List<PurchaseApplicationMaster> getPurchaseApplicationMaster(PurchaseApplicationMaster purForm);
	/**
	 * 
	 * getApplicationDetail:(查询申请单详情).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param storeProcurementPlanNo
	 * @return
	 */
	public PurchaseApplicationMaster getApplicationDetail(String storeProcurementPlanNo);
	/**
	 * 
	 * submitApplication:(提交申请单).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param applicationForm
	 * @return
	 */
/*	public int submitApplication(PurchaseApplicationMaster applicationForm);
	public int auditApplication(PurchaseApplicationMaster applicationForm);*/
}
