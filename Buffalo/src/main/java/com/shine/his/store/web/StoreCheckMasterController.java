package com.shine.his.store.web;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shine.his.store.service.StoreCheckMasterServiceI;

/**   
 * @Title: Controller
 * @Description: ss
 * @author zhangdaihao
 * @date 2015-07-07 10:13:40
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/storeCheckMasterController")
public class StoreCheckMasterController {
	/**
	 * Logger for this class
	 */
//	private static final Logger logger = Logger.getLogger(StoreCheckMasterController.class);

	@Autowired
	private StoreCheckMasterServiceI storeCheckMasterService;
	@Autowired
//	private SystemService systemService;
	private String message;
	

}
