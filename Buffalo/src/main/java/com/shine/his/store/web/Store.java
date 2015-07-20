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
 * Class Name:Store
 * Function:TODO(简单描述功能)
 * @author panda
 * @version (版本1.0)
 */
@Path("/store")
@Singleton
public class Store {
	/*
	 * 仓库类服务对象
	 */
	@Autowired
	private IStoreService storeService;
	private Logger logger = LoggerFactory.getLogger(Store.class);
	
	/**
	 * 
	 * addStoreInfoInit:(新增仓库初始化).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @return
	 */
	@GET
	@Path("/addStoreInfoInit")
	public JSON addStoreInfoInit() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}
	
	/**
	 * 
	 * addStoreInfo:(新增仓库).<br/>
	 * TODO:(新增仓库的时候).<br/>
	 * @param storeInfo
	 * @return
	 */
	@GET
	@Path("/addStoreInfo")
	@Consumes("application/json")
	public JSON addStoreInfo(String storeInfo) {
		try {
//			storeService.addStoreInfo(storeInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}
	
	/**
	 * 
	 * updateStoreInfo:(修改仓库信息).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param storeInfo
	 * @return
	 */
	@GET
	@Path("/updateStoreInfo")
	@Consumes("application/json")
	public JSON updateStoreInfo(String storeInfo) {
		try{
//			storeService.updateStoreInfo(storeInfo);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}
	
	/**
	 * 
	 * stopStore:(停用仓库).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param storeInfo
	 * @return
	 */
	@GET
	@Path("/stopStore")
	@Consumes("application/json")
	public JSON stopStore(String storeInfo){
		try {
	//		storeService.stopStore(storeInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}
	
	/**
	 * 
	 * queryStoreInfo:(仓库信息查询).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param storeInfo
	 * @return
	 */
	@GET
	@Path("/queryStoreInfo")
	@Consumes("application/json")
	public JSON queryStoreInfo(String storeInfo){
		try {
			//storeService.queryStoreInfo(storeInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}
}
