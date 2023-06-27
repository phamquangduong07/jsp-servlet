package com.laptrinhjavaweb.model;

public class RoleModel extends AbstractModel{
	/*
	 * id bigint NOT NULL PRIMARY KEY auto_increment, name VARCHAR(255) NOT NULL,
	 * code VARCHAR(255) NOT NULL, createddate TIMESTAMP NULL, modifieddate
	 * TIMESTAMP NULL, createdby VARCHAR(255) NULL, modifiedby VARCHAR(255) NULL
	 */
	private String code;
	private String name;


	// Model là nơi luân chuyển dữ liệu
	
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
	

}
