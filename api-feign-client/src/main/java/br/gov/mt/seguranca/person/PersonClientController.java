package br.gov.mt.seguranca.person;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PersonClientController {

private static final Logger LOGGER = LoggerFactory.getLogger(PersonClientController.class);
	
	private final PersonClient personClient;
	
	@RequestMapping(value = "/query")
	public ResponseEntity<PersonDTO> findByQuery(PersonQuery personQuery){
		LOGGER.info("call client findByQuery with param PersonQuery: {}", personQuery);
		
		return personClient.query(personQuery);
	}
	
	@RequestMapping(value = "/query-dois")
	public HttpEntity<PersonQuery> findByQueryDois(PersonQuery personQuery){
		convert(personQuery);
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.convertValue(personQuery, new TypeReference<Map<String,Object>>() {});

		// Map to MultiValueMap
		LinkedMultiValueMap<String, String> linkedMultiValueMap = new LinkedMultiValueMap<String, String>();
		map.entrySet().forEach(e -> linkedMultiValueMap.add(e.getKey(), e.getValue().toString()));

		 HttpHeaders requestHeaders = new HttpHeaders();
	        //set up HTTP Basic Authentication Header
	        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

	        //request entity is created with request headers
	        HttpEntity<PersonQuery> requestEntity = new HttpEntity<>(requestHeaders);

		
		// call RestTemplate.exchange
		ResponseEntity<HttpEntity<PersonQuery>> exchange = new RestTemplate().exchange(
		        UriComponentsBuilder.fromHttpUrl("http://localhost:8080/api/persons/query?name=Denys Hetzel barbosa&address.zipcode=12345678")
		        //.queryParams(linkedMultiValueMap)
		        .build().toUri(),
		        HttpMethod.GET,
		        requestEntity,
		        new ParameterizedTypeReference<HttpEntity<PersonQuery>>() {});
		System.out.println("body" + exchange.getBody());
		return exchange.getBody();
	}
	
	private void convert(PersonQuery personQuery) {
		 ObjectMapper objectMapper = new ObjectMapper();
	        Map<String, Object> map =
	                objectMapper.convertValue(personQuery, new TypeReference<Map<String,Object>>(){});


	        StringBuilder qs = new StringBuilder();
	        for (String key : map.keySet()){

	            if (map.get(key) == null){
	                continue;
	            }
	            // key=value&
	            qs.append(key);
	            qs.append("=");
	            qs.append(map.get(key));
	            qs.append("&");
	        }

	        // delete last '&'
	        if (qs.length() != 0) {
	            qs.deleteCharAt(qs.length() - 1);
	        }
	        System.out.println(qs.toString());
	}
}
