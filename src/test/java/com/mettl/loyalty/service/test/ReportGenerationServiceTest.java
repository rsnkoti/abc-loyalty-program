package com.mettl.loyalty.service.test;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.mettl.loyalty.AbcLoyaltyProgramApplication;
import com.mettl.loyalty.service.ReportGenerationService;
import com.mettl.loyalty.service.TransactionsDataStorageService;
import com.mettl.loyalty.vo.CustomerReport;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AbcLoyaltyProgramApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class ReportGenerationServiceTest {

	@Autowired
	ReportGenerationService reportGenerationService;
	
	@Autowired
	TransactionsDataStorageService txDataStore;
	
	@Test
	public void reportGenerationTest(){
		txDataStore.populateTransactionDataAtStartUp();
		Set<CustomerReport> list=reportGenerationService.generateLoyaltyCustomerReport();
		assertEquals("Sample Data test failed", 5, list.size());
	}

}
