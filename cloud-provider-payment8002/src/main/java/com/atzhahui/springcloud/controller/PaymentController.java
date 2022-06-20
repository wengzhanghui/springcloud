package com.atzhahui.springcloud.controller;

import com.atzhahui.springcloud.entities.CommonResult;
import com.atzhahui.springcloud.entities.Payment;
import com.atzhahui.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhahui
 * @creat -05-29 16:54
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果*****:"+result);
        if (result>0){
            return new CommonResult(200,"添加成功,serverPort"+serverPort,result);
        }else {
            return new CommonResult(404,"添加失败",null);
        }
    }
    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果*****:"+payment);
        if (payment!=null){
            return new CommonResult(200,"查询成功,serverPort"+serverPort,payment);
        }else {
            return new CommonResult(404,"没有对应的记录，查询id"+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
