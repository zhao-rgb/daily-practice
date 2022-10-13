package com.zxl.dailypractice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.zxl.dailypractice.project.mapper")
@EnableSwagger2
public class DailyPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyPracticeApplication.class, args);
    }

}
