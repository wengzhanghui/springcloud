package com.atzhahui.cloudalibaba.domain;

import lombok.Data;

/**
 * @author zhahui
 * @creat -07-17 17:44
 */
@Data
public class Storage {

    private Long id;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 总库存
     */
    private Integer total;
    /**
     * 已用库存
     */
    private Integer used;
    /**
     * 剩余库存
     */
    private Integer residue;
}
