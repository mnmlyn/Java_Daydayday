package com.mnmlyn.service.impl;

import java.util.Arrays;
import java.util.List;

import com.mnmlyn.bean.UserAddress;
import com.mnmlyn.service.UserService;

public class UserServiceImpl implements UserService {

	public List<UserAddress> getUserAddressList(String userId) {
		UserAddress address1 = new UserAddress(1, "宇宙中国村", "1", "18812345678");
		UserAddress address2 = new UserAddress(2, "另一个宇宙", "1", "18887654321");

		return Arrays.asList(address1, address2);
	}

}
