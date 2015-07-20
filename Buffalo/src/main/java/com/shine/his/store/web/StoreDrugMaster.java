package com.shine.his.store.web;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.shine.his.common.util.JsonResultUtil;
import com.shine.his.store.service.IStoreDrugMasterService;

/**
 * 
 * Class Name:StoreDrugMaster Function:TODO(出入库操作入口)
 * 
 * @author yuxinchen
 * @version (1.0)
 */
@Path("/storeDrugMaster")
@Singleton
public class StoreDrugMaster {
	/**
	 * 出入库服务类接口对象
	 */
	@Autowired
	private IStoreDrugMasterService storeDrugMasterService;
	/**
	 * 日志对象
	 */
	private Logger logger = LoggerFactory.getLogger(StoreDrugMaster.class);

	/**
	 * 
	 * insertInDrugInit:(入库界面初始化方法).<br/>
	 * TODO:(入库界面初始化).<br/>
	 * 
	 * @return
	 */
	@GET
	@Path("/insertInStoreDrugInit")
	public JSON insertInStoreDrugInit(String inStroeType) {
		try {
			storeDrugMasterService.insertInStoreDrugInit(inStroeType);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}

	/**
	 * 
	 * insertInStoreDrug:(新增入库).<br/>
	 * TODO:(新增入库单).<br/>
	 * 
	 * @param storeDrugInMaster
	 *            新增入库信息
	 * @return result 插入结果
	 */
	@PUT
	@Path("/insertInStoreDrug")
	public String insertInStoreDrug(String dataMap) {
		String result = "";
		try {
			result = storeDrugMasterService.insertInStoreDrug(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			return JsonResultUtil.createResult(false, null, "入库失败");
		}
		return result;
	}

	/**
	 * 
	 * insertOutStoreDrugInit:(出库初始化方法).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * 
	 * @return
	 */
	@GET
	@Path("/insertOutStoreDrugInit")
	public JSON insertOutDrugInit() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}

	/**
	 * 
	 * insertOutDrug:(出库初始化方法).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * 
	 * @param storeDrugOutMaster
	 * @return
	 */
	@PUT
	@Path("/insertOutStoreDrug")
	public String insertOutStoreDrug(String storeDrugOutMaster) {
		String result = "";
		try {
			result = storeDrugMasterService
					.insertOutStoreDrug(storeDrugOutMaster);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			return JsonResultUtil.createResult(false, null, "出库失败");
		}
		return result;
	}

	/**
	 * 
	 * storeInOutDataGrid:(查询入库记录方法).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * 
	 * @param storeDrugInMaster
	 * @return
	 */
	@PUT
	@Path("/storeInDataGrid")
	public void storeInDataGrid(String searchCondition) {

		
		try {
			List list = storeDrugMasterService
					.storeInOutDataGrid(searchCondition);

			JsonResultUtil.createResult(true, list, null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			JsonResultUtil.createResult(false, null, "查询数据失败");
		}

	}
	/**
	 * 
	 * storeOutDataGrid:(查询出库记录方法).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * 
	 * @param storeDrugOutMaster
	 * @return
	 */
	@PUT
	@Path("/storeOutDataGrid")
	public void storeInOutDataGrid(String searchCondition) {

		
		try {
			List list = storeDrugMasterService
					.storeInOutDataGrid(searchCondition);

			JsonResultUtil.createResult(true, list, null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			JsonResultUtil.createResult(false, null, "查询数据失败");
		}

	}

	/**
	 * 
	 * storeDrugDataGrid:(查询出入库记录页面初始化方法).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * 
	 * @param storeDrugOutMaster
	 * @return
	 */
	@PUT
	@Path("/storeDrugDataGridInit")
	@Consumes("application/json")
	public JSON storeDrugDataGridInit() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return null;
	}

}
