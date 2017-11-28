package com.anrong.wulan.admin;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * junit测试Service
 * 
 * @author liuxun
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/spring-context.xml" }) // 加载配置文件
public class JunitTestJedis {

	private final static Logger log = LoggerFactory.getLogger(JunitTestJedis.class);

	@Autowired
	private RedisTemplate<String	, Object> redisTemplate;
	
	@Autowired
	private JedisPool jedisServicePool;
	
	@Autowired
	private JedisPool jedisSessionPool;
	@Test
	public void test1() throws Exception {
		ValueOperations<String, Object> value = redisTemplate.opsForValue();
		value.set("lp", "hello word");
        //获取 这个 key 的值
        System.out.println(value.get("lp").toString().trim());
	}

	@Test
	public void test2() throws Exception {
		Jedis jedis = jedisServicePool.getResource();
		jedis.set("aaaa", "XHHXHXHXYUIOUOUW14545454");
	}
	
	@Test
	public void test3() throws Exception {
		Jedis jedis = jedisSessionPool.getResource();
		jedis.set("bbbbbb", "775211111111111");
	}
}
