package com.shine.his.store.service;


import com.github.pagehelper.PageInfo;
import com.shine.his.common.exception.HISException;
import com.shine.his.common.service.HISService;
import com.shine.his.store.pojo.StoreCheckDetail;
import com.shine.his.store.pojo.StoreCheckMaster;
import com.shine.his.usrcenter.pojo.User;

import java.util.List;
import java.util.Map;

public interface IStoreCheckService extends HISService {
    /**
     * 获得一个新的盘点单号,获得前将做盘点许可验证<br/>
     *
     * @return
     * @throws HISException
     */
    String newCheckNo();

    /**
     * 创建盘点单,保存盘点单和盘点明细等信息<br/>
     *
     * @param master
     * @throws HISException
     */
    StoreCheckMaster saveStoreCheck(StoreCheckMaster master) throws HISException;

    /**
     * 根据盘点单号取盘点单头信息<br/>
     *
     * @param checkNo
     * @return
     * @throws HISException
     */
    StoreCheckMaster getStoreCheckMasterByCheckNo(String checkNo) throws HISException;

    /**
     * 根据盘点单号取整个盘点单信息,包括头信息和下那详细信息<br/>
     *
     * @param checkNo
     * @return
     * @throws HISException
     */
    StoreCheckMaster getStoreCheckByCheckNo(String checkNo) throws HISException;

    /**
     * 更新整个盘点单,包括头和详细信息,当某个字段为null时将不被更新<br/>
     *
     * @param master
     * @throws HISException
     */
    boolean updateStoreCheck(StoreCheckMaster master) throws HISException;

    /**
     * 更新盘点单的头信息<br/>
     *
     * @param master
     * @return
     * @throws HISException
     */
    boolean updateStoreCheckMaster(StoreCheckMaster master) throws HISException;

    /**
     * 根据盘点详细ID查询盘点详细<br/>
     *
     * @param detailId
     * @throws HISException
     */
    StoreCheckDetail getStoreCheckDetailByDetailId(Integer detailId) throws HISException;

    /**
     * 更新一条盘点详细记录<br/>
     *
     * @param detail
     * @return
     * @throws HISException
     */
    boolean updateStoreCheckDetail(StoreCheckDetail detail) throws HISException;

    /**
     * 删除盘点单,更新其status字段为已删除<br/>
     *
     * @param storeCheckNo
     * @throws HISException
     */
    boolean deleteStoreCheckMasterByCheckNo(String storeCheckNo) throws HISException;

    /**
     * 确认盘点单,释放库存改动锁标志<br/>
     *
     * @param checkNo
     * @param confirmUser
     * @return
     * @throws HISException
     */
    boolean confirmStoreCheck(String checkNo, User confirmUser) throws HISException;

    /**
     * 审核盘点单.记录盘点损益到损益表<br/>
     *
     * @param checkNo
     * @param auditUser
     * @return
     * @throws HISException
     */
    boolean auditStoreCheck(String checkNo, User auditUser) throws HISException;


    /**
     * 根据查询条件{@code conditions}按分页页码查找盘点单头信息<br/>
     *
     * @param conditions {@code conditions}的可用属性为:
     *                   checkTimeStart-->java.util.Date
     *                   checkTimeEnd-->java.util.Date
     *                   status-->StoreCheckMaster.StoreCheckStatus.*.getStatusCode()
     *                   storeCheckNo-->java.lang.String
     * @param pageNum
     * @param pageSize
     * @return
     * @throws HISException
     */
    PageInfo<StoreCheckMaster> findStoreCheckMasters(Map<String, Object> conditions, int pageNum, int pageSize) throws HISException;


    /**
     * 根据查询条件{@code conditions}查找盘点单头信息<br/>
     *
     * @param conditions {@code conditions}的可用属性为:
     *                   checkTimeStart-->java.util.Date
     *                   checkTimeEnd-->java.util.Date
     *                   status-->StoreCheckMaster.StoreCheckStatus.*.getStatusCode()
     *                   storeCheckNo-->java.lang.String
     * @return
     * @throws HISException
     */
    List<StoreCheckMaster> findStoreCheckMasters(Map<String, Object> conditions) throws HISException;

    /**
     * 根据盘点单号查找所有盘点详细<br/>
     *
     * @param checkNo
     * @return
     * @throws HISException
     */
    List<StoreCheckDetail> getStoreCheckDetailsByCheckNo(String checkNo) throws HISException;

    /**
     * 根据盘点单号按翻页页码查找所有盘点详细<br/>
     *
     * @param checkNo
     * @param pageNum
     * @param pageSize
     * @return
     * @throws HISException
     */
    PageInfo<StoreCheckDetail> getStoreCheckDetailsByCheckNo(String checkNo, int pageNum, int pageSize) throws HISException;


}
