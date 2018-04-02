package com.mettl.loyalty.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mettl.loyalty.service.LoyaltyPointsService;

@Service(value="normal")
public class NormalPointsServiceImpl implements LoyaltyPointsService {

	@Value("${loyalty.normal.percentage}")
	private double percentage;
	
	@Override
	public long computeTxLoyaltyPoint(double txAmount) {
		return  (long) (txAmount*percentage/100.0);
	}

}
