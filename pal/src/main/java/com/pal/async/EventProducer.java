package com.pal.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.pal.utils.JedisAdapter;
import com.pal.utils.JedisKeyUtils;

@Service
public class EventProducer {

	@Autowired
	JedisAdapter jedisAdapter;
	
	public void fireEvent(EventModel eventModel) {
		String key = JedisKeyUtils.getEventKey();
		jedisAdapter.lpush(key, JSON.toJSONString(eventModel));
	}
	
}
