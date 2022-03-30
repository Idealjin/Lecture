package com.ohgiraffers.section01.programmatic.model.dao;

import com.ohgiraffers.section01.programmatic.model.dto.OrderDTO;
import com.ohgiraffers.section01.programmatic.model.dto.OrderMenuDTO;

public interface OrderMapper {

	int insertOrder(OrderDTO order);

	int insertOrderMenu(OrderMenuDTO orderMenu);
	
}
