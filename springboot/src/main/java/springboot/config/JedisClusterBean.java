package springboot.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@Configuration //相当于创建spring的 application。xml
public class JedisClusterBean {

	//注入
	@Value("${spring.redis.cluster.nodes}")
	private String clusterNodes ;
	
	@Bean //相当于<bean class="JedisCluster">
	public JedisCluster getJedisCluster() {
		//创建连接池配置对象
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(20);
		poolConfig.setMaxTotal(2000);
	
		//创建set集合
		Set<HostAndPort> nodes = new HashSet<>();
		
		//截取集群地址
		String[] redisNodes = clusterNodes.split(",");
		
		//截取节点和端口
		for (String hostNode : redisNodes) {
			String[] hn = hostNode.split(":");
			nodes.add(new HostAndPort(hn[0],Integer.parseInt(hn[1])));
		}
		
		//创建jedisCluster		
		JedisCluster jc = new JedisCluster(nodes,poolConfig);
		return jc;
	}
}
