package com.shine.his.common.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回前端公用结果类 Class Name:JsonResultUtil Function:TODO(将返回结果集转化为json字符窜)
 * 
 * @author 余鑫晨
 * @version (1.0)
 */
public class JsonResultUtil {

	/**
	 * 
	 * createResult:(简单描述方法的作用).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param result 操作结果成功与否
	 * @param obj 需要返回前端的结果集
	 * @return 转换后的json字符串
	 */
	public static String createResult(boolean result, Object obj,String msg) {
	
		if (null == obj ) {
			result = false;
			msg = "没有相关数据";
		}
		// 结果map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", result);
		resultMap.put("msg", msg);
		resultMap.put("obj", obj);
		return JSONObject.toJSONString(resultMap);

	}
}
