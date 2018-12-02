package com.zhaoyh.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhaoyh on 2018/9/3
 *
 * @author zhaoyh
 */
@Component
public class ConsumerService {

    @Value("${provider.name}")
    private String providerName;

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer(int num) {
        return restTemplate.getForObject("http://" + providerName + "/api/calculate?num=" + num, String.class);
    }

    /**
     * 降级方法
     * @return
     */
    private String fallback(int num) {
        return "fallbck 降级啦！！！！";
    }

}
