package com.bhz.eps.dao;

import com.bhz.eps.entity.NozzleOrder;

public interface NozzleOrderDao {
	public void addOrder(NozzleOrder order);
	public NozzleOrder getOrder();
}
