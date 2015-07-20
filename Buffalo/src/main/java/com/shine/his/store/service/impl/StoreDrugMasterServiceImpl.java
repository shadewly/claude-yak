package com.shine.his.store.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shine.his.common.core.SysConstant;
import com.shine.his.common.pojo.SysDictEntity;
import com.shine.his.common.util.JsonResultUtil;
import com.shine.his.common.util.ServletContextUtil;
import com.shine.his.store.dao.IPurchaseApplicationDao;
import com.shine.his.store.dao.IStoreDrugMasterDao;
import com.shine.his.store.pojo.PurchaseApplicationMaster;
import com.shine.his.store.pojo.StoreDrugInMaster;
import com.shine.his.store.pojo.StoreDrugOutMaster;
import com.shine.his.store.service.IStoreDrugDetailService;
import com.shine.his.store.service.IStoreDrugMasterService;

/**
 * 
 * Class Name:StoreDrugMasterServiceImpl 出出库操作服务实现类 Function:TODO(出出库操作服务)
 * 
 * @author yuxinchen
 * @version (1.0)
 */

@Service
@Transactional
public class StoreDrugMasterServiceImpl implements IStoreDrugMasterService {

	/**
	 * 出出库dao接口对象
	 */
	@Autowired
	private IStoreDrugMasterDao storeDrugMasterDao;
	@Autowired
	private IPurchaseApplicationDao purchaseApplicationDao;
	@Autowired
	IStoreDrugDetailService storeDrugDetailService;

	/**
	 * 库存管理dao接口对象
	 */
	@Override
	public String insertInStoreDrug(String metaDataMap) throws Exception {

		// 获取缓存中的入库表状态map集合
		SysDictEntity storeDrugInStatus = ServletContextUtil.getSysDict().get(
				SysConstant.STORE_DRUG_IN_STATUS);
		Map<String, SysDictEntity> storeDrugInStatusMap = storeDrugInStatus
				.getSysDictMap();

		// 前端出入数据转化为map
		Map<String, Object> dataMap = (Map<String, Object>) JSONObject
				.parse(metaDataMap);

		// 将传入的出库信息转化为实体对象
		StoreDrugInMaster storeDrugInMasterEntity = (StoreDrugInMaster) JSONObject
				.parseObject(dataMap.get(SysConstant.STORE_DRUG_IN_MASTER)
						.toString(), StoreDrugInMaster.class);
		// 获取当前登录用户
		storeDrugInMasterEntity.setCreateUser("yxc");
		// 获取当前登录用户部门
		storeDrugInMasterEntity.setDepartment("药库部");
		// 出库单采购总价
		BigDecimal totalPurchasePrice = new BigDecimal(0.0000);
		// 出库单销售总价
		BigDecimal totalRetailPrice = new BigDecimal(0.0000);

		// 将出库信息插入出库主表,生成出库单号
		if (storeDrugMasterDao.insertInStoreDrug(storeDrugInMasterEntity) > 0) {

		}

		for (int i = 0; i < storeDrugInMasterEntity.getStoreInOrderDetailList()
				.size(); i++) {
			BigDecimal quantity = new BigDecimal(storeDrugInMasterEntity
					.getStoreInOrderDetailList().get(i).getQuantity());
			// 通过药品编码获取药品采购价格及销售价格？？
			BigDecimal purchasePrice = new BigDecimal(12);
			BigDecimal retailPrice = new BigDecimal(12);

			// 采购价小计
			BigDecimal purchaseAmount = purchasePrice.multiply(quantity);
			// 销售价小计
			BigDecimal retailAmount = retailPrice.multiply(quantity);

			storeDrugInMasterEntity.getStoreInOrderDetailList().get(i)
					.setRetailPrice(retailPrice);
			storeDrugInMasterEntity.getStoreInOrderDetailList().get(i)
					.setPurchasePrice(purchasePrice);

			storeDrugInMasterEntity.getStoreInOrderDetailList().get(i)
					.setPurchaseAmount(purchaseAmount);

			storeDrugInMasterEntity.getStoreInOrderDetailList().get(i)
					.setRetailAmount(retailAmount);

			// 设置出库单号
			storeDrugInMasterEntity.getStoreInOrderDetailList().get(i)
					.setStoreOrderNo(storeDrugInMasterEntity.getStoreOrderNo());

			// 添加主表总价
			totalPurchasePrice = totalPurchasePrice.add(purchaseAmount);
			totalRetailPrice = totalRetailPrice.add(retailAmount);

		}
		// 插入出库详细表
		storeDrugMasterDao.insertInStoreDrugDetail(storeDrugInMasterEntity
				.getStoreInOrderDetailList());
		// 更新主表价格
		storeDrugInMasterEntity.setTotalPurchasePrice(totalPurchasePrice);
		storeDrugInMasterEntity.setTotalRetailPrice(totalRetailPrice);

		storeDrugMasterDao.updateInStoreDrug(storeDrugInMasterEntity);

		// 入库类型为采购计划入库,修改采购计划单状态，并将生成的订单编号保存至采购计划单？？
		SysDictEntity dd = storeDrugInStatusMap
				.get(SysConstant.StoreInOrderType.PHARMACY_IN_STORE.getIndex());

		if (storeDrugInStatusMap
				.get(SysConstant.StoreInOrderType.PURCHASE_IN_STORE.getIndex())
				.getSysValue()
				.equals(storeDrugInMasterEntity.getStoreOrderType())) {
			PurchaseApplicationMaster purForm = new PurchaseApplicationMaster();
			purForm.setStatus("05");
			purForm.setStoreProcurementPlanNo(dataMap.get(
					SysConstant.STORE_PROC_PLAN_NO).toString());
			purForm.setStoreOrderNo(storeDrugInMasterEntity.getStoreOrderNo());
			purchaseApplicationDao.updatePurchaseApplication(purForm);
		}
		// 入库类型为药房退库再入库,修改药房退库申请单状态为完成？？
		if (storeDrugInStatusMap
				.get(SysConstant.StoreInOrderType.PHARMACY_IN_STORE.getIndex())
				.getSysValue()
				.equals(storeDrugInMasterEntity.getStoreOrderType())) {

		}
		// 入库类型为科室退库再入库,修改科室退库申请单状态为完成？？
		if (storeDrugInStatusMap
				.get(SysConstant.StoreInOrderType.DEPT_IN_STORE.getIndex())
				.getSysValue()
				.equals(storeDrugInMasterEntity.getStoreOrderType())) {

		}
		// 入库类型为药品调拨入库,调拨申请状态”为"已入库"？？
		if (storeDrugInStatusMap
				.get(SysConstant.StoreInOrderType.ALLOT_IN_STORE.getIndex())
				.getSysValue()
				.equals(storeDrugInMasterEntity.getStoreOrderType())) {

		}
		// 入库类型为药品调拨出库再入库,调拨申请状态”为"已入库"？？
		if (storeDrugInStatusMap
				.get(SysConstant.StoreInOrderType.RE_ALLOT_IN_STORE.getIndex())
				.getSysValue()
				.equals(storeDrugInMasterEntity.getStoreOrderType())) {

		}
		// 修改库存信息??
		return JsonResultUtil.createResult(true, null, "入库成功");

	}

	@Override
	public JSON insertInStoreDrugInit(String inStroeType) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 采购计划出库初始化
		if ("00".equals(inStroeType)) {
			// 获取验收药品信息
		}
		// 药房退库再出库初始化？？
		// 科室出库初始化？？
		// 调拨出库初始化？？
		// 调拨出库再出库初始化？？
		return null;
	}

	@Override
	public String insertOutStoreDrug(String metaDataMap) throws Exception {

		// 获取缓存中的入库表状态map集合
		SysDictEntity storeDrugInStatus = ServletContextUtil.getSysDict().get(
				SysConstant.STORE_DRUG_OUT_STATUS);
		Map<String, SysDictEntity> storeDrugOutStatusMap = storeDrugInStatus
				.getSysDictMap();
		Map<String, Object> dataMap = (Map<String, Object>) JSONObject
				.parse(metaDataMap);
		// 将传入的出库信息转化为实体对象
		StoreDrugOutMaster storeDrugOutMasterEntity = (StoreDrugOutMaster) JSONObject
				.parseObject(dataMap.get("storeDrugOutMaster").toString(),
						StoreDrugOutMaster.class);
		// 获取当前登录用户
		storeDrugOutMasterEntity.setCreateUser("yxc");
		// 获取当前登录用户部门
		storeDrugOutMasterEntity.setDepartment("药库部");
		// 出库单采购总价
		BigDecimal totalPurchasePrice = new BigDecimal(0.0000);
		// 出库单销售总价
		BigDecimal totalRetailPrice = new BigDecimal(0.0000);

		// 将出库信息插入出库主表,生成出库单号
		storeDrugMasterDao.insertOutStoreDrug(storeDrugOutMasterEntity);

		for (int i = 0; i < storeDrugOutMasterEntity
				.getStoreOutOrderDetailList().size(); i++) {
			BigDecimal quantity = new BigDecimal(storeDrugOutMasterEntity
					.getStoreOutOrderDetailList().get(i).getQuantity());
			// 通过药品编码获取药品采购价格及销售价格？？
			BigDecimal purchasePrice = new BigDecimal(12);
			BigDecimal retailPrice = new BigDecimal(12);

			// 采购价小计
			BigDecimal purchaseAmount = purchasePrice.multiply(quantity);
			// 销售价小计
			BigDecimal retailAmount = retailPrice.multiply(quantity);

			storeDrugOutMasterEntity.getStoreOutOrderDetailList().get(i)
					.setRetailPrice(retailPrice);
			storeDrugOutMasterEntity.getStoreOutOrderDetailList().get(i)
					.setPurchasePrice(purchasePrice);

			storeDrugOutMasterEntity.getStoreOutOrderDetailList().get(i)
					.setPurchaseAmount(purchaseAmount);

			storeDrugOutMasterEntity.getStoreOutOrderDetailList().get(i)
					.setRetailAmount(retailAmount);

			// 设置出库单号
			storeDrugOutMasterEntity
					.getStoreOutOrderDetailList()
					.get(i)
					.setStoreOrderNo(storeDrugOutMasterEntity.getStoreOrderNo());

			// 添加主表总价
			totalPurchasePrice = totalPurchasePrice.add(purchaseAmount);
			totalRetailPrice = totalRetailPrice.add(retailAmount);

			// 修改库存信息??
			// storeDrugDetailService.updateQuantity(storeDrugDetailId,
			// quantity);

		}
		// 插入出库详细表
		storeDrugMasterDao.insertOutStoreDrugDetail(storeDrugOutMasterEntity
				.getStoreOutOrderDetailList());
		// 更新主表价格
		storeDrugOutMasterEntity.setTotalPurchasePrice(totalPurchasePrice);
		storeDrugOutMasterEntity.setTotalRetailPrice(totalRetailPrice);

		storeDrugMasterDao.updateOutStoreDrug(storeDrugOutMasterEntity);

		// 出库类型为药房科室出库,修改药房科室申请单状态？？
		if (storeDrugOutStatusMap
				.get(SysConstant.StoreOutOrderType.DEPT_OUT_STORE.getIndex())
				.getSysValue()
				.equals(storeDrugOutMasterEntity.getStoreOrderType())) {

		}
		// 出库类型为供应商退货出库 ,修改供应商退库申请单状态为完成？？
		if (storeDrugOutStatusMap
				.get(SysConstant.StoreOutOrderType.RETURN_OUT_STORE.getIndex())
				.getSysValue()
				.equals(storeDrugOutMasterEntity.getStoreOrderType())) {

		}
		// 出库类型为药品报损出库,修改药品报损出库申请单状态为完成？？
		if (storeDrugOutStatusMap
				.get(SysConstant.StoreOutOrderType.BREAK_OUT_STORE.getIndex())
				.getSysValue()
				.equals(storeDrugOutMasterEntity.getStoreOrderType())) {

		}
		// 出库类型为药品调拨出库,调拨申请状态”为"已出库"？？
		if (storeDrugOutStatusMap
				.get(SysConstant.StoreOutOrderType.ALLOT_OUT_STORE.getIndex())
				.getSysValue()
				.equals(storeDrugOutMasterEntity.getStoreOrderType())) {

		}

		return JsonResultUtil.createResult(true, null, "出库单成功");

	}

	@Override
	public JSON insertOutStoreDrugInit() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List storeInOutDataGrid(String searchCondition) throws Exception {

		Map<String, Object> serchConditionMap = JSONObject.parseObject(
				searchCondition, HashMap.class);
		List list = null;
		// 0为入库
		if ("0".equals(serchConditionMap.get("ioType"))) {
			list = storeDrugMasterDao.storeInDataGrid(serchConditionMap);
		}
		// 1为出库
		if ("1".equals(serchConditionMap.get("ioType"))) {
			list = storeDrugMasterDao.storeOutDataGrid(serchConditionMap);
		}

		return list;
	}
}
