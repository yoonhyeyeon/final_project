package com.kh.app99;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class App99Application {

	public static void main(String[] args) {
		SpringApplication.run(App99Application.class, args);
	}

}
