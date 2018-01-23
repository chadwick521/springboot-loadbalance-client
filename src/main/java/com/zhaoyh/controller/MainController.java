package com.zhaoyh.controller;

import com.zhaoyh.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhaoyh on 2018/1/9
 * @author zhaoyh
 */
@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/requestByRestTemplate/{num}", method = RequestMethod.GET)
    public String requestByRestTemplate(@PathVariable(name = "num") int num) {
        String result = restTemplate.getForObject("http://PRODUCER/api/calculate?num=" + num, String.class);
        return result;
    }

    @RequestMapping(value = "/requestByFeign/{num}", method = RequestMethod.GET)
    public String requestByFeign(@PathVariable(value = "num") int num) {
        String result = feignService.calculate(num);
        return result;
    }

}
