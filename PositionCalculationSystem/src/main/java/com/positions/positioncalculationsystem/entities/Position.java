package com.positions.positioncalculationsystem.entities;

public class Position {
	private String instrument;
	private String accountNo;
	private String accountType;
	private String quantity;
	
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Position [instrument=" + instrument + ", accountNo=" + accountNo + ", accountType=" + accountType
				+ ", quantity=" + quantity + "]";
	}
	
	public Position() {
		super();
	}
	
	public Position(String instrument, String accountNo, String accountType, String quantity) {
		super();
		this.instrument = instrument;
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.quantity = quantity;
	}
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Position) {
            return this.instrument.equals(((Position) obj).instrument) &&
            		this.accountNo.equals(((Position) obj).accountNo) &&
            		this.accountType.equals(((Position) obj).accountType) &&
            		this.quantity.equals(((Position) obj).quantity);
        }
        return false;
	}
	
	
	
	
}
