package com.mettl.loyalty.service.test;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.mettl.loyalty.AbcLoyaltyProgramApplication;
import com.mettl.loyalty.service.CustomerDataProcessingService;
import com.mettl.loyalty.service.CustomerDataStorageService;
import com.mettl.loyalty.service.ReportGenerationService;
import com.mettl.loyalty.service.TransactionsDataStorageService;
import com.mettl.loyalty.vo.CustomerReport;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AbcLoyaltyProgramApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class CustomerDataStorageServiceTest {
	
	@Autowired
	TransactionsDataStorageService txDataStore;
	
	@Autowired
	CustomerDataStorageService customerDataStoreService;
	
	@Autowired
	CustomerDataProcessingService customerDataProcessingService;
	
	private Boolean flag=true;
	
	@Before
	public void before(){
		if(flag)
		{
			txDataStore.populateTransactionDataAtStartUp();
			customerDataProcessingService.processTransactionStorageData();
			this.flag=false;
		}
	}
	
	@Test
	public void updateCustomerRecordTest(){
		Boolean resultOne=customerDataStoreService.updateCustomerRecord(11004L, "Rajendra", null);
		assertTrue("resultOne test failed",resultOne);
		Boolean resultTwo=customerDataStoreService.updateCustomerRecord(11004L, null, null);
		assertFalse("resultTwo test failed",resultTwo);
	}
	
	@Test
	public void checkExistingCustomerByLoyaltyCardNoTest(){
		Boolean result3=customerDataStoreService.checkExistingCustomerByLoyaltyCardNo(11004L);
		assertTrue("result3 test failed", result3);
		Boolean result4=customerDataStoreService.checkExistingCustomerByLoyaltyCardNo(10000L);
		assertFalse("result4 test failed", result4);
	}

}
