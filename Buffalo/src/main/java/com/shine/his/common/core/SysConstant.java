package com.shine.his.common.core;

/**
 * 
 * Class Name:SysConstant Function:TODO(系统常量)
 * 
 * @author yuxinchen
 * @version (1.0)
 */
public class SysConstant {
	/** 系统字典map集合 */
	public static final String SYS_DICT_MAP = "sysDictMap";

	/**
	 * 入库状态map集合常量
	 */
	public static final String STORE_DRUG_IN_STATUS = "1001";

	/**
	 * 出库状态map集合常量
	 */
	public static final String STORE_DRUG_OUT_STATUS = "1007";
	/**
	 * 入库单常量
	 */
	public static final String STORE_DRUG_IN_MASTER = "storeDrugInMaster";
	/**
	 * 采购计划单常量
	 */
	public static final String STORE_PROC_PLAN_NO = "storeProcurementPlanNo";

	/**
	 * 入库单类型枚举类 Class Name:StoreInOrderType Function:TODO(简单描述功能)
	 * 
	 * @author yuxinchen
	 * @version (1.0)
	 */
	public static enum StoreInOrderType {
		PURCHASE_IN_STORE("1002", "采购计划入库"), PHARMACY_IN_STORE("1003",
				"药房退库再入库"), DEPT_IN_STORE("1004", "科室退库再入库"), ALLOT_IN_STORE(
				"1005", "药品调拨入库"), RE_ALLOT_IN_STORE("1006", "调拨出库再入库");
		private String v;

		private String index;

		private String value;

		StoreInOrderType(String index) {
			v = value;
		}

		StoreInOrderType(String index, String value) {
			this.index = index;
			this.value = value;
		}

		public static String getValue(String index) {
			for (StoreInOrderType c : StoreInOrderType.values()) {
				if (c.getIndex().equals(index)) {
					return c.getValue();
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return v;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	/**
	 * 出库单类型枚举类 Class Name:StoreInOrderType Function:TODO(简单描述功能)
	 * 
	 * @author yuxinchen
	 * @version (1.0)
	 */
	public static enum StoreOutOrderType {
		DEPT_OUT_STORE("1008", "药房科室出库"), RETURN_OUT_STORE("1009",
				"供应商退货出库 "), BREAK_OUT_STORE("1010", "药品报损出库"), ALLOT_OUT_STORE(
				"1011", "药品调拨出库");
		private String v;

		private String index;

		private String value;

		StoreOutOrderType(String index) {
			v = value;
		}

		StoreOutOrderType(String index, String value) {
			this.index = index;
			this.value = value;
		}

		public static String getValue(String index) {
			for (StoreOutOrderType c : StoreOutOrderType.values()) {
				if (c.getIndex().equals(index)) {
					return c.getValue();
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return v;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

}
