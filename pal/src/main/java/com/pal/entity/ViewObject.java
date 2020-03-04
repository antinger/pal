package com.pal.entity;

import java.util.HashMap;
import java.util.Map;

public class ViewObject {

	private Map<String, Object> view = new HashMap<String, Object>();

	public Map<String, Object> getView() {
		return view;
	}

	public void setView(String key, Object value) {
		this.view.put(key, value);
	}
	
}
