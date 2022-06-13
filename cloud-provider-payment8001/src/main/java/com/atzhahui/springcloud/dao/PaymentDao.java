package com.atzhahui.springcloud.dao;

import com.atzhahui.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhahui
 * @creat -05-29 16:33
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@PathVariable("id") Long id);
}
