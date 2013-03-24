package com.dimasco.hello;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class TestHelloController {
	
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(getBasicResource());
		
		// http://localhost:8080/jersey_test_app/rest/hello  - example of uri
		System.out.println(webResource.path("rest").path("hello").accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString());
		
		System.out.println(webResource.path("rest").path("hello").accept(MediaType.TEXT_PLAIN).get(String.class));
		
		System.out.println(webResource.path("rest").path("hello").accept(MediaType.TEXT_HTML).get(String.class));
		
		System.out.println(webResource.path("rest").path("hello").accept(MediaType.TEXT_XML).get(String.class));
	}
	
	private static URI getBasicResource() {
		return UriBuilder.fromUri("http://localhost:8080/jersey_test_app").build();
	}

}
