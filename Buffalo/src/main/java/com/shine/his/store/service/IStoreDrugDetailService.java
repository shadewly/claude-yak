package com.shine.his.store.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.shine.his.store.pojo.StoreDrugDetail;

/**
 * Class Name:IStoreDrugDetailService
 * Function:TODO
 * @author ducheng
 * @version 1.0
 */
public interface IStoreDrugDetailService {
	//---------------基础操作接口
	/**
	 * 根据I	D查询库存明细，不包含药品信息.<br/>
	 * @param storeDrugDetailId 库存明细编号
	 * @return
	 */
	public StoreDrugDetail getStoreDrugDetail(Integer storeDrugDetailId);
	/**
	 * 根据I	D查询库存明细，不包含药品信息.<br/>
	 * @param drugCode 药品编码
	 * @param batchNo 批号
	 * @return
	 */
	public StoreDrugDetail getStoreDrugDetail(String drugCode, String batchNo);

	/**
	 * 分页所有库存明细，同种药品不同批次的药品需要进行汇总计算.<br/>
	 * @param pageNum
	 * @param pageSize
	 * @param param 查询参数<br/>
	 * 			查询参数可用列表:<br/>
	 * 			drugCategoryId:药品大类ID,Intager类型<br/>
	 * 		  	drugCategoryName:药品大类名称,String类型 <br/>
	 * 		  	selectStr:检索字符串,String类型 <br/>
	 * 			onlyShowZeroStock:只显示零库存,boolean类型 <br/>
	 * 			bll:低于下限,boolean类型
	 * @return
	 */
	public PageInfo<StoreDrugDetail> findStoreDrugSummary(int pageNum, int pageSize, Map<String, ?> param);
	
	/**
	 * 分页所有库存明细，同种药品不同批次不进行汇总.<br/>
	 * @param pageNum
	 * @param pageSize
	 * @param param 查询参数<br/>
	 * 			查询参数可用列表:<br/>
	 * 		  	storeDrugDetailId:库存ID,Integer类型 <br/>
	 * 		  	storeGoodsPositionCode:货位号,String类型 <br/>
	 * @return
	 */
	public PageInfo<StoreDrugDetail> findStoreDrugDetail(int pageNum, int pageSize, Map<String, ?> param);
	/**
	 * 根据I	D删除库存药品信息.<br/>
	 * @param storeDrugDetailId 库存明细编号
	 * @return
	 */
	public boolean deleteStoreDrugDetail(Integer storeDrugDetailId);
	/**
	 * 添加库存库存药品明细.<br/>
	 * @param storeDrugDetail
	 * @return
	 */
	public StoreDrugDetail addStoreDrugDetail(StoreDrugDetail storeDrugDetail);
	/**
	 * 更新库存药品明细.<br/>
	 * @param storeDrugDetail
	 * @return
	 */
	public boolean updateStoreDrugDetail(StoreDrugDetail storeDrugDetail);
	//---------------其他操作接口
	/**
	 * 修改库存数量.<br/>
	 * @param storeDrugDetailId 库存明细编号
	 * @param quantity 库存
	 */
	public boolean updateQuantity(Integer storeDrugDetailId, Integer quantity);
	/**
	 * plusQuantity:增加库存数量.<br/>
	 * 用于以相对值进行库存数量增加.<br/>
	 * @param storeDrugDetailId
	 * @param number 要增加的数量，只能为正数，否则会抛出参数异常
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean plusQuantity(Integer storeDrugDetailId, Integer number) throws IllegalArgumentException;
	
	/**
	 * subtractQuantity:减少库存数量.<br/>
	 * 用于以相对值进行库存数量减少.<br/>
	 * @param storeDrugDetailId
	 * @param number 要减少的数量,只能为正数，否则会抛出参数异常
	 * @return
	 * @throws IllegalArgumentException 
	 */
	public boolean subtractQuantity(Integer storeDrugDetailId, Integer number) throws IllegalArgumentException;
	
	/**
	 * 跟新药品状态.<br/>
	 * @param storeDrugDetailId
	 * @param status 0已过近效期 ，1没过近效期
	 * @return
	 */
	public boolean updateStatus(Integer storeDrugDetailId, String status);
	
}
