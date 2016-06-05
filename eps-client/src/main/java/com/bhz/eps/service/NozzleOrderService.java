package com.bhz.eps.service;

import com.bhz.eps.entity.NozzleOrder;

public interface NozzleOrderService {
	public void addOrder(NozzleOrder order);
	public NozzleOrder getOrder();
}