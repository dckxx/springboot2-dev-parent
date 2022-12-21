package com.dckxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dckxx.mybatis.mapper")
@SpringBootApplication
public class MybatisStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisStartApplication.class, args);
    }

}
