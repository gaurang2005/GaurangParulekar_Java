package com.positions.positioncalculationsystem.entities;

public class EodPosition extends Position {
	private int delta;

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	public EodPosition() {
		super();
	}

	public EodPosition(Position pos, int delta) {
		super(pos.getInstrument(), pos.getAccountNo(), pos.getAccountType(), pos.getQuantity());
		this.delta = delta;
	}

	@Override
	public String toString() {
		return "EodPosition "+super.toString()+" [delta=" + delta + "]";
	}

	public int getAbsDelta() {
		return Math.abs(this.delta);
	}
	
	
	
	
	
	
}
