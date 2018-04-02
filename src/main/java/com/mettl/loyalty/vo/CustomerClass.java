package com.mettl.loyalty.vo;

public enum CustomerClass{

	NORMAL(25000), SILVER(50000), GOLD(Integer.MAX_VALUE);
	
	private final double maxAmount;
	
	private CustomerClass(double maxAmount){
		this.maxAmount=maxAmount;
	}
	
    public static CustomerClass getCustomerClass(double amount) {
    	CustomerClass found = NORMAL;
        for (CustomerClass type : values())
            if (amount <= type.maxAmount)
            {
            	found = type;
            	break;
            }
                
        return found;
    }
}
