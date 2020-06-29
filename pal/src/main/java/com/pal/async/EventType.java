package com.pal.async;

public enum EventType {
	
	PAY(1), VISA(2);

	private Integer type;
	
	private EventType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

}
