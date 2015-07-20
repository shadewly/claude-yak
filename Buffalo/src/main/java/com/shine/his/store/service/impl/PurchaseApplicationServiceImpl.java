package com.shine.his.store.service.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Logger;

import com.shine.his.common.exception.HISException;
import com.shine.his.store.dao.IPurchaseApplicationDao;
import com.shine.his.store.pojo.PurchaseApplicationDetail;
import com.shine.his.store.pojo.PurchaseApplicationMaster;
import com.shine.his.store.service.IPurchaseApplicationService;
/**
 * 
 * Class Name:PurchaseApplicationServiceImpl
 * Function:TODO(简单描述功能)
 * @author lily
 * @version (版本1.0)
 */
@Service
public class PurchaseApplicationServiceImpl implements IPurchaseApplicationService{
	/**
	 * 采购计划申请Dao接口对象
	 */
	@Autowired
    private IPurchaseApplicationDao purchaseApplicationDao;
    private Logger logger = (Logger) LoggerFactory.getLogger(PurchaseApplicationServiceImpl.class);
    
	public void addApplication(PurchaseApplicationMaster applicationForm)
			throws HISException {
		// 添加申请单
		logger.info("添加申请单："+applicationForm);
		int masterInt = purchaseApplicationDao.addPurchaseApplicationMaster(applicationForm);
		logger.info("masterInt："+masterInt);
		logger.info("purchaseApplicationDetail111："+applicationForm.getPurchaseApplicationDetail());
		if(masterInt > 0){
			List<PurchaseApplicationDetail> purchaseApplicationDetail = applicationForm.getPurchaseApplicationDetail();
			int detailInt = purchaseApplicationDao.addPurchaseApplicationDetail(purchaseApplicationDetail);
		    if(detailInt > 0){
		    	logger.info("申请单添加成功！");
		    }
		}
		
	}

	public void deleteApplicationMaster(String Id) throws HISException {
		// TODO Auto-generated method stub
		if(Id != "" && Id != null){
			int detailInt = purchaseApplicationDao.delPurchaseApplicationDetail(Id);
			if(detailInt > 0){
			int masterInt = purchaseApplicationDao.delPurchaseApplicationMaster(Id);
			if(masterInt > 0){
				logger.info("申请单删除成功！");
			}else{
				logger.error("申请单删除失败！");
			}
			}
		}
		
	}
	public void deleteApplicationDetail(String Id) throws HISException {
		// TODO Auto-generated method stub
		if(Id != "" && Id != null){
			int delInt = purchaseApplicationDao.delPurchaseApplicationDetail(Id);
			if(delInt > 0){
				logger.info("申请单详情删除成功！");
			}else{
				logger.error("申请单详情删除失败！");
			}
		}
		
	}

	public List<PurchaseApplicationMaster> getApplicationMaster(
			PurchaseApplicationMaster applicationForm) throws HISException {
		// TODO Auto-generated method stub
		logger.info("查询申请单》》》》：");
		List<PurchaseApplicationMaster> purMaster = purchaseApplicationDao.getPurchaseApplicationMaster(applicationForm);		
		return purMaster;
	}

	public PurchaseApplicationMaster getApplicationDetail(String storeProcurementPlanNo)
			throws HISException {
		// TODO Auto-generated method stub
		logger.info("查询申请单详情信息》》》》-----：");
		PurchaseApplicationMaster purMaster = purchaseApplicationDao.getApplicationDetail(storeProcurementPlanNo);		

		return purMaster;
	}

	public void updateApplicationAll(PurchaseApplicationMaster applicationForm)
			throws HISException {
		// TODO Auto-generated method stub
		
	}

	public void updateApplicationStatusByID(
			PurchaseApplicationMaster applicationForm) throws HISException {
		// TODO Auto-generated method stub
		logger.info("通过id更新申请主表状态》》》》-----：");
		int masterInt = purchaseApplicationDao.updatePurchaseApplication(applicationForm);
		if(masterInt > 0){
			logger.info("通过id更新申请主表状态成功！");
		}else{
			logger.error("通过id更新申请主表状态失败！");
		}
	}

	public void submitApplication(PurchaseApplicationMaster applicationForm)
			throws HISException {
		// TODO Auto-generated method stub
		logger.info("提交申请单》》》》-----：");
		int masterInt = purchaseApplicationDao.updatePurchaseApplication(applicationForm);
		if(masterInt > 0){
			logger.info("提交申请单成功！");
		}else{
			logger.error("提交申请单失败！");
		}
	}

	public void auditApplication(PurchaseApplicationMaster applicationForm)
			throws HISException {
		// TODO Auto-generated method stub
		logger.info("审核申请单》》》》-----：");
		int masterInt = purchaseApplicationDao.updatePurchaseApplication(applicationForm);
		if(masterInt > 0){
			logger.info("审核申请单成功！");
		}else{
			logger.error("审核申请单失败！");
		}
	}

}
