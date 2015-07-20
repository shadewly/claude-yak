package com.shine.his.store.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.shine.his.store.dao.IStoreDao;
import com.shine.his.store.pojo.StoreGoodsPositionInfo;
import com.shine.his.store.pojo.StoreInfo;

import com.shine.his.store.pojo.StoreManagerStore;
import com.shine.his.store.pojo.StoreShelfInfo;
import com.shine.his.store.service.IStoreService;

/**
 * 
 * Class Name:IStoreServiceImpl
 * Function:TODO(简单描述功能)
 * @author panda
 * @version (版本1.0)
 */
@Service
@Transactional
public class StoreServiceImpl implements IStoreService {
	/**
	 * 仓库模块操作dao
	 */
	@Autowired
	private IStoreDao storeDao;
	
	/**
	 * 仓库信息查询
	 */
	@Override
	public List<StoreInfo> queryStoreInfo(StoreInfo storeInfo) throws Exception{
		//StoreInfo storeInfoEntiy=(StoreInfo)JSONObject.parseObject(storeInfo, StoreInfo.class);
	//	StoreInfo si=new StoreInfo();
	return storeDao.queryStoreInfo(storeInfo);
	//	si.setStoreName("仓库");
	//	si=storeDao.queryStoreInfo(si);
	//	System.out.println("!!!!!!!!!!!!!!!!!!!!" + si.getStoreCode());
	//	System.out.println("&&&&&&&&&&&"+si.getStoreManager().getStoreManagerName());
	//	return storeInfoEntiy;
	}
	
	/**
	 * 增加仓库
	 */
	@Override
	public boolean addStoreInfo(StoreInfo storeInfo) throws Exception{
		boolean result=false;
		storeDao.addStoreInfo(storeInfo);
		// 将传入的信息转化为实体对象
//		StoreInfo storeInfoEntiy=(StoreInfo)JSONObject.parseObject(storeInfo, StoreInfo.class);
//		StoreInfo si=new StoreInfo();
//		si.setStoreCode("111");
//		si.setStoreName("仓库1号");
//		si.setStoreLocation("东边");
//		si.setStatus("1");
//		si.setCreateTime(new Date());
//		si.setModifyTime(new Date());
//		si.setRemark("测试专用");
//		List<StoreManagerStore> list =new ArrayList<StoreManagerStore>();
//		StoreManagerStore storeManagerStore=new StoreManagerStore();
//		storeManagerStore.setStoreCode("111");
//		storeManagerStore.setStoreManagerId(222);
//		list.add(storeManagerStore);
//		storeDao.addStoreInfo(si);
//		storeDao.addStoreManager(list);
		return result;
	}
	
	/**
	 * 更新仓库信息
	 */
	@Override
	public int updateStoreInfo(StoreInfo storeInfo) throws Exception{
		int i=0;
//		StoreInfo storeInfoEntiy=(StoreInfo)JSONObject.parseObject(storeInfo, StoreInfo.class);
//		StoreManager storeManagerEntiy=(StoreManager)JSONObject.parse(storeInfo);
//		StoreInfo si=new StoreInfo();
//		StoreManagerStore storeManagerStore=new StoreManagerStore();
//		storeManagerStore.setStoreCode("111");
//		storeManagerStore.setStoreManagerId(222);
//		si.setStoreCode("111");
//		si.setStoreName("仓库1号");
//		si.setStoreLocation("东边边");
//		si.setStatus("0");
//		si.setCreateTime(new Date());
//		si.setModifyTime(new Date());
//		si.setRemark("测试专用2");
//		List<StoreManagerStore>list=new ArrayList<StoreManagerStore>();
//		list.add(storeManagerStore);
		storeDao.updateStoreInfo(storeInfo);
		//storeDao.updateSMS(list);
		return i;
	}
	
	/**
	 * 停用仓库
	 */
	@Override
	public void stopStore(StoreInfo storeInfo) throws Exception{
//		StoreInfo storeInfoEntiy=(StoreInfo)JSONObject.parseObject(storeInfo, StoreInfo.class);
//		StoreInfo si=new StoreInfo();
//		si.setStoreCode("111");
//		si.setStatus("2");
//		storeDao.stopStore(si);
		storeDao.stopStore(storeInfo);
	}

	/**
	 * 查询货架信息
	 */
	@Override
	public  List<StoreShelfInfo> queryStoreShelfInfo(StoreShelfInfo storeInfo) throws Exception{
	StoreShelfInfo storeShelfInfo=new StoreShelfInfo();
//		StoreShelfInfo ssi=new StoreShelfInfo();
//		ssi.setShelfName("货架一号");
//		ssi=storeDao.queryStoreShelfInfo(ssi);
//		System.out.println(ssi.getShelfName());
	return storeDao.queryStoreShelfInfo(storeShelfInfo);
	}
	
	/**
	 *  增加货架
	 */
	@Override
	public int addStoreShelfInfo(StoreShelfInfo storeShelfInfo ) throws Exception {
		int result=storeDao.addStoreShelfInfo(storeShelfInfo);
//		StoreShelfInfo storeShelfInfo=(StoreShelfInfo)JSONObject.parseObject(storeInfo, StoreShelfInfo.class);
//		StoreShelfInfo ssi=new StoreShelfInfo();
//		ssi.setStoreShelfCode("111222");
//		ssi.setStoreCode("111");
//		ssi.setShelfName("货架一号");
//		ssi.setShelfStatus("1");
//		ssi.setCreateTime(new Date());
//		ssi.setModifyTime(new Date());
//		ssi.setRemark("测试货架");
//		storeDao.addStoreShelfInfo(ssi);
		return result;
	}

	/**
	 * 更新货架信息 
	 */
	@Override
	public int updateStoreShelfInfo(StoreShelfInfo storeShelfInfo) throws Exception {
		int result=storeDao.updateStoreShelfInfo(storeShelfInfo);
//		StoreShelfInfo storeShelfInfo=(StoreShelfInfo)JSONObject.parseObject(storeInfo, StoreShelfInfo.class);
//		StoreShelfInfo ssi=new StoreShelfInfo();
//		ssi.setStoreShelfCode("111222");
//		ssi.setStoreCode("111");
//		ssi.setShelfName("货架二号");
//		ssi.setShelfStatus("0");
//		ssi.setCreateTime(new Date());
//		ssi.setModifyTime(new Date());
//		ssi.setRemark("测试货架");
//		storeDao.updateStoreShelfInfo(ssi);
		return result;
	}

	/**
	 * 停用货架
	 */
	@Override
	public int stopStoreShelf(StoreShelfInfo storeShelfInfo) throws Exception {
		int result=storeDao.stopStoreShelf(storeShelfInfo);
//		StoreShelfInfo storeShelfInfo=(StoreShelfInfo)JSONObject.parseObject(storeInfo, StoreShelfInfo.class);
//		StoreShelfInfo ssi=new StoreShelfInfo();
//		ssi.setStoreShelfCode("111222");
//		ssi.setStoreCode("111");
//		ssi.setShelfName("货架一号");
//		ssi.setShelfStatus("1");
//		ssi.setCreateTime(new Date());
//		ssi.setModifyTime(new Date());
//		ssi.setRemark("测试货架");
//		storeDao.stopStoreShelf(ssi);
		return result;
	}
	
	/**
	 * 查询货位信息
	 */
	@Override
	public List<StoreGoodsPositionInfo> querySGPInfo(String name) throws Exception{
		// TODO Auto-generated method stub
		return storeDao.querySGPInfo(name);
	}

	/**
	 * 增加货位
	 */
	@Override
	public int addSGPInfo(StoreGoodsPositionInfo storeGoodsPositionInfo) throws Exception{
		// TODO Auto-generated method stub
		return storeDao.addSGPInfo(storeGoodsPositionInfo);
	}

	/**
	 * 更新货位信息
	 */
	@Override
	public int updateSGPInfo(StoreGoodsPositionInfo storeGoodsPositionInfo) throws Exception{
		// TODO Auto-generated method stub
		return storeDao.updateSGPInfo(storeGoodsPositionInfo);
	}

	/**
	 * 停用货位
	 */
	@Override
	public int stopSGP(StoreGoodsPositionInfo storeGoodsPositionInfo) throws Exception{
		// TODO Auto-generated method stub
		return storeDao.stopSGP(storeGoodsPositionInfo);
	}
	
	@Override
	public void updateSMS(Map<String,Object>list) throws Exception{
		storeDao.updateSMS(list);
	}
	public void addSMS(List<StoreManagerStore> sms) throws Exception{
		storeDao.addSMS(sms);
	}
}
