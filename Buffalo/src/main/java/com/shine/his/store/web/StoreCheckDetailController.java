package com.shine.his.store.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shine.his.store.service.StoreCheckDetailServiceI;

/**   
 * @Title: Controller
 * @Description: ss
 * @author zhangdaihao
 * @date 2015-07-07 10:14:12
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/storeCheckDetailController")
public class StoreCheckDetailController {
	/**
	 * Logger for this class
	 */
	//private static final Logger logger = Logger.getLogger(StoreCheckDetailController.class);

	@Autowired
	private StoreCheckDetailServiceI storeCheckDetailService;
	@Autowired
//	private SystemService systemService;
	private String message;

}
