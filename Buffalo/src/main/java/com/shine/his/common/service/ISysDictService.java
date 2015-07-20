package com.shine.his.common.service;

import java.util.List;
import java.util.Map;

import com.shine.his.common.pojo.SysDictEntity;

/**
 * 
 * Class Name:ISysDictService
 * Function:TODO(系统字典服务接口)
 * @author yuxinchen
 * @version (1.0)
 */
public interface ISysDictService{

	/**
	 * 
	 * sysDictInit:(系统字典初始化方法).<br/>
	 * TODO:(系统字典初始化).<br/>
	 * @param sysDicList 系统字典子对象集合
	 * @return
	 */
	public Map<String, SysDictEntity> sysDictInit(List<SysDictEntity> sysDicList);
	
}
