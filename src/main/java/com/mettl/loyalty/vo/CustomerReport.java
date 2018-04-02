package com.mettl.loyalty.vo;

import java.io.Serializable;
import java.util.Set;

public class CustomerReport implements Serializable {

	private static final long serialVersionUID = 9069561682856659902L;
	
	private long loyaltyCardNo;
	private String customerName;
	private String customerEmail;
	private transient double totalAmount;
	private long loyaltyPoints;
	private CustomerClass customerClass;
	private Set<CustomerTransaction> transactions;
	
	@Override
	public String toString() {
		return  "\n"+"__________________________________________________________________"+"\n"+
				"Customer Name : " + customerName +"\n"+
				"customer Email : " + customerEmail +"\n" +
				"Loyalty Points : " + loyaltyPoints +"\n" +
				"Customer Class : " + customerClass +"\n" +
				"Transactions : " + "\n" + (transactions)
				+"\n"+
				"\t"+"(date time)"+"\t" +"(trx Id)" +"\t"+"(trx Amt)"+"\t"+"(Points Earned)"+"\n";
	}
	
	public CustomerReport(long loyaltyCardNo, String customerName, String customerEmail, double totalAmount,
			long loyaltyPoints, CustomerClass customerClass, Set<CustomerTransaction> transactions) {
		super();
		this.loyaltyCardNo = loyaltyCardNo;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.totalAmount = totalAmount;
		this.loyaltyPoints = loyaltyPoints;
		this.customerClass = customerClass;
		this.transactions = transactions;
	}


	public long getLoyaltyCardNo() {
		return loyaltyCardNo;
	}


	public String getCustomerName() {
		return customerName;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public long getLoyaltyPoints() {
		return loyaltyPoints;
	}


	public CustomerClass getCustomerClass() {
		return customerClass;
	}


	public Set<CustomerTransaction> getTransactions() {
		return transactions;
	}


	public void setLoyaltyCardNo(long loyaltyCardNo) {
		this.loyaltyCardNo = loyaltyCardNo;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public void setLoyaltyPoints(long loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}


	public void setCustomerClass(CustomerClass customerClass) {
		this.customerClass = customerClass;
	}


	public void setTransactions(Set<CustomerTransaction> transactions) {
		this.transactions = transactions;
	}
	
	
	
	
	
}
