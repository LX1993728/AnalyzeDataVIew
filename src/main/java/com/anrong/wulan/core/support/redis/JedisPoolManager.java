package com.anrong.wulan.core.support.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

/**
 * JedisPool 管理类 用于单个redis 集群， 每个redis集群由master-salve组成
 */
public class JedisPoolManager {

	private JedisPool jedisPool;

	/**
	 * redis的List集合 ，向key这个list添加元素
	 */
	public long rpush(String key, String string) {
		Jedis jedis = null;
		long ret = 0l;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			ret = jedis.rpush(key, string);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return ret;
	}

	/**
	 * 获取key这个List，从第几个元素到第几个元素 LRANGE key start
	 * stop返回列表key中指定区间内的元素，区间以偏移量start和stop指定。
	 * 下标(index)参数start和stop都以0为底，也就是说，以0表示列表的第一个元素，以1表示列表的第二个元素，以此类推。
	 * 也可以使用负数下标，以-1表示列表的最后一个元素，-2表示列表的倒数第二个元素，以此类推。
	 */
	public List<String> lrange(String key, long start, long end) {
		Jedis jedis = null;
		List<String> ret = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			ret = jedis.lrange(key, start, end);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return ret;
	}

	/**
	 * 将哈希表key中的域field的值设为value。
	 */
	public void hset(String key, String field, String value) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			jedis.hset(key, field, value);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
	}

	/**
	 * 向key赋值
	 */
	public void set(String key, String value) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
	}

	/**
	 * 向key赋值
	 */
	public void set(byte[] key, byte[] value) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
	}

	/**
	 * 获取key的值
	 */
	public String get(String key) {
		Jedis jedis = null;
		String value = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			value = jedis.get(key);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return value;
	}

	/**
	 * 获取key的值
	 */
	public byte[] get(byte[] key) {
		byte[] value = null;
		Jedis jedis = jedisPool.getResource();
		boolean isBroken = false;
		try{
			value = jedis.get(key);
		}catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally{
			returnResource(jedis, isBroken);
		}
		return value;

	}

	/**
	 * 将多个field - value(域-值)对设置到哈希表key中。
	 */
	public void hmset(String key, Map<String, String> map) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			jedis.hmset(key, map);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
	}

	/**
	 * 给key赋值，并生命周期设置为seconds
	 */
	public void setex(String key, int seconds, String value) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			jedis.setex(key, seconds, value);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
	}

	/**
	 * 给key赋值，并生命周期设置为seconds
	 */
	public byte[] setex(byte[] key, byte[] value, int seconds) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			jedis.setex(key, seconds, value);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return value;

	}

	/**
	 * 为给定key设置生命周期
	 */
	public void expire(String key, int seconds) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			jedis.expire(key, seconds);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
	}

	/**
	 * 检查key是否存在
	 */
	public boolean exists(String key) {
		Jedis jedis = null;
		boolean isBroken = false;
		boolean bool;
		try {
			jedis = jedisPool.getResource();
			bool = jedis.exists(key);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return bool;
	}

	/**
	 * 检查key是否存在
	 */
	public boolean exists(byte[] key) {
		Jedis jedis = null;
		boolean isBroken = false;
		Set<byte[]> hashSet;
		try {
			jedis = jedisPool.getResource();
			hashSet = jedis.keys(key);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		if (null != hashSet && hashSet.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 返回key值的类型 none(key不存在),string(字符串),list(列表),set(集合),zset(有序集),hash(哈希表)
	 */
	public String type(String key) {
		Jedis jedis = null;
		boolean isBroken = false;
		String type = null;
		try {
			jedis = jedisPool.getResource();
			type = jedis.type(key);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return type;
	}

	/**
	 * 从哈希表key中获取field的value
	 */
	public String hget(String key, String field) {
		Jedis jedis = null;
		boolean isBroken = false;
		String value = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.hget(key, field);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return value;
	}

	/**
	 * 返回哈希表key中，所有的域和值
	 */
	public Map<String, String> hgetAll(String key) {
		Jedis jedis = null;
		boolean isBroken = false;
		Map<String, String> map = null;
		try {
			jedis = jedisPool.getResource();
			map = jedis.hgetAll(key);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return map;

	}

	/**
	 * 返回哈希表key中，所有的域和值
	 */
	public Set<?> smembers(String key) {
		Jedis jedis = null;
		boolean isBroken = false;
		Set<?> set  = null;
		try {
			jedis = jedisPool.getResource();
			set = jedis.smembers(key);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return set;
	}

	/**
	 * 返回匹配的 keys 列表
	 */
	public Set<byte[]> keys(String pattern) {
		Jedis jedis = null;
		boolean isBroken = false;
		Set<byte[]> keys = null;
		try {
			jedis = jedisPool.getResource();
			keys = jedis.keys(pattern.getBytes());
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return keys;

	}

	/**
	 * 移除set集合中的member元素
	 */
	public void delSetObj(String key, String field) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			jedis.srem(key, field);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
	}

	/**
	 * 删除元素
	 */
	public void del(byte[] key) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			jedis.del(key);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
	}

	/**
	 * 判断member元素是否是集合key的成员。是（true），否则（false）
	 */
	public boolean isNotField(String key, String field) {
		Jedis jedis = null;
		boolean isBroken = false;
		boolean bool = false;
		try {
			jedis = jedisPool.getResource();
			bool = jedis.sismember(key, field);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return bool;
	}

	/**
	 * 如果key已经存在并且是一个字符串，将value追加到key原来的值之后
	 */
	public void append(String key, String value) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			jedis.append(key, value);
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
	}

	/**
	 * 清空当前的redis 库
	 */
	public void flushDB() {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = jedisPool.getResource();
			jedis.flushDB();
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}

	}

	/**
	 * 返回当前redis库所存储数据的大小
	 */
	public Long dbSize() {

		Long dbSize = 0L;
		boolean isBroken = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			dbSize = jedis.dbSize();
		} catch (Exception e) {
			isBroken = true;
			throw new JedisException(e);
		}finally {
			returnResource(jedis, isBroken);
		}
		return dbSize;

	}
	
	public void returnResource(Jedis jedis, boolean isBroken) {
        if (jedis == null)
            return;
        /**
         * @deprecated starting from Jedis 3.0 this method will not be exposed.
         * Resource cleanup should be done using @see {@link redis.clients.jedis.Jedis#close()}
         */
        if (isBroken){
            getJedisPool().returnBrokenResource(jedis);
        }else{
            getJedisPool().returnResource(jedis);
        }
    }

	/**
	 * 关闭 Redis
	 */
	public void destory() {
		jedisPool.destroy();
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
}
