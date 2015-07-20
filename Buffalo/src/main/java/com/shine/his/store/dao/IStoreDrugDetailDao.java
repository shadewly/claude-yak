package com.shine.his.store.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shine.his.common.mybatis.MybatisMapperAnnotation;
import com.shine.his.store.pojo.StoreDrugDetail;

/**
 * Class Name:IStoreDrugDetailDao 
 * Function:药品库存明细dao
 * @author ducheng
 * @version 1.0
 */
@Repository
@MybatisMapperAnnotation
public interface IStoreDrugDetailDao {
	
    
	/**
	 * 根据I	D查询库存明细.<br/>
	 * @param storeDrugDetailId 库存明细编号
	 * @return
	 */
	public StoreDrugDetail selectByPrimaryKey(Integer storeDrugDetailId);
	/**
	 * 根据其他条件查询库存明细.<br/>
	 * @param param 
	 * @return
	 */
	public StoreDrugDetail selectByParam(Map<String, ?> param);
	/**
	 * 根据I	D查询库存明细，并关联查询出药品信息.<br/>
	 * @param storeDrugDetailId
	 * @return
	 */
	public StoreDrugDetail associateSelectByPrimaryKey(Integer storeDrugDetailId);
	
	/**
	 * 查询所有库存药品信息,同种药品不同批次需要进行汇总.<br/>
	 * @return 库存药品信息列表
	 */
	public List<StoreDrugDetail> selectStockSummaryList(Map<String, ?> param);
	/**
	 * 查询所有库存药品信息,同种药品不同批次不进行汇总.<br/>
	 * @return 库存药品信息列表
	 */
	public List<StoreDrugDetail> selectStockList(Map<String, ?> param);
	/**
	 * 根据I	D删除库存药品信息.<br/>
	 * @param storeDrugDetailId 库存明细编号
	 * @return
	 */
	public int deleteByPrimaryKey(Integer storeDrugDetailId);
	/**
	 * insert:插入库存药品明细.<br/>
	 * 插入的对象属性要完整.<br/>
	 * @param storeDrugDetail
	 * @return
	 */
	public int insert(StoreDrugDetail storeDrugDetail);
	/**
	 * insert:插入库存药品明细.<br/>
	 * 插入的对象属性可以不完整.<br/>
	 * @param storeDrugDetail
	 * @return
	 */
	public int insertSelective(StoreDrugDetail storeDrugDetail);
	/**
	 * 根据ID更新库存药品明细.<br/>
	 * 跟新的对象属性要完整.<br/>
	 * @param storeDrugDetail
	 * @return
	 */
	public int updateByPrimaryKey(StoreDrugDetail storeDrugDetail);
	/**
	 * 根据ID更新库存药品明细.<br/>
	 * 跟新的对象属性可以不完整.<br/>
	 * @param storeDrugDetail
	 * @return
	 */
	public int updateByPrimaryKeySelective(StoreDrugDetail storeDrugDetail);

}
