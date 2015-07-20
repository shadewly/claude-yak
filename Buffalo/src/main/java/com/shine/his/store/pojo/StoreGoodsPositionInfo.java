package com.shine.his.store.pojo;
import java.util.Date;
/**
 * 
 * Class Name:StoreGoodsPositionInfo
 * Function:TODO(简单描述功能)
 * @author panda
 * @version (版本1.0)
 */
public class StoreGoodsPositionInfo {
	/**
	 * 货位编号
	 */
	private  String storeGoodsPositionCode;
	/**
	 * 货架编号
	 */
	private  String storeShelfCode;
	/**
	 * 货位状态
	 */
	private  String status;
	/**
	 * 货位内容
	 */
	private  String goodsContent;
	/**
	 * 货位创建时间
	 */
	private  Date createTime;
	/**
	 * 货位修改时间
	 */
	private  Date modifyTime;
	/**
	 * 备注
	 */
	private  String remark;
	
	public String getStoreGoodsPositionCode() {
		return storeGoodsPositionCode;
	}
	public void setStoreGoodsPositionCode(String storeGoodsPositionCode) {
		this.storeGoodsPositionCode = storeGoodsPositionCode;
	}
	public String getStoreShelfCode() {
		return storeShelfCode;
	}
	public void setStoreShelfCode(String storeShelfCode) {
		this.storeShelfCode = storeShelfCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
