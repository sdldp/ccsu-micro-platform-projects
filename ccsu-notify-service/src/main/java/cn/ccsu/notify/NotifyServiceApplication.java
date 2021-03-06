package cn.ccsu.notify;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "cn.ccsu.notify.dao")
public class NotifyServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(NotifyServiceApplication.class, args);

    }
}
