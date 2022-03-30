package com.ohgiraffers.section02.mapperscan.model.service;

import java.util.List;

import com.ohgiraffers.section02.mapperscan.model.dto.MenuDTO;

public interface MenuService {

	List<MenuDTO> selectMenuList();
	
}
