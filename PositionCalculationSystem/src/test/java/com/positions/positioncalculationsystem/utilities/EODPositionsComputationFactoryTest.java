package com.positions.positioncalculationsystem.utilities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.positions.positioncalculationsystem.entities.EodPosition;
import com.positions.positioncalculationsystem.entities.InputTransaction;
import com.positions.positioncalculationsystem.entities.Position;

public class EODPositionsComputationFactoryTest {

	@Test
	public void testComputeEODPositions() {
		//Creating Sample Output Positions
		Position testPosition1 = new Position("IBM","101","E","101000");
		Position testPosition2 = new Position("IBM","102","I","-101000");
		Position testPosition3 = new Position("NFLX","101","E","100000000");
		Position testPosition4 = new Position("NFLX","102","I","-100000000");
		EodPosition testEod1 = new EodPosition(testPosition1,1000);
		EodPosition testEod2 = new EodPosition(testPosition2,-1000);
		EodPosition testEod3 = new EodPosition(testPosition3,0);
		EodPosition testEod4 = new EodPosition(testPosition4,0);
		
		List<EodPosition> eodPositions = new ArrayList<EodPosition>();
		Collections.addAll(eodPositions, testEod1, testEod2, testEod3, testEod4);
		
		//Creating sample input Positions
		Position testInputPosition1 = new Position("IBM","101","E","100000");
		Position testInputPosition2 = new Position("IBM","102","I","-100000");
		Position testInputPosition3 = new Position("NFLX","101","E","100000000");
		Position testInputPosition4 = new Position("NFLX","102","I","-100000000");

		List<Position> positions = new ArrayList<Position>();
		Collections.addAll(positions, testInputPosition1, testInputPosition2, testInputPosition3, testInputPosition4);
		
		//Creating sample input transactions
		InputTransaction testInputTransaction1 = new InputTransaction(1,"IBM",'B',1000);
		InputTransaction testInputTransaction2 = new InputTransaction(2,"NFLX",'S',0);		
		
		List<InputTransaction> transactions = new ArrayList<InputTransaction>();
		Collections.addAll(transactions, testInputTransaction1, testInputTransaction2);
		
		assertEquals(eodPositions, EODPositionsComputationFactory.computeEODPositions(positions, transactions));
		
	}

}
