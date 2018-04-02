package com.mettl.loyalty.service;

import java.util.List;

import com.mettl.loyalty.vo.TransactionInputData;

public interface TransactionsDataStorageService {

	void populateTransactionDataAtStartUp();

	void addTransactionData(TransactionInputData transaction);	
	
	List<TransactionInputData> getTransactionData();
}
