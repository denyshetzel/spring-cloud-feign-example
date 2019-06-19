package com.example.demo;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PersonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	
	private final PersonRepository personRepository;
	
	@RequestMapping(value = "/query")
	public ResponseEntity<Collection<PersonDTO>> findByQuery(PersonQuery personQuery){
		LOGGER.info("call findByQuery with param PersonQuery: {}", personQuery);
		
		Collection<PersonDTO> persons = personRepository.findAll();
		
		return ResponseEntity.ok(persons);
	}
	
	
	
}
