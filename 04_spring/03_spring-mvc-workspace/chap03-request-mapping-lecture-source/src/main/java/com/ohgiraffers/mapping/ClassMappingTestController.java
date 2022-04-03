package com.ohgiraffers.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RequestMapping 어노테이션은 클래스 레벨에도 사용이 가능하다.
/*
 * 클래스 레벨에 URL을 공통 부분을 이용해 설정하고 나면 매번 핸들러 메소드에 URL의 중복되는
 * 내용을 작성하지 않아도 된다.
 * 이때 와일드 카드를 이용해서 조금 더 포괄적인 URL패턴을 설정할 수 있다.
 * 
 * 
 * */

@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

	@GetMapping("/regist")
	public String registOrder(Model model) {
	
		model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메소드 호출함...");
		
		return "mappingResult";
	}
	
	@RequestMapping(value= {"modify", "delete"}, method = RequestMethod.POST)
	public String modifyAndDelete(Model model) {
		model.addAttribute("message", "POST방식의 주문 정보 수정과 주문 삭제 공통 처리용 메소드 호출함...");
	
		return "mappingResult";
	}
	
	//PathVariable로 전달되는 값은 반드시 매개변수 이름이 동일해야 한다.
	// 동일하지않을경우 @PathVariable("이름")을 설정해줘야한다.
	@GetMapping("/detail/{orderNo}")
	public String selectOrderDetail(Model model, @PathVariable int orderNo) {
		
		model.addAttribute("message", orderNo + "번 주문 상세 내용 조회용 핸들러 메소드 호출함...");
		
		return "mappingResult";
	}
	
}
