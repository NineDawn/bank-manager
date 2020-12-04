package org.practice.mrj.bankmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.practice.mrj.bankmanager.mapper")
public class BankManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankManagerApplication.class, args);
	}

}
