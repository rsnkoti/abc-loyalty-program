package com.mettl.loyalty.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mettl.loyalty.service.LoyaltyPointsService;

@Service(value="silver")
public class SilverPointsServiceImpl implements LoyaltyPointsService {

	@Value("${loyalty.silver.basePoint}")
	private long basePoint;
	
	@Value("${loyalty.silver.baseSpent}")
	private double baseSpent;
	
	@Override
	public long computeTxLoyaltyPoint(double txAmount) {
		long eligibleAmtForPoint= (long) (txAmount/baseSpent);
		return eligibleAmtForPoint*basePoint;
	}
}
