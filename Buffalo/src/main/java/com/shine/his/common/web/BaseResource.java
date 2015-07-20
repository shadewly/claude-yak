package com.shine.his.common.web;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by claude on 15-7-20.
 */
public class BaseResource {
    protected final String STATUS_SUCCESS = "success";
    protected final String STATUS_FAILED = "failed";
    Logger logger = LoggerFactory.getLogger(this.getClass());

    protected String exceptionToJson(Exception e) {
        return JSONObject.toJSONString(e);
    }

    protected String toJSONStringException(Exception e, JSONObject jsonObject) {
        logger.error("Wrap error:" + e);
        jsonObject.put("error", e);
        return jsonObject.toString();
    }

    protected String toJSONStringException(Exception e) {
        JSONObject jsonObject = new JSONObject();
        return toJSONStringException(e, jsonObject);
    }

    protected String toJSONStringStatus(boolean success) {
        if (success) {
            return new JSONObject().put("status", STATUS_SUCCESS).toString();
        } else {
            return new JSONObject().put("status", STATUS_FAILED).toString();
        }
    }

    protected JSONObject toJSONObjectStatus(boolean success) {
        JSONObject jsonObject = new JSONObject();
        if (success) {
            jsonObject.put("status", STATUS_SUCCESS);
        } else {
            jsonObject.put("status", STATUS_FAILED);
        }
        return jsonObject;
    }
}
