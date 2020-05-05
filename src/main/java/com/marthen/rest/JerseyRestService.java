package com.marthen.rest;

import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/graal")
public class JerseyRestService {
 
	@GET
	@Path("/benchmark/{iteration}")
	public Response benchmark(@PathParam("iteration") final int iterate) {
		int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		long result = 0; 
		long begin = System.currentTimeMillis();
		for (int i=0; i<iterate; i++) {
			int a = Arrays.stream(values)
				.map(x -> x + 1)
				.map(x -> x * 2)
				.map(x -> x + 2)
				.reduce(0, Integer::sum);
			result += a;
		}
		long processTime = System.currentTimeMillis() - begin;
		String output = "Time taken to complete in milliseconds: " + processTime + " ; and result is: " + result; 
		return Response.status(200).entity (output).build();	
  }
 
}