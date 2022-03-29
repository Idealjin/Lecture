package com.ohgiraffers.section03.layertests.model.dao;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ohgiraffers.section03.layertests.model.dto.CategoryDTO;
import com.ohgiraffers.section03.layertests.model.dto.OrderDTO;

public class OrderDAOTests {

	private Connection con;
	private OrderDAO orderDAO;
	private OrderDTO order;
	
	@Before
	public void setup() {
		con = getConnection();
		orderDAO = new OrderDAO();
		order.setDate("22/02/17");
		order.setTime("12:04:15");
		order.setTotalOrderPrice(30000);
		
	}
	
	@Test
	@Ignore
	public void testSelectAllCategory() {
		
		List<CategoryDTO> categoryList = orderDAO.selectAllCategory(con);
		
		assertNotNull(categoryList);
		
	}
	
	@Test
	public void testInsertOrder() {
		
		int result = orderDAO.insertOrder(con, order);
		
		assertEquals(1, result);
	}
	
	
}
