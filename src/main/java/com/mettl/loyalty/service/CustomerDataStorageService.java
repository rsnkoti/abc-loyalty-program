package com.mettl.loyalty.service;

import java.util.Set;

import com.mettl.loyalty.vo.CustomerClass;
import com.mettl.loyalty.vo.CustomerReport;
import com.mettl.loyalty.vo.TransactionInputData;

public interface CustomerDataStorageService {
	
	Boolean enrollCustomer(Long loyaltyCardNo, String name, String email);
	
	Boolean updateCustomerRecord(Long loyaltyCardNo, String name, String email);
	
	Boolean checkExistingCustomerByLoyaltyCardNo(Long loyaltyCardNo);
	
	double retriveTotalAmountByLoyaltyCardNo(Long loyaltyCardNo);
	
	void addCustomerTransaction(TransactionInputData transactionData);

	void updateCustomerClass(Long loyaltyCardNo, CustomerClass customerClass);

	Set<CustomerReport> retrieveCustomerReports();
}
