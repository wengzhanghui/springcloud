package com.atzhahui.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atzhahui.cloudalibaba.myhandler.CustomerBlockHandler;
import com.atzhahui.springcloud.entities.CommonResult;
import com.atzhahui.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhahui
 * @creat -07-12 18:03
 */
@RestController
public class RateLimitController
{
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource()
    {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2022L,"serial001"));
    }
    public CommonResult handleException(BlockException exception)
    {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按Url限流测试ok",new Payment(2022L,"serial002"));
    }

    @GetMapping("/rateLimit/custemerBlockHander")
    @SentinelResource(value = "custemerBlockHander",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2")
    public CommonResult custemerBlockHander(){
        return new CommonResult(200,"按客户自定义限流测试ok",new Payment(2022L,"serial002"));
    }
}
