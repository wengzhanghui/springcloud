package com.atzhahui.cloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhahui
 * @creat -07-17 18:12
 */
@Configuration
@MapperScan("com.atzhahui.cloudalibaba.dao")
public class MyBatisConfig {
}
