package com.zhaoyh.controller;

import com.zhaoyh.LoadConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhaoyh on 2018/1/9
 * @author zhaoyh
 */
@RestController
@RibbonClient(name = "say-hello", configuration = LoadConfig.class)
public class MainController {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String say() {
        String result = restTemplate.getForObject("http://say-hello/api/say", String.class);
        return result;
    }

}
