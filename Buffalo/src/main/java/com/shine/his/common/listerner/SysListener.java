package com.shine.his.common.listerner;

import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSONObject;
import com.shine.his.common.core.SysConstant;
import com.shine.his.common.pojo.SysDictEntity;
import com.shine.his.common.service.ISysDictService;

public class SysListener implements ServletContextListener, InitializingBean {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {

		
			sysDictInit(arg0);
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void sysDictInit(ServletContextEvent arg0) throws Exception {
		WebApplicationContext rwp = WebApplicationContextUtils
				.getRequiredWebApplicationContext(arg0.getServletContext());
		ISysDictService sysDictService = (ISysDictService) rwp.getBean("sysDictService");

		arg0.getServletContext().setAttribute(SysConstant.SYS_DICT_MAP,
				sysDictService.sysDictInit(null));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

}
