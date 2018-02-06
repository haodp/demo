package com.chen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisService {

	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void setValue(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Object getValue(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @param expire expire为过期时间 
	 */
	public void setValueExpire(String key, Object value, long expire) {
		redisTemplate.opsForValue().set(key, value, expire);
	}

}
