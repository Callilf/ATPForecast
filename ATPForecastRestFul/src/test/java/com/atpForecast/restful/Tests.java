package com.atpForecast.restful;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.atpForecast.restful.objects.Player;
import com.atpForecast.restful.simulator.DatabaseSimulator;

public class Tests {

	@Test
	public void test() {
		DatabaseSimulator instance = DatabaseSimulator.getInstance();
		Player[] players = instance.getPlayers();
		
		ObjectMapper mapper = new ObjectMapper();

		
		try {
			
			//Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(players);
			System.out.println(jsonInString);
			
			//Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(players);
			System.out.println(jsonInString);
			
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
