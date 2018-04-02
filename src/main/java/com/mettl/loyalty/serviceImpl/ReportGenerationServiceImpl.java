package com.mettl.loyalty.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mettl.loyalty.service.CustomerDataProcessingService;
import com.mettl.loyalty.service.CustomerDataStorageService;
import com.mettl.loyalty.service.ReportGenerationService;
import com.mettl.loyalty.vo.CustomerReport;

@Service(value ="reportGenerationService")
public class ReportGenerationServiceImpl implements ReportGenerationService {

	@Autowired
	CustomerDataStorageService customerDataStoreService;
	
	@Autowired
	CustomerDataProcessingService customerDataProcessingService;
	
	@Override
	public Set<CustomerReport> generateLoyaltyCustomerReport() {
		customerDataProcessingService.processTransactionStorageData();
		Set<CustomerReport> result = customerDataStoreService.retrieveCustomerReports();
		System.out.println(result);
		return result;
	}

}
