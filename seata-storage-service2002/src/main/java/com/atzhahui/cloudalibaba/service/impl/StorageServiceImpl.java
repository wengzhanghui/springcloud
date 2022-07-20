package com.atzhahui.cloudalibaba.service.impl;

import com.atzhahui.cloudalibaba.dao.StorageDao;
import com.atzhahui.cloudalibaba.service.StorageService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;

/**
 * @author zhahui
 * @creat -07-17 17:56
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);


    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("----->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("----->storage-service中扣减库存结束");
    }
}
