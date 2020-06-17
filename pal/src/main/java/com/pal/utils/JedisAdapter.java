package com.pal.utils;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class JedisAdapter implements InitializingBean {

	private JedisPool jedisPool;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("redis线程池生成");
		jedisPool = new JedisPool("localhost", 6379);
	}
	
	//从队列左边入队一个元素
	public void lpush(String key, String value) {
		Jedis jedis = getConnection();
		try {
			jedis.lpush(key, value);
		} catch (Exception e) {
			
		} finally {
			close(jedis);
		}
	}
	
	//从队列右边出队一个元素
	public String rpop(String key) {
		Jedis jedis = getConnection();
		try {
			return jedis.rpop(key);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}
	
	public List<String> brpop(String key) {
		Jedis jedis = getConnection();
		try {
			return jedis.brpop(0, key);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}
	
	public String lindex(String key, long index) {
		Jedis jedis = getConnection();
		try {
			return jedis.lindex(key, index);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}
	
	public List<String> lrange(String key, long start, long end) {
		Jedis jedis = getConnection();
		try {
			return jedis.lrange(key, start, end);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}
	
	public void set(String key, String value) {
		Jedis jedis = getConnection();
		try {
			jedis.set(key, value);
		} catch (Exception e) {
			
		} finally {
			close(jedis);
		}
	}
	
	public String get(String key) {
		Jedis jedis = getConnection();
		try {
			return jedis.get(key);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}
	
	public void append(String key, String value) {
		Jedis jedis = getConnection();
		try {
			jedis.append(key, value);
		} catch (Exception e) {
			
		} finally {
			close(jedis);
		}
	}
	
	public void del(String key) {
		Jedis jedis = getConnection();
		try {
			jedis.del(key);
		} catch (Exception e) {
			
		} finally {
			close(jedis);
		}
	}
	
	public void sadd(String key, String member) {
		Jedis jedis = getConnection();
		try {
			jedis.sadd(key, member);
		} catch (Exception e) {
			
		} finally {
			close(jedis);
		}
	}
	
	public void sadd(String key, String[] members) {
		Jedis jedis = getConnection();
		try {
			jedis.sadd(key, members);
		} catch (Exception e) {
			
		} finally {
			close(jedis);
		}
	}
	
	public boolean sismember(String key, String member) {
		Jedis jedis = getConnection();
		try {
			return jedis.sismember(key, member);
		} catch (Exception e) {
			return false;
		} finally {
			close(jedis);
		}
	}
	
	public void srem(String key, String member) {
		Jedis jedis = getConnection();
		try {
			jedis.srem(key, member);
		} catch (Exception e) {
			
		} finally {
			close(jedis);
		}
	}
	
	private void close(Jedis jedis) {
		try {
			if(jedis != null) {
				jedis.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jedis = null;
		}
	}

	private Jedis getConnection() {
		return jedisPool.getResource();
	}

}
