package com.mettl.loyalty.serviceImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mettl.loyalty.service.CustomerDataStorageService;
import com.mettl.loyalty.service.LoyaltyPointsService;
import com.mettl.loyalty.service.factory.LoyaltyPointsServiceFactory;
import com.mettl.loyalty.util.TxTimeStampComparator;
import com.mettl.loyalty.vo.CustomerClass;
import com.mettl.loyalty.vo.CustomerReport;
import com.mettl.loyalty.vo.CustomerTransaction;
import com.mettl.loyalty.vo.TransactionInputData;

@Service(value="customerDataStoreService")
public class CustomerDataStorageServiceImpl implements CustomerDataStorageService {

	private Map<Long, CustomerReport> customersDataMap;
	
	@Autowired
	LoyaltyPointsServiceFactory loyaltyPointsServiceFactory;
	
	@Value("${loyalty.joining.bonus.point}")
	private long joiningBonus;
	
	@Override
	public Boolean enrollCustomer(Long loyaltyCardNo, String name, String email) {
		CustomerReport customerData = new CustomerReport(loyaltyCardNo.longValue() , name, email, 0.0, joiningBonus, CustomerClass.NORMAL, null);
		customersDataMap.put(loyaltyCardNo, customerData);
		return Boolean.TRUE;
	}

	@Override
	public Boolean updateCustomerRecord(Long loyaltyCardNo, String name, String email) {
		Boolean ret =Boolean.FALSE;
		CustomerReport customerData=customersDataMap.get(loyaltyCardNo);
		if(name!=null && !name.trim().equals("") && !name.equalsIgnoreCase(customerData.getCustomerName()))
		{
			customerData.setCustomerName(name);
			ret=Boolean.TRUE;
		}
		if(email!=null && !email.trim().equals("") && !email.equalsIgnoreCase(customerData.getCustomerEmail()))
		{
			customerData.setCustomerEmail(email);
			ret=Boolean.TRUE;
		}
		return ret;
	}

	@Override
	public Boolean checkExistingCustomerByLoyaltyCardNo(Long loyaltyCardNo) {
		if(customersDataMap==null){
			customersDataMap = new HashMap<>();
		}
		return (customersDataMap.get(loyaltyCardNo)!=null)? Boolean.TRUE:Boolean.FALSE;
	}

	@Override
	public double retriveTotalAmountByLoyaltyCardNo(Long loyaltyCardNo) {
		CustomerReport customerData = customersDataMap.get(loyaltyCardNo);
		return customerData.getTotalAmount();
	}

	@Override
	public void addCustomerTransaction(TransactionInputData transactionData) {
		Long loyaltyCardNo = Long.valueOf(transactionData.getLoyaltyCardNo());
		CustomerReport customerData = customersDataMap.get(loyaltyCardNo);
		Set<CustomerTransaction> customerTxList = customerData.getTransactions();
		if (customerTxList == null) {
			customerTxList = new TreeSet<>(new TxTimeStampComparator());
			//Adding transactions to Customer data
			customerData.setTransactions(customerTxList);
		}

		//Getting LoyaltyPoints Service - Normal, Silver, Gold
		LoyaltyPointsService pointsCalcService = loyaltyPointsServiceFactory
				.getLoyaltyPointsServiceBasedOnCustomerClass(customerData.getCustomerClass());
		
		long txPoint = pointsCalcService.computeTxLoyaltyPoint(transactionData.getPurchaseAmount());
		
		CustomerTransaction customerTx = new CustomerTransaction(loyaltyCardNo.longValue(), transactionData.getPurchaseDateTime(),
				transactionData.getPurchaseTransactionId(), transactionData.getPurchaseAmount(), txPoint);
		
		// Update transactionPoints
		customerData.setLoyaltyPoints(customerData.getLoyaltyPoints() + txPoint);
		
		// Update total amount
		customerData.setTotalAmount(customerData.getTotalAmount() + transactionData.getPurchaseAmount());
		
		// Adding Tx
		customerTxList.add(customerTx);
	}
	
	@Override
	public void updateCustomerClass(Long loyaltyCardNo, CustomerClass customerClass)
	{
		CustomerReport customerData=customersDataMap.get(loyaltyCardNo);
		customerData.setCustomerClass(customerClass);
	}

	@Override
	public Set<CustomerReport> retrieveCustomerReports()
	{
		  return new HashSet<CustomerReport>(customersDataMap.values()); 
	}

}
