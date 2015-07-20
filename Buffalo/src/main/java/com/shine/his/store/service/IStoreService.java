package com.shine.his.store.service;

import java.util.List;
import java.util.Map;

import com.shine.his.store.pojo.StoreGoodsPositionInfo;
import com.shine.his.store.pojo.StoreInfo;
import com.shine.his.store.pojo.StoreManagerStore;
import com.shine.his.store.pojo.StoreShelfInfo;


/**
 * 
 * Class Name:IStoreService
 * Function:TODO(仓库，货架，货位的增删改查)
 * @author panda
 * @version (版本1.0)
 */
public interface IStoreService {
	/**
	 * 
	 * queryStoreInfo:(仓库信息查询).<br/>
	 * TODO:(按仓库名字查询或全部查询).<br/>
	 */
	public List<StoreInfo> queryStoreInfo(StoreInfo storeInfo) throws Exception;
	
	/**
	 * 
	 * addStoreInfo:(新增仓库).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public boolean addStoreInfo(StoreInfo storeInfo) throws Exception;
	
	/**
	 * 
	 * updateStoreInfo:(修改仓库信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public int updateStoreInfo(StoreInfo storeInfo) throws Exception;
	
	/**
	 * 
	 * stopStore:(停用仓库).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public void stopStore(StoreInfo storeInfo) throws Exception;
	
	/**
	 * 
	 * queryStoreShelfInfo:(货架信息查询).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public List<StoreShelfInfo> queryStoreShelfInfo(StoreShelfInfo storeInfo) throws Exception;
	
	/**
	 * 
	 * addStoreShelfInfo:(增加货架信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public int addStoreShelfInfo(StoreShelfInfo storeInfo) throws Exception;
	
	/**
	 * 
	 * updateStoreShelfInfo:(修改货架信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public int updateStoreShelfInfo(StoreShelfInfo storeInfo) throws Exception;
	
	/**
	 * 
	 * stopStoreShelf:(停用货架).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public int stopStoreShelf(StoreShelfInfo storeInfo) throws Exception;
	
	/**
	 * 
	 * querySGPInfo:(查询货位信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public List<StoreGoodsPositionInfo> querySGPInfo(String name) throws Exception;
	
	/**
	 * 
	 * addSGPInfo:(新增货位).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public int addSGPInfo(StoreGoodsPositionInfo storeGoodsPositionInfo) throws Exception;
	
	/**
	 * 
	 * updateSGPInfo:(更新货位信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public int updateSGPInfo(StoreGoodsPositionInfo storeGoodsPositionInfo) throws Exception;
	
	/**
	 * 
	 * stopSGP:(停用货位).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public int stopSGP(StoreGoodsPositionInfo storeGoodsPositionInfo) throws Exception;
	/**
	 * 
	 * updateSMS:(更新仓库管理员信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param list
	 * @throws Exception
	 */
	public void updateSMS(Map<String, Object> list)  throws Exception;
	/**
	 * 
	 * addSMS:(新增仓库管理员信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param sms
	 * @throws Exception
	 */
	public void addSMS(List<StoreManagerStore> sms) throws Exception;
}
