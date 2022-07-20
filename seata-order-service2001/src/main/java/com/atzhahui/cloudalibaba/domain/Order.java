package com.atzhahui.cloudalibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhahui
 * @creat -07-17 9:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order
{
    private Long id;

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 产品id
     */
    private Long productId;

    /**
     * 订单物品的数量
     */
    private Integer count;

    /**
     * 要付的钱
     */
    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;
}