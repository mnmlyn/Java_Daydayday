package com.mnmlyn.service.impl;

import java.util.Arrays;
import java.util.List;

import com.mnmlyn.bean.UserAddress;
import com.mnmlyn.service.UserService;

public class UserServiceImpl implements UserService {

	public List<UserAddress> getUserAddressList(String userId) {
		UserAddress address1 = new UserAddress(1, "�����й���", "1", "18812345678");
		UserAddress address2 = new UserAddress(2, "��һ������", "1", "18887654321");

		return Arrays.asList(address1, address2);
	}

}
