package com.mettl.loyalty.service.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.mettl.loyalty.service.LoyaltyPointsService;
import com.mettl.loyalty.vo.CustomerClass;

@Component("loyaltyPointsServiceFactory")
public class LoyaltyPointsServiceFactory implements ApplicationContextAware {

	private ApplicationContext appContext;
	
	public LoyaltyPointsService getLoyaltyPointsServiceBasedOnCustomerClass(CustomerClass customerClass)
	{
		LoyaltyPointsService loyaltyPointsService =null;
		if(customerClass ==null){
			return appContext.getBean("normal",LoyaltyPointsService.class);
		}
		
		switch(customerClass){
		case NORMAL:
			loyaltyPointsService= appContext.getBean("normal",LoyaltyPointsService.class);
			break;
			
		case SILVER:
			loyaltyPointsService= appContext.getBean("silver",LoyaltyPointsService.class);
			break;
			
		case GOLD:
			loyaltyPointsService= appContext.getBean("gold",LoyaltyPointsService.class);
			break;
		}
		return loyaltyPointsService;
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appContext = applicationContext;
		
	}

}
