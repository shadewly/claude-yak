package com.shine.his.store.service;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 
 * Class Name:IStoreDrugMasterService 出入库服务接口类 Function:TODO(出入库操作服务接口)
 * 
 * @author yuxinchen
 * @version (1.0)
 */
public interface IStoreDrugMasterService {
	
    /**
     * 
     * insertInStoreDrug:(新增入库单).<br/>
     * TODO:(新增入库主单).<br/>
	 * TODO:(新增入库详细单).<br/>
	 * TODO:(修改库存数量).<br/>
	 * 
	 * @param storeDrugInMaster
	 *            入库信息
     * @return result 插入结果
     * @throws Exception
     */
	public String insertInStoreDrug(String metaDataMap) throws Exception;

	/**
	 * 
	 * insertInStoreDrugInit:(新增入库单页面初始化).<br/>
	 * TODO:(获取新增入库单页面初始化所需数据).<br/>
	 * @param inStroeType 入库类型
	 */
	public JSON insertInStoreDrugInit(String inStroeType) throws Exception;

	/**
	 * 
	 * insertOutStoreDrug:(新增出库单).<br/>
	 * TODO:(新增出库主单).<br/>
	 * TODO:(新增出库详细单).<br/>
	 * TODO:(修改库存数量).<br/>
	 * 
	 * @param storeDrugInMaster
	 *            出库信息
	 */
	public String insertOutStoreDrug(String storeDrugOutMaster)
			throws Exception;

	/**
	 * 
	 * insertOutStoreDrugInit:(新增出库单页面初始化).<br/>
	 * TODO:(获取新增出库单页数初始化所需数据).<br/>
	 */
	public JSON insertOutStoreDrugInit() throws Exception;
	
	/**
	 * 
	 * storeInOutDataGrid:(获取出入库主表数据列表方法).<br/>
	 * TODO:(获取出入库主表数据列表).<br/>
	 * @param searchCondition 查询条件
	 * @return
	 * @throws Exception
	 */
	public List storeInOutDataGrid(String searchCondition) throws Exception;
	
	

}
