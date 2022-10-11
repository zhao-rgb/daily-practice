package com.zxl.dailypractice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zxl.dailypractice.project.mapper")
public class DailyPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyPracticeApplication.class, args);
    }

}
