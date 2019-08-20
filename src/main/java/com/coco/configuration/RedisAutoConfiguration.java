package com.coco.configuration;

import com.coco.configuration.properties.JedisPoolConfigProperties;
import com.coco.configuration.properties.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description: redis 配置
 * @author zhangxiaoxun
 * @date 2019/8/20 14:15
 * @Version: V1.0
 *
 **/
public class RedisAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public JedisPoolConfig jedisPoolConfig(JedisPoolConfigProperties jedisPoolConfigProperties){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(jedisPoolConfigProperties.getMaxTotal());
        jedisPoolConfig.setMaxIdle(jedisPoolConfigProperties.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(jedisPoolConfigProperties.getMaxWait());
        jedisPoolConfig.setTestOnBorrow(jedisPoolConfigProperties.isTestOnBorrow());
        jedisPoolConfig.setTestOnReturn(jedisPoolConfigProperties.isTestOnReturn());
        jedisPoolConfig.setTestWhileIdle(jedisPoolConfigProperties.isTestWhileIdle());
        return jedisPoolConfig;
    }

    @Autowired
    private JedisPoolConfig jedisPoolConfig;

    @Bean
    @ConditionalOnMissingBean
    public JedisPool jedisPool(RedisProperties redisProperties){
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,redisProperties.getHost(),redisProperties.getPort(),
                redisProperties.getTimeout(),redisProperties.getPassword());
        return jedisPool;

    }


}
