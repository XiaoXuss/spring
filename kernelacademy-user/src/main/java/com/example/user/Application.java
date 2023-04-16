package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Application : 全局启动器
 *
 * @author xab
 * @date 2023/4/13 21:03
 */
@AutoConfigureAfter
@SpringBootApplication()
@ComponentScan({"com.example.common","com.example.security","com.example.user"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
