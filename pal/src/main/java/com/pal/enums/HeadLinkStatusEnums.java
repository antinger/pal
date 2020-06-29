package com.pal.enums;

public enum HeadLinkStatusEnums {

	PASS(0), NoPASS(1);
	
	private Integer headLinkStatus;
	
	private HeadLinkStatusEnums(Integer headLinkStatus) {
		this.headLinkStatus = headLinkStatus;
	}

	public Integer getHeadLinkStatus() {
		return headLinkStatus;
	}

}
