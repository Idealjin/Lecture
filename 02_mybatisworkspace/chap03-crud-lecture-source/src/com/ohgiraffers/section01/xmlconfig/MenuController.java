package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {

	private MenuService menuService; //= new MenuService();
	private PrintResult printResult;
	
	public MenuController() {
		menuService = new MenuService();
		printResult = new PrintResult();
	}
	
	public void selectAllMenu() {
		
		List<MenuDTO> menuList = menuService.selectAllMenu();
		
		if(menuList != null) {
			printResult.printMenuList(menuList);
		} else {
			printResult.printErrorMessage("selectList");
			
		}
		
	}

	public void selectMenuByCode(Map<String, String> parameter) {
	
	int code = Integer.parseInt(parameter.get("code"));	

	MenuDTO menu = menuService.selectMenuByCode(code);
	
	if(menu != null) {
		printResult.printMenuList(menu);
	} else {
		printResult.printErrorMessage("selectOne");
	}
	
	}

	public void registMenu(Map<String, String> parameter) {
		
		String name = parameter.get("name");
		int price = Integer.parseInt(parameter.get("price"));
		int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
		
		MenuDTO menu = new MenuDTO();
		menu.setName(name);
		menu.setPrice(price);
		menu.setCategoryCode(categoryCode);
		
		if(menuService.registMenu(menu)) {			//성공 실패여부가 중요하므로 불린값으로 사용해도 된다.
			printResult.printSuccesMessage("insert");
		} else {
			printResult.printErrorMessage("insert");
		}
		
	}

	public void updateMenuByCode(Map<String, String> parameter) {
		
		int code = Integer.parseInt(parameter.get("code"));	
		String name = parameter.get("name");
		int price = Integer.parseInt(parameter.get("price"));
		int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
		String orderableStatus = parameter.get("orderableStatus");
	
		MenuDTO menu = new MenuDTO();
		menu.setCode(code);
		menu.setName(name);
		menu.setPrice(price);
		menu.setCategoryCode(categoryCode);
		menu.setOrderableStatus(orderableStatus);
		
		
		if(menuService.updateMenuByCode(menu)) {
			printResult.printSuccesMessage("update");
		} else {
			printResult.printErrorMessage("update");
		}
	}

	public void deleteMenuByCode(Map<String, String> parameter) {
		int code = Integer.parseInt(parameter.get("code"));	
		MenuDTO menu = new MenuDTO();
		menu.setCode(code);
		
		if(menuService.deleteMenuByCode(menu)) {
			printResult.printSuccesMessage("delete");
		} else {
			printResult.printErrorMessage("delete");
		}
		
	}

}
