package com.rest.ws.jersey;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/*
 * Jersey is an open source, RESTful web service framework
 */

@Path("/rest")
public class Hello {

	// curl -H "Accept: text/html" http://localhost:8080/SOAPService/restservlet/rest
	@GET
    @Produces("text/html")
    public Response getStartingPage()
    {
        String output = "<h1>Hello World!<h1>" +
                "<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br>";
        return Response.status(200).entity(output).build();
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayJsonHello() {
	    return "{\"name\":\"greeting\", \"message\":\"Bonjour tout le monde!\"}";
	}
	
	@GET
    @Path("/{name}")
    public Response getMsg(@PathParam("name") String name) {
  
        String output = "Welcome   : " + name;
  
        return Response.status(200).entity(output).build();
    }
	
	@GET
	@Path("/nri")
	@Produces("text/html")
	public Response getNriCust() {
        String output = "I am from 'getNriCust' method";
	    return Response.status(200).entity(output).build();
	}
	
}
