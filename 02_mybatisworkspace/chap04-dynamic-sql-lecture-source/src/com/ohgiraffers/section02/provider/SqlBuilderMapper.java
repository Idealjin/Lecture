package com.ohgiraffers.section02.provider;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.ohgiraffers.common.MenuDTO;

public interface SqlBuilderMapper {

	@InsertProvider(type = SqlbuilderProvider.class, method="registMenu")
	int registMenu(MenuDTO menu);

	@UpdateProvider(type = SqlbuilderProvider.class, method="modifyMenu")
	int modifyMenu(MenuDTO menu);

	@DeleteProvider(type = SqlbuilderProvider.class, method="deleteMenu")
	int deleteMenu(int code);

	
	
}
