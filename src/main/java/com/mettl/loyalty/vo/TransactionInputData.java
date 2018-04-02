package com.mettl.loyalty.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionInputData implements Serializable{

	private static final long serialVersionUID = 6691625412253008103L;
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	
	private String name;
	private String emailAddress;
	private long loyaltyCardNo;
	private double purchaseAmount;
	private LocalDateTime purchaseDateTime;
	private long purchaseTransactionId;
	
	public TransactionInputData(Builder builder) {
		this.name = builder.name;
		this.emailAddress = builder.emailAddress;
		this.loyaltyCardNo = builder.loyaltyCardNo;
		this.purchaseAmount = builder.purchaseAmount;
		this.purchaseDateTime = builder.purchaseDateTime;
		this.purchaseTransactionId = builder.purchaseTransactionId;
	}

	
	public String getName() {
		return name;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public long getLoyaltyCardNo() {
		return loyaltyCardNo;
	}


	public double getPurchaseAmount() {
		return purchaseAmount;
	}


	public LocalDateTime getPurchaseDateTime() {
		return purchaseDateTime;
	}


	public long getPurchaseTransactionId() {
		return purchaseTransactionId;
	}

	public static class Builder {
		private String name;
		private String emailAddress;
		private long loyaltyCardNo;
		private double purchaseAmount;
		private LocalDateTime purchaseDateTime;
		private long purchaseTransactionId;
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder emailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
			return this;
		}
		
		public Builder loyaltyCardNo(long loyaltyCardNo) {
			this.loyaltyCardNo = loyaltyCardNo;
			return this;
		}
		
		public Builder purchaseAmount(double purchaseAmount) {
			this.purchaseAmount = purchaseAmount;
			return this;
		}
		
		public Builder purchaseDateTime(String purchaseDateTimeStr) {
			LocalDateTime dateTime = LocalDateTime.parse(purchaseDateTimeStr, formatter);
			this.purchaseDateTime = dateTime;
			return this;
		}
		
		public Builder purchaseTransactionId(long purchaseTransactionId) {
			this.purchaseTransactionId = purchaseTransactionId;
			return this;
		}
		
		public TransactionInputData build() {
			return new TransactionInputData(this);
		}
		
		
	}
}