/**
 * 
 */
package com.atpForecast.restful;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.spi.HttpResponse;

import com.atpForecast.restful.objects.Player;
import com.atpForecast.restful.simulator.DatabaseSimulator;

@Path("/PlayerService")
public class PlayerService {
	
	@Context HttpResponse response;
	
	@Body
	public String body;

	@GET
	@Path("/players")
	public Response getPlayers() {

		DatabaseSimulator instance = DatabaseSimulator.getInstance();
		Player[] players = instance.getPlayers();
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonResult = null;
		try {
			//Convert object to JSON string and pretty print
			jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(players);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		response.getOutputHeaders().putSingle("Access-Control-Allow-Origin", "http://localhost:3000");
		return Response.status(200).entity(jsonResult).build();
	}
	
	@GET
	@Path("/player/{id}")
	public Response getPlayer(@PathParam("id") int id) {

		DatabaseSimulator instance = DatabaseSimulator.getInstance();
		Player[] players = instance.getPlayers();
		Player desiredPlayer = null;
		for(Player p : players) {
			if (p.getId() == id){
				desiredPlayer = p;
				break;
			}
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonResult = null;
		try {
			//Convert object to JSON string and pretty print
			jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(desiredPlayer);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		response.getOutputHeaders().putSingle("Access-Control-Allow-Origin", "http://localhost:3000");
		return Response.status(200).entity(jsonResult).build();
	}

}