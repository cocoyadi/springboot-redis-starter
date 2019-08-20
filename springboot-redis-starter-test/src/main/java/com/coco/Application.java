package com.coco;

import com.coco.service.RedisCacheService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description: 启动类
 * @author zhangxiaoxun
 * @date 2019/8/20 14:52
 * @Version: V1.0
 *
 **/
@SpringBootApplication
public class Application{
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class,args);
        RedisCacheService redisCacheService = context.getBean(RedisCacheService.class);
        boolean flag = redisCacheService.putCache("name1","coco",3000);
        System.out.println(flag);
        Object object = redisCacheService.getCache("name1");
        System.out.println(object);
        context.close();
    }
}
