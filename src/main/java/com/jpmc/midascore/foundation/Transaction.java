// src/main/java/com/jpmc/midascore/foundation/Transaction.java
package com.jpmc.midascore.foundation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal; // Import BigDecimal for better monetary handling (optional, see note below)

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
    private long senderId;
    private long recipientId;
    // Consider using BigDecimal for currency to avoid floating-point issues
    // private BigDecimal amount;
    private float amount; // Sticking to float as per your provided code for now

    public Transaction() {
    }

    // Constructor with float amount
    public Transaction(long senderId, long recipientId, float amount) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.amount = amount;
    }

    // If using BigDecimal, add an additional constructor or adjust existing one
    // public Transaction(long senderId, long recipientId, BigDecimal amount) {
    // this.senderId = senderId;
    // this.recipientId = recipientId;
    // this.amount = amount;
    // }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(long recipientId) {
        this.recipientId = recipientId;
    }

    // Getter for float amount
    public float getAmount() {
        return amount;
    }

    // Setter for float amount
    public void setAmount(float amount) {
        this.amount = amount;
    }

    // If using BigDecimal, you'd also need BigDecimal getters/setters
    // public BigDecimal getAmount() {
    // return amount;
    // }
    // public void setAmount(BigDecimal amount) {
    // this.amount = amount;
    // }

    @Override
    public String toString() {
        return "Transaction {senderId=" + senderId + ", recipientId=" + recipientId + ", amount=" + amount + "}";
    }
}