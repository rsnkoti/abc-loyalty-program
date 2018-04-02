package com.mettl.loyalty.util;

import java.util.Comparator;

import com.mettl.loyalty.vo.CustomerTransaction;

public class TxTimeStampComparator implements Comparator<CustomerTransaction> {

	@Override
	public int compare(CustomerTransaction o1, CustomerTransaction o2) {
		return o1.getDateTime().compareTo(o2.getDateTime());
	}

}
