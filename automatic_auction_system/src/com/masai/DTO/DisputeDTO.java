package com.masai.DTO;



import java.sql.Timestamp;

public class DisputeDTO {
    private int disputeId;
    private int transactionId;
    private int buyerId;
    private int sellerId;
    private String description;
    private DisputeStatus status;

    public DisputeDTO(int disputeId, int transactionId, int buyerId, int sellerId, String description, DisputeStatus status) {
        this.disputeId = disputeId;
        this.transactionId = transactionId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.description = description;
        this.status = status;
    }

    public DisputeDTO(int disputeId2, int transactionId2, String description2, Timestamp dateCreated) {
		// TODO Auto-generated constructor stub
	}

	public int getDisputeId() {
        return disputeId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public String getDescription() {
        return description;
    }

    public DisputeStatus getStatus() {
        return status;
    }

    public void setStatus(DisputeStatus status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "DisputeDTO [disputeId=" + disputeId + ", transactionId=" + transactionId + ", buyerId=" + buyerId
				+ ", sellerId=" + sellerId + ", description=" + description + ", status=" + status + "]";
	}
    
    
    
}



