package com.pal.async;

import java.util.List;

public interface EventHandler {

	void handler(EventModel eventModel);
	
	List<EventType> getSupportEventType();
	
}
