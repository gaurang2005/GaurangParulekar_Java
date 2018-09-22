package com.positions.positioncalculationsystem.entities;

public class InputTransaction {
	private int transactionId;
	private String instrument;
	private char transactionType;
	private int transactionQuantity;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactonId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public char getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(char transactionType) {
		this.transactionType = transactionType;
	}
	public int getTransactionQuantity() {
		return transactionQuantity;
	}
	public void setTransactionQuantity(int transactionQuantity) {
		this.transactionQuantity = transactionQuantity;
	}
	@Override
	public String toString() {
		return "InputTransaction [transactionId=" + transactionId + ", instrument=" + instrument + ", transactionType="
				+ transactionType + ", transactionQuantity=" + transactionQuantity + "]";
	}
	
	public InputTransaction() {
		super();
	}
	
	public InputTransaction(int transactionId, String instrument, char transactionType, int transactionQuantity) {
		super();
		this.transactionId = transactionId;
		this.instrument = instrument;
		this.transactionType = transactionType;
		this.transactionQuantity = transactionQuantity;
	}

	
	
	
}
