package com.mnmlyn.service;

import java.util.List;
import com.mnmlyn.bean.UserAddress;

public interface OrderService {
	/**
	 * ��ʼ������
	 * @param userId
	 */
	public List<UserAddress> initOrder(String userId);
}
