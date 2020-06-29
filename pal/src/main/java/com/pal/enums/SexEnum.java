package com.pal.enums;

public enum SexEnum {
	
	MAN(0), WOMAN(1);
	
	private Integer sex;
	
	private SexEnum(Integer sex) {
		this.sex = sex;
	} 

	public Integer getSex() {
		return sex;
	}

}
