package com.ohgiraffers.mvc.employee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;


@WebServlet("/employee/select")
public class SelectOneEmpByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empId = request.getParameter("empId"); //파라미터의 key값은 input태그의 name 값이다.
		System.out.println("empId : " + empId);
		
		//사번을 이용해 사원 정보를 조회하는 비즈니스 로직 호출
		EmployeeService empService = new EmployeeService();
		EmployeeDTO selectEmp = empService.selectOneEmpById(empId);
		
		System.out.println("selectedEmp : " + selectEmp);
		
		//비지니스 로직 실행 결과에 따라 뷰 연결
		String path = "";
		if(selectEmp != null) {
			path = "/Web-INF/view/employee/showEmpInfo.jsp";
			request.setAttribute("selectedEmp", selectEmp);
		} else {
			path = "/Web-INF/view/common/errorPage.jsp";
			request.setAttribute("message", "직원정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
