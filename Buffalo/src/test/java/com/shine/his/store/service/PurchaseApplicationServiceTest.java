package com.shine.his.store.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Logger;

import com.shine.his.common.exception.HISException;
import com.shine.his.store.pojo.PurchaseApplicationDetail;
import com.shine.his.store.pojo.PurchaseApplicationMaster;
import com.shine.his.store.service.impl.PurchaseApplicationServiceImpl;
/**
 * 
 * Class Name:PurchaseApplicationServiceTest
 * Function:TODO(简单描述功能)
 * @author lili
 * @version (1.0)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/applicationContext.xml" })
public class PurchaseApplicationServiceTest {
	@Autowired
	private IPurchaseApplicationService purchaseApplicationService; 
    private Logger logger = (Logger) LoggerFactory.getLogger(PurchaseApplicationServiceTest.class);
    private static   int intID = 5;
    @Test
	public void testAddApplication()throws HISException{
		logger.info("intId.......:"+intID);
		PurchaseApplicationMaster applicationForm = new PurchaseApplicationMaster();
		applicationForm.setStoreProcurementPlanNo("0000"+intID);
		applicationForm.setPriority("0");
		applicationForm.setTitle("阿莫西林采购计划");
		applicationForm.setRemark("十天之内必须采购完成，请尽快处理");
		applicationForm.setCreateUser("lily");
		applicationForm.setStatus("01");
		List<PurchaseApplicationDetail> purDetailList = new ArrayList<PurchaseApplicationDetail>();
		for(int i = 0;i<5;i++){
			PurchaseApplicationDetail  purDetail = purDetail = new PurchaseApplicationDetail();
			purDetail.setStoreProcurementPlanNo("0000"+intID);
			purDetail.setProcurementPlanDetailId(i);
			purDetail.setPurchasePrice(45678);
			purDetail.setDrugCode("code"+i);
			purDetail.setQuantity(123);
			purDetail.setSupplierCode("sup"+i);
			purDetail.setRemark("详情");
			purDetailList.add(purDetail);
		}
		logger.info("purDetailList:"+purDetailList);
		applicationForm.setPurchaseApplicationDetail(purDetailList);
		logger.info("applicationForm:"+applicationForm);
		purchaseApplicationService.addApplication(applicationForm);
	}
	@Test
	public void testDeleteApplicationMaster() throws HISException{
		String masterId = "00002";
		purchaseApplicationService.deleteApplicationMaster(masterId);
	}
	@Test
	public void testDelPurchaseApplicationDetail() throws HISException{
		String detailId = "1013";
		purchaseApplicationService.deleteApplicationDetail(detailId);
	}
	
	@Test
	public void testGetApplicationMaster() throws HISException{
		PurchaseApplicationMaster pur = new PurchaseApplicationMaster();
		pur.setPriority("0");
		pur.setTitle("阿莫西林采购计划1");
		List<PurchaseApplicationMaster> purMaster = purchaseApplicationService.getApplicationMaster(pur);
		logger.info("查询申请单成功》》》》："+purMaster);
	}
	@Test
	public void testGetApplicationDetail() throws HISException{
		String masterId = "00001";
		PurchaseApplicationMaster purMaster = purchaseApplicationService.getApplicationDetail(masterId);
		logger.info("查询申请单详情成功》》》》------："+purMaster.toString());
		
	}
	@Test
   public void testUpdateApplicationAll(){
		
	}
	@Test
	public void updateApplicationStatusByID() throws HISException{
		//创建申请单人直接提交申请单
		//更改申请单状态
		PurchaseApplicationMaster pur = new PurchaseApplicationMaster();
		pur.setStatus("05");//02提交
		pur.setStoreProcurementPlanNo("00001");
		purchaseApplicationService.updateApplicationStatusByID(pur);
	}
	@Test
	public void submitApplication() throws HISException{	
		//完善人提交申请单
		PurchaseApplicationMaster pur = new PurchaseApplicationMaster();
		pur.setStatus("02");
		pur.setStoreProcurementPlanNo("00001");
		pur.setImproveUser("zhangsan1");;
		purchaseApplicationService.submitApplication(pur);
	}
	@Test
	public void auditApplication() throws HISException{
		// 01创建 02提交待审批 03审批通过 04审批不通过 05结束
		PurchaseApplicationMaster pur = new PurchaseApplicationMaster();
		pur.setStatus("03");
		pur.setStoreProcurementPlanNo("00001");
		pur.setAuditUser("lisi");
		purchaseApplicationService.auditApplication(pur);
	}

}
