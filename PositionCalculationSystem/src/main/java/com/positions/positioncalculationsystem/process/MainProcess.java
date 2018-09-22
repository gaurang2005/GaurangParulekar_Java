package com.positions.positioncalculationsystem.process;

import java.io.IOException;
import java.util.*;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.positions.positioncalculationsystem.entities.EodPosition;
import com.positions.positioncalculationsystem.entities.InputTransaction;
import com.positions.positioncalculationsystem.entities.Position;
import com.positions.positioncalculationsystem.exceptions.InputPositionException;
import com.positions.positioncalculationsystem.exceptions.InputTransactionException;
import com.positions.positioncalculationsystem.utilities.InputFileReaderFactory;
import com.positions.positioncalculationsystem.utilities.InputFileValidationsFactory;
import com.positions.positioncalculationsystem.utilities.InputJsonReaderFactory;
import com.positions.positioncalculationsystem.utilities.OutputFileWriterFactory;
import com.positions.positioncalculationsystem.utilities.EODPositionsComputationFactory;

public class MainProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("*** Start of the Process ***");
			//Initiating global variables
			List<Position> inputPositions=null;
			List<InputTransaction> inputTransactions=null;
			List<EodPosition> eodPositions = null;
			
			
			//Extracting Positions from input file
			System.out.println("*** Start of the Input Start of Day Instruments Positions extraction ***");
			try {
				inputPositions = InputFileReaderFactory.readInputFile("data/input/Input_StartOfDay_Positions.txt");
				//System.out.println(inputPositions);
			}catch (IOException e) {
				System.out.println("*** Process Halted: Error in reading Start of Day Instrument Positions : "+e.getMessage()+" ***");
			}
			System.out.println("*** End of the Input Start of Day Instruments Positions extraction ***");
			
			//Extracting Input transactions from JSON file
			System.out.println("*** Start of the Input transactions extraction from JSON file ***");
			try {
				inputTransactions = InputJsonReaderFactory.readInputJSON("data/input/Input_Transactions.txt");
				//System.out.println(inputTransactions);
			}catch (IOException e) {
				System.out.println("*** Process Halted: Error in reading Input Transactions JSON : "+e.getMessage()+" ***");
			}
			System.out.println("*** End of the Input transactions extraction from JSON file ***");
			
			//Validation of Input Positions and Input Transactions pulled from Flat file
			try {
				InputFileValidationsFactory.validateInputPositions(inputPositions);
			}catch(InputPositionException ipe) {
				System.out.println("*** Process Halted: Validation error in the input positions file at line number : "+ipe.getLineNo()+" error message : "+ipe.getMessage()+" ***");
			}
			
			try {
				InputFileValidationsFactory.validateInputTransactions(inputTransactions);
			}catch(InputTransactionException ipt) {
				System.out.println("*** Process Halted: Validation error in the input Input Transaction file for trasnaction Id : "+ipt.getTransactionId()+" error message : "+ipt.getMessage()+" ***");
			}
			
			//Computation of List of EOD Positions
			System.out.println("*** Start of computation of EOD positions ***");
			eodPositions = EODPositionsComputationFactory.computeEODPositions(inputPositions,inputTransactions);
			System.out.println("*** End of computation of EOD positions ***");
			
			//Write EOD Positions to output file
			System.out.println("*** Start of writing EOD Positions to output file ***");
			try {
				OutputFileWriterFactory.writeOutputFile(eodPositions, "data/output/Expected_EndOfDay_Positions.txt");
				//System.out.println(inputTransactions);
			}catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
				System.out.println("*** Process Halted: Error in writing EOD Positions to output file : "+e.getMessage()+" ***");
			}
			System.out.println("*** End of writing EOD Positions to output file ***");
			
		}catch (Exception e) {
			System.out.println("*** Process Halted: Error in Main Process due to unknown exception : "+e.getMessage()+" ***");
			e.printStackTrace();
		}
		
	}

}
