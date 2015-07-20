package com.shine.his.store.web;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.Scope;

import com.alibaba.fastjson.JSONObject;
import com.shine.his.store.pojo.PurchaseApplicationMaster;
import com.shine.his.store.service.IPurchaseApplicationService;

/**
 * 
 * Class Name:PurchaseApplicationView
 * Function:TODO(简单描述功能)
 * @author lily
 * @version (版本1.0)
 */
@Path("/purchaseApplication")
@Singleton
public class PurchaseApplicationView {
	private IPurchaseApplicationService purchaseApplicationService;
	
	/**
	 * 
	 * addPurchaseApplication:(添加采购).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param str
	 */
	@POST
	@Path("/addPurchase")
	@Produces(MediaType.APPLICATION_JSON )
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPurchaseApplication(String str){
		try {
			PurchaseApplicationMaster applicationForm = (PurchaseApplicationMaster)JSONObject.parse(str);
			purchaseApplicationService.addApplication(applicationForm);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 
	 * deleteApplication:(删除申请采购计划).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param storeProcurementPlanNo
	 */
	@POST
	@Path("/deletePurchase")
	@Produces(MediaType.APPLICATION_JSON )
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteApplication(String storeProcurementPlanNo){
		try {			
			purchaseApplicationService.deleteApplicationMaster(storeProcurementPlanNo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@POST
	@Path("/deletePurchaseOne")
	@Produces(MediaType.APPLICATION_JSON )
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteApplicationOne(String procurementPlanDetailId){
		try {			
			purchaseApplicationService.deleteApplicationDetail(procurementPlanDetailId);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 
	 * updateApplication:(修改采购申请单).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param str
	 */
	@POST
	@Path("/updatePurchase")
	@Produces(MediaType.APPLICATION_JSON )
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateApplication(String str){
		try {
			PurchaseApplicationMaster applicationForm = (PurchaseApplicationMaster)JSONObject.parse(str);
			purchaseApplicationService.updateApplicationAll(applicationForm);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 
	 * updateApplicationStatus:(更新申请单状态).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param str
	 */
	@POST
	@Path("/updateApplStatus")
	@Produces(MediaType.APPLICATION_JSON )
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateApplicationStatus(String str){
		try {
			PurchaseApplicationMaster applicationForm = (PurchaseApplicationMaster)JSONObject.parse(str);
			purchaseApplicationService.updateApplicationStatusByID(applicationForm);;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 
	 * submitApplication:(提交申请单).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 */
	@POST
	@Path("/submitApplication")
	@Produces(MediaType.APPLICATION_JSON )
	@Consumes(MediaType.APPLICATION_JSON)
	public void submitApplication(String str){
		try {
			PurchaseApplicationMaster applicationForm = (PurchaseApplicationMaster)JSONObject.parse(str);
			purchaseApplicationService.submitApplication(applicationForm);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 
	 * auditApplication:(审核申请单).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param str
	 */
	@POST
	@Path("/auditApplication")
	@Produces(MediaType.APPLICATION_JSON )
	@Consumes(MediaType.APPLICATION_JSON)
	public void auditApplication(String str){
		try {
			PurchaseApplicationMaster applicationForm = (PurchaseApplicationMaster)JSONObject.parse(str);
			purchaseApplicationService.submitApplication(applicationForm);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 
	 * getPurchaseApplication:(查询采购申请单).<br/>
	 * TODO:(描述方法的适用条件-可选).<br/>
	 * @param str
	 */
	@POST
	@Path("/getPurchase")
	@Produces(MediaType.APPLICATION_JSON )
	@Consumes(MediaType.APPLICATION_JSON)
	public void getPurchaseApplication(String str){
		try {
			PurchaseApplicationMaster applicationForm = (PurchaseApplicationMaster)JSONObject.parse(str);
			purchaseApplicationService.getApplicationMaster(applicationForm);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
