package com.shine.his.store.service;

import com.github.pagehelper.PageInfo;
import com.shine.his.common.exception.HISException;
import com.shine.his.store.pojo.StoreCheckDetail;
import com.shine.his.store.pojo.StoreCheckMaster;
import com.shine.his.usrcenter.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by claude on 15-7-8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class StoreCheckServiceTest {

    @Autowired
    IStoreCheckService storeCheckService;

    public void saveStoreCheck() throws Exception {
        StoreCheckMaster master = new StoreCheckMaster();
        master.setCheckTime(new Date());
        master.setStoreCode("STO");
        master.setRemark("我是个测试");
        StoreCheckDetail detail = null;
        for (int i = 0; i < 8; i++) {
            detail = new StoreCheckDetail();
            detail.setRemark("new stock check!");
            detail.setDrugCode("fff");
            detail.setExpDate(new Date());
            detail.setStoreNum(65);
            detail.setRealNum(89);
            detail.setRetailPrice(new BigDecimal(56789.6789));
            master.addDetail(detail);
            detail.setBatchNo("789");
            detail.setPurchasePrice(new BigDecimal(2500000.90));
            master.addDetail(detail);
        }
        master.setDrugCheckNo(storeCheckService.newCheckNo());
        storeCheckService.saveStoreCheck(master);
        System.out.println("---------------------->" + master.getDrugCheckNo());
        List<StoreCheckDetail> details = master.getStoreCheckDetails();
        for (StoreCheckDetail detail1 : details) {
            System.out.println("--=====>" + detail1.getStoreCheckDetailId());
        }
    }

    public void getStoreCheckMasterByCheckNo() throws HISException {
//        StoreCheckMaster master = storeCheckService.getStoreCheckMasterByCheckNo("SC201507091514201060");
        StoreCheckMaster master = storeCheckService.getStoreCheckByCheckNo("SC201507091514201060");
        System.out.println("---------------------->" + master.getRemark());
        List<StoreCheckDetail> details = master.getStoreCheckDetails();
        for (StoreCheckDetail detail1 : details) {
            System.out.println("--=====>" + detail1.getStoreCheckDetailId());
        }
    }

    public void getStoreCheckByCheckNo() throws HISException {
        //getStoreCheckByCheckNo
        StoreCheckMaster master = storeCheckService.getStoreCheckByCheckNo("SC201507091514201060");
        System.out.println("---------------------->" + master.getRemark());
        List<StoreCheckDetail> details = master.getStoreCheckDetails();
        for (StoreCheckDetail detail1 : details) {
            System.out.println("--=====>" + detail1.getStoreCheckDetailId());
        }
    }

    public void updateStoreCheckMaster() throws HISException {
        StoreCheckMaster master = storeCheckService.getStoreCheckMasterByCheckNo("SC201507091514201060");
        System.out.println("---------------------->" + master.getRemark());
        master.setRemark("测试update!!!");
        System.out.println(storeCheckService.updateStoreCheckMaster(master));
    }
    public void deleteStoreCheckMasterByCheckNo() throws HISException {
        System.out.println(storeCheckService.deleteStoreCheckMasterByCheckNo("SC201507091514201060"));
    }

    public void updateStoreCheck() throws HISException {
        StoreCheckMaster master = storeCheckService.getStoreCheckByCheckNo("SC201507131607011080");
        List<StoreCheckDetail> details = master.getStoreCheckDetails();
        master.setRemark("update whole check info!");
        details.remove(0);
        details.remove(1);
        details.remove(2);
        details.remove(3);
        details.remove(4);
        for (StoreCheckDetail detail1 : details) {
            detail1.setRemark("test 2015!");
            detail1.setPurchasePrice(new BigDecimal(6789.234));
        }
        StoreCheckDetail detail = new StoreCheckDetail();
        detail.setRemark("new stock check!");
        detail.setDrugCode("fff");
        detail.setPurchasePrice(new BigDecimal(23.24));
        detail.setExpDate(new Date());
        detail.setStoreNum(65);
        detail.setRealNum(89);
        detail.setRetailPrice(new BigDecimal(56789.6789));
        master.addDetail(detail);
        detail.setBatchNo("wwwwwww");
        master.setStoreCode("qq");
        storeCheckService.updateStoreCheck(master);
        for (StoreCheckDetail detail1 : details) {
            System.out.println("--=====>" + detail1.getStoreCheckDetailId());
        }
    }

    public void auditStoreCheck() throws HISException {
        User user = new User();
        user.setId(5678);
        storeCheckService.auditStoreCheck("SC201507131607011080", user);
    }

    @Test
    public void findStoreCheckMasters() throws HISException {
        Map<String, Object> conditions = new HashMap<String, Object>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -9);
        Date startDate = calendar.getTime();
        System.out.println(startDate);
        conditions.put("checkTimeStart", startDate);
        conditions.put("checkTimeEnd", new Date());
        conditions.put("status", StoreCheckMaster.StoreCheckStatus.DELETED.getStatusCode());
        conditions.put("storeCheckNo", "150709");
        PageInfo<StoreCheckMaster> list = storeCheckService.findStoreCheckMasters(conditions, 3, 7);
        System.out.println(list.getList().size());
    }

    public void getStoreCheckDetailsByCheckNo() throws HISException {
        List<StoreCheckDetail> list = storeCheckService.getStoreCheckDetailsByCheckNo("SC201507131607011080");
        for (StoreCheckDetail detail : list) {
            System.out.println("---------------->" + detail.getBatchNo());
        }
    }
}
