package com.ohgiraffers.section01.programmatic.model.service;

import com.ohgiraffers.section01.programmatic.model.dto.OrderDTO;

public interface OrderService {

	int registOrder(OrderDTO order);
	
	int registOrder2(OrderDTO order);
}
