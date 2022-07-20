package com.atzhahui.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atzhahui.cloudalibaba.service.PaymentFallbackService;
import com.atzhahui.cloudalibaba.service.PaymentService;
import com.atzhahui.springcloud.entities.CommonResult;
import com.atzhahui.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhahui
 * @creat -07-14 18:31
 */
@RestController
@Slf4j
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback",fallback = "handlerfallback")
//    @SentinelResource(value = "fallback",blockHandler = "blockhandler")
    @SentinelResource(value = "fallback",fallback = "handlerfallback",blockHandler = "blockhandler",
                        exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    //本利是fallback
    public CommonResult handlerfallback(@PathVariable("id") Long id,Throwable e){
        Payment payment =new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback，exception内容 "+e.getMessage(),payment);
    }
//    本例是blockhandler
    public CommonResult<Payment> blockhandler(@PathVariable("id") Long id, BlockException blockException) {
        Payment payment =new Payment(id,"null");
        return new CommonResult<>(445,"blockhandler-sentinel限流,无此流水：blockException "+ blockException.getMessage());
    }

    //openfegin
    @Resource
    public PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }
}
