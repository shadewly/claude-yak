package com.shine.his.store.pojo;

import java.io.Serializable;

/**
 * Class Name:SupplyTypeDict
 * Function:供应商字典
 * @author ducheng
 * @version 1.0
 */
public class SupplyTypeDict implements Serializable {
	private static final long serialVersionUID = 3888829105780578541L;
	private String code;
	private String name;
	/**
	 * 输入码，名称简拼
	 */
	private String inputCode;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInputCode() {
		return inputCode;
	}
	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((inputCode == null) ? 0 : inputCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupplyTypeDict other = (SupplyTypeDict) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (inputCode == null) {
			if (other.inputCode != null)
				return false;
		} else if (!inputCode.equals(other.inputCode))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SupplyTypeDict [code=" + code + ", name=" + name
				+ ", inputCode=" + inputCode + "]";
	}
	
}
