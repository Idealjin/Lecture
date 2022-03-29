package com.ohgiraffers.section02.service.model.dto;

public class CategoryDTO {
	
	private int code;
	private String name;
	private Integer refCategoryCode;
	//혼자 Integer인 이유 -> int에 null이 안들어가는데 카테코리 DB를 보면 널을 포함하기때문에 Wrapper클래스 형태로 쓴것
	
	
	public CategoryDTO() {
		super();
	}

	public CategoryDTO(int code, String name, Integer refCategoryCode) {
		super();
		this.code = code;
		this.name = name;
		this.refCategoryCode = refCategoryCode;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRefCategoryCode() {
		return refCategoryCode;
	}

	public void setRefCategoryCode(Integer refCategoryCode) {
		this.refCategoryCode = refCategoryCode;
	}

	
	
}

