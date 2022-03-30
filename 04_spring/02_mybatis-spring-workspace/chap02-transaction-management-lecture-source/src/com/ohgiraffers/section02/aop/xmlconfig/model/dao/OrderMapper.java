package com.ohgiraffers.section02.aop.xmlconfig.model.dao;

import com.ohgiraffers.section02.aop.xmlconfig.model.dto.OrderDTO;
import com.ohgiraffers.section02.aop.xmlconfig.model.dto.OrderMenuDTO;

public interface OrderMapper {

	int insertOrder(OrderDTO order);

	int insertOrderMenu(OrderMenuDTO orderMenu);
	
}
