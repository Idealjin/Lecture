package com.ohgiraffers.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class ExceptionHandlerController {

		@GetMapping("simple-null")
		public String simpleNullPointerExceptionTest() {
			String str = null;
			System.out.println(str.charAt(0));
			
			return "main";
		}
		
		@GetMapping("simple-user")
		public String simpleUserExceptionTest() throws MemberRegistException {
			boolean check = true;
			
			if(check) {
				throw new MemberRegistException("당신 같은 사람은 회원으로 받을 수 없습니다!");
			}
			
			return "main";
		}
		
		@GetMapping("annotation-null")
		public String annotationNullPointerExceptionTest() {
			String str = null;
			
			System.out.println(str.charAt(0));
			
			return "main";
		}
	
		@ExceptionHandler(NullPointerException.class)
		public String nullPointerExcetionHandler(NullPointerException exception) {
			System.out.println("여기 핸들러로 오는게 맞는지 확인!");
			
			return "error/nullPointer";
		}
		
		@GetMapping("annotation-user")
		public String annotationUserExceptionTest() throws MemberRegistException {
			boolean check = true;
			if(check) {
				throw new MemberRegistException("당신 같은 사람은 회원으로 받을 수 없다고!");
			}
			return "main";
		}
	
		@ExceptionHandler(MemberRegistException.class)
		public String userExceptionHandler(Model model, MemberRegistException exception) {
			
			model.addAttribute("exception", exception);
			
			return "error/memberRegist";
		}
		
}
