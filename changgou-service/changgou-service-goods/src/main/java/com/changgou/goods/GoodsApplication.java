package com.changgou.goods;

import entity.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.changgou.goods.dao"})
public class GoodsApplication {

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(0,1) ;}

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
