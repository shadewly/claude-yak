package com.shine.his.store.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shine.his.common.exception.HISException;
import com.shine.his.common.web.BaseResource;
import com.shine.his.store.pojo.StoreCheckMaster;
import com.shine.his.store.service.IStoreCheckService;
import com.shine.his.store.service.IStoreDrugDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;

/**
 * Created by claude on 15-7-8.
 * 盘点资源
 */
@Path("storeCheck")
public class StoreCheck extends BaseResource {
    @Autowired
    private IStoreCheckService storeCheckService;
    private IStoreDrugDetailService storeDrugDetailService;

    @GET
    @Path("newCheckNo")
    @Produces("application/json")
    public String newCheckNo() {
        return new JSONObject().put("newCheckNo", storeCheckService.newCheckNo()).toString();
    }

    @PUT
    @Path("newStoreCheck")
    @Produces("application/json")
    @Consumes("application/json")
    public String newStoreCheck(String masterStr) {
        StoreCheckMaster master = JSON.parseObject(masterStr, StoreCheckMaster.class);
        try {
            return toJSONStringStatus(storeCheckService.saveStoreCheck(master) == null);
        } catch (HISException e) {
            e.printStackTrace();
            return toJSONStringException(e);
        }
    }

}
