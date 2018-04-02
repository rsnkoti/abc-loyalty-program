package com.mettl.loyalty.service;

import java.util.Set;

import com.mettl.loyalty.vo.CustomerReport;

public interface ReportGenerationService {
	
	Set<CustomerReport> generateLoyaltyCustomerReport();
}
