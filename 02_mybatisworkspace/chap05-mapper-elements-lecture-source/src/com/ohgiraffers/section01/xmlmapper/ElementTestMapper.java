package com.ohgiraffers.section01.xmlmapper;

import java.util.List;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;

public interface ElementTestMapper {
	
	List<String> selectCacheTest();

	List<MenuDTO> selectResultMapTest();

	List<MenuDTO> selectResultMapConstructorTest();

	List<MenuAndCategoryDTO> selectResultMapAssociationTest();

	List<CategoryAndMenuDTO> selectResultMapCollectionTest();

	List<MenuDTO> selectSqlTest();

	int insertMenuTest(MenuDTO menu);

	int insertNewMenu(MenuAndCategoryDTO menuAndCategory);

	int insertNewCategory(MenuAndCategoryDTO menuAndCategory);

}
