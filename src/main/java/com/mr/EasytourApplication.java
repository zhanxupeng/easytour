package com.mr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mr.dao")
public class EasytourApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasytourApplication.class, args);
	}

}

