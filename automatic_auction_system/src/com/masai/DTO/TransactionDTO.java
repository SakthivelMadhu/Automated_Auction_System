package com.masai.DTO;


import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TransactionDTO {
    private int transactionId;
    private int itemId;
    private int sellerId;
    private int buyerId;
    private String transactionDate;
    private double transactionAmount;

    public TransactionDTO(int transactionId, int itemId, int sellerId, int buyerId, String transactionDate, double transactionAmount) {
        this.transactionId = transactionId;
        this.itemId = itemId;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    public TransactionDTO(int int1, int int2, int int3, int int4, Timestamp timestamp) {
		// TODO Auto-generated constructor stub
	}

	public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

	public void setAmount(double double1) {
		// TODO Auto-generated method stub
		
	}

	public void setTransactionDate(LocalDateTime localDateTime) {
		// TODO Auto-generated method stub
		
	}

	public double getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
}

