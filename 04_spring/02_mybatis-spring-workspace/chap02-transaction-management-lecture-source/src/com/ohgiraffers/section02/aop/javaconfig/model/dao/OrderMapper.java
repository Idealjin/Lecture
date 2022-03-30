package com.ohgiraffers.section02.aop.javaconfig.model.dao;

import com.ohgiraffers.section02.aop.javaconfig.model.dto.OrderDTO;
import com.ohgiraffers.section02.aop.javaconfig.model.dto.OrderMenuDTO;

public interface OrderMapper {

	int insertOrder(OrderDTO order);

	int insertOrderMenu(OrderMenuDTO orderMenu);
	
}
