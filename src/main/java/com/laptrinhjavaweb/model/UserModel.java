package com.laptrinhjavaweb.model;

public class UserModel extends AbstractModel<UserModel>{
	/*
	 *  id bigint NOT NULL PRIMARY KEY auto_increment,
  username VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  fullname VARCHAR(150) NULL,
  status int NOT NULL,
  roleid bigint NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
	 */
	
	private String userName;
	private String fullName;
	private String password;
	private int status;
	private Long roleId;
	private RoleModel role= new RoleModel();


	@Override
	public String toString() {
		return "UserModel{" +
				"userName='" + userName + '\'' +
				", fullName='" + fullName + '\'' +
				", password='" + password + '\'' +
				", status=" + status +
				", role=" + role +
				'}';
	}

	//Model là nơi luân chuyển dữ liệu
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public RoleModel getRole() {
		return role;
	}
	public void setRole(RoleModel role) {
		this.role = role;
	}
	
	
	
	
}
