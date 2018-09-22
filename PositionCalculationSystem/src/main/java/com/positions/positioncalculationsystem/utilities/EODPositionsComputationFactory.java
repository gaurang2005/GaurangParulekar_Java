package com.positions.positioncalculationsystem.utilities;

import java.util.ArrayList;
import java.util.List;


import com.positions.positioncalculationsystem.entities.EodPosition;
import com.positions.positioncalculationsystem.entities.InputTransaction;
import com.positions.positioncalculationsystem.entities.Position;

public class EODPositionsComputationFactory {
	
	public static List<EodPosition> computeEODPositions(List<Position> inputPositions,List<InputTransaction> inputTransactions){
		List<EodPosition> eodPositions = new ArrayList<EodPosition>();
		
		
		//Initializing eodPositions with inputPostions and delta as 0
		inputPositions.forEach(ip -> {
			EodPosition ep = new EodPosition (ip,0);
			eodPositions.add(ep);
		});
		
		//System.out.println("EOD Positions:"+eodPositions);
		
		inputTransactions.forEach(it ->{
			eodPositions.stream()
						.filter(ep -> ep.getInstrument().equalsIgnoreCase(it.getInstrument()))
						.forEach(epMatched -> {
							switch(it.getTransactionType()) {
								case 'B':
									switch(epMatched.getAccountType()) {
										case "E":
											epMatched.setQuantity(new Integer(Integer.parseInt(epMatched.getQuantity()) + it.getTransactionQuantity()).toString());
											epMatched.setDelta(epMatched.getDelta()+it.getTransactionQuantity());
											break;
										case "I":
											epMatched.setQuantity(new Integer(Integer.parseInt(epMatched.getQuantity()) - it.getTransactionQuantity()).toString());
											epMatched.setDelta(epMatched.getDelta()-it.getTransactionQuantity());
											break;
									}			
									break;
								case 'S':
									switch(epMatched.getAccountType()) {
										case "E":
											epMatched.setQuantity(new Integer(Integer.parseInt(epMatched.getQuantity()) - it.getTransactionQuantity()).toString());
											epMatched.setDelta(epMatched.getDelta()-it.getTransactionQuantity());
											break;
										case "I":
											epMatched.setQuantity(new Integer(Integer.parseInt(epMatched.getQuantity()) + it.getTransactionQuantity()).toString());
											epMatched.setDelta(epMatched.getDelta()+it.getTransactionQuantity());
											break;
									}
									break;
							}
						});
					
		});
		//System.out.println("EOD Positions:"+eodPositions);
		return eodPositions;
	}
}
