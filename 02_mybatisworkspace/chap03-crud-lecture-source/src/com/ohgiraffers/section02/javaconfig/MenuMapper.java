package com.ohgiraffers.section02.javaconfig;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;


public interface MenuMapper {
	@Results(id="menuResultMap", value = {
			 @Result(id = true, property = "code", column = "MENU_CODE"),
			 @Result(property = "name", column = "MENU_NAME"),
			 @Result(property = "price", column = "MENU_PRICE"),
			 @Result(property = "categoryCode", column = "CATEGORY_CODE"),
			 @Result(property = "orderableStatus", column = "ORDERABLE_STATUS")
	})
	@Select("		SELECT\n"
			+ "	    	   A.MENU_CODE\n"
			+ "	    	 , A.MENU_NAME\n"
			+ "	    	 , A.MENU_PRICE\n"
			+ "	    	 , A.CATEGORY_CODE\n"
			+ "	    	 , A.ORDERABLE_STATUS\n"
			+ "	      FROM TBL_MENU A\n"
			+ "	     WHERE A.ORDERABLE_STATUS = 'Y'\n"
			+ "	     ORDER BY A.MENU_CODE")
	List<MenuDTO> selectAllMenu();

	@Select("		SELECT\n"
			+ "	    	   A.MENU_CODE\n"
			+ "	    	 , A.MENU_NAME\n"
			+ "	    	 , A.MENU_PRICE\n"
			+ "	    	 , A.CATEGORY_CODE\n"
			+ "	    	 , A.ORDERABLE_STATUS\n"
			+ "	      FROM TBL_MENU A\n"
			+ "	     WHERE A.ORDERABLE_STATUS = 'Y'\n"
			+ "	       AND A.MENU_CODE = #{ code }")
	@ResultMap("menuResultMap")				//위에 사용한 resultmap을 재사용할 수 잇따.
	MenuDTO selectMenuByCode(int code);

	@Insert("	   INSERT\n"
			+ "	     INTO TBL_MENU A\n"
			+ "	   (\n"
			+ "	     A.MENU_CODE\n"
			+ "	   , A.MENU_NAME\n"
			+ "	   , A.MENU_PRICE\n"
			+ "	   , A.CATEGORY_CODE\n"
			+ "	   , A.ORDERABLE_STATUS\n"
			+ "	   )\n"
			+ "	   VALUES\n"
			+ "	   (\n"
			+ "	     SEQ_MENU_CODE.NEXTVAL\n"
			+ "	   , #{ name }\n"
			+ "	   , #{ price }\n"
			+ "	   , #{ categoryCode }\n"
			+ "	   , 'Y'\n"
			+ "	   )")	
	int insertMenu(MenuDTO menu);

	@Update("  	  UPDATE\n"
			+ "	  	     TBL_MENU A\n"
			+ "	     SET A.MENU_NAME = #{ name }\n"
			+ "	       , A.MENU_PRICE = #{ price }\n"
			+ "	       , A.CATEGORY_CODE = #{ categoryCode }\n"
			+ "	       , A.ORDERABLE_STATUS = #{ orderableStatus }\n"
			+ "	   WHERE A.MENU_CODE = #{ code } ")
	int updateMenu(MenuDTO menu);

	@Delete("  	  DELETE\n"
			+ "	  	FROM TBL_MENU A\n"
			+ "	   WHERE A.MENU_CODE = #{ code }")
	int deleteMenu(MenuDTO menu);

}
