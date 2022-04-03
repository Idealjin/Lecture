package com.ohgiraffers.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingTestController {

	// 1. 메소드에 요청 매핑하기
	//method 방식을 지정하지않으면 get,post 다 처리한다.
	@RequestMapping("/menu/regist")
	public String registMenu(Model model) {
		model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함...");
		
		return "mappingResult";
	}
	
	@RequestMapping(value="/menu/modify", method=RequestMethod.GET)
	public String modifyMenu(Model model) {
		model.addAttribute("message", "Get방식의 메뉴 수정용 핸들러 메소드 호출함...");
		
		return "mappingResult";
	}
	
	
	/* 요청 메소드 별 전용 어노테이션 
	 * 핸들러 메소드를 조금 더 간결하게 코딩할 수 있게 해준다.
	 * @PostMapping
	 * @GetMapping
	 * @DeleteMapping
	 * @PutMapping
	 * */

	@GetMapping("/menu/delete")
	public String getDeleteMenu(Model model) {
		model.addAttribute("message", "GET 방식의 삭제용 핸들러 메소드 호출함...");
		return "mappingResult";
	}
	
	@PostMapping("/menu/delete")
	public String postDeleteMenu(Model model) {
		model.addAttribute("message", "POST 방식의 삭제용 핸들러 메소드 호출함...");
		return "mappingResult";
	}
	

	
}
