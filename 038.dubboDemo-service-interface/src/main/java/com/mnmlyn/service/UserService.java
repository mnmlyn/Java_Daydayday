package com.mnmlyn.service;

import java.util.List;

import com.mnmlyn.bean.UserAddress;

/**
 * �û�����
 */
public interface UserService  {
	public List<UserAddress> getUserAddressList(String userId);
}
