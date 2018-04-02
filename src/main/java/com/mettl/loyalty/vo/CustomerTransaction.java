package com.mettl.loyalty.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CustomerTransaction implements Serializable {

	private static final long serialVersionUID = -2836387207959515939L;

	private transient long loyaltyCardNo;
	private LocalDateTime dateTime;
	private long trxId;
	private double trxAmt;
	private double pointsEarned;
	
	public CustomerTransaction(long loyaltyCardNo, LocalDateTime dateTime, long trxId, double trxAmt,
			double pointsEarned) {
		super();
		this.loyaltyCardNo = loyaltyCardNo;
		this.dateTime = dateTime;
		this.trxId = trxId;
		this.trxAmt = trxAmt;
		this.pointsEarned = pointsEarned;
	}

	@Override
	public String toString() {
		return "\t"+dateTime +"\t"+trxId +"\t"+trxAmt+"\t"+pointsEarned+"\n";
	}
	
	public long getLoyaltyCardNo() {
		return loyaltyCardNo;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public long getTrxId() {
		return trxId;
	}

	public double getTrxAmt() {
		return trxAmt;
	}

	public double getPointsEarned() {
		return pointsEarned;
	}

	public void setLoyaltyCardNo(long loyaltyCardNo) {
		this.loyaltyCardNo = loyaltyCardNo;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void setTrxId(long trxId) {
		this.trxId = trxId;
	}

	public void setTrxAmt(double trxAmt) {
		this.trxAmt = trxAmt;
	}

	public void setPointsEarned(double pointsEarned) {
		this.pointsEarned = pointsEarned;
	}
	
}
