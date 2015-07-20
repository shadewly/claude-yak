package com.shine.his.store.service;


import java.util.Date;
import java.util.List;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.shine.his.store.pojo.StoreGoodsPositionInfo;
import com.shine.his.store.pojo.StoreInfo;
import com.shine.his.store.pojo.StoreManagerStore;
import com.shine.his.store.pojo.StoreShelfInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class StoreTest {
	@Autowired
	private IStoreService storeService;
	
	@Test
	public void testQueryStoreInfo() throws Exception{
		StoreInfo storeInfo=new StoreInfo();
		//storeInfo.setStoreCode("111");
		storeInfo.setStoreName("仓库");
		//storeInfo.setStoreLocation("东边第一个位置");
		//storeInfo.setStatus("1");
		//storeInfo.setCreateTime(new Date());
		//storeInfo.setModifyTime(new Date());
		//storeInfo.setRemark("测试专用");
		//String s=JSONObject.toJSONString(storeInfo);
		PageHelper.startPage(1, 3);
		List<StoreInfo> list=storeService.queryStoreInfo(storeInfo);
		System.out.println(list);
		for (StoreInfo storeInfo2 : list) {
			System.out.println("仓库编号："+storeInfo2.getStoreCode());
		}
	}
	
	@Test 
	public void testUpdateStoreInfo() throws Exception{
		//StoreInfo storeInfo =new StoreInfo();
		StoreInfo si=new StoreInfo();
		StoreManagerStore storeManagerStore=new StoreManagerStore();
		storeManagerStore.setStoreCode("101");
		storeManagerStore.setStoreManagerId(123);
		si.setStoreCode("101");
		si.setStoreName("仓库1号");
		si.setStoreLocation("东边边");
		si.setStatus("0");
		si.setCreateTime(new Date());
		si.setModifyTime(new Date());
		si.setRemark("测试专用2");
	//	Map<String,Object>list=new HashMap<String,Object>();
	//	list.put("newStoreManagerId", 123);
	//	list.put("storeCode", "111");
	//	list.put("storeManagerId", 222);
		storeService.updateStoreInfo(si);
	//	storeService.updateSMS(list);
	}
	
	@Test
	public void testAddStoreInfo() throws Exception{
		int i=101;
		StoreInfo si1=new StoreInfo();
		si1.setStoreName("");
		si1=storeService.queryStoreInfo(si1).get(0);
		if (si1==null){
			i=101;
		}else {
			i=Integer.parseInt(si1.getStoreCode())+1;
		}
		StoreInfo si=new StoreInfo();
		si.setStoreCode(String.valueOf(i));
		si.setStoreName("仓库777号");
		si.setStoreLocation("东边");
		si.setStatus("1");
		si.setCreateTime(new Date());
		si.setModifyTime(new Date());
		si.setRemark("测试专用777");
		//List<StoreManagerStore> list =new ArrayList<StoreManagerStore>();
		//StoreManagerStore storeManagerStore=new StoreManagerStore();
		//storeManagerStore.setStoreCode("555");
		//storeManagerStore.setStoreManagerId(222);
		//list.add(storeManagerStore);
		storeService.addStoreInfo(si);
		//storeService.addSMS(list);
		System.out.println("新增数据成功");
	} 
	
	@Test
	public void testStopStore() throws Exception{
		StoreInfo storeInfo=new StoreInfo();
		storeInfo.setStatus("9");
		storeInfo.setStoreCode("101");
		storeService.stopStore(storeInfo);
		System.out.println("仓库停用成功");
	}
	@Test
	public void testAddStoreShelfInfo() throws Exception{
		StoreShelfInfo ssi=new StoreShelfInfo();
		/**设置货架名字为空*/
		ssi.setShelfName("");
		/** 由前台传入当前仓库号*/
		String storeCodeString="102";
		/** 用来设置货架编号的参数*/
		int i;;
		List<StoreShelfInfo> list=storeService.queryStoreShelfInfo(ssi);
		if(list.isEmpty()){
			i=Integer.parseInt(storeCodeString)*1000+1;
		}else {
			i=Integer.parseInt(list.get(0).getStoreShelfCode())+1;
		}
		ssi.setStoreShelfCode(String.valueOf(i));
		ssi.setStoreCode(storeCodeString);
		ssi.setShelfName("货架二号");
		ssi.setShelfStatus("1");
		ssi.setCreateTime(new Date());
		ssi.setModifyTime(new Date());
		ssi.setRemark("测试货架");
		storeService.addStoreShelfInfo(ssi);
		System.out.println("新增货架成功");
	}
		
	@Test
	public void testQueryStoreShelfInfo() throws Exception{
		StoreShelfInfo ssi=new StoreShelfInfo();
		/**设置货架名字为空*/
		ssi.setShelfName("货架");
		List<StoreShelfInfo> list=storeService.queryStoreShelfInfo(ssi);
		for (StoreShelfInfo storeShelfInfo : list) {
			System.out.println("#####"+storeShelfInfo.getShelfName());
		}
	}
	@Test
	public void testUpdateStoreShelfInfo() throws Exception{
		StoreShelfInfo ssi=new StoreShelfInfo();
		/*由前台传入当前货架号*/
		ssi.setStoreShelfCode("102002");
//		ssi.setStoreCode("101");
		ssi.setShelfName("货架三号");
		ssi.setShelfStatus("1");
		ssi.setCreateTime(new Date());
		ssi.setModifyTime(new Date());
		ssi.setRemark("测试货架");
		int i=storeService.updateStoreShelfInfo(ssi);
		if(i!=0){
			System.out.println("更新货架成功");
		}
	}
	@Test
	public void testStopStoreShelf() throws Exception{
		StoreShelfInfo ssi=new StoreShelfInfo();
		/**由前台传入停止使用参数*/
		ssi.setStoreShelfCode("102002");
		ssi.setShelfStatus("1");
		int i=storeService.stopStoreShelf(ssi);
		if (i!=0){
			System.out.println("停用货架成功");
		}
	}
	
	@Test
	public void testAddSGPInfo () throws Exception{
		StoreGoodsPositionInfo sgp=new StoreGoodsPositionInfo();
		/** 由前台传入当前货位号*/
		String storeShelfCode="102001";
		/** 用来设置货位编号的参数*/
		long i;;
		List<StoreGoodsPositionInfo> list=storeService.querySGPInfo("");
		if(list.isEmpty()){
			i=Long.parseLong(storeShelfCode)*10000+1;
		}else {
			i=Long.parseLong(list.get(0).getStoreGoodsPositionCode())+1;
		}
		sgp.setStoreGoodsPositionCode(String.valueOf(i));
		sgp.setStoreShelfCode(storeShelfCode);
		sgp.setGoodsContent("薯条专用");
		sgp.setStatus("1");
		sgp.setCreateTime(new Date());
		sgp.setModifyTime(new Date());
		sgp.setRemark("测试货位");
		int count=storeService.addSGPInfo(sgp);
		if (count!=0){
			System.out.println("新增货位成功，编号为："+i);
		}
	}
	@Test
	public void testQuerySGPInfo () throws Exception{
		StoreGoodsPositionInfo storeGoodsPositionInfo=new StoreGoodsPositionInfo();
		storeGoodsPositionInfo.setStoreGoodsPositionCode("1010010001");
		List<StoreGoodsPositionInfo> list=storeService.querySGPInfo("");
		for (StoreGoodsPositionInfo storeGoodsPositionInfo2 : list) {
			System.out.println("货位的编号是："+storeGoodsPositionInfo2.getStoreGoodsPositionCode());
		}
	}
	@Test
	public void testUpdateSGPInfo () throws Exception{
		StoreGoodsPositionInfo storeGoodsPositionInfo=new StoreGoodsPositionInfo();
		storeGoodsPositionInfo.setModifyTime(new Date());
		storeGoodsPositionInfo.setGoodsContent("heihei");
		storeGoodsPositionInfo.setStatus("2");
		storeGoodsPositionInfo.setRemark("very good");
		storeGoodsPositionInfo.setStoreGoodsPositionCode("1020010001");
		int i=storeService.stopSGP(storeGoodsPositionInfo);
		if(i!=0){
			System.out.println("编号："+storeGoodsPositionInfo.getStoreGoodsPositionCode()+
					"货位更新成功");
		}
	}
	@Test
	public void testStopSGP() throws Exception{
		StoreGoodsPositionInfo storeGoodsPositionInfo=new StoreGoodsPositionInfo();
		storeGoodsPositionInfo.setStatus("9");
		storeGoodsPositionInfo.setStoreGoodsPositionCode("1020010001");
		int i=storeService.stopSGP(storeGoodsPositionInfo);
		if(i!=0){
			System.out.println("编号："+storeGoodsPositionInfo.getStoreGoodsPositionCode()+
					"货位停用成功");
		}
	}
}
