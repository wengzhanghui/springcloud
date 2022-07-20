package com.atzhahui.cloudalibaba.dao;

import com.atzhahui.cloudalibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhahui
 * @creat -07-17 9:52
 */
@Mapper
public interface OrderDao {
    /**
     * 创建订单
     */
    void create(Order order);

    /**
     * 修改订单状态，从0改为1
     * 修改订单金额
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
