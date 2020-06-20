package com.pal.async;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pal.utils.JedisAdapter;
import com.pal.utils.JedisKeyUtils;

@Service
public class EventConsumer implements InitializingBean, ApplicationContextAware {
	
	@Autowired
	JedisAdapter jedisAdapter;

	private ApplicationContext applicationContext;
	
	private Map<EventType, List<EventHandler>> config = new HashMap<EventType, List<EventHandler>>();
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);
		for (Entry<String, EventHandler> entry : beans.entrySet()) {
			for (EventType type : entry.getValue().getSupportEventType()) {
				if(!config.containsKey(type)) {
					config.put(type, new ArrayList<EventHandler>());
				}
				config.get(type).add(entry.getValue());
			}
		}
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					String key = JedisKeyUtils.getEventKey();
					List<String> messages = jedisAdapter.brpop(key);
					System.out.println("消费者运转中");
					for(String message : messages) {
						if(message.equals(key)) {
							continue;
						}
						EventModel eventModel = JSONObject.parseObject(message, EventModel.class);
						if(!config.containsKey(eventModel.getEventType())) {
							continue;
						}
						System.out.println("获取到的数据" + message);
						for(EventHandler eventHandler : config.get(eventModel.getEventType())) {
							eventHandler.handler(eventModel);
						}
					}
				}
			}
		});
		thread.start();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
}
