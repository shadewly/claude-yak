package com.shine.his.store.dao;

import com.shine.his.common.exception.HISException;
import com.shine.his.common.mybatis.MybatisMapperAnnotation;
import com.shine.his.store.pojo.StoreCheckMaster;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by claude on 15-7-7.
 */
@MybatisMapperAnnotation
@Repository
@Scope("singleton")
public interface IStoreCheckMasterDao {
    String newStoreCheckNo();
    /**
     * 插入盘点master记录.<br/>
     *
     * @param storeCheckMaster
     */
    int insertStoreCheckMaster(StoreCheckMaster storeCheckMaster) throws HISException;

    /**
     * 更新盘点master记录<br/>
     *
     * @param storeCheckMaster
     * @throws HISException
     */
    int updateStoreCheckMaster(StoreCheckMaster storeCheckMaster) throws HISException;

    /**
     * 根据盘点单号获得盘点头信息记录<br/>
     *
     * @param checkNo
     * @return
     * @throws HISException
     */
    StoreCheckMaster getStoreCheckMasterByCheckNo(String checkNo) throws HISException;

    /**
     * 标注盘点单为已删除<br/>
     * @param checkNo
     * @throws HISException
     */
    int markDeleteStoreCheckMaster(String checkNo) throws HISException;

    /**
     * 根据查询条件查找盘点单<br/>
     *
     * @param conditions
     * @return 返回结果只包含盘点单头信息
     * @throws HISException
     */
    List<StoreCheckMaster> findStoreCheckMasters(Map<String, Object> conditions) throws HISException;
}
