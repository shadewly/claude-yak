package com.shine.his.common.util;

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.shine.his.common.core.SysConstant;
import com.shine.his.common.pojo.SysDictEntity;

/**
 * 获取上下文工具类 Class Name:ServletContextUtil Function:TODO( 获取上下文对象)
 * 
 * @author yuxinchen
 * @version (1.0)
 */
public class ServletContextUtil {
	private static ServletContext servletContext = ContextLoader
			.getCurrentWebApplicationContext().getServletContext();

	/**
	 * 获取上下文
	 * 
	 * @return
	 */
	public static ServletContext getServletContext() {

		return servletContext;
	}

	/**
	 * 通过键获取缓存中的数据 getServletContext:(简单描述方法的作用).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * 
	 * @return
	 */
	public static Object getServletContextObj(String keyCode) {

		return servletContext.getAttribute(keyCode);
	}

	/**
	 * 
	 * getSysDict:(获取缓存中的系统字典map集合对象方法).<br/>
	 * TODO:(获取缓存中的系统字典map集合对象).<br/>
	 * 
	 * @return
	 */
	public static Map<String, SysDictEntity> getSysDict() {
		return (Map<String, SysDictEntity>) ServletContextUtil
				.getServletContextObj(SysConstant.SYS_DICT_MAP);
	}
}