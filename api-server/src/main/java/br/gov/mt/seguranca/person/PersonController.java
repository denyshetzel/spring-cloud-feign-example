package br.gov.mt.seguranca.person;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PersonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	
	//private final PersonRepository personRepository;
	
	@GetMapping(value = "/query-map")
	public HttpEntity<Void> findByQuery(@RequestParam Map<String, Object> map){
		LOGGER.info("call server findByQuery with param PersonQuery: {}", map);
		
		PersonDTO personDTO = new PersonDTO();
		//personDTO.setName(personQuery.getName());
		//personDTO.setAddress(personQuery.getAddress());
		return null;
		
		//return ResponseEntity.ok(map);
	}
	
	@GetMapping(value = "/query")
	public HttpEntity<PersonQuery> findByQueryDois(PersonQuery personQuery, Pageable pageable){
		LOGGER.info("call server findByQuery with param PersonQuery: {} e Pageable: {}", personQuery, pageable);
		
		PersonDTO personDTO = new PersonDTO();
		personDTO.setName(personQuery.getName());
		personDTO.setAddress(personQuery.getAddress());
		
		return ResponseEntity.ok(personQuery);
	}
	
	
}
