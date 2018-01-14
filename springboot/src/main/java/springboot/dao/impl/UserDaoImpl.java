package springboot.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import springboot.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	//注入jedisPool对象
	@Autowired
	private JedisPool jp;
	//注入jedis集群对象
	@Autowired
	private JedisCluster jc;
	
	public String set(String key, String value) {
		Jedis jedis = jp.getResource();
		String v = jc.set(key, value);
		return v;
	}

	public String get(String key) {
		Jedis jedis = jp.getResource();
		String value = jc.get(key);
		return value;
	}

}
