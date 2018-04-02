package com.mettl.loyalty.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mettl.loyalty.service.CustomerDataProcessingService;
import com.mettl.loyalty.service.CustomerDataStorageService;
import com.mettl.loyalty.service.TransactionsDataStorageService;
import com.mettl.loyalty.vo.CustomerClass;
import com.mettl.loyalty.vo.TransactionInputData;

@Service(value="customerDataProcessingService")
public class CustomerDataProcessingServiceImpl implements CustomerDataProcessingService {

	@Autowired
	CustomerDataStorageService customerDataStoreService;
	
	@Autowired
	TransactionsDataStorageService txDataStore;
	
	@Override
	public void processTransactionStorageData() {
		List<TransactionInputData> txDataList=txDataStore.getTransactionData();
		txDataList.forEach(x->{
			//check loyalty CardNo not null
			long loyaltyCardNbr = x.getLoyaltyCardNo();
			if (loyaltyCardNbr > 0) {
				// If loyalty Card exist
				if (!customerDataStoreService.checkExistingCustomerByLoyaltyCardNo(Long.valueOf(loyaltyCardNbr))) {
					//Enroll Customer
					customerDataStoreService.enrollCustomer(Long.valueOf(loyaltyCardNbr), x.getName(), x.getEmailAddress());		
				} 
				else
				{
				//If changes to name and email
					customerDataStoreService.updateCustomerRecord(Long.valueOf(loyaltyCardNbr), x.getName(), x.getEmailAddress());
				}
				//Add Tx
				customerDataStoreService.addCustomerTransaction(x);
				
				//Total amount
				double amount = customerDataStoreService.retriveTotalAmountByLoyaltyCardNo(Long.valueOf(loyaltyCardNbr));
				
				//Get Loyalty Customer class
				CustomerClass customerClass= CustomerClass.getCustomerClass(amount);
				
				//Update class for next Tx
				customerDataStoreService.updateCustomerClass(Long.valueOf(loyaltyCardNbr), customerClass);
			}
			
		});

	}

}
