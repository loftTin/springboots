package com_bjut.blog;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sangeng.mapper")
public class BlogAdminApplication {
    public static void main(String[] args) {

        SpringApplication.run(BlogAdminApplication.class, args);
    }
}
