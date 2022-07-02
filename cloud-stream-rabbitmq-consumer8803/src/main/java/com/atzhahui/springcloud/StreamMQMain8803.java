package com.atzhahui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhahui
 * @creat -07-02 8:42
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8803 {
    public static void main(String[] args)
    {
        SpringApplication.run(StreamMQMain8803.class,args);
    }
}
