package com.ohgiraffers.mvc.employee.model.dao;

import java.util.List;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

public interface EmployeeMapper {

	EmployeeDTO selectEmpById(String empId);

	List<EmployeeDTO> selectAllEmpList();

	int insertEmp(EmployeeDTO emp);

	

}
