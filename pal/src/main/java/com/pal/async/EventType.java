package com.pal.async;

public enum EventType {
	
	PAY(1);

	private Integer type;
	
	private EventType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
