package com.ohgiraffers.section02.aop.xmlconfig.model.service;

import com.ohgiraffers.section02.aop.xmlconfig.model.dto.OrderDTO;

public interface OrderService {

	int registOrder(OrderDTO order) throws Exception;

}
