package com.anrong.wulan.core.security.shiro;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anrong.wulan.core.support.redis.JedisPoolManager;
import com.anrong.wulan.core.support.redis.RedisCache;

public class RedisCacheManager implements CacheManager{
	
	private Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);
	
	private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();
	private JedisPoolManager redisManager;
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		logger.debug("获取名称为: " + name + " 的RedisCache实例");
		Cache c = caches.get(name);
		if (c == null) {
			c = new RedisCache<K, V>(redisManager);
			caches.put(name, c);
		}
		return c;
	}
	public JedisPoolManager getRedisManager() {
		return redisManager;
	}
	public void setRedisManager(JedisPoolManager redisManager) {
		this.redisManager = redisManager;
	}
	
	

}
