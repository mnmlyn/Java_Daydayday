package com.mnmlyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mnmlyn.bean.UserAddress;
import com.mnmlyn.service.OrderService;
import com.mnmlyn.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {
	
	//@Autowired
	@Reference
	UserService userService;
	public List<UserAddress> initOrder(String userId) {
		System.out.println("用户ID为：" + userId);
		// 1.查询用户的收货地址ַ
		List<UserAddress> userAddressList = userService.getUserAddressList(userId);
		return userAddressList;
	}

}
