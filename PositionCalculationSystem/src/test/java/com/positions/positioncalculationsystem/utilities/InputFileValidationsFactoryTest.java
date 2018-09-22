package com.positions.positioncalculationsystem.utilities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.positions.positioncalculationsystem.entities.InputTransaction;
import com.positions.positioncalculationsystem.entities.Position;
import com.positions.positioncalculationsystem.exceptions.InputPositionException;
import com.positions.positioncalculationsystem.exceptions.InputTransactionException;

public class InputFileValidationsFactoryTest {

	@Test
	public void test_checkNullValues() {
		assertEquals(false, InputFileValidationsFactory.checkNullValues(" "));
		assertEquals(true, InputFileValidationsFactory.checkNullValues(""));
		assertEquals(true, InputFileValidationsFactory.checkNullValues(null));
	}
	
	@Test
	public void test_checkAccountTypes() {
		assertEquals(false, InputFileValidationsFactory.checkAccountType("E"));
		assertEquals(true, InputFileValidationsFactory.checkAccountType("F"));
		assertEquals(true, InputFileValidationsFactory.checkAccountType(""));
	}
	
	@Test
	public void test_checkTransactionType() {
		assertEquals(false, InputFileValidationsFactory.checkTransactionType('B'));
		assertEquals(false, InputFileValidationsFactory.checkTransactionType('S'));
		assertEquals(true, InputFileValidationsFactory.checkTransactionType('s'));
		
	}
	
	@Test
	public void test_checkIntQuantity() {
		assertEquals(false, InputFileValidationsFactory.checkIntQuantity("5"));
		assertEquals(true, InputFileValidationsFactory.checkIntQuantity("abc"));
		assertEquals(true, InputFileValidationsFactory.checkIntQuantity("5a0"));
		assertEquals(true, InputFileValidationsFactory.checkIntQuantity(""));
	}
	
	@Test(expected = InputPositionException.class) 
	public void test_validateInputPositions() throws Exception { 
		//Create list of positions for testing
		Position testPosition1 = new Position("","101","E","100000");
		Position testPosition2 = new Position("IBM","102","I","-100000"); 
		List<Position> testPositions =  new ArrayList<Position>();
		testPositions.add(testPosition1);
		testPositions.add(testPosition2);
		InputFileValidationsFactory.validateInputPositions(testPositions); 
	}
	
	@Test(expected = InputTransactionException.class) 
	public void test_validateInputTransactions() throws Exception { 
		//Create list of positions for testing
		InputTransaction testTransaction1 = new InputTransaction(1,"IBM",'B',1000);
		InputTransaction testTransaction2 = new InputTransaction(1,"IBM",'E',1000);
		List<InputTransaction> testTransactions =  new ArrayList<InputTransaction>();
		testTransactions.add(testTransaction1);
		testTransactions.add(testTransaction2);
		InputFileValidationsFactory.validateInputTransactions(testTransactions); 
	}

}
