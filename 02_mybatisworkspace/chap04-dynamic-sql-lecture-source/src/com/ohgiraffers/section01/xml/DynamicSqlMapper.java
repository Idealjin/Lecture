package com.ohgiraffers.section01.xml;

import java.util.List;
import java.util.Map;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;

public interface DynamicSqlMapper {

	List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);

//	List<MenuDTO> selectMenuByName(Map<String, String> map);

	List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

	List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

	List<MenuDTO> searchMenuByRandomMenuCode(Map<String, List<Integer>> criteria);

	List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria criteria);

	List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> searchCriteria);

	int modifyMenu(Map<String, Object> criteria);
	
}
