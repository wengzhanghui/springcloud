package com.atzhahui.springcloud.service.impl;

import com.atzhahui.springcloud.dao.PaymentDao;
import com.atzhahui.springcloud.entities.Payment;
import com.atzhahui.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhahui
 * @creat -05-29 16:50
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
