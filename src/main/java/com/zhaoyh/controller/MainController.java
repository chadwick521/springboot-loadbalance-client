package com.zhaoyh.controller;

import com.zhaoyh.service.ConsumerService;
import com.zhaoyh.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhaoyh on 2018/1/9
 * @author zhaoyh
 */
@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/requestByRestTemplate/{num}", method = RequestMethod.GET)
    public String requestByRestTemplate(@PathVariable(name = "num") int num) {
        return consumerService.consumer(num);
    }

    @RequestMapping(value = "/requestByFeign/{num}", method = RequestMethod.GET)
    public String requestByFeign(@PathVariable(value = "num") int num) {
        return feignService.calculate(num);
    }

}
