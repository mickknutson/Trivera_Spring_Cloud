package com.springclass.cloud.client;

import com.springclass.cloud.BasicAuthRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class TestClient {

	private static final Logger log = LoggerFactory.getLogger(TestClient.class);

	private static String uri = "http://localhost:8888/config-client/development/";

	/**
	 * Simple Test method to verify the Spring Boot REST API.
	 * @param args
	 */
	public static void main(String args[]) {

	    // We need to use a custom RestTemplate that will allow us to send BASIC Authentication
        // Credentials:
		RestTemplate restTemplate = new BasicAuthRestTemplate("user1", "s3cr3t");

		// First get user, and there should be none.
		String result = restTemplate.getForObject(uri, String.class);
		log.info("getForObject.uri: {}", uri);
		log.info("getForObject.result: {}", result);
		assertThat(result, containsString("{\"name\":\"config-client\""));
		
		log.info("*** Successfully pulled properties through REST ***");

	}
}
