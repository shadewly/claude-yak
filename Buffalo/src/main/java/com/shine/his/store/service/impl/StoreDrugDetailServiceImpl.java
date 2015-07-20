package com.shine.his.store.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.shine.his.common.util.PageUtil;
import com.shine.his.store.dao.IStoreDrugDetailDao;
import com.shine.his.store.pojo.StoreDrugDetail;
import com.shine.his.store.service.IStoreDrugDetailService;

/**
 * Class Name:StoreDrugDetailServiceImpl
 * Function:TODO
 * @author ducheng
 * @version 1.0
 */
@Service
public class StoreDrugDetailServiceImpl implements IStoreDrugDetailService {
	private static Logger logger = LoggerFactory.getLogger(StoreDrugDetailServiceImpl.class);
	
	@Autowired
	private IStoreDrugDetailDao storeDrugDetailDao;
	
	@Override
	public StoreDrugDetail getStoreDrugDetail(Integer storeDrugDetailId) {
		return storeDrugDetailId!=null?storeDrugDetailDao.associateSelectByPrimaryKey(storeDrugDetailId):null;
	}
	
	@Override
	public StoreDrugDetail getStoreDrugDetail(String drugCode, String batchNo) {
		if(drugCode == null || "".equals(drugCode.trim())){
			logger.error("Parameter drugCode is null");
			throw new IllegalArgumentException("Parameter drugCode is null");
		}else if( batchNo == null || "".equals(batchNo.trim())){
			logger.error("Parameter batchNo is null");
			throw new IllegalArgumentException("Parameter batchNo is null");
		}else{
			Map<String, String> param = new HashMap<String, String>();
			param.put("drugCode", drugCode);
			param.put("batchNo", batchNo);
			return storeDrugDetailDao.selectByParam(param);
		}
	}

	@Override
	public PageInfo<StoreDrugDetail> findStoreDrugSummary(int pageNum, int pageSize, Map<String,?> param) {
		PageUtil.pagingInit(pageNum, pageSize);
		return PageUtil.getPageInfo(storeDrugDetailDao.selectStockSummaryList(param));
	}

	@Override
	public PageInfo<StoreDrugDetail> findStoreDrugDetail(int pageNum, int pageSize, Map<String,?> param) {
		PageUtil.pagingInit(pageNum, pageSize);
		return PageUtil.getPageInfo(storeDrugDetailDao.selectStockList(param));
	}

	@Override
	public boolean deleteStoreDrugDetail(Integer storeDrugDetailId) {
		if(storeDrugDetailId!=null){
			return storeDrugDetailDao.deleteByPrimaryKey(storeDrugDetailId)>0;
		}else{
			logger.error("storeDrugDetailId is null");
			return false;
		}
	}

	@Override
	public StoreDrugDetail addStoreDrugDetail(StoreDrugDetail storeDrugDetail) {
		int isInserted  = storeDrugDetailDao.insert(storeDrugDetail);
		if(isInserted>0){
			logger.info("add " + storeDrugDetail);
			return storeDrugDetail;
		}else{
			logger.error("add fail " + storeDrugDetail);
			return null;
		}
		
	}

	@Override
	public boolean updateStoreDrugDetail(StoreDrugDetail storeDrugDetail) {
		int isInserted  = storeDrugDetailDao.updateByPrimaryKey(storeDrugDetail);
		if(isInserted>0){
			logger.info("update " + storeDrugDetail);
			return true;
		}else{
			logger.error("update fail " + storeDrugDetail);
			return false;
		}
	}

	@Override
	public boolean updateQuantity(Integer storeDrugDetailId, Integer quantity) {
		StoreDrugDetail storeDrugDetail = new StoreDrugDetail();
		storeDrugDetail.setStoreDrugDetailId(storeDrugDetailId);
		storeDrugDetail.setQuantity(quantity);
		
		int isUpdated  = storeDrugDetailDao.updateByPrimaryKeySelective(storeDrugDetail);
		if(isUpdated>0){
			logger.info("update storeDrugDetail quantity:storeDrugDetailId=" + storeDrugDetailId + ",quantity=" + quantity);
			return true;
		}else{
			logger.error("update storeDrugDetail quantity fail:storeDrugDetailId=" + storeDrugDetailId + ",quantity=" + quantity);
			return false;
		}
	}

	@Override
	public boolean plusQuantity(Integer storeDrugDetailId, Integer number) 
			throws IllegalArgumentException {
		if(number==null || number<0){
			//增加的值必须为正数
			logger.error("plus quantity fail:plus the number of not less than 0");
			throw new IllegalArgumentException("plus the number of not less than 0 ");
		}else{
			//
			StoreDrugDetail oldStoreDrugDetail = this.getStoreDrugDetail(storeDrugDetailId);
			StoreDrugDetail updateStoreDrugDetail = new StoreDrugDetail();
			updateStoreDrugDetail.setStoreDrugDetailId(storeDrugDetailId);
			updateStoreDrugDetail.setQuantity(oldStoreDrugDetail.getQuantity() + number);
			int isUpdated  = storeDrugDetailDao.updateByPrimaryKeySelective(updateStoreDrugDetail);
			if(isUpdated>0){
				logger.info("plus quantity:storeDrugDetailId=" + storeDrugDetailId + ",number=" + number);
				return true;
			}else{
				logger.error("plus quantity fail:storeDrugDetailId=" + storeDrugDetailId + ",number=" + number);
				return false;
			}
		}
	}

	@Override
	public boolean subtractQuantity(Integer storeDrugDetailId, Integer number)
			throws IllegalArgumentException {
		if(number==null || number<0){
			//减少的值必须为正数
			logger.error("subtract quantity fail:subtract the number of not less than 0");
			throw new IllegalArgumentException("subtract the number of not less than 0 ");
		}else{
			//
			StoreDrugDetail oldStoreDrugDetail = this.getStoreDrugDetail(storeDrugDetailId);
			StoreDrugDetail updateStoreDrugDetail = new StoreDrugDetail();
			updateStoreDrugDetail.setStoreDrugDetailId(storeDrugDetailId);
			int newQuantity = oldStoreDrugDetail.getQuantity() - number;
			if(newQuantity<0){
				logger.error("subtract quantity fail:store quantity can not be less than 0.(storeDrugDetailId=" + storeDrugDetailId + ",number=" + number + ")");
				return false;
			}else{
				updateStoreDrugDetail.setQuantity(newQuantity);
			}
			int isUpdated  = storeDrugDetailDao.updateByPrimaryKeySelective(updateStoreDrugDetail);
			if(isUpdated>0){
				logger.info("subtract quantity:storeDrugDetailId=" + storeDrugDetailId + ",number=" + number);
				return true;
			}else{
				logger.error("subtract quantity fail:storeDrugDetailId=" + storeDrugDetailId + ",number=" + number);
				return false;
			}
		}
	}

	@Override
	public boolean updateStatus(Integer storeDrugDetailId, String status) {
		StoreDrugDetail storeDrugDetail = new StoreDrugDetail();
		storeDrugDetail.setStoreDrugDetailId(storeDrugDetailId);
		storeDrugDetail.setStatus(status);
		
		int isInserted  = storeDrugDetailDao.updateByPrimaryKeySelective(storeDrugDetail);
		if(isInserted>0){
			logger.info("update storeDrugDetail status:storeDrugDetailId=" + storeDrugDetailId + ",status=" + status);
			return true;
		}else{
			logger.error("update storeDrugDetail status fail:storeDrugDetailId=" + storeDrugDetailId + ",status=" + status);
			return false;
		}
	}

}
