package com.shine.his.store.service;

import java.util.List;

import com.shine.his.common.exception.HISException;
import com.shine.his.store.pojo.PurchaseApplicationMaster;
/**
 * 
 * Class Name:PurchaseApplicationService
 * Function:TODO(简单描述功能)
 * @author lily
 * @version (版本1.0)
 */
public interface IPurchaseApplicationService {
	/**
	 * create new applicationForm
	 * @param applicationForm
	 */
	public void addApplication(PurchaseApplicationMaster applicationForm)throws HISException;
	/**
	 * delete Application
	 * @param Id
	 * @throws HISException
	 */
	public void deleteApplicationMaster(String Id) throws HISException;
	public void deleteApplicationDetail(String Id) throws HISException;
	/**
	 * update Application all
	 * @param applicationForm
	 * @throws HISException
	 */
	public void updateApplicationAll(PurchaseApplicationMaster applicationForm)throws HISException;
	/**
	 * 
	 * updateApplicationStatusByID:(通过ID更新申请表状态).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param applicationForm
	 * @throws HISException
	 */
	public void updateApplicationStatusByID(PurchaseApplicationMaster applicationForm)throws HISException;	
	/**
	 * 
	 * @param applicationForm
	 * @return
	 * @throws HISException
	 */
	public List<PurchaseApplicationMaster> getApplicationMaster(PurchaseApplicationMaster applicationForm) throws HISException;
	/**
	 * 
	 * getApplicationDetail:(查询申请单详情).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param ID
	 * @return
	 * @throws HISException
	 */
	public PurchaseApplicationMaster getApplicationDetail(String ID) throws HISException;
	/**
	 * 
	 * submitApplication:(简单描述方法的作用).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param applicationForm
	 * @throws HISException
	 */
    public void submitApplication(PurchaseApplicationMaster applicationForm) throws HISException;
    /**
     * 
     * auditApplication:(简单描述方法的作用).<br/>
     * TODO:(描述方法的适用条件-可选).<br/>
     * @param applicationForm
     * @throws HISException
     */
    public void auditApplication(PurchaseApplicationMaster applicationForm) throws HISException;
}
