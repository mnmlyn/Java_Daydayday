package com.mnmlyn.service;

import java.util.List;

import com.mnmlyn.bean.UserAddress;

/**
 * 用户服务
 */
public interface UserService  {
	public List<UserAddress> getUserAddressList(String userId);
}
