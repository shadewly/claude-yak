package com.shine.his.store.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shine.his.store.pojo.StoreDrugDetail;

/**
 * Class Name:StoreDrugDetailServiceTest Function:StoreDrugDetailServiceTest
 * 
 * @author ducheng
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/applicationContext.xml" })
public class StoreDrugDetailServiceTest {
	private static Logger logger = LoggerFactory
			.getLogger(StoreDrugDetailServiceTest.class);
	@Autowired
	private IStoreDrugDetailService storeDrugDetailService;

	/**
	 * 测试getStoreDrugDetail
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testGetStoreDrugDetail() throws ParseException {
		// 参数为null
		StoreDrugDetail storeDrugDetail_null = storeDrugDetailService.getStoreDrugDetail(null);
		assertNull(storeDrugDetail_null);
		//
		StoreDrugDetail storeDrugDetail = storeDrugDetailService.getStoreDrugDetail(1001);
		logger.debug(storeDrugDetail.toString());
		assertNotNull(storeDrugDetail);

	}
	
	@Test
	public void testGetStoreDrugDetailByParam(){
		StoreDrugDetail storeDrugDetail = storeDrugDetailService.getStoreDrugDetail("10000102","20150102");
		logger.debug(storeDrugDetail.toString());
		assertNotNull(storeDrugDetail);
	}
	
	@Test
	public void testFindStoreDrugSummary() {
		
		PageInfo<StoreDrugDetail> page1 = storeDrugDetailService.findStoreDrugSummary(3, 5, null);
		logger.debug("参数为NULL,当前第{}页，页面大小为{}，真实数据量为{},total为{}",
				new Object[] { page1.getPageNum(), page1.getPageSize(),
						page1.getList().size(), page1.getTotal()});
		
		Map<String,Object> param = new HashMap<String, Object>();
		//param.put("drugCategoryName", "西药");
		param.put("onlyShowZeroStock", false);
		//param.put("selectStr", "诺氟");
		param.put("bll", true);
		PageInfo<StoreDrugDetail> page2 = storeDrugDetailService.findStoreDrugSummary(1, 5, param);
		logger.debug("参数为param,当前第{}页，页面大小为{}，真实数据量为{},total为{}",
				new Object[] { page2.getPageNum(), page2.getPageSize(),
						page2.getList().size(),page2.getTotal() });
		logger.debug("参数为param{}", JSONObject.toJSONString(page2.getList()));
	}
	
	@Test
	public void findStoreDrugDetail() {
		
		PageInfo<StoreDrugDetail> page1 = storeDrugDetailService.findStoreDrugDetail(1, 10, null);
		logger.debug(
				"详细查询,当前第{}页，页面大小为{}，真实数据量为{},total为{}",
				new Object[] { page1.getPageNum(), page1.getPageSize(),
						page1.getList().size(),page1.getTotal() });
		Map<String,Object> param = new HashMap<String, Object>();
		//param.put("storeDrugDetailId", 1025);
		PageInfo<StoreDrugDetail> page2 = storeDrugDetailService.findStoreDrugDetail(1, 20, param);
		logger.debug(
				"详细查询,当前第{}页，页面大小为{}，真实数据量为{},total为{}",
				new Object[] { page2.getPageNum(), page2.getPageSize(),
						page2.getList().size(),page2.getTotal() });
		logger.debug("参数为param{}", JSONObject.toJSONString(page2.getList()));
	}

	@Test
	public void testDeleteStoreDrugDetail() {
		boolean bf = storeDrugDetailService.deleteStoreDrugDetail(null);
		assertFalse(bf);

		boolean bt = storeDrugDetailService.deleteStoreDrugDetail(1);
		assertTrue(bt);

	}

	@Test
	public void testAddStoreDrugDetail() throws ParseException {
		StoreDrugDetail storeDrugDetail1 = new StoreDrugDetail();
		storeDrugDetail1.setBatchNo("201511111");
		storeDrugDetail1.setQuantity(998);
		storeDrugDetail1.setStoreGoodsPositionCode("xxxx");
		storeDrugDetail1.setDrugCode("drugCode");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		storeDrugDetail1.setExpDate(format.parse("2015-07-07"));
		storeDrugDetail1.setStatus("1");

		storeDrugDetailService.addStoreDrugDetail(storeDrugDetail1);

		StoreDrugDetail storeDrugDetail3 = new StoreDrugDetail();
		storeDrugDetail3.setBatchNo("201511111");
		storeDrugDetail3.setQuantity(998);
		storeDrugDetail3.setStoreGoodsPositionCode("xxxx");
		storeDrugDetail3.setDrugCode("drugCode");
		storeDrugDetail3.setExpDate(format.parse("2015-07-07"));
		storeDrugDetail3.setStatus("1");
		storeDrugDetail3.setStoreDrugDetailId(1009);
		assertEquals(storeDrugDetail1, storeDrugDetail3);
	}

	@Test
	public void testUpdateStoreDrugDetail() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		StoreDrugDetail storeDrugDetail3 = new StoreDrugDetail();
		storeDrugDetail3.setBatchNo("201511111");
		storeDrugDetail3.setQuantity(998);
		storeDrugDetail3.setStoreGoodsPositionCode("xxxx");
		storeDrugDetail3.setDrugCode("update test");
		storeDrugDetail3.setExpDate(format.parse("2015-07-09"));
		storeDrugDetail3.setStatus("1");
		storeDrugDetail3.setStoreDrugDetailId(1009);

		boolean ok = storeDrugDetailService
				.updateStoreDrugDetail(storeDrugDetail3);

		assertTrue(ok);

	}

	@Test
	public void testUpdateQuantity() {
		boolean bt = storeDrugDetailService.updateQuantity(1010, 5555555);
		assertTrue(bt);
		boolean bf = storeDrugDetailService.updateQuantity(null, 5555555);
		assertFalse(bf);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPlusQuantity() {
		boolean bt = storeDrugDetailService.plusQuantity(1010, 100);
		assertTrue(bt);
		storeDrugDetailService.plusQuantity(1010, -100);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSubtractQuantity() {
		boolean bt = storeDrugDetailService.subtractQuantity(1011, 100);
		assertTrue(bt);
		storeDrugDetailService.subtractQuantity(1011, -100);
	}

	@Test
	public void testUpdateStatus() {
		boolean bt = storeDrugDetailService.updateStatus(1011, "0");
		assertTrue(bt);
		boolean bf = storeDrugDetailService.updateStatus(null, "0");
		assertFalse(bf);
	}

}
