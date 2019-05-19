package com.mnmlyn.service;

import java.util.List;
import com.mnmlyn.bean.UserAddress;

public interface OrderService {
	/**
	 * ≥ı ºªØ∂©µ•
	 * @param userId
	 */
	public List<UserAddress> initOrder(String userId);
}
