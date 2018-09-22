package com.positions.positioncalculationsystem.utilities;

import java.util.List;

import com.positions.positioncalculationsystem.entities.InputTransaction;
import com.positions.positioncalculationsystem.entities.Position;
import com.positions.positioncalculationsystem.exceptions.InputPositionException;
import com.positions.positioncalculationsystem.exceptions.InputTransactionException;

public class InputFileValidationsFactory {
	
	public static void validateInputPositions(List<Position> inputPositions) throws InputPositionException{
		for (int i=0; i<inputPositions.size(); i++) {
			//null checks for all fields
			if (checkNullValues(inputPositions.get(i).getInstrument())) {
				throw new InputPositionException(i+2,"Empty or Null Value for Instrument");
			}
			
			if (checkNullValues(inputPositions.get(i).getAccountNo())) {
				throw new InputPositionException(i+2,"Empty or Null Value for Account No");
			}
			
			if (checkNullValues(inputPositions.get(i).getAccountType())) {
				throw new InputPositionException(i+2,"Empty or Null Value for Account Type");
			}
			
			if (checkNullValues(inputPositions.get(i).getQuantity())) {
				throw new InputPositionException(i+2,"Empty or Null Value for Quantity");
			}
			
			//account type check
			if (checkAccountType(inputPositions.get(i).getAccountType())) {
				throw new InputPositionException(i+2,"Account Type does not have correct value I or E");
			}
			
			//quantity check
			if (checkIntQuantity(inputPositions.get(i).getQuantity())) {
				throw new InputPositionException(i+2,"Quantity is not a numeric value");
			}
			
		}
	}
	
	public static void validateInputTransactions(List<InputTransaction> inputTransactions) throws InputTransactionException{
		for (int i=0; i<inputTransactions.size(); i++) {
			//null checks for all fields
			if (checkNullValues(inputTransactions.get(i).getInstrument())) {
				throw new InputTransactionException(inputTransactions.get(i).getTransactionId(),"Empty or Null Value for Instrument");
			}
			
			//transaction type check
			if (checkTransactionType(inputTransactions.get(i).getTransactionType())) {
				throw new InputTransactionException(inputTransactions.get(i).getTransactionId(),"Transaction Type does not have correct value B or S");
			}
			
		}
		
	}
	
	
	public static boolean checkNullValues(String input) {
		if (input == null || input.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkAccountType(String accountType) {
		if (accountType.equals("E") || accountType.equals("I")) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean checkIntQuantity(String quantity) {
	    try
	    {
	        Integer.parseInt(quantity);
	        return false;
	    } catch (NumberFormatException ex)
	    {
	        return true;
	    }
	}
	
	public static boolean checkTransactionType(char transactionType) {
		if (transactionType == 'B' || transactionType == 'S') {
			return false;
		} else {
			return true;
		}
	}


}
