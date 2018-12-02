package com.zhaoyh.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhaoyh on 2018/1/23
 * @author zhaoyh
 */
@FeignClient(name = "${provider.name}", fallback = HystrixTest.class)
public interface FeignService {

    /**
     * 计算接口
     * @param num
     * @return
     */
    @RequestMapping(value = "/api/calculate")
    String calculate(@RequestParam(value = "num") int num);

}
