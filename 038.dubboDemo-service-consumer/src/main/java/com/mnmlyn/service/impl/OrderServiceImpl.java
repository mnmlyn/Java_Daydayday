package com.mnmlyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnmlyn.bean.UserAddress;
import com.mnmlyn.service.OrderService;
import com.mnmlyn.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	UserService userService;
	public void initOrder(String userId) {
		System.out.println("�û�IDΪ��" + userId);
		// 1.��ѯ�û����ջ��ַ
		List<UserAddress> userAddressList = userService.getUserAddressList(userId);
		for (UserAddress userAddress : userAddressList) {
			System.out.println(userAddress.getUserAddress());
		}
	}

}
