package com.guli.teacher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: guli_parent
 * @description:
 * @author: Mr.D
 * @create: 2020-05-29 01:35
 **/
@SpringBootApplication
@MapperScan("com.guli.teacher.mapper")
public class TeacherApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeacherApplication.class);
    }
}
