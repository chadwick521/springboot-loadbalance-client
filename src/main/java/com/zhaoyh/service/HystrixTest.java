package com.zhaoyh.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhaoyh on 2018/6/15
 * @author zhaoyh
 */
@Component
public class HystrixTest implements FeignService {

    @Override
    public String calculate(@RequestParam(value = "num") int num) {
        return "Sorry, we do not have a response from server!";
    }
}
