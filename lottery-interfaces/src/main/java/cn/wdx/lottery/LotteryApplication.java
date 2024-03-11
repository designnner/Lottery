package cn.wdx.lottery;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/6 8:28 PM
 * @version: 1.0
 */
@SpringBootApplication
@EnableDubbo
@Configurable
public class LotteryApplication {
    public static void main(String[] args){
        SpringApplication.run(LotteryApplication.class,args);
    }
}
