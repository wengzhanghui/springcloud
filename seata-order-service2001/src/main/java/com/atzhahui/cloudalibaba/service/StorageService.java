package com.atzhahui.cloudalibaba.service;

import com.atzhahui.cloudalibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhahui
 * @creat -07-17 9:55
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @GetMapping( "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
