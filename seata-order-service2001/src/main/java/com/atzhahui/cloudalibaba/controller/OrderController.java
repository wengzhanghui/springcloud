package com.atzhahui.cloudalibaba.controller;

import com.atzhahui.cloudalibaba.domain.CommonResult;
import com.atzhahui.cloudalibaba.domain.Order;
import com.atzhahui.cloudalibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhahui
 * @creat -07-17 10:15
 */
@RestController
public class OrderController {

    @Resource
    public OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");

    }
}
