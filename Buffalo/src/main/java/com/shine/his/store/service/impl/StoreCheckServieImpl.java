package com.shine.his.store.service.impl;

import com.github.pagehelper.PageInfo;
import com.shine.his.common.exception.HISException;
import com.shine.his.common.util.MergeStatusUtil;
import com.shine.his.common.util.PageUtil;
import com.shine.his.store.dao.IStoreCheckDetailDao;
import com.shine.his.store.dao.IStoreCheckMasterDao;
import com.shine.his.store.exception.StoreCheckException;
import com.shine.his.store.pojo.StoreCheckDetail;
import com.shine.his.store.pojo.StoreCheckMaster;
import com.shine.his.store.service.IStoreCheckService;
import com.shine.his.usrcenter.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by claude on 15-7-8.
 */
@Service
@Scope("singleton")
public class StoreCheckServieImpl implements IStoreCheckService {
    Logger logger = LoggerFactory.getLogger(StoreCheckServieImpl.class);
    @Autowired
    IStoreCheckMasterDao storeCheckMasterDao;
    @Autowired
    IStoreCheckDetailDao storeCheckDetailDao;


    @Override
    public String newCheckNo() {
        return storeCheckMasterDao.newStoreCheckNo();
    }

    @Override
    public StoreCheckMaster saveStoreCheck(StoreCheckMaster master) throws HISException {
        logger.debug("存储整个盘点单信息,盘点信息=>[" + master + "]");
        validateStoreCheckBeforeSave(master);
        storeCheckMasterDao.insertStoreCheckMaster(master);
        if (master.getStoreCheckDetails().size() != 0) {
            for (StoreCheckDetail detail : master.getStoreCheckDetails()) {
                detail.setDrugCheckNo(master.getDrugCheckNo());
                storeCheckDetailDao.insertStoreCheckDetail(detail);
            }
        }
        return master;
    }

    @Override
    public StoreCheckMaster getStoreCheckMasterByCheckNo(String checkNo) throws HISException {
        logger.debug("获取盘点单头信息,盘点单号=>[" + checkNo + "]");
        StoreCheckMaster master = storeCheckMasterDao.getStoreCheckMasterByCheckNo(checkNo);
        return master;
    }

    @Override
    public StoreCheckMaster getStoreCheckByCheckNo(String checkNo) throws HISException {
        logger.debug("获取整个盘点信息,盘点单号=>[" + checkNo + "]");
        StoreCheckMaster master = this.getStoreCheckMasterByCheckNo(checkNo);
        List<StoreCheckDetail> storeCheckDetails = storeCheckDetailDao.getStoreCheckDetailsByCheckNo(checkNo);
        master.setStoreCheckDetails(storeCheckDetails);
        return master;
    }

    @Override
    public boolean updateStoreCheck(StoreCheckMaster master) throws HISException {
        logger.debug("更新整个盘点信息,盘点信息=>[" + master + "],盘点详细条数[" + master.getStoreCheckDetails().size() + "]");
        int updateCount = 0;
        updateCount = storeCheckMasterDao.updateStoreCheckMaster(master);

        List newDetailList = master.getStoreCheckDetails();
        if (newDetailList != null && newDetailList.size() > 0) {
            List persistenceDetailList = storeCheckDetailDao.getStoreCheckDetailsByCheckNo(master.getDrugCheckNo());
            List<MergeStatusUtil.MergedEntity> finalList = MergeStatusUtil.mergeStatus(newDetailList, persistenceDetailList);

            for (MergeStatusUtil.MergedEntity<StoreCheckDetail> detail : finalList) {
                if (MergeStatusUtil.isNew(detail)) {
                    storeCheckDetailDao.insertStoreCheckDetail(detail.getEntity());
                } else if (MergeStatusUtil.isDelete(detail)) {
                    storeCheckDetailDao.deleteStoreCheckDetailById(detail.getEntity().getStoreCheckDetailId());
                } else if (MergeStatusUtil.isUpdate(detail)) {
                    storeCheckDetailDao.updateStoreCheckDetail(detail.getEntity());
                } else {
                    throw new StoreCheckException("获得未知盘点详细单=>" + detail.getEntity());
                }
            }
        }
        return updateCount > 0;
    }

    @Override
    public boolean updateStoreCheckMaster(StoreCheckMaster master) throws HISException {
        logger.debug("更新盘点单头信息,盘点信息=>[" + master + "]");
        int count = storeCheckMasterDao.updateStoreCheckMaster(master);
        return count > 0;
    }

    @Override
    public StoreCheckDetail getStoreCheckDetailByDetailId(Integer detailId) throws HISException {
        logger.debug("更新盘点详细,盘点详细ID=>[" + detailId + "]");
        return storeCheckDetailDao.getStockCheckDetailByDetailId(detailId);
    }

    @Override
    public boolean updateStoreCheckDetail(StoreCheckDetail detail) throws HISException {
        return storeCheckDetailDao.updateStoreCheckDetail(detail) > 0;
    }

    @Override
    public boolean deleteStoreCheckMasterByCheckNo(String storeCheckNo) throws HISException {
        return storeCheckMasterDao.markDeleteStoreCheckMaster(storeCheckNo) > 0;
    }

    @Override
    public boolean confirmStoreCheck(String checkNo, User confirmUser) throws HISException {
        StoreCheckMaster master = new StoreCheckMaster();
        master.setDrugCheckNo(checkNo);
        master.setConfigTime(new Date());
        master.setAuditUser(confirmUser.getId() + "");
        return storeCheckMasterDao.updateStoreCheckMaster(master) > 0;
    }

    @Override
    public boolean auditStoreCheck(String checkNo, User auditUser) throws HISException {
        StoreCheckMaster master = new StoreCheckMaster();
        master.setDrugCheckNo(checkNo);
        master.setAuditTime(new Date());
        master.setAuditUser(auditUser.getId() + "");
        int count = storeCheckMasterDao.updateStoreCheckMaster(master);
        return count > 0;
    }

    @Override
    public List<StoreCheckDetail> getStoreCheckDetailsByCheckNo(String checkNo) throws HISException {
        return storeCheckDetailDao.getStoreCheckDetailsByCheckNo(checkNo);
    }

    @Override
    public PageInfo<StoreCheckDetail> getStoreCheckDetailsByCheckNo(String checkNo, int pageNum, int pageSize) throws HISException {
        PageUtil.pagingInit(pageNum, pageSize);
        return PageUtil.getPageInfo(storeCheckDetailDao.getStoreCheckDetailsByCheckNo(checkNo));
    }

    @Override
    public PageInfo<StoreCheckMaster> findStoreCheckMasters(Map conditions, int pageNum, int pageSize) throws HISException {
        logger.debug("查找盘点头信息,查询页码=>[pageNum:" + pageNum + ",pageSize:" + pageSize + "]");
        PageUtil.pagingInit(pageNum, pageSize);
        return PageUtil.getPageInfo(this.findStoreCheckMasters(conditions));
    }

    @Override
    public List<StoreCheckMaster> findStoreCheckMasters(Map conditions) throws HISException {
        logger.debug("查找盘点头信息,查询条件=>[" + conditions + "]");
        return storeCheckMasterDao.findStoreCheckMasters(conditions);
    }

    private void validateStoreCheckBeforeSave(StoreCheckMaster master) throws StoreCheckException {
        if (master.getStoreCode() == null) {
            throw new StoreCheckException("保存盘点单时,部门不能为空!");
        } else if (master.getCheckTime() == null) {
            throw new StoreCheckException("保存盘点单时,创建时间不能为空!");
        } else if (master.getDrugCheckNo() == null) {
            throw new StoreCheckException("保存盘点单时,盘点单号不能为空!");
        }
    }
}
