package com.shine.his.store.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.shine.his.common.core.SysConstant;
import com.shine.his.store.pojo.StoreDrugInDetail;
import com.shine.his.store.pojo.StoreDrugInMaster;
import com.shine.his.store.pojo.StoreDrugOutDetail;
import com.shine.his.store.pojo.StoreDrugOutMaster;

/**
 * 
 * Class Name:StoreDrugMasterTest 出入库测试类 Function:TODO(测试出入库)
 * 
 * @author yuxinchen
 * @version (1.0)
 */
public class StoreDrugMasterTest {
	private static String serverUri = "http://localhost:8080/ShineHIS/";

	/**
	 * 00:计划采购入库 insertInStoreDrugTest1:(计划申请入库).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void insertInStoreDrugTest1() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/insertInStoreDrug");
	
		StoreDrugInMaster sd = new StoreDrugInMaster();

		sd.setRemark("ddd");
		sd.setStoreOrderType("00");

		List<StoreDrugInDetail> storeDrugInDetailList = new ArrayList<StoreDrugInDetail>();
		StoreDrugInDetail sdi = new StoreDrugInDetail();

		sdi.setBatchNo("222");
		sdi.setDrugCode("22");
		sdi.setDrugSource("2");
		sdi.setExpDate(new Date());

		sdi.setQuantity(33);
		sdi.setRemark("33");

		sdi.setStoreCode("dd");
		sdi.setStoreGoodsPositionCode("dd");
		sdi.setSupplierCode("dv");
		sdi.setStoreDrugInDetailId(1);
		storeDrugInDetailList.add(sdi);
		StoreDrugInDetail sdi1 = new StoreDrugInDetail();

		sdi1.setBatchNo("222");
		sdi1.setDrugCode("22");
		sdi1.setDrugSource("2");
		sdi1.setExpDate(new Date());

		sdi1.setQuantity(33);
		sdi1.setRemark("33");

		sdi1.setStoreCode("dd");
		sdi1.setStoreGoodsPositionCode("dd");
		sdi1.setSupplierCode("dv");
		sdi1.setStoreDrugInDetailId(1);
		storeDrugInDetailList.add(sdi1);
		sd.setStoreInOrderDetailList(storeDrugInDetailList);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put(SysConstant.STORE_PROC_PLAN_NO, "");
		dataMap.put(SysConstant.STORE_DRUG_IN_MASTER, sd);
		String jsonString = JSONObject.toJSONString(dataMap);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 01：药房退库再入库 insertInStoreDrugTest2:(药房退库再入库 ).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void insertInStoreDrugTest2() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/insertInStoreDrug");
		StoreDrugInMaster sd = new StoreDrugInMaster();

		sd.setRemark("ddd");

		sd.setStoreOrderType("01");

		List<StoreDrugInDetail> storeDrugInDetailList = new ArrayList<StoreDrugInDetail>();
		StoreDrugInDetail sdi = new StoreDrugInDetail();

		sdi.setBatchNo("222");
		sdi.setDrugCode("22");
		sdi.setDrugSource("2");
		sdi.setExpDate(new Date());

		sdi.setQuantity(33);
		sdi.setRemark("33");

		sdi.setStoreCode("dd");
		sdi.setStoreGoodsPositionCode("dd");
		sdi.setSupplierCode("dv");
		sdi.setStoreDrugInDetailId(1);
		storeDrugInDetailList.add(sdi);
		sd.setStoreInOrderDetailList(storeDrugInDetailList);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put(SysConstant.STORE_DRUG_IN_MASTER, sd);
		String jsonString = JSONObject.toJSONString(dataMap);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 02：科室退库再入库 insertInStoreDrugTest3:(科室退库再入库 ).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void insertInStoreDrugTest3() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/insertInStoreDrug");
		StoreDrugInMaster sd = new StoreDrugInMaster();

		sd.setRemark("ddd");

		sd.setStoreOrderType("02");

		List<StoreDrugInDetail> storeDrugInDetailList = new ArrayList<StoreDrugInDetail>();
		StoreDrugInDetail sdi = new StoreDrugInDetail();

		sdi.setBatchNo("222");
		sdi.setDrugCode("22");
		sdi.setDrugSource("2");
		sdi.setExpDate(new Date());

		sdi.setQuantity(33);
		sdi.setRemark("33");

		sdi.setStoreCode("dd");
		sdi.setStoreGoodsPositionCode("dd");
		sdi.setSupplierCode("dv");
		sdi.setStoreDrugInDetailId(1);
		storeDrugInDetailList.add(sdi);
		sd.setStoreInOrderDetailList(storeDrugInDetailList);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put(SysConstant.STORE_DRUG_IN_MASTER, sd);
		String jsonString = JSONObject.toJSONString(dataMap);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 03：药品调拨入库 insertInStoreDrugTest4:(药品调拨入库 ).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void insertInStoreDrugTest4() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/insertInStoreDrug");
		StoreDrugInMaster sd = new StoreDrugInMaster();

		sd.setRemark("ddd");

		sd.setStoreOrderType("03");

		List<StoreDrugInDetail> storeDrugInDetailList = new ArrayList<StoreDrugInDetail>();
		StoreDrugInDetail sdi = new StoreDrugInDetail();

		sdi.setBatchNo("222");
		sdi.setDrugCode("22");
		sdi.setDrugSource("2");
		sdi.setExpDate(new Date());

		sdi.setQuantity(33);
		sdi.setRemark("33");

		sdi.setStoreCode("dd");
		sdi.setStoreGoodsPositionCode("dd");
		sdi.setSupplierCode("dv");
		sdi.setStoreDrugInDetailId(1);
		storeDrugInDetailList.add(sdi);
		sd.setStoreInOrderDetailList(storeDrugInDetailList);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put(SysConstant.STORE_DRUG_IN_MASTER, sd);
		String jsonString = JSONObject.toJSONString(dataMap);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 04：药品调拨出库再入库 insertInStoreDrugTest5:(药品调拨出库再入库).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void insertInStoreDrugTest5() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/insertInStoreDrug");
		StoreDrugInMaster sd = new StoreDrugInMaster();

		sd.setRemark("ddd");

		sd.setStoreOrderType("04");

		List<StoreDrugInDetail> storeDrugInDetailList = new ArrayList<StoreDrugInDetail>();
		StoreDrugInDetail sdi = new StoreDrugInDetail();

		sdi.setBatchNo("222");
		sdi.setDrugCode("22");
		sdi.setDrugSource("2");
		sdi.setExpDate(new Date());

		sdi.setQuantity(33);
		sdi.setRemark("33");

		sdi.setStoreCode("dd");
		sdi.setStoreGoodsPositionCode("dd");
		sdi.setSupplierCode("dv");
		sdi.setStoreDrugInDetailId(1);
		storeDrugInDetailList.add(sdi);
		sd.setStoreInOrderDetailList(storeDrugInDetailList);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put(SysConstant.STORE_DRUG_IN_MASTER, sd);
		String jsonString = JSONObject.toJSONString(dataMap);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 10：药房科室出库 insertOutStoreDrugTest1:(药房科室出库).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void insertOutStoreDrugTest1() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/insertOutStoreDrug");
		StoreDrugOutMaster sd = new StoreDrugOutMaster();

		sd.setRemark("ddd");
		sd.setStoreOrderType("11");

		List<StoreDrugOutDetail> storeDrugOutDetailList = new ArrayList<StoreDrugOutDetail>();
		StoreDrugOutDetail sdi = new StoreDrugOutDetail();

		sdi.setBatchNo("222");
		sdi.setDrugCode("22");
		sdi.setDrugSource("2");
		sdi.setExpDate(new Date());

		sdi.setQuantity(33);
		sdi.setRemark("33");

		sdi.setStoreCode("dd");
		sdi.setStoreGoodsPositionCode("dd");
		sdi.setSupplierCode("dv");
		sdi.setStoreDrugOutDetailId(1);
		storeDrugOutDetailList.add(sdi);
		
		StoreDrugOutDetail sdi1 = new StoreDrugOutDetail();

		sdi1.setBatchNo("222");
		sdi1.setDrugCode("22");
		sdi1.setDrugSource("2");
		sdi1.setExpDate(new Date());

		sdi1.setQuantity(33);
		sdi1.setRemark("33");

		sdi1.setStoreCode("dd");
		sdi1.setStoreGoodsPositionCode("dd");
		sdi1.setSupplierCode("dv");
		sdi1.setStoreDrugOutDetailId(1);
		storeDrugOutDetailList.add(sdi1);
		sd.setStoreOutOrderDetailList(storeDrugOutDetailList);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("storeDrugOutMaster", sd);
		String jsonString = JSONObject.toJSONString(dataMap);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 11：供应商退货出库 insertOutStoreDrugTest2:(供应商退货出库).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void insertOutStoreDrugTest2() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/insertOutStoreDrug");
		StoreDrugOutMaster sd = new StoreDrugOutMaster();

		sd.setRemark("ddd");

		sd.setStoreOrderType("12");

		List<StoreDrugOutDetail> storeDrugOutDetailList = new ArrayList<StoreDrugOutDetail>();
		StoreDrugOutDetail sdi = new StoreDrugOutDetail();

		sdi.setBatchNo("222");
		sdi.setDrugCode("22");
		sdi.setDrugSource("2");
		sdi.setExpDate(new Date());

		sdi.setQuantity(33);
		sdi.setRemark("33");

		sdi.setStoreCode("dd");
		sdi.setStoreGoodsPositionCode("dd");
		sdi.setSupplierCode("dv");
		sdi.setStoreDrugOutDetailId(1);
		storeDrugOutDetailList.add(sdi);
		sd.setStoreOutOrderDetailList(storeDrugOutDetailList);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("storeDrugOutMaster", sd);
		String jsonString = JSONObject.toJSONString(dataMap);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 12：药品报损出库 insertOutStoreDrugTest3:(药品报损出库).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void insertOutStoreDrugTest3() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/insertOutStoreDrug");
		StoreDrugOutMaster sd = new StoreDrugOutMaster();

		sd.setRemark("ddd");

		sd.setStoreOrderType("13");

		List<StoreDrugOutDetail> storeDrugOutDetailList = new ArrayList<StoreDrugOutDetail>();
		StoreDrugOutDetail sdi = new StoreDrugOutDetail();

		sdi.setBatchNo("222");
		sdi.setDrugCode("22");
		sdi.setDrugSource("2");
		sdi.setExpDate(new Date());

		sdi.setQuantity(33);
		sdi.setRemark("33");

		sdi.setStoreCode("dd");
		sdi.setStoreGoodsPositionCode("dd");
		sdi.setSupplierCode("dv");
		sdi.setStoreDrugOutDetailId(1);
		storeDrugOutDetailList.add(sdi);
		sd.setStoreOutOrderDetailList(storeDrugOutDetailList);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("storeDrugOutMaster", sd);
		String jsonString = JSONObject.toJSONString(dataMap);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 13：药品调拨出库 insertOutStoreDrugTest3:(药品调拨出库).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void insertOutStoreDrugTest4() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/insertOutStoreDrug");
		StoreDrugOutMaster sd = new StoreDrugOutMaster();

		sd.setRemark("ddd");

		sd.setStoreOrderType("14");

		List<StoreDrugOutDetail> storeDrugOutDetailList = new ArrayList<StoreDrugOutDetail>();
		StoreDrugOutDetail sdi = new StoreDrugOutDetail();

		sdi.setBatchNo("222");
		sdi.setDrugCode("22");
		sdi.setDrugSource("2");
		sdi.setExpDate(new Date());

		sdi.setQuantity(33);
		sdi.setRemark("33");

		sdi.setStoreCode("dd");
		sdi.setStoreGoodsPositionCode("dd");
		sdi.setSupplierCode("dv");
		sdi.setStoreDrugOutDetailId(1);
		storeDrugOutDetailList.add(sdi);
		sd.setStoreOutOrderDetailList(storeDrugOutDetailList);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("storeDrugOutMaster", sd);
		String jsonString = JSONObject.toJSONString(dataMap);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 查询入库单数据列表 storeInOutDataGrid1:(查询入库单数据列表).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void storeInDataGrid1() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/storeInOutDataGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("storeOrderTypeId", "00");
		map.put("ioType", "0");

		String jsonString = JSONObject.toJSONString(map);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 通过单号查询入库单数据列表 storeInOutDataGrid2:(查询入库单数据列表).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void storeInDataGrid2() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/storeInOutDataGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ioType", "0");
		map.put("storeOrderNo", "201507131102341125");

		String jsonString = JSONObject.toJSONString(map);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 通过时间查询查询入库单数据列表 storeInOutDataGrid3:(查询入库单数据列表).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void storeInDataGrid3() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/storeInOutDataGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ioType", "0");
		map.put("startTime", "2015-07-13");

		String jsonString = JSONObject.toJSONString(map);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 通过时间范围查询查询入库单数据列表 storeInOutDataGrid4:(查询入库单数据列表).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void storeInDataGrid4() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/storeInOutDataGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ioType", "0");
		map.put("startTime", "2015-07-10");
		map.put("endTime", "2015-07-12");

		String jsonString = JSONObject.toJSONString(map);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 通过出库单类型查询出库单数据列表 storeInOutDataGrid1:(查询出库单数据列表).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void storeOutDataGrid1() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/storeInOutDataGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("storeOrderTypeId", "11");
		map.put("ioType", "1");

		String jsonString = JSONObject.toJSONString(map);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 通过单号查询出库单数据列表 storeInOutDataGrid2:(查询出库单数据列表).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void storeOutDataGrid2() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/storeInOutDataGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ioType", "1");
		map.put("storeOrderNo", "201507131102341054");

		String jsonString = JSONObject.toJSONString(map);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 通过时间查询出库单数据列表 storeInOutDataGrid3:(查询出库单数据列表).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void storeOutDataGrid3() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/storeInOutDataGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ioType", "1");
		map.put("startTime", "2015-07-13");
		String jsonString = JSONObject.toJSONString(map);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}

	/**
	 * 通过时间段查询出库单数据列表 storeInOutDataGrid4:(查询出库单数据列表).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@Test
	public void storeOutDataGrid4() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(serverUri
				+ "storeDrugMaster/storeInOutDataGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ioType", "1");
		map.put("startTime", "2015-07-11");
		map.put("endTime", "2015-07-12");
		String jsonString = JSONObject.toJSONString(map);
		Response response = target
				.request()
				.buildPut(Entity.entity(jsonString, MediaType.APPLICATION_JSON))
				.invoke();
		System.out.print(response.getStatus());
		response.close();
	}
}
