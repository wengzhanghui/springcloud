package com.atzhahui.cloudalibaba.service.impl;

import com.atzhahui.cloudalibaba.dao.OrderDao;
import com.atzhahui.cloudalibaba.domain.Order;
import com.atzhahui.cloudalibaba.service.AccountService;
import com.atzhahui.cloudalibaba.service.OrderService;
import com.atzhahui.cloudalibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhahui
 * @creat -07-17 10:12
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "zhahui_test_group",rollbackFor = Exception.class)
    public void create(Order order) {

        //1.新建订单
        log.info("------->开始新建订单");
        orderDao.create(order);

        //2.库存扣减
        log.info("------->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->订单微服务开始调用库存，做扣减结束");

        //3.账号扣减
        log.info("------->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->订单微服务开始调用账户，做扣减结束");

        //4.修改订单的状态从0到1,1代表已经完成
        log.info("------->订单开始改变状态");
        orderDao.update(order.getUserId(),0);
        log.info("------->订单完成改变状态");

        log.info("------->下订单结束了，O(∩_∩)O哈哈~");
    }
}
