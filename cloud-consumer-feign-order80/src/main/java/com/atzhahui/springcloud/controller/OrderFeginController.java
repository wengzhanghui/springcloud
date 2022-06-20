package com.atzhahui.springcloud.controller;

import com.atzhahui.springcloud.entities.CommonResult;
import com.atzhahui.springcloud.entities.Payment;
import com.atzhahui.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhahui
 * @creat -06-17 18:50
 */
@RestController
@Slf4j
public class OrderFeginController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon:客戶端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
