package com.positions.positioncalculationsystem.exceptions;

public class InputTransactionException extends Exception{
	private int transactionId;

	public InputTransactionException(int transactionId, String message) {
		super(message);
		this.transactionId = transactionId;

	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
}
