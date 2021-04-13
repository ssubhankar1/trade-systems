package com.tradesystem.tradesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.tradesystem.tradesystem")
@SpringBootApplication
public class TradeSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeSystemApplication.class, args);
	}

}
