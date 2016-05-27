/**
 * 
 */
package com.atpForecast.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/testServices")
public class Services {

	@GET
	@Path("/{exampleParam}")
	public Response printMessage(@PathParam("exampleParam") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();
	}

}