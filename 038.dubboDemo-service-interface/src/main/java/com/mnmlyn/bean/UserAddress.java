package com.mnmlyn.bean;

import java.io.Serializable;

public class UserAddress implements Serializable {
	private Integer id;
	private String userAddress;
	public String getUserAddress() {
		return userAddress;
	}

	private String userId;
	private String phoneNum;
	
	public UserAddress(Integer id, String userAddress, String userId, String phoneNum) {
		super();
		this.id = id;
		this.userAddress = userAddress;
		this.userId = userId;
		this.phoneNum = phoneNum;
	}
	
	public UserAddress() {
		super();
	}
}
