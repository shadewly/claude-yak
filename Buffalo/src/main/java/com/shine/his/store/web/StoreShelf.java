package com.shine.his.store.web;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.shine.his.store.service.IStoreService;

/**
 * 
 * Class Name:StoreShelf
 * Function:TODO(简单描述功能)
 * @author panda
 * @version (版本1.0)
 */
@Path("/storeShelf")
@Singleton
public class StoreShelf {
	/*
	 * 
	 */
	@Autowired
	private IStoreService storeService;
	private Logger logger=LoggerFactory.getLogger(StoreShelf.class);
	
	/**
	 * 
	 * addStoreInfo:(增加货架).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param storeInfo
	 * @return
	 */
	@GET
	@Path("/addStoreShelfInfo")
	@Consumes("application/json")
	public JSON addStoreShelfInfo(String storeShelfInfo){
		try {
//			storeService.addStoreShelfInfo(storeShelfInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}
	
	/**
	 * 
	 * queryStoreShelfInfo:(查询货架信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param storeShelf
	 * @return
	 */
	@GET
	@Path("/queryStoreShelfInfo")
	@Consumes("application/json")
	public JSON queryStoreShelfInfo(String storeShelf){
		try{
			//storeService.queryStoreShelfInfo(storeShelf);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}
	
	/**
	 * 
	 * updateStoreShelfInfo:(更新货架信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param storeShelf
	 * @return
	 */
	@GET
	@Path("/updateStoreShelfInfo")
	@Consumes("application/json")
	public JSON updateStoreShelfInfo(String storeShelf){
		try{
//			storeService.updateStoreShelfInfo(storeShelf);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}
	
	/**
	 * 
	 * stopStoreShelf:(停用货架).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param storeShelf
	 * @return
	 */
	@GET
	@Path("/stopStoreShelf")
	@Consumes("application/json")
	public JSON stopStoreShelf(String storeShelf){
		try{
//			storeService.stopStoreShelf(storeShelf);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}
	
}
