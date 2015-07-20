package com.shine.his.common.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统字典 Class Name:SysDictEntity Function:TODO(系统字典)
 * 
 * @author yuxinchen
 * @version (1.0)
 */
public class SysDictEntity {
	/** 系统编码，编码由开发人员制定 */
	private String sysCode;
	private String keyCode;
	/** 父级编码，用于构建树形目录 */
	private String parentCode;
	/** 字典分类，该项用于开发做数据归类，由后台开发人员维护。 */
	private String dictType;
	/** 参数值 */
	private String sysValue;
	/** 备注 */
	private String remark;

	private List<SysDictEntity> sysDictList = new ArrayList<SysDictEntity>();
	private Map<String, SysDictEntity> sysDictMap = new HashMap<String, SysDictEntity>();

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getSysValue() {
		return sysValue;
	}

	public void setSysValue(String sysValue) {
		this.sysValue = sysValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<SysDictEntity> getSysDictList() {
		return sysDictList;
	}

	public void setSysDictList(List<SysDictEntity> sysDictList) {
		this.sysDictList = sysDictList;
	}

	public Map<String, SysDictEntity> getSysDictMap() {
		return sysDictMap;
	}

	public void setSysDictMap(Map<String, SysDictEntity> sysDictMap) {
		this.sysDictMap = sysDictMap;
	}

	public String getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

}
