package com.shine.his.common.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.shine.his.common.mybatis.MybatisMapperAnnotation;
import com.shine.his.common.pojo.SysDictEntity;

/**
 * 
 * Class Name:IStoreDrugMasterDao 出入库dao接口类 Function:TODO(出入库操作dao接口)
 * 
 * @author yuxinchen
 * @version (1.0)
 */
@Repository
@Scope("singleton")
@MybatisMapperAnnotation
public interface ISysDictDao {

	/**
	 * 
	 * sysDictInit:(简单描述方法的作用).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @return
	 */
	public List<SysDictEntity> sysDictInit();


}