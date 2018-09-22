package com.positions.positioncalculationsystem.utilities;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.positions.positioncalculationsystem.entities.Position;

public class InputFileReaderFactory {
	public static List<Position> readInputFile (String inputFilePath) throws IOException {
		
		FileReader filereader = new FileReader(inputFilePath); 
		CSVParser parser = new CSVParserBuilder().withSeparator(',').build(); 
		CSVReader csvReader = new CSVReaderBuilder(filereader)
				.withSkipLines(1)
                .withCSVParser(parser) 
                .build(); 
		
		ColumnPositionMappingStrategy<Position> beanStrategy = new ColumnPositionMappingStrategy<Position>();
		beanStrategy.setType(Position.class);
		beanStrategy.setColumnMapping(new String[] {"instrument","accountNo","accountType","quantity"});
		
		CsvToBean<Position> csvToBean = new CsvToBean<Position>();
		
		@SuppressWarnings("deprecation")
		List<Position> positions = csvToBean.parse(beanStrategy, csvReader);
		
		filereader.close();
		csvReader.close();
		
		return positions;
	}
	

}
