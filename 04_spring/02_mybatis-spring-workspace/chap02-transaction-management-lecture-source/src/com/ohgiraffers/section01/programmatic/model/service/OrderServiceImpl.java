package com.ohgiraffers.section01.programmatic.model.service;

import java.sql.SQLException;
import java.util.List;

import org.aspectj.apache.bcel.util.DefaultClassLoaderReference;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.ohgiraffers.section01.programmatic.model.dao.OrderMapper;
import com.ohgiraffers.section01.programmatic.model.dto.OrderDTO;
import com.ohgiraffers.section01.programmatic.model.dto.OrderMenuDTO;


@Service("orderService")
public class OrderServiceImpl implements OrderService{

	private SqlSessionTemplate sqlSession;
	private DataSourceTransactionManager transactionManager;
	
	@Autowired
	public OrderServiceImpl(SqlSessionTemplate sqlSession, DataSourceTransactionManager transactionManager) {
		this.sqlSession = sqlSession;
		this.transactionManager = transactionManager;
		
	}
	
	@Override
	public int registOrder(OrderDTO order) {
		
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
			sqlSession.commit();
		}
		
		return result;
	}

	@Override
	public int registOrder2(OrderDTO order) {
		
		//트랜젝션에 대한 설정 정보를 담고 있는 객체
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		
		//이미 하나의 트랜젝션이 존재한다면 이후의 트랜젝션은 그 트랜잭션을 지원하고
		//트랜젝션이 없다면 새로운 트랜젝션을 시작한다는 의미이다.
		
		//전파행위 옵션
		
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		//격리 레벨
		
		def.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_SERIALIZABLE);
		
		//트랜잭션을 수동으로 할 수 있도록 설정한다.
		try {
			sqlSession.getConnection().setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
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
			transactionManager.commit(status);
		}else {
			transactionManager.rollback(status);
		}
		
		return result;
	
	}

}
