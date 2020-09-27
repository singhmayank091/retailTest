package com.retail.big;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscountApplicaiton {	

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DiscountApplicaiton.class);
		application.run(args);
	}
}
