package com.positions.positioncalculationsystem.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.positions.positioncalculationsystem.entities.InputTransaction;
import com.positions.positioncalculationsystem.entities.InputTransactionNamingStrategy;


public class InputJsonReaderFactory {
	public static List<InputTransaction> readInputJSON (String inputJsonPath) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		List<InputTransaction> listIt;
		
		mapper.setPropertyNamingStrategy(new InputTransactionNamingStrategy());
		listIt = mapper.readValue(new File(inputJsonPath), new TypeReference<List<InputTransaction>>(){});
		
		return listIt;
		
	}
}
