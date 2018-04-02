package com.mettl.loyalty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mettl.loyalty.service.TransactionsDataStorageService;

@SpringBootApplication(scanBasePackages = { "com.mettl" })
public class AbcLoyaltyProgramApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(AbcLoyaltyProgramApplication.class, args);
		
		TransactionsDataStorageService txDataStore = context.getBean(TransactionsDataStorageService.class);
		txDataStore.populateTransactionDataAtStartUp();
	}
}
