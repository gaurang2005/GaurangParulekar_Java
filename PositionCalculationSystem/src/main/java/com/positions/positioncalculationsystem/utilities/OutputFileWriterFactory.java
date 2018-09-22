package com.positions.positioncalculationsystem.utilities;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.positions.positioncalculationsystem.entities.EodPosition;


public class OutputFileWriterFactory {
	public static void writeOutputFile (List<EodPosition> eodPositions,String outputFilePath) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
		Path myPath = Paths.get(outputFilePath);
		
		String header = "Instrument,Account,AccountType,Quantity,Delta\n";

		BufferedWriter writer = Files.newBufferedWriter(myPath,StandardCharsets.UTF_8);
		
		writer.write(header);
		
		ColumnPositionMappingStrategy<EodPosition> mappingStrategy= 
                new ColumnPositionMappingStrategy<EodPosition>(); 
		mappingStrategy.setType(EodPosition.class); 
		
		String[] columns = new String[]  
                { "instrument", "accountNo", "accountType", "quantity", "delta" };
		
		mappingStrategy.setColumnMapping(columns);

        StatefulBeanToCsv<EodPosition> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withMappingStrategy(mappingStrategy)
                .build();
                
        beanToCsv.write(eodPositions);
        writer.close();
       


	}
}
