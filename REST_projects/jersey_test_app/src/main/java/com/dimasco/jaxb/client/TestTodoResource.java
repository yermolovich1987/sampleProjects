package com.dimasco.jaxb.client;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class TestTodoResource {
	
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(getBasicResource());
		
		// http://localhost:8080/jersey_test_app/rest/todo  - example of uri
		
		   // Get XML
	    System.out.println(webResource.path("rest").path("todo").accept(MediaType.TEXT_XML).get(String.class));
	    // Get XML for application
	    System.out.println(webResource.path("rest").path("todo").accept(MediaType.APPLICATION_JSON).get(String.class));
	    // Get JSON for application
	    System.out.println(webResource.path("rest").path("todo").accept(MediaType.APPLICATION_XML).get(String.class));
	}
	
	private static URI getBasicResource() {
		return UriBuilder.fromUri("http://localhost:8080/jersey_test_app").build();
	}

}
