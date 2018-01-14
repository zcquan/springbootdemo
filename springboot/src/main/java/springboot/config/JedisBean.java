package springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration //相当于创建spring的 application。xml
public class JedisBean {

	//注入
	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private Integer port;
	
	@Bean //相当于<bean class="JedisPool">
	public JedisPool getJedisPool() {
		//创建连接池对象
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(20);
		poolConfig.setMaxTotal(2000);
		//创建jedisPool
		JedisPool jp = new JedisPool(poolConfig, host,port);
		
		return jp;
	}
}
