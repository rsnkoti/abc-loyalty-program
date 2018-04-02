package com.mettl.loyalty.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.mettl.loyalty.AbcLoyaltyProgramApplication;
import com.mettl.loyalty.service.LoyaltyPointsService;
import com.mettl.loyalty.service.factory.LoyaltyPointsServiceFactory;
import com.mettl.loyalty.vo.CustomerClass;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AbcLoyaltyProgramApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class LoyaltyPointServiceTest {
	
	@Autowired
	LoyaltyPointsServiceFactory loyaltyPointsServiceFactory;
	
	@Test
	public void goldClassTest(){
		LoyaltyPointsService pointsCalcService = loyaltyPointsServiceFactory
				.getLoyaltyPointsServiceBasedOnCustomerClass(CustomerClass.GOLD);
		
		long txPoint = pointsCalcService.computeTxLoyaltyPoint(1510);
		assertEquals("Gold Class calculation failed", 75, txPoint);
	}

	@Test
	public void silverClassTest(){
		LoyaltyPointsService pointsCalcService = loyaltyPointsServiceFactory
				.getLoyaltyPointsServiceBasedOnCustomerClass(CustomerClass.SILVER);
		
		long txPoint = pointsCalcService.computeTxLoyaltyPoint(1510);
		assertEquals("Silver Class calculation failed", 30, txPoint);
		
	}
	
	@Test
	public void normalClassTest(){
		LoyaltyPointsService pointsCalcService = loyaltyPointsServiceFactory
				.getLoyaltyPointsServiceBasedOnCustomerClass(CustomerClass.NORMAL);
		
		long txPoint = pointsCalcService.computeTxLoyaltyPoint(1510);
		assertEquals("Normal Class calculation failed", 15, txPoint);
		
	}
}
