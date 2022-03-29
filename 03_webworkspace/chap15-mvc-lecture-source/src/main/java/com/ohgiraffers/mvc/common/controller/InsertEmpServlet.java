package com.ohgiraffers.mvc.common.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String empName = request.getParameter("empName");
		String empNo = request.getParameter("empNo");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String deptCode = request.getParameter("deptCode");
		String jobCode = request.getParameter("jobCode");
		String salLevel = request.getParameter("salLevel");
		int salary = Integer.parseInt(request.getParameter("salary"));
		double bonus =Double.parseDouble(request.getParameter("bonus"));
		String managerId =request.getParameter("managerId");
		java.sql.Date hireDate = java.sql.Date.valueOf(request.getParameter("hireDate"));
		
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmpName(empName);
		emp.setEmpNo(empNo);
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setDeptCode(deptCode);
		emp.setJobCode(jobCode);
		emp.setSalLevel(salLevel);
		emp.setSalary(salary);
		emp.setBonus(bonus);
		emp.setManagerId(managerId);
		emp.setHireDate(hireDate);
		
		System.out.println("insert request emp : " + emp);
		
		EmployeeService empService = new EmployeeService();
		int result = empService.insertEmp(emp);
		
		String path = "";
		if(result > 0) {
//			response.sendRedirect(request.getContextPath() + "/WEB-INF/views/common/successPage.jsp");
			response.sendRedirect(request.getContextPath());
//			path= "/WEB-INF/views/common/successPage.jsp";
//			request.setAttribute("successCode", "insertEmp");
		} else {
			path= "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "신규 직원 등록에 실패하셨습니다.");
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}

}
