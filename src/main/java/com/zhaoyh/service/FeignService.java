package com.zhaoyh.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhaoyh on 2018/1/23
 * @author zhaoyh
 */
@FeignClient(name = "PRODUCER")
public interface FeignService {

    @RequestMapping(value = "/api/calculate")
    String calculate(@RequestParam(value = "num") int num);
}
