package com.atzhahui.springcloud.servce;

import org.springframework.stereotype.Service;

/**
 * @author zhahui
 * @creat -06-19 15:11
 */
@Service
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fallback ok";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "----PaymentFallbackService fallback paymentInfo_timeout";
    }
}
