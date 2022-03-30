package com.ohgiraffers.section02.aop.javaconfig.model.service;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ohgiraffers.section02.aop.javaconfig.model.dao.OrderMapper;
import com.ohgiraffers.section02.aop.javaconfig.model.dto.OrderDTO;
import com.ohgiraffers.section02.aop.javaconfig.model.dto.OrderMenuDTO;




@Service("orderService")
public class OrderServiceImpl implements OrderService{

	private SqlSessionTemplate sqlSession;

	
	@Autowired
	public OrderServiceImpl(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
		
	}
	
	
	/*class레벨에 작성하면 모든 public 메소드에 적용된다.
	 * 메소드 레벨에는 어노테이션이 작성된 메소드만 트랜잭션 처리를 진행한다.
	 * 
	 * */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE,
			rollbackFor = {Exception.class})
	public int registOrder(OrderDTO order) throws Exception {
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		int orderResult = orderMapper.insertOrder(order);
		List<OrderMenuDTO> orderMenuList = order.getMenuList(); 
		int orderMenuResult = 0;
		
		for(OrderMenuDTO orderMenu : orderMenuList) {
			orderMenuResult += orderMapper.insertOrderMenu(orderMenu);
		}
		
		int result = 0;
		if(orderResult > 0 && orderMenuResult == orderMenuList.size()) {
			result = 1;
//			throw new Exception("테스트를 위해 Exception발생");
		}
		
		return result;
	}
	

}
