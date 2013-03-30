package com.dimasco.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("restClient")
public class RestClient {
	/*private static final String URL_FETCH_RETURN_OBJECT = "http://localhost:8080/SpringInAction_REST_server_JAXB/path/{text}";
	private static final String URL_FETCH_SPITTER = "http://localhost:8080/SpringInAction_REST_server_JAXB/spitters/{username}";

	private static final String URL_PUT_SPITTER = "http://localhost:8080/SpringInAction_REST_server_JAXB/spitters/{id}";
	
	private static final String URL_POST_SPITTER = "http://localhost:8080/SpringInAction_REST_server_JAXB/spitters/";*/
	
	private static final String URL_POST_FOO = "http://localhost:8080/RestSpringTest/foo";
	private static final String URL_PUT_FOO = "http://localhost:8080/RestSpringTest/foo/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public long postFooObject(final Foo foo) {
		
		long id = restTemplate.postForObject(URL_POST_FOO, foo, Long.class);
		
		return id;
	}
	
	public void putFooObject(final Foo foo) {
		String url = URL_PUT_FOO + foo.getId();
		restTemplate.put(url, foo);
	}

		
/*	public ResponseObj fetchResponseObject(String testString) {
		
		return restTemplate.getForObject(URL_FETCH_RETURN_OBJECT, 
				ResponseObj.class, 
				testString);	
	}
	
	public Spitter fetchSpitter(String testString) {
		
		return restTemplate.getForObject(URL_FETCH_SPITTER, 
				Spitter.class, 
				testString);	
	}
	
	public void updateSpitter(Spitter spitter) {
		
		restTemplate.put(URL_PUT_SPITTER, 
				spitter, 
				spitter.getId());
	}
	
	public Spitter postSpitterForObject(Spitter spitter){
		//RestTemplate rest = new RestTemplate();
		return restTemplate.postForObject(URL_POST_SPITTER,
					spitter, Spitter.class);
	}
	
	public Spitter postSpitterUsingExchange(Spitter spitter) {
		MultiValueMap<String,String>headers=
				new LinkedMultiValueMap<String,String>();
		headers.add("Accept","application/xml");
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
		
		ResponseEntity<Spitter> response = restTemplate.exchange(URL_POST_SPITTER, 
							HttpMethod.POST, 
							requestEntity, 
							Spitter.class);
		
		return response.getBody();
	}*/
}
