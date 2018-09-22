package com.positions.positioncalculationsystem.utilities;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import com.positions.positioncalculationsystem.entities.EodPosition;

public class FindLargestLowestTransactionFactory {
	public static void findLargestLowestTransaction(List<EodPosition> eodPositions) {
		EodPosition largestPosition = eodPositions.stream()
											.max(Comparator.comparing(EodPosition::getAbsDelta))
											.orElseThrow(NoSuchElementException::new);
		System.out.println("*** The largest net transaction Instrument is : "+largestPosition.getInstrument()+" ***");
		
		EodPosition lowestPosition = eodPositions.stream()
				.min(Comparator.comparing(EodPosition::getAbsDelta))
				.orElseThrow(NoSuchElementException::new);
		System.out.println("*** The lowest net transaction Instrument is : "+lowestPosition.getInstrument()+" ***");
	}
}
