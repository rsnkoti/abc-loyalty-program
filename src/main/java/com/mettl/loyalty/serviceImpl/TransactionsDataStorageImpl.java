package com.mettl.loyalty.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mettl.loyalty.service.TransactionsDataStorageService;
import com.mettl.loyalty.vo.TransactionInputData;

@Service(value="txDataStore")
public class TransactionsDataStorageImpl implements TransactionsDataStorageService {

	List<TransactionInputData> transactionDataList;
	
	@Override
	public void populateTransactionDataAtStartUp() {
		if(null==transactionDataList){
			transactionDataList = new ArrayList<>();
		}
		//Build Transacrtion Supplied Data
		TransactionInputData transaction_1 = new TransactionInputData.Builder().name("Abhay")
				.emailAddress("abhay@demo.com").loyaltyCardNo(11001).purchaseAmount(7402)
				.purchaseDateTime("22-06-2012 11:23").purchaseTransactionId(2348723).build();

		TransactionInputData transaction_2 = new TransactionInputData.Builder().purchaseAmount(5000)
				.purchaseDateTime("22-06-2012 13:48").purchaseTransactionId(3830283).build();
		
		TransactionInputData transaction_3 = new TransactionInputData.Builder().name("Anant")
				.emailAddress("anant@example.com").loyaltyCardNo(11002).purchaseAmount(3839)
				.purchaseDateTime("22-06-2012 15:39").purchaseTransactionId(2939303).build();
		
		TransactionInputData transaction_4 = new TransactionInputData.Builder().name("Ashish")
				.emailAddress("ashish@mettl.com").loyaltyCardNo(11003).purchaseAmount(13890)
				.purchaseDateTime("22-06-2012 17:15").purchaseTransactionId(2828939).build();
		
		TransactionInputData transaction_5 = new TransactionInputData.Builder().loyaltyCardNo(11001).
				purchaseAmount(12083).purchaseDateTime("23-06-2012 11:38").purchaseTransactionId(3839403).build();
		
		TransactionInputData transaction_6 = new TransactionInputData.Builder().name("Abhimanyu")
				.emailAddress("abhi@mettl.com").loyaltyCardNo(11004).purchaseAmount(33283)
				.purchaseDateTime("23-06-2012 14:18").purchaseTransactionId(1384839).build();
		
		TransactionInputData transaction_7 = new TransactionInputData.Builder().purchaseAmount(5984)
				.purchaseDateTime("23-06-2012 19:56").purchaseTransactionId(8383939).build();
		
		TransactionInputData transaction_8 = new TransactionInputData.Builder().loyaltyCardNo(11003)
				.purchaseAmount(38103).purchaseDateTime("24-06-2012 15:38").purchaseTransactionId(9388383).build();
		
		TransactionInputData transaction_9 = new TransactionInputData.Builder().name("Anant")
				.emailAddress("anant@mettl.com").loyaltyCardNo(11002).purchaseAmount(7281)
				.purchaseDateTime("24-06-2012 19:18").purchaseTransactionId(2938381).build();
		
		TransactionInputData transaction_10 = new TransactionInputData.Builder().purchaseAmount(1038)
				.purchaseDateTime("24-06-2012 20:00").purchaseTransactionId(3833838).build();
		
		TransactionInputData transaction_11= new TransactionInputData.Builder().name("Abhijeet")
				.emailAddress("abhi@mettl.com").loyaltyCardNo(11005).purchaseAmount(17937)
				.purchaseDateTime("25-06-2012 18:53").purchaseTransactionId(8383383).build();
		
		//Populating TransactionSuppliedData
		transactionDataList.add(transaction_1);
		transactionDataList.add(transaction_2);
		transactionDataList.add(transaction_3);
		transactionDataList.add(transaction_4);
		transactionDataList.add(transaction_5);
		transactionDataList.add(transaction_6);
		transactionDataList.add(transaction_7);
		transactionDataList.add(transaction_8);
		transactionDataList.add(transaction_9);
		transactionDataList.add(transaction_10);
		transactionDataList.add(transaction_11);
		
	}
	
	@Override
	public void addTransactionData(TransactionInputData transaction) {
		if(null==transactionDataList){
			transactionDataList = new ArrayList<>();
		} 
		transactionDataList.add(transaction);
	}
	
	@Override
	public List<TransactionInputData> getTransactionData() {
		if(null==transactionDataList){
			transactionDataList = new ArrayList<>();
		}
		return transactionDataList;	
	}

}
