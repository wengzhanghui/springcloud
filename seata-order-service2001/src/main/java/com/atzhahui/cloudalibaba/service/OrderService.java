package com.atzhahui.cloudalibaba.service;

import com.atzhahui.cloudalibaba.domain.Order;

/**
 * @author zhahui
 * @creat -07-17 9:54
 */
public interface OrderService{
    /**
     * 创建订单
     */
    void create(Order order);
}
