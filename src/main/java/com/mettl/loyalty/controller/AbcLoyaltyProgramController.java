package com.mettl.loyalty.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mettl.loyalty.service.ReportGenerationService;
import com.mettl.loyalty.service.TransactionsDataStorageService;
import com.mettl.loyalty.vo.CustomerReport;
import com.mettl.loyalty.vo.TransactionInputData;

@RestController
@RequestMapping("loyalty-program")
public class AbcLoyaltyProgramController {

	@Autowired
	TransactionsDataStorageService datastore;

	@Autowired
	ReportGenerationService reportGenerationService;

	@GetMapping("welcome")
	public String loyaltyWelcome() {
		return "Welcome to ABC Loyalty Program";
	}
	
	@GetMapping("transaction-data")
	public List<TransactionInputData> transactionData() {
		return datastore.getTransactionData();
	}
	
	@GetMapping("customers-report")
	public Set<CustomerReport> report() {
		Set<CustomerReport> result= reportGenerationService.generateLoyaltyCustomerReport();
		return result;
	}
	
	
}
