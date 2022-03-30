package com.ohgiraffers.section02.aop.javaconfig.model.service;

import com.ohgiraffers.section02.aop.javaconfig.model.dto.OrderDTO;

public interface OrderService {

	int registOrder(OrderDTO order) throws Exception;

}
