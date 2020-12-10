package com.thxy.pojo;

import com.mysql.fabric.xmlrpc.base.Data;

public class User {
	
	private Integer id;
	private String userCode;
	private String userName;
	private String userPassword;
	private Integer gender;
	private Data creationDate;
	private Integer modifyBy;
	private Data modifyDate;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Data getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Data creationDate) {
		this.creationDate = creationDate;
	}
	public Data getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Data modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", gender=" + gender + ", creationDate=" + creationDate + ", modifyBy=" + modifyBy + ", modifyDate="
				+ modifyDate + "]";
	}

}