package com.coco.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: redis连接配置
 * @author zhangxiaoxun
 * @date 2019/8/20 14:20
 * @Version: V1.0
 *
 **/
@ConfigurationProperties(prefix="redis")
@Data
@Component
public class RedisProperties {
    private String host;
    private Integer port;
    private Integer timeout;
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
