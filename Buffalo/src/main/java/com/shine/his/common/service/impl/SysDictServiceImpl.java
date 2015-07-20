package com.shine.his.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shine.his.common.dao.ISysDictDao;
import com.shine.his.common.pojo.SysDictEntity;
import com.shine.his.common.service.ISysDictService;

/**
 * 
 * Class Name:SysDictServiceImpl Function:TODO(系统字典服务实现类)
 * 
 * @author yuxinchen
 * @version (1.0)
 */
@Service("sysDictService")
@Transactional
public class SysDictServiceImpl implements ISysDictService {
	@Autowired
	ISysDictDao sysDictDao;

	@Override
	public Map<String, SysDictEntity> sysDictInit(
			List<SysDictEntity> sysDicList) {
		Map<String, SysDictEntity> sysDictMap = new HashMap<String, SysDictEntity>();
		
		if (null == sysDicList) {
			sysDicList = sysDictDao.sysDictInit();
		}

		for (SysDictEntity sysDict : sysDicList) {
		
			
			
			if(null!=sysDict.getSysDictList()&&sysDict.getSysDictList().size()>0){
				sysDict.setSysDictMap(sysDictInit(sysDict.getSysDictList()));
			}
			sysDictMap.put(sysDict.getKeyCode(), sysDict);
			
		}

		return sysDictMap;
	}

}