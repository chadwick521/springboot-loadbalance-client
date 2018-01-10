package com.zhaoyh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhaoyh on 2018/1/9
 * @author zhaoyh
 */
@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String say() {
        String result = restTemplate.getForObject("http://PRODUCER/api/say", String.class);
        return result;
    }

}
