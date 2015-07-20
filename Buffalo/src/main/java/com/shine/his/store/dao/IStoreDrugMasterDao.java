package com.shine.his.store.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.shine.his.common.mybatis.MybatisMapperAnnotation;
import com.shine.his.store.pojo.StoreDrugInDetail;
import com.shine.his.store.pojo.StoreDrugInMaster;
import com.shine.his.store.pojo.StoreDrugOutDetail;
import com.shine.his.store.pojo.StoreDrugOutMaster;

/**
 * 
 * Class Name:IStoreDrugMasterDao 出入库dao接口类 Function:TODO(出入库操作dao接口)
 * 
 * @author yuxinchen
 * @version (1.0)
 */
@Repository
@Scope("singleton")
@MybatisMapperAnnotation
public interface IStoreDrugMasterDao {

	/**
	 * 
	 * insertInStoreDrug:(新增入库).<br/>
	 * TODO:(插入入库信息).<br/>
	 * 
	 * @param storeDrugInMaster
	 *            入库信息
	 */
	public int insertInStoreDrug(StoreDrugInMaster storeDrugInMaster)
			throws Exception;

	/**
	 * 
	 * insertInStoreDrug:(新增入库详细信息).<br/>
	 * TODO:(插入入库详细信息).<br/>
	 * 
	 * @param storeDrugInMaster
	 *            入库信息
	 */
	public int insertInStoreDrugDetail(
			@Param("storeDrugInDetailList") List<StoreDrugInDetail> storeDrugInDetailList)
			throws Exception;

	/**
	 * 
	 * insertInStoreDrug:(新增出库详细信息).<br/>
	 * TODO:(插入出库详细信息).<br/>
	 * 
	 * @param storeDrugOutMaster
	 *            出库信息
	 */
	public int insertOutStoreDrugDetail(
			@Param("storeDrugOutDetailList") List<StoreDrugOutDetail> storeDrugOutDetailList)
			throws Exception;

	/**
	 * 
	 * insertOutStoreDrug:(新增出库).<br/>
	 * TODO:(插入出库信息).<br/>
	 * 
	 * @param storeDrugOutMaster
	 *            出库信息
	 */
	public int insertOutStoreDrug(StoreDrugOutMaster storeDrugOutMaster)
			throws Exception;

	/**
	 * 
	 * storeInDataGrid:(获取入库主表数据列表).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * 
	 * @param serchConditionMap
	 * @return
	 * @throws Exception
	 */
	public List<Object> storeInDataGrid(Map<String, Object> serchConditionMap)
			throws Exception;

	/**
	 * 
	 * storeInDataGrid:(获取出库主表数据列表).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * 
	 * @param serchConditionMap
	 * @return
	 * @throws Exception
	 */
	public List<Object> storeOutDataGrid(Map<String, Object> serchConditionMap)
			throws Exception;

	/**
	 * 
	 * updateInStoreDrug:(修改入库主表信息).<br/>
	 * TODO:(修改入库主表信息).<br/>
	 * 
	 * @param storeDrugInMaster
	 *            入库信息
	 */
	public int updateInStoreDrug(StoreDrugInMaster storeDrugInMaster)
			throws Exception;

	/**
	 * 
	 * updateOutStoreDrug:(修改出库主表信息).<br/>
	 * TODO:(修改出库主表信息).<br/>
	 * 
	 * @param storeDrugOutMaster
	 *            出库信息
	 */
	public int updateOutStoreDrug(StoreDrugOutMaster storeDrugOutMaster)
			throws Exception;

}