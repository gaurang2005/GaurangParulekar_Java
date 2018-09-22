package com.positions.positioncalculationsystem.exceptions;

public class InputPositionException extends Exception{
	private int lineNo;


	public InputPositionException(int lineNo, String message) {
		super(message);
		this.lineNo = lineNo;

	}


	public int getLineNo() {
		return lineNo;
	}


	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	

	
	
	
}
