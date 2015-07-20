package com.shine.his.store.dao;

import com.shine.his.common.exception.HISException;
import com.shine.his.common.mybatis.MybatisMapperAnnotation;
import com.shine.his.store.pojo.StoreCheckDetail;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by claude on 15-7-7.
 */
@MybatisMapperAnnotation
@Repository
@Scope("singleton")
public interface IStoreCheckDetailDao {

    /**
     * 保存盘点详细<br/>
     *
     * @param storeCheckDetail
     * @throws HISException
     */
    int insertStoreCheckDetail(StoreCheckDetail storeCheckDetail) throws HISException;

    /**
     * 通过盘点单号获取盘点明细列表<br/>
     *
     * @param storeCheckNo
     * @return
     * @throws HISException
     */
    List<StoreCheckDetail> getStoreCheckDetailsByCheckNo(String storeCheckNo) throws HISException;

    /**
     * 更新盘点详细
     *
     * @param storeCheckDetail
     * @throws HISException
     */
    int updateStoreCheckDetail(StoreCheckDetail storeCheckDetail) throws HISException;

    /**
     * 根据盘点详细ID获得盘点详细<br/>
     *
     * @param detailId
     * @return
     * @throws HISException
     */
    StoreCheckDetail getStockCheckDetailByDetailId(Integer detailId) throws HISException;

    /**
     * 根据盘点详细ID删除盘点详细记录<br/>
     *
     * @param detailId
     * @throws HISException
     */
    int deleteStoreCheckDetailById(Integer detailId) throws HISException;
}
