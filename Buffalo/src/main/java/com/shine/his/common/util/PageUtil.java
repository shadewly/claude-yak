/**
 * Project Name:ShineHIS
 * Copyright (c) 2015,四川欣阳科技有限公司 All Right Reserved.
 */
package com.shine.his.common.util;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Class Name:PageUtil
 * Function:TODO (简单描述功能)
 * @author jin
 * @version 1.0
 */
public class PageUtil {
	/**
	 * 默认的分页尺寸
	 */
	public static final int pageSize = 10;
	/**
	 * 允许的最小分页尺寸
	 */
	public static final int minValSize = 5;
	/**
	 * 允许的最大分页尺寸
	 */
	public static final int maxValSize = 25;
	
	/**
	 * 
	 * getPageInfo:获取pageInfo.<br/>
	 * @param resultList
	 * @return
	 */
	public static <T> PageInfo<T> getPageInfo(List<T> resultList) {
		PageInfo<T> pageInfo = new PageInfo<>(resultList);
		return pageInfo;
	}
	
	/**
	 * 
	 * pagingInit:初始化分页条件.<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param pageNum
	 * @param pageSize
	 */
	public static void pagingInit(Integer pageNum,Integer pageSize) {
		if (pageSize == null || pageSize.intValue() < PageUtil.minValSize
				|| pageSize.intValue() > PageUtil.maxValSize)// 如果客户端未设置分页尺寸，或设置分页尺寸无效
			PageHelper.startPage(pageNum, PageUtil.pageSize);
		PageHelper.startPage(pageNum, pageSize);
	}
	
}
