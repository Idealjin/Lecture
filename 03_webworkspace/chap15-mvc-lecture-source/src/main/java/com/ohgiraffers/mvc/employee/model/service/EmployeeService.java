package com.ohgiraffers.mvc.employee.model.service;


import org.apache.ibatis.session.SqlSession;
import static com.ohgiraffers.mvc.common.mybatis.Template.getSqlSession;

import java.util.List;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

public class EmployeeService {
	
	private EmployeeMapper mapper;

	public EmployeeDTO selectOneEmpById(String empId) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(EmployeeMapper.class);
		
		//SqlSession과 함께 정보를 전달하여 조회한다.
		EmployeeDTO selectedEmp = mapper.selectEmpById(empId);
		
		sqlSession.close();
		
		return selectedEmp;
	}

	public List<EmployeeDTO> selectAllEmp() {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(EmployeeMapper.class);
		
		List<EmployeeDTO> empList = mapper.selectAllEmpList();
		
		return empList;
	}

	public int insertEmp(EmployeeDTO emp) {
		
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(EmployeeMapper.class);
		
		int result = mapper.insertEmp(emp);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		
		return result;
	}

}
