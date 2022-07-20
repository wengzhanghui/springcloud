package com.atzhahui.cloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atzhahui.springcloud.entities.CommonResult;

/**
 * @author zhahui
 * @creat -07-12 18:19
 */
public class CustomerBlockHandler
{
    public static CommonResult handleException1(BlockException exception){
        return new CommonResult(4444,"按客户自定义的限流处理信息......CustomerBlockHandler-1");
    }
    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(4444,"按客户自定义的限流处理信息......CustomerBlockHandler-2");
    }
}