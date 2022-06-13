package com.atzhahui.springcloud.service;

import com.atzhahui.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhahui
 * @creat -05-29 16:50
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@PathVariable("id") Long id);
}
