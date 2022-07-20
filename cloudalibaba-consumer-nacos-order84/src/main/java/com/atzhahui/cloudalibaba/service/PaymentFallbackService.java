package com.atzhahui.cloudalibaba.service;

import com.atzhahui.springcloud.entities.CommonResult;
import com.atzhahui.springcloud.entities.Payment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author zhahui
 * @creat -07-16 10:03
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回，--PaymentFallbackService",new Payment(id,"errorservice"));
    }
}
