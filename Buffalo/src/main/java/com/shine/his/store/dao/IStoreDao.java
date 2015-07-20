package com.shine.his.store.dao;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.shine.his.common.mybatis.MybatisMapperAnnotation;
import com.shine.his.store.pojo.StoreGoodsPositionInfo;
import com.shine.his.store.pojo.StoreInfo;
import com.shine.his.store.pojo.StoreManagerStore;
import com.shine.his.store.pojo.StoreShelfInfo;

/**
 * 
 * Class Name:IStoreDao
 * Function:TODO(简单描述功能)
 * @author panda
 * @version (版本1.0)
 */
@Repository
@Scope("singleton")
@MybatisMapperAnnotation
public interface IStoreDao {
	/**
	 * 
	 * queryStoreInfo:(仓库信息查询).<br/>
	 * TODO:(可根据仓库名字查询或全部查询).<br/>
	 */
	public List<StoreInfo> queryStoreInfo(StoreInfo storeInfo) throws Exception;
	
	/**
	 * 
	 * addStoreInfo:(增加仓库).<br/>
	 * TODO:(参数为仓库实例).<br/>
	 */
	public int addStoreInfo(StoreInfo storeInfo) throws Exception;
	
	/**
	 * 
	 * addStoreManager:( 增加仓库管理员).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param storeManager
	 * @return
	 * @throws Exception
	 */
	public int addSMS(List<StoreManagerStore> list) throws Exception;
	
	/**
	 * 
	 * updateStoreInfo:(修改仓库信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public void updateStoreInfo(StoreInfo storeInfo) throws Exception;
	public void updateSMS(Map<String, Object> list) throws Exception;
	/**
	 * 
	 * stopStore:(停用仓库).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public void stopStore(StoreInfo storeInfo)throws Exception;
	
	/**
	 * 
	 * queryStoreShelfInfo:(查询货架信息).<br/>
	 * TODO:(点击查询货架信息).<br/>
	 */
	public List<StoreShelfInfo> queryStoreShelfInfo(StoreShelfInfo storeShelfInfo)throws Exception ;
	/**
	 * 
	 * addStoreShelfInfo:(增加货架).<br/>
	 * TODO:(新增货架).<br/>
	 */
	public int addStoreShelfInfo(StoreShelfInfo storeShelfInfo)throws Exception;
	
	/**
	 * 
	 * updateStoreShelfInfo:(更新货架信息).<br/>
	 * TODO:(更新货架操作).<br/>
	 */
	public int updateStoreShelfInfo(StoreShelfInfo storeShelfInfo)throws Exception;
	
	/**
	 * 
	 * stopStoreShelf:(停用货架).<br/>
	 * TODO:(点击货架停用).<br/>
	 */
	public int stopStoreShelf(StoreShelfInfo storeShelfInfo)throws Exception;
	
	/**
	 * 
	 * querySGPInfo:(查询货位信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public List<StoreGoodsPositionInfo> querySGPInfo(String name) throws Exception;
	
	/**
	 * 
	 * addSGPInfo:(增加货位).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public int addSGPInfo(StoreGoodsPositionInfo storeGoodsPositionInfo) throws Exception;
	
	/**
	 * 
	 * updateSGPInfo:(修改货位信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public int updateSGPInfo(StoreGoodsPositionInfo storeGoodsPositionInfo) throws Exception;
	
	/**
	 * 
	 * stopSGP:(停用货位).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	public int stopSGP(StoreGoodsPositionInfo storeGoodsPositionInfo) throws Exception;
	
	
}
