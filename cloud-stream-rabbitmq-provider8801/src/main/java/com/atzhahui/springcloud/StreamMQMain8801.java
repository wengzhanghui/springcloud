package com.atzhahui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhahui
 * @creat -07-01 18:27
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8801 {
    public static void main(String[] args)
    {
        SpringApplication.run(StreamMQMain8801.class,args);
    }

}
