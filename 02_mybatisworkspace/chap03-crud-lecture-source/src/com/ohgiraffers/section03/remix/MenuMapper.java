package com.ohgiraffers.section03.remix;
//mapper 소스폴더에 패키지를 동일하게 만든다.
import java.util.List;

//mappers소스폴더에 동일한 이름의 xml을 만든다.
public interface MenuMapper {
	
	List<MenuDTO> selectAllMenu();

	MenuDTO selectMenuByCode(int code);

	int insertMenu(MenuDTO menu);

	int updateMenu(MenuDTO menu);

	int deleteMenu(MenuDTO menu);
	
}
